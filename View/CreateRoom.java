package View;

import java.awt.*;

import javax.swing.*;

import Controller.ControlChambre;
import Model.Hotel;

public class CreateRoom extends JPanel {
    private JTextField txtNChambre;
    private JTextField txtNetage;
    private JTextField txtPrixParNuit;
    private JTextField txtNbrLits;
    Hotel hotel;
    RoomPage room;
    
    public CreateRoom(Hotel hotel, RoomPage roomPage) {
        this.hotel = hotel;
        this.room = roomPage;
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

        ControlChambre control = new ControlChambre(this.hotel, txtNChambre, txtNetage, txtPrixParNuit, txtNbrLits);

        btnCreer.addActionListener(control);
    }    
} 
