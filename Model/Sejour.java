
import java.util.*;

/**
 * 
 */
public class Sejour {

    public double Facture;

    public Reservation res;

    public Sejour(Reservation resa) {
        this.res = resa;
    }

    public Date getStartdate() {
        return this.res.DateDebut;
    }

    public Date getEnddate() {
        return this.res.DateDeFin;
    }

    public Client getClient() {
        return this.res.Client;
    }

    public int getResaNum() {
        return this.res.id;
    }

}