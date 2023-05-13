package View;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class CreateRoom extends JPanel {
    private JTextField txtNChambre;
    private JTextField txtNetage;
    private JTextField txtPrixParNuit;
    private JTextField txtNbrLits;

    public CreateRoom() {
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(20, 20, 20, 20); // Espacement augmenté

        // Titre "AJOUTER CHAMBRE"
        JLabel lblTitre = new JLabel("Chambre");
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

        // Label et zone de texte "Numéro chambre"
        JLabel lblNChambre = new JLabel("Numéro chambre:");
        panelConstraints.gridx = 0;
        panelConstraints.gridy = 0;
        panelConstraints.anchor = GridBagConstraints.EAST;
        panelZonesTexte.add(lblNChambre, panelConstraints);

        txtNChambre = new JTextField(30); // Largeur augmentée
        panelConstraints.gridx = 1;
        panelConstraints.gridy = 0;
        panelConstraints.anchor = GridBagConstraints.WEST;
        panelZonesTexte.add(txtNChambre, panelConstraints);

        // Label et zone de texte "Numéro étage"
        JLabel lblNetage = new JLabel("Numéro étage:");
        panelConstraints.gridx = 0;
        panelConstraints.gridy = 1;
        panelConstraints.anchor = GridBagConstraints.EAST;
        panelZonesTexte.add(lblNetage, panelConstraints);

        txtNetage = new JTextField(30); // Largeur augmentée
        panelConstraints.gridx = 1;
        panelConstraints.gridy = 1;
        panelConstraints.anchor = GridBagConstraints.WEST;
        panelZonesTexte.add(txtNetage, panelConstraints);

        // Label et zone de texte "Prix par nuit"
        JLabel lblPrixParNuit = new JLabel("Prix par nuit:");
        panelConstraints.gridx = 0;
        panelConstraints.gridy = 2;
        panelConstraints.anchor = GridBagConstraints.EAST;
        panelZonesTexte.add(lblPrixParNuit, panelConstraints);

        txtPrixParNuit = new JTextField(30); // Largeur augmentée
        panelConstraints.gridx = 1;
        panelConstraints.gridy = 2;
        panelConstraints.anchor = GridBagConstraints.WEST;
        panelZonesTexte.add(txtPrixParNuit, panelConstraints);

        // Label et zone de texte "Nombre de lits"
        JLabel lblNbrLits = new JLabel("Nombre de lits:");
        panelConstraints.gridx = 0;
        panelConstraints.gridy = 3;
        panelConstraints.anchor = GridBagConstraints.EAST;
        panelZonesTexte.add(lblNbrLits, panelConstraints);

        txtNbrLits = new JTextField(30); // Largeur augmentée
        panelConstraints.gridx = 1;
        panelConstraints.gridy = 3;
        panelConstraints.anchor = GridBagConstraints.WEST;
        panelZonesTexte.add(txtNbrLits, panelConstraints);

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
            frame.getContentPane().add(new CreateRoom());
            frame.pack();
            frame.setVisible(true);
        });
    }
}
