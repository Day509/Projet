
import java.time.LocalDate;
import java.util.*;

/**
 * 
 */
public class Sejour {

    public double Facture;
    Vector<Consommation> listConso = new Vector<Consommation>();
    public Reservation res;

    public Sejour(Reservation resa) {
        this.res = resa;
    }

    public LocalDate getStartdate() {
        return res.DateDebut;
    }

    public LocalDate getEnddate() {
        return res.DateDeFin;
    }

    public Client getClient() {
        return res.Client;
    }

    public int getResaNum() {
        return res.id;
    }

    public void addConso(Consommation c){
        listConso.add(c);
    }

    public double getPrice(){
        return 0.0; // Cumule des conso => somme des prix
    }
}