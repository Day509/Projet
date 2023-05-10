package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.time.LocalDate;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class RoomPage extends JPanel {

    private final int NB_CHAMBRES = 10; // nombre de chambres
    private final int NB_JOURS = 8; // nombre de jours à afficher
    private final String[] JOURS_SEMAINE = {"", "Lun", "Mar", "Mer", "Jeu", "Ven", "Sam", "Dim" }; // jours de la semaine
    private final int TAILLE_CASE = 40; // taille des cases du tableau
    LocalDate date;
    JTable table;

    public RoomPage() {
        setLayout(new BorderLayout());
        // création du panneau pour le tableau
        LocalDate date = LocalDate.now();
        DefaultTableModel model = new DefaultTableModel(NB_CHAMBRES, NB_JOURS);
        model.setColumnIdentifiers(JOURS_SEMAINE);
        // ajout des jours de la semaine dans la première ligne
        

        // ajout des cellules pour chaque chambre
        for (int i = 0; i < NB_CHAMBRES; i++) {
            model.setValueAt("Chambre " + (i+1), i, 0);
            for (int j = 1; j < NB_JOURS; j++) {
                model.setValueAt("", i, j);
            }
        }
        
        

        // création du tableau avec le modèle
        table = new JTable(model);
        table.setRowHeight(TAILLE_CASE);
        table.getTableHeader().setPreferredSize(new Dimension(0, TAILLE_CASE));
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
