package View;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Controller.*;
public class Dashboard extends JPanel {

    int height;
    int width;
    //JPanel panelContainer;

    // Initialisation des sections
    JPanel section1 = new TableauDeBord( height, width);
    JPanel section2 = new RoomPage();
    JPanel section3 = new ReservPage();
    //section4 = new Section4();

    JPanel panelContainer;

    
    JButton dashButton;
    JButton roomButton;
    JButton reservButton;
    JButton youHotelButton;

        

    public Dashboard(int h, int w) {
        height = h;
        width = w;
        // Affichage de la section 1 par défaut
        //mainContent=section1;
        panelContainer = new JPanel();
        panelContainer.setLayout(new CardLayout());
        panelContainer.add(section1);
        panelContainer.add(section2);
        panelContainer.add(section3);
    //j'affiche le tableau de brod par defaut
        section1.setVisible(true);

        

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
         //gestion des boutttons de la sidebare
        SideBarControl SideBarControl=new SideBarControl(dashButton,roomButton,reservButton,youHotelButton,section1,section2,section3);
        dashButton.addActionListener(SideBarControl);
        roomButton.addActionListener(SideBarControl);
        reservButton.addActionListener(SideBarControl);
        youHotelButton.addActionListener(SideBarControl);

    
        JPanel wPanel = new WeekPanel();

        GridBagConstraints gbcSideBar = new GridBagConstraints();

        // Définition des contraintes pour la sidebar
        gbcSideBar.gridx = 0;
        gbcSideBar.gridy = 0;
        gbcSideBar.anchor = GridBagConstraints.NORTHWEST; 
        gbcSideBar.gridheight = GridBagConstraints.REMAINDER; 
        gbcSideBar.fill = GridBagConstraints.VERTICAL; 
        panel.add(sideBar, gbcSideBar);

        GridBagConstraints gbcWeekPanel = new GridBagConstraints(); // contraintes
        gbcWeekPanel.anchor = GridBagConstraints.EAST; // alignement
        gbcWeekPanel.insets = new Insets(0, 0, 5, 20); // margin
        panel.add(wPanel, gbcWeekPanel);

        // Définition des contraintes pour le mainContent
        GridBagConstraints gbcmainContent = new GridBagConstraints(); // contraintes
        gbcmainContent.anchor = GridBagConstraints.EAST; // alignement
        gbcmainContent.insets = new Insets(0, 0, 0, 20); // margin
        gbcmainContent.fill = GridBagConstraints.BOTH; // remplissage

        gbcmainContent.weightx = 1.0; // poid en x
        panel.add(panelContainer, gbcmainContent); // ajout du panel au panel principal

        //panel.add(section2, gbcmainContent);
        //panel.add(section3, gbcmainContent);
        


       

        return panel;

    }

    private JPanel sidebar() {
        // Création du sidebar
        JPanel panel = new JPanel(new GridLayout(14, 1, 0, 10));
        panel.setBackground(new Color(51, 70, 88, 127));
        panel.setPreferredSize(new Dimension(200, 400));

         dashButton = new JButton("Tableau de bord");
        //this.dashButton=dashButton;
         roomButton = new JButton("Chambres");
        //this.roomButton=roomButton;
         reservButton = new JButton("Réservations");
        //this.reservButton=reservButton;
         youHotelButton = new JButton("Votre hôtel");
        //this.youHotelButton=youHotelButton;

        // Ajout des boutons au sidebar
        panel.add(dashButton);
        panel.add(roomButton);
        panel.add(reservButton);
        panel.add(youHotelButton);


        return panel;
    }




}