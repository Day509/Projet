package View;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class CreateReservation extends JPanel {
    private JTextField txtNom;
    private JTextField txtPrenom;
    private JTextField txtNbChambres;
    private JTextField txtArrivée;
    private JTextField txtDepart;
    public CreateReservation() {
        setLayout(new GridBagLayout());
         // Ajustez les dimensions selon vos besoins
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(20, 20, 20, 20); // Espacement augmenté

        // Titre "Création de l'hôtel"
        JLabel lblTitre = new JLabel("Réservation");
        lblTitre.setFont(new Font("Arial", Font.BOLD, 36)); // Police de caractères agrandie
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        add(lblTitre, constraints);

        // Panel pour contenir les zones de texte
        JPanel panelZonesTexte = new JPanel(new GridBagLayout());
        panelZonesTexte.setBackground(Color.LIGHT_GRAY);
        panelZonesTexte.setBorder(new RoundedBorder(20)); // Bordure arrondie, rayon augmenté
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        add(panelZonesTexte, constraints);

        GridBagConstraints panelConstraints = new GridBagConstraints();
        panelConstraints.insets = new Insets(20, 20, 20, 20); // Espacement augmenté

        // Label et zone de texte "Nom"
        JLabel lblNom = new JLabel("Nom:");
        panelConstraints.gridx = 0;
        panelConstraints.gridy = 0;
        panelConstraints.anchor = GridBagConstraints.EAST;
        panelZonesTexte.add(lblNom, panelConstraints);

        txtNom = new JTextField(30); // Largeur augmentée
        panelConstraints.gridx = 1;
        panelConstraints.gridy = 0;
        panelConstraints.anchor = GridBagConstraints.WEST;
        panelZonesTexte.add(txtNom, panelConstraints);

        // Label et zone de texte "prenom"
        JLabel lblPrenom = new JLabel("Prénom:");
        panelConstraints.gridx = 0;
        panelConstraints.gridy = 1;
        panelConstraints.anchor = GridBagConstraints.EAST;
        panelZonesTexte.add(lblPrenom, panelConstraints);

        txtPrenom = new JTextField(30); // Largeur augmentée
        panelConstraints.gridx = 1;
        panelConstraints.gridy = 1;
        panelConstraints.anchor = GridBagConstraints.WEST;
        panelZonesTexte.add(txtPrenom, panelConstraints);

        // Label et zone de texte "Numero chambre"
        JLabel lblNbChambres = new JLabel("Numéro de chambre:");
        panelConstraints.gridx = 0;
        panelConstraints.gridy = 2;
        panelConstraints.anchor = GridBagConstraints.EAST;
        panelZonesTexte.add(lblNbChambres, panelConstraints);

        txtNbChambres = new JTextField(30); // Largeur augmentée
        panelConstraints.gridx = 1;
        panelConstraints.gridy = 2;
        panelConstraints.anchor = GridBagConstraints.WEST;
        panelZonesTexte.add(txtNbChambres, panelConstraints);

        // Label et zone de texte "arrivée"
        JLabel lblArrivée = new JLabel("Arrivée:");
        panelConstraints.gridx = 0;
        panelConstraints.gridy = 3;
        panelConstraints.anchor = GridBagConstraints.EAST;
        panelZonesTexte.add(lblArrivée, panelConstraints);

        txtArrivée = new JTextField(30); // Largeur augmentée
        panelConstraints.gridx = 1;
        panelConstraints.gridy = 3;
        panelConstraints.anchor = GridBagConstraints.WEST;
        panelZonesTexte.add(txtArrivée, panelConstraints);

        // Label et zone de texte "depart"
        JLabel lblDepart = new JLabel("Départ:");
        panelConstraints.gridx = 0;
        panelConstraints.gridy = 4;
        panelConstraints.anchor = GridBagConstraints.EAST;
        panelZonesTexte.add(lblDepart, panelConstraints);

        txtDepart = new JTextField(30); // Largeur augmentée
        panelConstraints.gridx = 1;
        panelConstraints.gridy = 4;
        panelConstraints.anchor = GridBagConstraints.WEST;
        panelZonesTexte.add(txtDepart, panelConstraints);

        // Bouton "Créer"
        JButton btnCreer = new JButton("Ajouter");
        btnCreer.setFont(new Font("Arial", Font.BOLD, 24)); // Police de caractères agrandie
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        add(btnCreer, constraints);
    }

    // Classe pour la bordure arrondie du panneau
    private static class RoundedBorder implements Border {
        private int radius;

        RoundedBorder(int radius) {
            this.radius = radius;
        }

        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
        }

        public boolean isBorderOpaque() {
            return true;
        }

        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Fenêtre de l'hôtel");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(new CreateReservation());
            frame.pack();
            frame.setVisible(true);
        });
    }
}