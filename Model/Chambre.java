
import java.util.*;

/**
 * 
 */
public class Chambre {

    /**
     * Default constructor
     */
    public Chambre() {
    }

    /**
     * 
     */
    public int idChambre;

    /**
     * 
     */
    public int Etage;

    /**
     * 
     */
    public double Prix;

    /**
     * 
     */
    public int nbrLits;

    /**
     * 
     */
    public Vector<Reservation> listReserv = new Vector<Reservation>();

    /**
     * 
     */
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
    public void ajoutResa(Reservation r){
        listReserv.add(r);
    }
    public void annuleResa(Reservation r)
}