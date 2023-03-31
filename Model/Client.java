
import java.util.*;

public class Client {
    private String nom;
    private String prenom;
    private String email;
    private String adresse;
    private String telephone;
    private Vector<Reservation> listReservations;
    private Hotel hotel;

    public Client(String nom, String prenom, String email, String adresse, String telephone, Hotel hotel) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.adresse = adresse;
        this.telephone = telephone;
        this.listReservations = new Vector<Reservation>();
        this.hotel = hotel;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    
    public Vector<Reservation> getListReservations() {
        return listReservations;
    }

    public void setListReservations(Vector<Reservation> listReservations) {
        this.listReservations = listReservations;
    }
    
    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }


}
