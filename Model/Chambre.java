import java.time.LocalDate;
import java.util.*;

public class Chambre {

    public int idChambre;
    public int Etage;
    public double Prix;
    public int nbrLits;
    public Vector<Reservation> listReserv = new Vector<Reservation>();
    public Hotel Hotel;

    public Chambre(int id, int e, double p, int nbn) {
        this.Etage = e;
        this.idChambre = id;
        this.Prix = p;
        this.nbrLits = nbn;
    }

    public void setHotel(Hotel h) {
        this.Hotel = h;
    }

    public void ajoutResa(Reservation r) {// Ajoute une résa dans la liste de reservation
        listReserv.add(r);
    }

    public void annuleResa(Reservation r) { // Enlève une résa dans la liste de reservation
        listReserv.remove(r);
    }

    public boolean isFree(LocalDate deb, LocalDate fin) {
        for (Reservation reservation : listReserv) {
            if (!fin.isBefore(reservation.getStartdate()) || !deb.isAfter(reservation.getEnddate()))
                return false;
        }
        return true; // retourne l'etat de la chambre
    }

}
