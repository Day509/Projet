package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Controller.ControlChambre;
import Model.Hotel;
import test.Generate;

public class RoomPage extends JPanel {
    Generate g = new Generate(new Hotel("Hotel", "Paris"));
    private int NB_CHAMBRES = 0; // nombre de chambres
    private int NB_JOURS = 7; // nombre de jours à afficher
    private String[] JOURS_SEMAINE = { "Lun", "Mar", "Mer", "Jeu", "Ven", "Sam", "Dim" }; // jours de la semaine
    private int TAILLE_CASE = 40; // taille des cases du tableau
    LocalDate date;
    JTable table;
    CreateRoom createRoom;
    DefaultTableModel model;
    String[] entetes = new String[NB_JOURS + 1];

    public RoomPage(Hotel hotel) {
        setLayout(new BorderLayout());
        createRoom = new CreateRoom(g.getHotel());
        // création du panneau pour le taableau
        date = LocalDate.now();
        entetes[0] = "";
        // ajout des jours de la semaine dans la première ligne
        for (int i = 0; i < NB_JOURS; i++) {

            String entete = JOURS_SEMAINE[(date.getDayOfWeek().getValue() - 1 + i) % 7] + " " +
                    date.plusDays(i).getDayOfMonth() + "/" + date.plusDays(i).getMonthValue();
            entetes[i + 1] = entete;
        }

        createTable();
        if(hotel.getNom().equals("Hotel")) {
            updateTableData();
        } 

        // création du panneau pour le bouton
        JPanel buttonPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets.top = 10; // marge inférieure

        // ajout du bouton Ajouter une réservation
        JButton addButton = new JButton("Ajouter une chambre");
        buttonPanel.add(addButton, gbc);
        ControlChambre control = new ControlChambre(g.getHotel());
        addButton.addActionListener(control);
        // ajout du panneau du bouton au panneau principal
        add(buttonPanel, BorderLayout.SOUTH);
    }

    LocalDate setDate(LocalDate date) {
        this.date = date;
        return date;
    }

    // création du tableau
    private void createTable() {
        model = new DefaultTableModel(NB_CHAMBRES, NB_JOURS);
        model.setColumnIdentifiers(entetes);

        // création du tableau avec le modèle
        table = new JTable(model);
        table.setRowHeight(TAILLE_CASE);
        table.getTableHeader().setPreferredSize(new Dimension(0, TAILLE_CASE));
        table.setDefaultEditor(Object.class, null);
        table.setFont(new Font("SansSerif", Font.PLAIN, 12));

        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            public void setValue(Object value) {
                setText((value == null) ? "" : value.toString());
            }
        });

        // ajout du tableau dans un JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension((NB_JOURS + 1) * TAILLE_CASE, NB_CHAMBRES * TAILLE_CASE));

        add(scrollPane, BorderLayout.CENTER);
    }

    

    private void updateTableData() {
        // Récupérer les nouvelles données de la réservation
        model.setRowCount(NB_CHAMBRES); // Mettre à jour le nombre de lignes du modèle

        // ajout des cellules pour chaque chambre
        for (int i = 0; i < NB_CHAMBRES; i++) {
            model.setValueAt("Chambre " + (i + 1), i, 0);
            for (int j = 1; j < NB_JOURS; j++) {
                if (g.getAllReservations().get(i).getReservation().getStartdate().equals(date.plusDays(j))) {
                    int k = j;

                    while (g.getAllReservations().get(i).getReservation().getEnddate().isAfter(date.plusDays(k))) {
                        if (k == NB_JOURS) {
                            break;
                        }

                        model.setValueAt("Reservé", i, k);
                        k++;
                    }
                }
            }
        }

        model.fireTableDataChanged();
    }

}