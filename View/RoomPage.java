package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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

public class RoomPage extends JPanel {
    Generate g = new Generate(new Hotel("Hotel", "Paris"));
    private int NB_CHAMBRES = g.getHotel().getListChambres().size(); // nombre de chambres
    private int NB_JOURS = 7; // nombre de jours à afficher
    private String[] JOURS_SEMAINE = { "Lun", "Mar", "Mer", "Jeu", "Ven", "Sam", "Dim" }; // jours de la semaine
    private int TAILLE_CASE = 40; // taille des cases du tableau
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
                model.setValueAt("", i, j);
            }
        }

        // création du tableau avec le modèle
        table = new JTable(model);
        table.setRowHeight(TAILLE_CASE);
        table.getTableHeader().setPreferredSize(new Dimension(0, TAILLE_CASE));
        table.setFont(new Font("SansSerif", Font.PLAIN, 12));
        
int v=0;
        for (int i = 0; i < NB_CHAMBRES; i++) {
            for (int j = 0; j < NB_JOURS; j++) {
                if (g.getAllReservations().get(i).getReservation().getStartdate().equals(date.plusDays(j))) {
                    System.out.println("Chambre " + (i+1) + " " + g.getAllReservations().get(i).getReservation().DateDebut+ " | Cellule " + i + " / " + j);
                    setCellColor(table, i, j+1, Color.RED); // i+1 car la première colonne est vide
                    v++;
                }
            }
        }
System.out.println("nombre de reservation : "+v);
        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            public void setValue(Object value) {
                setText((value == null) ? "" : value.toString());
            }
        });
        
        System.out.println('\n');

        // ajout du tableau dans un JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension((NB_JOURS + 1) * TAILLE_CASE, NB_CHAMBRES * TAILLE_CASE));

        add(scrollPane, BorderLayout.CENTER);
    }

    LocalDate setDate(LocalDate date) {
        this.date = date;
        return date;
    }

    

    private void setCellColor(JTable table, int row, int column, Color color) {
        table.getColumnModel().getColumn(column).setCellRenderer(new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int rowIndex, int columnIndex) {
                Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, rowIndex, columnIndex);
                
                if (rowIndex == row && columnIndex == column) {
                    cellComponent.setBackground(color);
                } else {
                    cellComponent.setBackground(table.getBackground());
                }
                return cellComponent;
            }
        });
        table.repaint();
    }
}