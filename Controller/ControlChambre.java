package Controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import View.*;


public class ControlChambre {
    private RoomPage roomPage;
    public Component reservPage;

    public ControlChambre() {
        roomPage = new RoomPage();

        // Add action listener to the "Ajouter une réservation" button
        roomPage.getAddReservationButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open the CreateRoom window
                openCreateRoomWindow();
            }
        });
    }

    private void openCreateRoomWindow() {
        CreateRoom createRoom = new CreateRoom();
        JFrame frame = new JFrame("Ajouter une réservation");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(createRoom);
        frame.pack();
        frame.setVisible(true);
    }

    /*public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ControlChambre controlReservation = new ControlChambre();
            JFrame frame = new JFrame("Fenêtre de l'hôtel");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(controlReservation.roomPage);
            frame.pack();
            frame.setVisible(true);
        });
    }*/
}
