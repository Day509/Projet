package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Model.Hotel;
import test.ButtonRenderer;
import test.Generate;

public class ReservPage extends JPanel {
    Generate g = new Generate(new Hotel("Hotel", "blabla"));
    CreateReservation createReservation;
    String[] titresColonnes = { "N°Resa", "N°Chambre", "Nom", "Prénom", "Arrivée", "Départ", "Status", "Facture" };
    private int NB_COLONNES = titresColonnes.length; // nombre de colonnes à afficher
    private int NB_LIGNES = 0; // nombre de lignes à afficher
    Object[][] donneesTableau = new Object[NB_LIGNES][NB_COLONNES];
    DefaultTableModel modeleTableau;
    JTable tableau;
    Hotel hotel;
    ButtonRenderer buttonRenderer = new ButtonRenderer();

    public ReservPage(Hotel h) {
        hotel = h;
        NB_LIGNES = hotel.getListChambres().size();
        createReservation = new CreateReservation(g.getHotel());
        setLayout(new BorderLayout());

        // création du panneau pour le tableau
        JPanel tableauPanel = new JPanel(new BorderLayout());
        tableauPanel.setBackground(Color.WHITE);

        // création des données du tableau

        createTable();
        if (hotel.getNom().equals("Hotel")) {
            donneesTableau = new Object[NB_LIGNES][NB_COLONNES];

            for (int i = 0; i < NB_LIGNES; i++) {

                donneesTableau[i][0] = g.getAllReservations().get(i).getReservation().id;
                donneesTableau[i][1] = i; // g.getAllReservations().get(i).getReservations().get(i).getChambre().getIdChambre();
                donneesTableau[i][2] = g.getAllReservations().get(i).getReservation().getClient()
                        .getNom();
                donneesTableau[i][3] = g.getAllReservations().get(i).getReservation().getClient()
                        .getPrenom();
                donneesTableau[i][4] = g.getAllReservations().get(i).getReservation().getStartdate();
                donneesTableau[i][5] = g.getAllReservations().get(i).getReservation().getEnddate();
                donneesTableau[i][6] = "En cours";
                donneesTableau[i][7] = new JButton("Facture");

                // Mettre à jour le modèle de tableau avec les nouvelles données
                
                tableau.getColumnModel().getColumn(7).setCellRenderer(buttonRenderer);

            }
            DefaultTableModel modeleTableau = (DefaultTableModel) tableau.getModel();
                modeleTableau.setDataVector(donneesTableau, titresColonnes);
                modeleTableau.fireTableDataChanged();

        }

        // création du panneau pour le bouton
        JPanel buttonPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets.top = 10; // marge inférieure

        // ajout du bouton Ajouter une réservation
        JButton addButton = new JButton("Ajouter une réservation");
        buttonPanel.add(addButton, gbc);
        addButton.addActionListener(e -> {
            createReservWindow();
        });

        // ajout du panneau du bouton au panneau principal
        add(buttonPanel, BorderLayout.SOUTH);

    }

    private void createTable() {
        modeleTableau = new DefaultTableModel(donneesTableau, titresColonnes);
        // création des données du tableau

        tableau = new JTable(modeleTableau);
        tableau.setPreferredScrollableViewportSize(new Dimension(getWidth(), getWidth()));
        tableau.setDefaultEditor(Object.class, null);
        tableau.setFillsViewportHeight(true);
        tableau.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        // alignement du contenu des colonnes
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        tableau.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        for (int i = 0; i < NB_COLONNES; i++) {
            tableau.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        // ajout du tableau dans un panneau avec barre de défilement
        JScrollPane scrollPane = new JScrollPane(tableau);
        add(scrollPane, BorderLayout.CENTER);
    } //

    private void createReservWindow() {
        JDialog dialog = new JDialog();
        dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dialog.setContentPane(createReservation);
        dialog.pack();
        dialog.setVisible(true);
    }

    public void updateTableData() {

        donneesTableau = new Object[NB_LIGNES + 1][NB_COLONNES];

        // Récupérer les nouvelles données de la réservation
        donneesTableau[NB_LIGNES][0] = g.getAllReservations().get(NB_LIGNES).getReservation().id;
        donneesTableau[NB_LIGNES][1] = NB_LIGNES; // g.getAllReservations().get(i).getReservations().get(i).getChambre().getIdChambre();
        donneesTableau[NB_LIGNES][2] = g.getAllReservations().get(NB_LIGNES).getReservation().getClient().getNom();
        donneesTableau[NB_LIGNES][3] = g.getAllReservations().get(NB_LIGNES).getReservation().getClient().getPrenom();
        donneesTableau[NB_LIGNES][4] = g.getAllReservations().get(NB_LIGNES).getReservation().getStartdate();
        donneesTableau[NB_LIGNES][5] = g.getAllReservations().get(NB_LIGNES).getReservation().getEnddate();
        donneesTableau[NB_LIGNES][6] = "En cours";
        donneesTableau[NB_LIGNES][7] = new JButton("Facture");

        // Mettre à jour le modèle de tableau avec les nouvelles données
        DefaultTableModel modeleTableau = (DefaultTableModel) tableau.getModel();
        modeleTableau.setDataVector(donneesTableau, titresColonnes);
        modeleTableau.fireTableDataChanged();
        NB_LIGNES++;
        tableau.getColumnModel().getColumn(7).setCellRenderer(buttonRenderer);

    }

}