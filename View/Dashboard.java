package View;

import java.awt.*;
import javax.swing.*;
import Controller.SideBarControl;

public class Dashboard extends JPanel {

    int height;
    int width;
    JPanel mainContent;


    public Dashboard(int h, int w) {
        height = h;
        width = w;
        mainContent = new ReservPage();

        JPanel panel = showDashSection();
        int w_dash = w / 2 + 400;
        int h_dash = h / 2 + 200;
        panel.setPreferredSize(new Dimension(w_dash, h_dash));

        this.add(panel);
    }

    private JPanel showDashSection() {
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


        // Définition des contraintes pour le mainContent
        GridBagConstraints gbcmainContent = new GridBagConstraints(); // contraintes
        gbcmainContent.anchor = GridBagConstraints.EAST; // alignement
        gbcmainContent.insets = new Insets(40, 0, 0, 20); // margin
        gbcmainContent.fill = GridBagConstraints.BOTH; // remplissage

        gbcmainContent.weightx = 1.0; // poid en x
        panel.add(mainContent, gbcmainContent); // ajout du panel au panel principal

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

        SideBarControl controller = new SideBarControl(mainContent);
        dashButton.addActionListener(controller);
        roomButton.addActionListener(controller);
        reservButton.addActionListener(controller);
        youHotelButton.addActionListener(controller);

        return panel;
    }

}
