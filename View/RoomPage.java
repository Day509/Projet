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

public class RoomPage extends JPanel {

    private final int NB_CHAMBRES = 10; // nombre de chambres
    private final int NB_JOURS = 7; // nombre de jours à afficher
    private final String[] JOURS_SEMAINE = {"Lun", "Mar", "Mer", "Jeu", "Ven", "Sam", "Dim"}; // jours de la semaine
    private final int TAILLE_CASE = 40; // taille des cases du tableau
    
    public RoomPage() {
        setLayout(new BorderLayout());
        
        // création du panneau pour les numéros de chambre
        JPanel chambrePanel = new JPanel(new GridLayout(NB_CHAMBRES, 1));
        chambrePanel.setPreferredSize(new Dimension(50, NB_CHAMBRES * TAILLE_CASE));
        chambrePanel.setBackground(Color.WHITE);
        for (int i = 1; i <= NB_CHAMBRES; i++) {
            JLabel label = new JLabel("Chambre " + i, JLabel.CENTER);
            label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            chambrePanel.add(label);
        }
        
        // création du panneau pour le tableau
        JPanel tableauPanel = new JPanel(new GridLayout(NB_CHAMBRES + 1, NB_JOURS));
        tableauPanel.setBackground(Color.WHITE);
        LocalDate date = LocalDate.now();
        
        // ajout des jours de la semaine dans la première ligne
        for (int i = 0; i < NB_JOURS; i++) {
            JLabel label = new JLabel(JOURS_SEMAINE[(date.getDayOfWeek().getValue() - 1 + i) % 7] + " " + date.plusDays(i).getDayOfMonth() + "/" + date.plusDays(i).getMonthValue(), JLabel.CENTER);
            label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            label.setPreferredSize(new Dimension(TAILLE_CASE, TAILLE_CASE));
            label.setFont(new Font("SansSerif", Font.PLAIN, 12));
            tableauPanel.add(label);
        }
        
        // ajout des cellules pour chaque chambre
        for (int i = 1; i <= NB_CHAMBRES; i++) {
            for (int j = 0; j < NB_JOURS; j++) {
                JLabel label = new JLabel();
                label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                label.setPreferredSize(new Dimension(TAILLE_CASE, TAILLE_CASE));
                label.setOpaque(true);
                label.setBackground(Color.PINK);
                tableauPanel.add(label);
            }
        }
        
        add(chambrePanel, BorderLayout.WEST);
        add(tableauPanel, BorderLayout.CENTER);
    }
}
