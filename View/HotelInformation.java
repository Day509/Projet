package View;

import java.awt.*;
import javax.swing.*;
import Controller.*;

public class HotelInformation extends JPanel {
    private JTextField txtNom;
    private JTextField txtAdresse;
    private JTextField txtNbChambres;
    private JTextField txtNbEtages;

    public HotelInformation() {
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(800, 600)); // Ajustez les dimensions selon vos besoins
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(20, 20, 20, 20); // Espacement augmenté

        // Titre "Création de l'hôtel"
        JLabel lblTitre = new JLabel("Création de l'hôtel");
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

        // Label et zone de texte "Nom de votre hôtel"
        JLabel lblNom = new JLabel("Nom de votre hôtel:");
        panelConstraints.gridx = 0;
        panelConstraints.gridy = 0;
        panelConstraints.anchor = GridBagConstraints.EAST;
        panelZonesTexte.add(lblNom, panelConstraints);

        txtNom = new JTextField(30); // Largeur augmentée
        panelConstraints.gridx = 1;
        panelConstraints.gridy = 0;
        panelConstraints.anchor = GridBagConstraints.WEST;
        panelZonesTexte.add(txtNom, panelConstraints);

        // Label et zone de texte "Adresse de l'hôtel"
        JLabel lblAdresse = new JLabel("Adresse de l'hôtel:");
        panelConstraints.gridx = 0;
        panelConstraints.gridy = 1;
        panelConstraints.anchor = GridBagConstraints.EAST;
        panelZonesTexte.add(lblAdresse, panelConstraints);

        txtAdresse = new JTextField(30); // Largeur augmentée
        panelConstraints.gridx = 1;
        panelConstraints.gridy = 1;
        panelConstraints.anchor = GridBagConstraints.WEST;
        panelZonesTexte.add(txtAdresse, panelConstraints);

        // Label et zone de texte "Nombre de chambres par étage"
        JLabel lblNbChambres = new JLabel("Nombre de chambres par étage:");
        panelConstraints.gridx = 0;
        panelConstraints.gridy = 2;
        panelConstraints.anchor = GridBagConstraints.EAST;
        panelZonesTexte.add(lblNbChambres, panelConstraints);

        txtNbChambres = new JTextField(30); // Largeur augmentée
        panelConstraints.gridx = 1;
        panelConstraints.gridy = 2;
        panelConstraints.anchor = GridBagConstraints.WEST;
        panelZonesTexte.add(txtNbChambres, panelConstraints);

        // Label et zone de texte "Nombre d'étages"
        JLabel lblNbEtages = new JLabel("Nombre d'étages:");
        panelConstraints.gridx = 0;
        panelConstraints.gridy = 3;
        panelConstraints.anchor = GridBagConstraints.EAST;
        panelZonesTexte.add(lblNbEtages, panelConstraints);

        txtNbEtages = new JTextField(30); // Largeur augmentée
        panelConstraints.gridx = 1;
        panelConstraints.gridy = 3;
        panelConstraints.anchor = GridBagConstraints.WEST;
        panelZonesTexte.add(txtNbEtages, panelConstraints);

        // Bouton "Créer"
        JButton btnCreer = new JButton("Créer");
        btnCreer.setFont(new Font("Arial", Font.BOLD, 24)); // Police de caractères agrandie
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        add(btnCreer, constraints);

        creatControl creatControl = new creatControl(btnCreer, this, txtNom, txtAdresse, txtNbEtages, txtNbChambres);
        btnCreer.addActionListener(creatControl);
    }
    // Classe pour la bordure arrondie du panneau
}
