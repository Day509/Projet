package controleur;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class page4Controleur implements ActionListener {

    JLabel NomHôtel;
    JButton TableauDeBord;
    JButton Chambre;
    JButton Réservation;
    JButton VotreHôtel;

    JButton chH1;
    JButton chH2;
    JButton chH3;

    JButton chB1;
    JButton chB2;
    JButton chB3;
    JButton chB4;
    JButton chB5;

    public page4Controleur(JButton TableauDeBord, JButton Chambre, JButton Réservation, JButton VotreHôtel,
            JButton chH1,
            JButton chH2, JButton chH3, JButton chB1, JButton chB2, JButton chB3, JButton chB4, JButton chB5) {

        this.TableauDeBord = TableauDeBord;
        this.Chambre = Chambre;
        this.Réservation = Réservation;
        this.chH1 = chH1;
        this.chH2 = chH2;
        this.chH3 = chH3;
        this.chB1 = chB1;
        this.chB2 = chB2;
        this.chB3 = chB3;
        this.chB4 = chB4;
        this.chB5 = chB5;

    }

    @Override

    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();// je recuperee le button
        switch (button.getText()) {//
            case "Tableau de bord":// changement de page

                break;
            case "Chambre":// changement de page

                break;
            case "Réservation":// changement de page

                break;
            case "Votre hôtel":// changement de page

                break;
            case "1 lit":// changement de page afficher description 1 lit

                break;
            case "2 lit":// changement de page afficher description 2 lit

                break;
            case "3 lit":// changement de page afficher description 3 lit

                break;
            case "4 lit":// changement de page afficher description 4 lit

                break;
            case "5 lit":// changement de page afficher description 5 lit

                break;
          
        }
    }

}
