
package Controller;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import View.*;

public class LoginControl implements ActionListener {

	JButton button1;
	Login Login;
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();// recuperer la dimension de l'ecrant
	View view;
	String textExpected = "admin";
	JTextField text;

	public LoginControl(JButton button1, Login Login, JTextField textField) {
		this.button1 = button1;
		this.Login = Login;
		text = textField;
	}

	public void actionPerformed(ActionEvent e) {
		String textEntered = text.getText();
		// ajoute un ActionListener au bouton pour gérer l'événement de clic.
		if (((JButton) e.getSource()).getText().equals("Se connecter") && textEntered.equals(textExpected) ) {
			view = new View(dim.height, dim.width);
			Container parentContainer = Login.getParent();
			parentContainer.add(view);
			parentContainer.revalidate();
			parentContainer.repaint();
			view.setVisible(true);
			Login.setVisible(false);
		}
		else {
			JOptionPane.showMessageDialog(null, "Hôtel introuvable", "Erreur", JOptionPane.ERROR_MESSAGE);
		}
	}
}