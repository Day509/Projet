package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import View.*;


public class ControlReservation{
    private ReservPage reservPage;

    public ControlReservation() {
        reservPage = new ReservPage();

        // Add action listener to the "Ajouter une réservation" button
        reservPage.getAddReservationButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open the CreateRoom window
                openCreateRoomWindow();
            }
        });
    }

    private void openCreateRoomWindow() {
        CreateReservation createReservation = new CreateReservation();
        JFrame frame = new JFrame("Ajouter une réservation");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(createReservation);
        frame.pack();
        frame.setVisible(true);
    }

    /*public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ControlChambre controlReservation = new ControlChambre();
            JFrame frame = new JFrame("Fenêtre de l'hôtel");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(controlReservation.reservPage);
            frame.pack();
            frame.setVisible(true);
        });
    }*/
}
