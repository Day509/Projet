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
import View.RoomPage;

public class ControlChambre implements ActionListener {

    Hotel hotel;
    CreateRoom c;
    JTextField[] txt = new JTextField[4];
    static int id = 0;
    int[] toInt = new int[3];
    Double ppn;
    JDialog dialog = new JDialog();
    RoomPage r;

    public ControlChambre(Hotel hotel, RoomPage room) {
        this.hotel = hotel;
        r = room;
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
            c = new CreateRoom(hotel, r);
            dialog.add(c);
            dialog.pack();
            dialog.setVisible(true);
        }

        if (e.getSource() instanceof JButton && ((JButton) e.getSource()).getText().equals("Ajouter")) {

            if (dialog != null) {
                if (txt[0].getText().equals("") || txt[1].getText().equals("") || txt[2].getText().equals("")
                        || txt[2].getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs", "Erreur",
                            JOptionPane.ERROR_MESSAGE);
                }

                else {
                    try {
                        toInt[0] = Integer.parseInt(txt[0].getText());
                        toInt[1] = Integer.parseInt(txt[1].getText());
                        ppn = Double.parseDouble(txt[2].getText());
                        toInt[2] = Integer.parseInt(txt[3].getText());
                    } catch (NumberFormatException nfe) {
                        JOptionPane.showMessageDialog(null, "Veuillez entrer des nombres", "Erreur",
                                JOptionPane.ERROR_MESSAGE);
                    }

                    if (toInt[0] < 0 || toInt[1] < 0 || ppn < 0 || toInt[2] < 0) {
                        JOptionPane.showMessageDialog(null, "Veuillez entrer des nombres positifs", "Erreur",
                                JOptionPane.ERROR_MESSAGE);
                    } else {
                        hotel.ajouterChambre(new Chambre(toInt[0], toInt[1], ppn, toInt[2], hotel));
                        JOptionPane.showMessageDialog(null, "Chambre ajoutée", "Confirmation",
                                JOptionPane.PLAIN_MESSAGE);
                        if (r != null) {
                            r.updateTableData();
                        }

                    }
                }
            }
        }
    }
}