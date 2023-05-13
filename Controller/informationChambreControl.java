
package Controller;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import View.*;

public class informationChambreControl implements ActionListener {

	JButton button1;
	RoomPage RoomPage ;
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();//recuperer la dimension de l'ecrant

	public informationChambreControl(JButton button1,RoomPage RoomPage) {
		this.button1 = button1;
        this.RoomPage=RoomPage;
	}

	@Override

	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();

			// ajoute un ActionListener au bouton pour gérer l'événement de clic.
            informationChambre informationChambre=new informationChambre(dim.height, dim.width)	;
            informationChambre.setVisible(true);		//Login.setVisible(true);
			RoomPage.setVisible(false);

		
	}
}