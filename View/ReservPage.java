package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.AbstractButton;
import javax.swing.JButton;
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
    private int NB_COLONNES = 8; // nombre de colonnes à afficher
    private int NB_LIGNES = g.getAllReservations().size(); // nombre de lignes à afficher

    public ReservPage() {
        createReservation = new CreateReservation();
        setLayout(new BorderLayout());

        // création du panneau pour le tableau
        JPanel tableauPanel = new JPanel(new BorderLayout());
        tableauPanel.setBackground(Color.WHITE);

        // création des données du tableau
        String[] titresColonnes = { "N°Resa", "N°Chambre", "Nom", "Prénom", "Arrivée", "Départ", "Status", "Facture" };
        Object[][] donneesTableau = new Object[NB_LIGNES][NB_COLONNES];
        for (int i = 0; i < NB_LIGNES; i++) {
            donneesTableau[i][0] = g.getAllReservations().get(i).getReservation().id;
            donneesTableau[i][1] = i; // g.getAllReservations().get(i).getReservations().get(i).getChambre().getIdChambre();
            donneesTableau[i][2] = g.getAllReservations().get(i).getReservation().getClient().getNom();
            donneesTableau[i][3] = g.getAllReservations().get(i).getReservation().getClient().getPrenom();
            donneesTableau[i][4] = g.getAllReservations().get(i).getReservation().getStartdate();
            donneesTableau[i][5] = g.getAllReservations().get(i).getReservation().getEnddate();
            donneesTableau[i][6] = "En cours";
            donneesTableau[i][7] = new JButton("Facture");
        }

        // création du modèle de tableau
        DefaultTableModel modeleTableau = new DefaultTableModel(donneesTableau, titresColonnes);

        // création du tableau
        JTable tableau = new JTable(modeleTableau);
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

        ButtonRenderer buttonRenderer = new ButtonRenderer();
        tableau.getColumnModel().getColumn(7).setCellRenderer(buttonRenderer);

        // ajout du tableau dans un panneau avec barre de défilement
        JScrollPane scrollPane = new JScrollPane(tableau);
        tableauPanel.add(scrollPane, BorderLayout.CENTER);

        tableauPanel.setPreferredSize(new Dimension(getWidth(), getHeight()));
        add(tableauPanel, BorderLayout.CENTER);

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
    private void createReservWindow() {
        JFrame frame = new JFrame("Ajouter une Reservation");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(createReservation);
        frame.pack();
        frame.setVisible(true);
    }
    public AbstractButton getAddReservationButton() {
        return null;
    }
}