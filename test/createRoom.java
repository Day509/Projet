package test;

import java.util.Vector;

import Model.Chambre;
import Model.Hotel;
import java.util.Random;

public class createRoom {
    Hotel p;
    int floor;
    int roomsByFloor;
    Vector<Chambre> listChambres = new Vector<Chambre>();
    Random rand = new Random();

    public createRoom(Hotel h) {
        p = h;
        floor = 5;
        roomsByFloor = 4;

        for (int i = 1; i <= floor; i++) {
            for (int j = 1; j <= roomsByFloor; j++) {
                listChambres.add(create(i, j));
            }
            
        }
    }

    private Chambre create(int floor, int rooms){
        int idRoom = rooms;
        int floorRoom = floor;
        double price = rand.nextInt(1000);
        int nbBed = rand.nextInt(1, 5);
        return new Chambre(idRoom, floorRoom, price, nbBed, p);
    }

    Vector<Chambre> getRooms() {
        return listChambres;
    }

}
