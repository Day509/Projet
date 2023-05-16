
package View;

import java.awt.*;
import javax.swing.*;
 
import Model.Hotel;

import Controller.*;

public class CreateFacture extends JPanel {
    public JTextField txtNom;
    
    
    public CreateFacture(Hotel hotel) {
        

        setLayout(new GridBagLayout());
        // Ajustez les dimensions selon vos besoins
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(20, 20, 20, 20); // Espacement augmenté

        // Titre "Création de l'hôtel"
        JLabel lblTitre = new JLabel("Facture");
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
        JLabel lblNum = new JLabel("Num de Reservation:");
        panelConstraints.gridx = 0;
        panelConstraints.gridy = 0;
        panelConstraints.anchor = GridBagConstraints.EAST;
        panelZonesTexte.add(lblNum, panelConstraints);

        txtNom = new JTextField(30); // Largeur augmentée
        panelConstraints.gridx = 1;
        panelConstraints.gridy = 0;
        panelConstraints.anchor = GridBagConstraints.WEST;
        panelZonesTexte.add(txtNom, panelConstraints);

       


        // Bouton "Afficher"
        JButton btnAfficher = new JButton("Afficher");
        btnAfficher.setFont(new Font("Arial", Font.BOLD, 24)); // Police de caractères agrandie
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        add(btnAfficher, constraints);
        
        afficheButtonControl control = new afficheButtonControl(hotel,txtNom);
        btnAfficher.addActionListener(control);
    }
}