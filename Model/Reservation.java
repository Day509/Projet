package Model;

import java.util.*;

/**
 * 
 */
public class Reservation {

    private static int idResa = 1;
    public int id;
    public Date DateDebut;
    public Date DateDeFin;
    public Chambre[] chambre;
    public Client Client;
    public Sejour sejour;

    public Reservation(Client client, Chambre[] cham, Date deb, Date fin, int nbCham) {
        this.Client = client;
        this.id = idResa;
        this.chambre = new Chambre[nbCham];
        this.DateDebut = deb;
        this.DateDeFin = fin;
    }

    public Date getStartdate() {
        return this.DateDebut;
    }

    public Date getEnddate() {
        return this.DateDeFin;
    }

    public Client getClient() {
        return this.Client;
    }

    public int getResaNum() {
        return this.id;
    }

}