package controleur;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class page5Controleur implements ActionListener {
    JLabel InformationsChambre;
    JButton Retour;
    JLabel typeChambre;
    JTextArea Description;

    public page5Controleur(JLabel InformationsChambre,JButton Retour,JLabel typeChambre,JTextArea Description){
        this.InformationsChambre=InformationsChambre;  
        this.Retour=Retour;  
        this.typeChambre=typeChambre;  
        this.Description=Description;  
    }

    @Override

    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();// je recuperee le button
        { 
            //faire un retour a la page 4
        }
    }

}
