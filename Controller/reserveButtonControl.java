package Controller;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import View.*;

public class reserveButtonControl implements ActionListener {

	JButton button1;
	ReservPage ReservPage ;
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();//recuperer la dimension de l'ecrant

	public reserveButtonControl(JButton button1,ReservPage ReservPage) {
		this.button1 = button1;
        this.ReservPage=ReservPage;
	}

	@Override

	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();

			// ajoute un ActionListener au bouton pour gérer l'événement de clic.
            
            	//TRAITMENT A FAIRE POUR RESERVER 

            ReservPage.setVisible(false);

		
	}
}