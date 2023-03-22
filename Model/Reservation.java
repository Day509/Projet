
import java.util.*;

/**
 * 
 */
public class Reservation {

    Client client;
    Chambre chambre;
    public Date dateDebut;
    public Date dateDeFin;

    public Reservation(Client client,Chambre chambre,Date DateDebut,Date DateDeFin){
        this.client=client;
        this.chambre=chambre;
        this.dateDeFin=dateDeFin;
        this.dateDebut=dateDebut;
    }
    public Reservation() {
    }

}