package Controller;

import View.ReservPage;
import View.RoomPage;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import View.*;

public class NameControl implements ActionListener {

	JButton button1;
	JButton button2;
	JPanel Name;

	public NameControl(JButton button1, JButton button2, JPanel Name) {
		this.button1 = button1;
		this.button2 = button2;
		this.Name = Name;

	}

	@Override

	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();

		if (button == button1) {//Se connecter
			// ajoute un ActionListener au bouton pour gérer l'événement de clic.
			Login Login = new Login();
			Login.setVisible(true);
			Name.setVisible(false);
		}
		else

		{if (button == button2) {
			// ajoute un ActionListener au bouton pour gérer l'événement de clic.
			CreateHotel CreateHotel = new CreateHotel();// crée une nouvelle instance de la classe CreateHotel.
			CreateHotel.setVisible(true);// rend la fenêtre de View visible.
			Name.setVisible(false);
		}}
		
	}

	// public static void main(String[] args) {
	// new CreateHotel();
	// }
}