
import java.util.*;

import TD3.Exo_1.Client;

/**
 * 
 */
public class Reservation {
    private static int idResa = 1;
    private int id;
    Client resaOwn;
    Date DateDebut; 
    Date DateDeFin;
    int NbPersonne;

    public Reservation(Client client, int resa, int[] cham, Date deb, Date fin, int nbrPersonne) {
        resaOwn = client;
        this.id = idResa;
        DateDebut = deb;
        DateDeFin = fin;
        NbPersonne = nbrPersonne;
    }

}