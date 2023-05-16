package Model;

import java.time.LocalDate;

/**
 * 
 */
public class Reservation {

    private static int idResa = 1;
    public int id;
    public LocalDate DateDebut;
    public LocalDate DateDeFin;
    public Chambre[] chambre;
    public Client Client;
    public Sejour sejour;

    public Reservation(Client client, Chambre[] cham, LocalDate deb, LocalDate fin, int nbCham) {
        this.Client = client;
        this.id = idResa++;
        this.chambre = new Chambre[nbCham];
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

    public Reservation getResaNum(int id) {
        return this;
    }

    public int getId() {
        return this.id;
    }

}