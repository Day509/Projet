package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import Model.*;
import View.*;
 
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame; 

public class afficheButtonControl implements ActionListener {

    Hotel hotel;
    JTextField num;
    String numString;
    int numInt;

    

    Reservation Reservation;

    public afficheButtonControl(Hotel hotel, JTextField num) {
        this.hotel = hotel;
        this.num = num;
    }

    

    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if (button.getText().equals("Afficher")) {

            numString = num.getText();
            numInt = Integer.parseInt(numString);
            if (numString.equals("")) {
                JOptionPane.showMessageDialog(null, "Veuillez remplir le champ", "Erreur",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            else {

                Reservation = hotel.getReservationById(numInt);

                facture facture = new facture(hotel,Reservation);
                JDialog dialog = new JDialog();
                dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                dialog.setContentPane(facture);
                dialog.pack();
                dialog.setVisible(true);

               

                return;
            }

        }
    }

}
