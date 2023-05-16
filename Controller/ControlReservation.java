package Controller;



import javax.swing.JDialog;

import Model.Hotel;
import View.*;


public class ControlReservation{
    ReservPage reservPage;
    Hotel hotel;

    public ControlReservation(Hotel hotel, ReservPage reserv) {
        reservPage = new ReservPage(hotel);
        this.hotel = hotel;
    }




    public void openCreateRoomWindow() {
        CreateReservation createReservation = new CreateReservation(hotel);
        JDialog dialog = new JDialog();
        dialog.add(createReservation);
        dialog.pack();
        dialog.setVisible(true);
        
    }


}
