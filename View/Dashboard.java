package View;

import java.awt.*;
import javax.swing.*;

public class Dashboard extends JPanel {

    int height;
    int width;

    public Dashboard(int h, int w) {
        height = h;
        width = w;

        JPanel panel = showDashboard(h, w);
        int w_dash = w / 2 + 400;
        int h_dash = h / 2 + 200;
        panel.setPreferredSize(new Dimension(w_dash, h_dash));

        this.add(panel);
    }

    private JPanel showDashboard(int h, int w) {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(255, 255, 255, 215));

        JPanel sideBar = sidebar();

        GridBagConstraints gbcSideBar = new GridBagConstraints();

        // Définition des contraintes pour la sidebar
        gbcSideBar.gridx = 0;
        gbcSideBar.gridy = 0;
        gbcSideBar.anchor = GridBagConstraints.NORTHWEST;
        gbcSideBar.gridheight = GridBagConstraints.REMAINDER;
        gbcSideBar.fill = GridBagConstraints.VERTICAL;
        panel.add(sideBar, gbcSideBar);

        JPanel mainContent = mainContenJPanel();

        // Définition des contraintes pour le mainContent
        GridBagConstraints gbcmainContent = new GridBagConstraints();
        gbcmainContent.gridx = 0;
        gbcmainContent.gridy = 0;
        gbcmainContent.anchor = GridBagConstraints.EAST;
        gbcmainContent.insets = new Insets(40, 0, 0, 20);
        gbcmainContent.weightx = 1.0;
        panel.add(mainContent, gbcmainContent);

        JPanel roomPanel1 = roomPanel(Color.red);
        JPanel roomPanel2 = roomPanel(Color.blue);

        // Définition des contraintes pour le roomPanel1
        GridBagConstraints gbcroomPanel1 = new GridBagConstraints();
        gbcroomPanel1.gridx = 0;
        gbcroomPanel1.gridy = 0;
        gbcroomPanel1.anchor = GridBagConstraints.NORTHEAST;
        gbcroomPanel1.insets = new Insets(0, 0, 0, 0);
        gbcroomPanel1.weightx = 1.0;
        panel.add(roomPanel1, gbcroomPanel1);

        // Définition des contraintes pour le roomPanel2
        GridBagConstraints gbcroomPanel2 = new GridBagConstraints();
        gbcroomPanel2.gridx = 0;
        gbcroomPanel2.gridy = 1;
        gbcroomPanel2.anchor = GridBagConstraints.NORTHEAST;
        gbcroomPanel2.insets = new Insets(0, 0, 0, 0);
        gbcroomPanel2.weightx = 1.0;
        panel.add(roomPanel2, gbcroomPanel2);        

        return panel;

    }

    private JPanel sidebar() {
        // Création du sidebar
        JPanel panel = new JPanel(new GridLayout(14, 1, 0, 10));
        panel.setBackground(new Color(51, 70, 88, 127));
        panel.setPreferredSize(new Dimension(200, 400));

        JButton dashButton = new JButton("Tableau de bord");
        JButton roomButton = new JButton("Chambres");
        JButton reservButton = new JButton("Réservations");
        JButton youHotelButton = new JButton("Votre hôtel");

        // Ajout des boutons au sidebar
        panel.add(dashButton);
        panel.add(roomButton);
        panel.add(reservButton);
        panel.add(youHotelButton);

        return panel;
    }

    private JPanel mainContenJPanel() {
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(width - (width / 3 + 75), height - (height / 3 + 100)));
        panel.setBorder(BorderFactory.createEmptyBorder(0, 400, 0, 100));
        panel.setBackground(new Color(255, 255, 255, 215));

        return panel;
    }

    private JPanel roomPanel(Color color) {
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(100, 40));
        panel.setBackground(color);

        return panel;
    }

}
