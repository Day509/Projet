
package Controller;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Model.Hotel;
import View.*;

public class creatControl implements ActionListener {

	JButton button1;
	HotelInformation HotelInformation;
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();// recuperer la dimension de l'ecrant
	JTextField[] champs = new JTextField[4];
	View view;
	Hotel h;

	public creatControl(HotelInformation HotelInformation, JTextField name, JTextField ad,
			JTextField nbrFloor,
			JTextField nbrRoom) {
		this.HotelInformation = HotelInformation;
		champs[0] = name;
		champs[1] = ad;
		champs[2] = nbrFloor;
		champs[3] = nbrRoom;

	}

	@Override

	public void actionPerformed(ActionEvent e) {

		String[] textEntered = new String[4];
		for (int i = 0; i < 4; i++) {
			textEntered[i] = champs[i].getText();
		}
		int[] intEntered = new int[2];

		if (textEntered[0].equals("") || textEntered[1].equals("") || textEntered[2].equals("")
				|| textEntered[3].equals("")) {
			JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs", "Erreur",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		else {
			try {

				intEntered[0] = Integer.parseInt(textEntered[2]);
				intEntered[1] = Integer.parseInt(textEntered[3]);
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "Veuillez entrer des valeurs numériques", "Erreur",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			if (Integer.parseInt(textEntered[2]) < 1 || Integer.parseInt(textEntered[3]) < 1) {
				JOptionPane.showMessageDialog(null, "Veuillez entrer des valeurs positives", "Erreur",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			h = new Hotel(textEntered[0], textEntered[1]);
			view = new View(dim.height, dim.width, h);
			Container parentContainer = HotelInformation.getParent();
			parentContainer.add(view);
			parentContainer.revalidate();
			parentContainer.repaint();
			view.setVisible(true); // Login.setVisible(true);
			HotelInformation.setVisible(false);

		}
	}
}