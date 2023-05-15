package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Model.Chambre;
import Model.Hotel;
import View.CreateRoom;

public class ControlChambre implements ActionListener {

    Hotel hotel;
    CreateRoom c;
    JTextField[] txt = new JTextField[4];
    static int id = 0;
    int[] toInt = new int[4];

    public ControlChambre(Hotel hotel) {
        this.hotel = hotel;

    }

    public ControlChambre(Hotel hotel, JTextField numChambre, JTextField numEtage, JTextField prixParNuit,
            JTextField nbrLits) {
        this.hotel = hotel;
        txt[0] = numChambre;
        txt[1] = numEtage;
        txt[2] = prixParNuit;
        txt[3] = nbrLits;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton && ((JButton) e.getSource()).getText().equals("Ajouter une chambre")) {
            JDialog dialog = new JDialog();
            c = new CreateRoom(hotel);
            dialog.add(c);
            dialog.pack();
            dialog.setVisible(true);
        }
        try {
            for (int i = 0; i < txt.length; i++) {
                toInt[i] = Integer.parseInt(txt[i].getText());
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Veuillez entrer des nombres entiers", "Erreur",
                    JOptionPane.ERROR_MESSAGE);
        }

        if (e.getSource() instanceof JButton && ((JButton) e.getSource()).getText().equals("Valider")) {
            if (txt[0].getText().equals("") || txt[1].getText().equals("") || txt[2].getText().equals("")
                    || txt[3].getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs", "Erreur",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                hotel.ajouterChambre(new Chambre(toInt[0], toInt[1], toInt[2], toInt[3], hotel));
            }
        }
    }
}
