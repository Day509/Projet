package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.time.LocalDate;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Model.Hotel;
import test.Generate;
import test.TableCellColor;

public class RoomPage extends JPanel {
    Generate g = new Generate(new Hotel("Hotel", "Paris"));
    private int NB_CHAMBRES = g.getHotel().getListChambres().size(); // nombre de chambres
    private int NB_JOURS = 7; // nombre de jours à afficher
    private String[] JOURS_SEMAINE = { "Lun", "Mar", "Mer", "Jeu", "Ven", "Sam", "Dim" }; // jours de la semaine
    private int TAILLE_CASE = 40; // taille des cases du tableau
    TableCellColor tcc = new TableCellColor();
    LocalDate date;
    JTable table;

    public RoomPage() {
        setLayout(new BorderLayout());
        // création du panneau pour le taableau
        String[] entetes = new String[NB_JOURS + 1];
        date = LocalDate.now();
        entetes[0] = "";
        // ajout des jours de la semaine dans la première ligne
        for (int i = 0; i < NB_JOURS; i++) {

            String entete = JOURS_SEMAINE[(date.getDayOfWeek().getValue() - 1 + i) % 7] + " " +
                    date.plusDays(i).getDayOfMonth() + "/" + date.plusDays(i).getMonthValue();
            entetes[i + 1] = entete;
        }

        DefaultTableModel model = new DefaultTableModel(NB_CHAMBRES, NB_JOURS);
        model.setColumnIdentifiers(entetes);

        // ajout des cellules pour chaque chambre
        for (int i = 0; i < NB_CHAMBRES; i++) {
            model.setValueAt("Chambre " + (i + 1), i, 0);
            for (int j = 1; j < NB_JOURS; j++) {
                if (g.getAllReservations().get(i).getReservation().getStartdate().equals(date.plusDays(j))){
                    int k = j;
                    
                    while (g.getAllReservations().get(i).getReservation().getEnddate().isAfter(date.plusDays(k))){
                        if(k == NB_JOURS){
                            break;
                        }

                        model.setValueAt("Reservé", i, k);
                        k++;
                    }
                }
            }
        }

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

    LocalDate setDate(LocalDate date) {
        this.date = date;
        return date;
    }    
    
}