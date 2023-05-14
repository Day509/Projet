package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class ReservPage extends JPanel {

    private final int NB_COLONNES = 8; // nombre de colonnes à afficher
    private final int NB_LIGNES = 7; // nombre de lignes à afficher
    
    public ReservPage() {
        setLayout(new BorderLayout());
        
        // création du panneau pour le tableau
        JPanel tableauPanel = new JPanel(new BorderLayout());
        tableauPanel.setBackground(Color.WHITE);
        
        // création des données du tableau
        String[] titresColonnes = {"N°Resa", "N°Chambre", "Nom", "Prénom", "Arrivée", "Départ", "Status", "Facture"};
        Object[][] donneesTableau = new Object[NB_LIGNES][NB_COLONNES];
        for (int i = 0; i < NB_LIGNES; i++) {
            donneesTableau[i][0] = "12345";
            donneesTableau[i][1] = "Chambre " + (i + 1);
            donneesTableau[i][2] = "Dupont";
            donneesTableau[i][3] = "Jean";
            donneesTableau[i][4] = "01/06/2023";
            donneesTableau[i][5] = "05/06/2023";
            donneesTableau[i][6] = "En cours";
            donneesTableau[i][7] = "50 €";
        }
        
        // création du modèle de tableau
        DefaultTableModel modeleTableau = new DefaultTableModel(donneesTableau, titresColonnes);
        
        // création du tableau
        JTable tableau = new JTable(modeleTableau);
        tableau.setPreferredScrollableViewportSize(new Dimension(getWidth(), getWidth()));
        tableau.setFillsViewportHeight(true);
        tableau.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        // alignement du contenu des colonnes
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < NB_COLONNES; i++) {
            tableau.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        
        // ajout du tableau dans un panneau avec barre de défilement
        JScrollPane scrollPane = new JScrollPane(tableau);
        tableauPanel.add(scrollPane, BorderLayout.CENTER);

        tableauPanel.setPreferredSize(new Dimension(getWidth(), getHeight()));



        
        add(tableauPanel, BorderLayout.CENTER);
    }
}







































