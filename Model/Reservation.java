
import java.util.*;

/**
 * 
 */
public class Reservation {

    static String idReservation;
    Client client;
    Chambre chambre;
    public Date dateDebut;
    public Date dateDeFin;

    
    public Reservation(Client client,Chambre chambre,Date DateDebut,Date DateDeFin){
        idReservation=client.nom+client.prenom+DateDebut.toString()+dateDeFin.toString();
        this.client=client;
        this.chambre=chambre;
        this.dateDeFin=DateDeFin;
        this.dateDebut=DateDebut;
    }
    public int chambreDispo(Chambre chambre){
        if (chambre.dispo) {
            return 0;
        } 
    }
    
    public annulation(Reservation idReservation){
        idReservation=null;
        this.client=null;
        this.chambre=null;
        this.dateDeFin=null;
        this.dateDebut=null;
    }

}