package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainContent extends JPanel {

    public MainContent(int width, int height) {
        this.setPreferredSize(new Dimension(width - (width / 3 + 75), height - (height / 3 + 100)));
        this.setBackground(new Color(255, 255, 255, 215));

        JPanel topPanel = topPanel();
        topPanel.setBackground(new Color(255, 255, 255, 0));
        GridBagConstraints gbcpanel = new GridBagConstraints();
        gbcpanel.gridx = 0;
        gbcpanel.gridy = 0;
        gbcpanel.insets = new Insets(10, 10, 10, 10);
        gbcpanel.anchor = GridBagConstraints.NORTHWEST; // aligner en haut
        gbcpanel.weightx = 1; // occuper toute la largeur
        gbcpanel.weighty = 1; // occuper toute la hauteur
        gbcpanel.fill = GridBagConstraints.HORIZONTAL; // remplir horizontalement

        this.add(topPanel, gbcpanel);

        JPanel content = content();
        gbcpanel.gridx = 0;
        gbcpanel.gridy = 1; // mettre sur la deuxième rangée
        gbcpanel.insets = new Insets(10, 10, 10, 10);
        gbcpanel.anchor = GridBagConstraints.NORTHWEST; // aligner en haut
        gbcpanel.weightx = 1; // occuper toute la largeur
        gbcpanel.weighty = 1; // occuper toute la hauteur
        gbcpanel.fill = GridBagConstraints.HORIZONTAL; // remplir horizontalement
        gbcpanel.ipady = 2; // hauteur minimum

        this.add(content, gbcpanel);
    }

    private JPanel topPanel() {
        JPanel panel = new JPanel(new GridBagLayout());

        // Création et ajout des 3 RoomPanel avec espacement
        JPanel roomPanel1 = roomPanel(Color.green);
        GridBagConstraints gbcRoomPanel1 = new GridBagConstraints();
        gbcRoomPanel1.gridx = 0;
        gbcRoomPanel1.gridy = 0;
        gbcRoomPanel1.insets = new Insets(10, 10, 10, 10);
        panel.add(roomPanel1, gbcRoomPanel1);

        JPanel roomPanel2 = roomPanel(Color.blue);
        GridBagConstraints gbcRoomPanel2 = new GridBagConstraints();
        gbcRoomPanel2.gridx = 1;
        gbcRoomPanel2.gridy = 0;
        gbcRoomPanel2.insets = new Insets(10, 10, 10, 10);
        panel.add(roomPanel2, gbcRoomPanel2);

        JPanel roomPanel3 = roomPanel(Color.yellow);
        GridBagConstraints gbcRoomPanel3 = new GridBagConstraints();
        gbcRoomPanel3.gridx = 2;
        gbcRoomPanel3.gridy = 0;
        gbcRoomPanel3.insets = new Insets(10, 10, 10, 10);
        panel.add(roomPanel3, gbcRoomPanel3);

        return panel;
    }

    private JPanel content() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(255, 255, 255, 215));

        GridBagConstraints gbc = new GridBagConstraints();

        // Ajouter 6 NumBedPanels avec des espaces entre eux
        for (int i = 0; i < 6; i++) {
            JPanel numBedPanel = NumBedPanel(i + 1);
            gbc.gridx = i;
            gbc.gridy = 0;
            gbc.insets = new Insets(10, 10, 10, 10);
            gbc.anchor = GridBagConstraints.WEST;
            panel.add(numBedPanel, gbc);
        }

        return panel;
    }

    private JPanel NumBedPanel(int numBeds) {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.GRAY);

        // Ajouter une image
        JLabel bedLabel = new JLabel(new ImageIcon(new ImageIcon("View/Image_Hotel/ChambreSimple1.jpg").getImage()
                .getScaledInstance(80, 50, Image.SCALE_DEFAULT))); // Remplace "View/Image_Hotel/ChambreSimple1.jpg" par
                                                                   // le chemin vers ton image
        GridBagConstraints gbcBedLabel = new GridBagConstraints();
        gbcBedLabel.gridx = 0;
        gbcBedLabel.gridy = 0;
        gbcBedLabel.insets = new Insets(0, 0, 5, 0); // Ajouter une marge en bas pour séparer l'image du texte
        panel.add(bedLabel, gbcBedLabel);

        // Ajouter le nombre de lits
        JLabel numBedsLabel = new JLabel(numBeds + " lits");
        GridBagConstraints gbcNumBedsLabel = new GridBagConstraints();
        gbcNumBedsLabel.insets = new Insets(0, 0, 20, 0); // Ajouter une marge en bas pour séparer l'image du texte
        gbcNumBedsLabel.gridx = 0;
        gbcNumBedsLabel.gridy = 1;
        gbcNumBedsLabel.anchor = GridBagConstraints.NORTHWEST;
        panel.add(numBedsLabel, gbcNumBedsLabel);

        return panel;
    }

    private JPanel roomPanel(Color color) {
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(200, 100));
        panel.setBackground(color);

        return panel;
    }
}
