package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Model.Chambre;
import Model.Client;
import Model.Hotel;
import Model.Reservation;

public class reserveButtonControl implements ActionListener {

	Hotel hotel;
	JTextField[] text = new JTextField[6];

	public reserveButtonControl(Hotel hotel, JTextField nom, JTextField prenom, JTextField numCham,
			JTextField arrivée, JTextField départ) {
		this.hotel = hotel;
		this.text[0] = nom;
		this.text[1] = prenom;
		this.text[2] = numCham;
		this.text[3] = arrivée;
		this.text[4] = départ;

	}

	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		if (button.getText().equals("Ajouter")) {
			String[] textEntered = new String[text.length + 1];
			for (int i = 0; i < text.length; i++) {
				textEntered[i] = text[i].getText();
			}
			LocalDate[] dateEntered = new LocalDate[2];

			for (String i : textEntered) {
				if (i.equals("")) {
					JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs", "Erreur",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				else {
					try {

						dateEntered[0] = LocalDate.parse(textEntered[2]);
						dateEntered[1] = LocalDate.parse(textEntered[3]);
					} catch (DateTimeParseException nf) {
						JOptionPane.showMessageDialog(null, "Veuillez entrer des valeurs numériques", "Erreur",
								JOptionPane.ERROR_MESSAGE);
						return;
					}

					if (dateEntered[0].isBefore(LocalDate.now())
							|| dateEntered[1].isBefore(LocalDate.now())) {
						JOptionPane.showMessageDialog(null, "Veuillez entrer une date ulterieure", "Erreur",
								JOptionPane.ERROR_MESSAGE);
						return;
					}

					else if (dateEntered[0].isAfter(dateEntered[1])) {
						JOptionPane.showMessageDialog(null, "Veuillez entrer une date de départ ultérieure", "Erreur",
								JOptionPane.ERROR_MESSAGE);
						return;
					}

					else {
						Chambre[] room = new Chambre[1];
						room[1] = new Chambre(
								hotel.getListChambres().get(Integer.parseInt(textEntered[2])).getIdChambre(),
								hotel.getListChambres().get(Integer.parseInt(textEntered[2])).getEtage(),
								hotel.getListChambres().get(Integer.parseInt(textEntered[2])).getPrixParNuit(),
								hotel.getListChambres().get(Integer.parseInt(textEntered[2])).getNbrLits(), hotel);
						Client c = new Client(textEntered[0], textEntered[1], null, null, null, hotel);
						Reservation resa = new Reservation(c, room, dateEntered[0], dateEntered[1], room.length);
						hotel.getListChambres().get(Integer.parseInt(textEntered[2])).ajoutResa(resa);
						JOptionPane.showMessageDialog(null, "Réservation ajoutée", "Confirmation",
								JOptionPane.INFORMATION_MESSAGE);
						return;
					}

				}
			}
		}
	}
}