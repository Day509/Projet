package Controller;

import java.awt.event.*;
import javax.swing.*;
import View.*;

public class NameControl implements ActionListener {

	JButton button1;
	JButton button2;
	Name section3;
	JPanel HotelInformation;
	JPanel Login;

	public NameControl(JButton button1, JButton button2, JPanel HotelInformation, JPanel Login, Name Name) {
		this.button1 = button1;
		this.button2 = button2;

		this.HotelInformation = HotelInformation;
		this.Login = Login;
		this.section3 = Name;

	}

	@Override

	public void actionPerformed(ActionEvent e) {
		// JButton button = (JButton) e.getSource();

		if (((JButton) e.getSource()).getText().equals("Se connecter")) {
			HotelInformation.setVisible(false);
			Login.setVisible(true);
			section3.setVisible(false);
		}

		else if (((JButton) e.getSource()).getText().equals("Ajouter un hôtel")) {
			HotelInformation.setVisible(true);
			Login.setVisible(false);
			section3.setVisible(false);

		}
	}
}