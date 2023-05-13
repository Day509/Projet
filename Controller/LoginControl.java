
package Controller;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import View.*;

public class LoginControl implements ActionListener {

	JButton button1;
	Login Login ;
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();//recuperer la dimension de l'ecrant

	public LoginControl(JButton button1,Login Login) {
		this.button1 = button1;
        this.Login=Login;
	}

	@Override

	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();

			// ajoute un ActionListener au bouton pour gérer l'événement de clic.
            View View=new View(dim.height, dim.width)	;
            View.setVisible(true);		//Login.setVisible(true);
			Login.setVisible(false);

		
	}

	// public static void main(String[] args) {
	// new CreateHotel();
	// }
}