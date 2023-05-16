package View;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Model.Hotel;

public class yourHotel extends JPanel {

    private JLabel nameLabel;
    private JLabel addressLabel;
    private JLabel roomCountLabel;
    private JLabel clientCountLabel;

    public yourHotel(Hotel hotel) {
        setLayout(new GridBagLayout());

        // Création des étiquettes pour les informations de l'hôtel
        nameLabel = new JLabel("Nom de l'hôtel: " + hotel.getNom());
        nameLabel.setFont(new Font("Arial", Font.BOLD, 36));
        addressLabel = new JLabel("Adresse de l'hôtel: " + hotel.getAdresse());
        addressLabel.setFont(new Font("Arial", Font.BOLD, 36));
        roomCountLabel = new JLabel("Nombre de chambres: " + hotel.getListChambres());
        roomCountLabel.setFont(new Font("Arial", Font.BOLD, 36));
        clientCountLabel = new JLabel("Nombre de clients: " + hotel.getlistClient());
        clientCountLabel.setFont(new Font("Arial", Font.BOLD, 36));

        // Configuration des contraintes pour les composants
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.NORTHWEST; // Set anchor to top left
        constraints.fill = GridBagConstraints.NONE; // Set fill to none
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets.left = 10;
        constraints.insets.top = 10;

        // Ajout des composants au panel avec les contraintes
        add(nameLabel, constraints);

        constraints.gridy = 1;
        add(addressLabel, constraints);

        constraints.gridy = 2;
        add(roomCountLabel, constraints);

        constraints.gridy = 3;
        add(clientCountLabel, constraints);
    }
}
