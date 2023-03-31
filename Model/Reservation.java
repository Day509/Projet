
import java.time.LocalDate;
import java.util.*;

/**
 * 
 */
public class Reservation {

    private static int idResa = 1;
    public int id;
    public LocalDate DateDebut;
    public LocalDate DateDeFin;
    public Vector<Chambre> chambre;
    public Client Client;
    public Sejour sejour;

    public Reservation(Client client, Chambre[] cham, LocalDate deb, LocalDate fin, int nbCham) {
        this.Client = client;
        this.id = idResa;
        this.chambre = new Vector<Chambre>(nbCham);
        this.DateDebut = deb;
        this.DateDeFin = fin;
    }

    public LocalDate getStartdate() {
        return this.DateDebut;
    }

    public LocalDate getEnddate() {
        return this.DateDeFin;
    }

    public Client getClient() {
        return this.Client;
    }

    public int getResaNum() {
        return this.id;
    }
}