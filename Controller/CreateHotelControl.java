package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import View.*;
import java.awt.Dimension;
import java.awt.Toolkit;

public class CreateHotelControl implements ActionListener {

	JButton validerBtn;
	CreateHotel CreateHotel;
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();// recuperer la dimension de l'ecrant

	public CreateHotelControl(JButton validerBtn, CreateHotel CreateHotel) {
		this.validerBtn = validerBtn;
		this.CreateHotel = CreateHotel;
	}

	@Override

	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();

		// ajoute un ActionListener au bouton pour gérer l'événement de clic.
		View View = new View(dim.height, dim.width);
		View.setVisible(true); // Login.setVisible(true);
		CreateHotel.setVisible(false);

	}

}