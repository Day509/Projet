

package Controller;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import View.*;

public class creatControl implements ActionListener {

	JButton button1;
	HotelInformation HotelInformation ;
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();//recuperer la dimension de l'ecrant

	public creatControl(JButton button1,HotelInformation HotelInformation) {
		this.button1 = button1;
        this.HotelInformation=HotelInformation;
	}

	@Override

	public void actionPerformed(ActionEvent e) {
		//JButton button = (JButton) e.getSource();

			// ajoute un ActionListener au bouton pour gérer l'événement de clic.
            View View=new View(dim.height, dim.width)	;
            View.setVisible(true);		//Login.setVisible(true);
			HotelInformation.setVisible(false);

		
	}

	// public static void main(String[] args) {
	// new CreateHotel();
	// }
}