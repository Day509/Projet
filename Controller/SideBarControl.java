package Controller;
    
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.Toolkit;

import View.*;

public class SideBarControl implements ActionListener{

    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();//recuperer la dimension de l'ecrant
    //TableauDeBord TableauDeBord=new TableauDeBord(dim.height, dim.width);
    //RoomPage RoomPage =new RoomPage();
    //ReservPage ReservPage =new ReservPage();
    JButton dashButton;
    JButton roomButton;
    JButton reservButton;
    JButton youHotelButton;
    Dashboard Dashboard;
    JPanel section1;
    JPanel section2;
    JPanel section3;
    //JPanel mainContent;

    public SideBarControl(JButton dashButton,JButton roomButton,JButton reservButton,JButton youHotelButton
    ,JPanel section1,JPanel section2,JPanel section3) {
        this.dashButton = dashButton;
        this.roomButton = roomButton;
        this.reservButton = reservButton;
        this.youHotelButton = youHotelButton;
        this.section1 = section1;
        this.section2 = section2;
        this.section3 = section3;
     }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if (button == dashButton) {
            // Faire quelque chose lorsque le bouton 1 est cliqué
            section2.setVisible(false);
            section3.setVisible(false);
            section1.setVisible(true);
            //mainContent=section1;
            
            //section4.hide();
        } else if (button == roomButton) {
            // Faire quelque chose lorsque le bouton 2 est cliqué
            section1.setVisible(false);
            section3.setVisible(false);
            section2.setVisible(true);
            
            //section3.setVisible(false);
            //section2.setVisible(true);
           
        } else if (button == reservButton) {
            // Faire quelque chose lorsque le bouton 3 est cliqué
            section1.setVisible(false);
            section2.setVisible(false);
            section3.setVisible(true);
           
        } else if (button == youHotelButton) {
            // Faire quelque chose lorsque le bouton 4 est cliqué
           
        }
    }
}