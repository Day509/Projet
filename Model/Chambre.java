
import java.util.Vector;

public class Chambre {

    private int idChambre;
    private int etage;
    private double prixParNuit;
    private int nbrLits;
    private Vector<Reservation> listReservations;
    private Hotel hotel;

    public Chambre(int idChambre, int etage, double prixParNuit, int nbrLits, Hotel hotel) {
        this.idChambre = idChambre;
        this.etage = etage;
        this.prixParNuit = prixParNuit;
        this.nbrLits = nbrLits;
        this.listReservations = new Vector<Reservation>();
        this.hotel = hotel;
    }

    public int getIdChambre() {
        return idChambre;
    }

    public void setIdChambre(int idChambre) {
        this.idChambre = idChambre;
    }

    public int getEtage() {
        return etage;
    }

    /* public void setEtage(int etage) {
        this.etage = etage;
    }
*/
    public double getPrixParNuit() {
        return prixParNuit;
    }

    public void setPrixParNuit(double prixParNuit) {
        this.prixParNuit = prixParNuit;
    }

    public int getNbrLits() {
        return nbrLits;
    }

    public void setNbrLits(int nbrLits) {
        this.nbrLits = nbrLits;
    }

    public Vector<Reservation> getReservations() {
        return listReservations;
    }

    public void setReservations(Vector<Reservation> listReservations) {
        this.listReservations = listReservations;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public void ajoutResa(Reservation reservation){
        listReservations.add(reservation);
    }
    public void annuleResa(Reservation reservation) {
        listReservations.remove(reservation);
    }
}
