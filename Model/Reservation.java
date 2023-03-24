
import java.util.*;

import TD3.Exo_1.Client;

/**
 * 
 */
public class Reservation {
    private static int idResa = 1;
    private int id;
    Client resaOwn;
    int[] cham;
    Date DateDebut; 
    Date DateDeFin;
    int NbPersonne;

    public Reservation(Client client, int nbrcham, Date deb, Date fin, int np) { //Modif complete 
     this.id = idResa;
     this.resaOwn = client;
     this.cham = new int[nbrcham];
     this.DateDebut = deb;
     this.DateDeFin = fin;
     this.NbPersonne =  np;
    }

}