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

public class TableauDeBord extends JPanel {

    public TableauDeBord(int width, int height) {
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

        // Ajouter 6 NumBedPanels avec des espaces entre eux

        return panel;
    }

    private JPanel roomPanel(Color color) {
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(200, 100));
        panel.setBackground(color);

        return panel;
    }
}