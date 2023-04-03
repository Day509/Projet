
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import Chambre.isFree;

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

    public Reservation(Client client, Chambre[] cham, LocalDate deb, LocalDate fin, int nbCham) {
        this.Client = client;
        this.id = idResa;
        this.chambre = new Vector<Chambre>(nbCham);
        this.DateDebut = deb;
        this.DateDeFin = fin;
        idResa++;
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

    public void cancelResa(Reservation r){
       r.chambre.removeAll(chambre);
    }

    public boolean modifyDate(LocalDate newB, LocalDate newE){ // Permet de modifier les dates de sa reservation en verifiant la disponibilité des chambres
        for (Chambre room : chambre) {
            if (room.isFree(newB, newE) == false) {
                return false;
            }
            DateDebut = newB;
            DateDeFin = newE;
        }
        return true;
    }

    public long lenOfStay(){
        return ChronoUnit.DAYS.between(getStartdate(), getEnddate());
    }

    public boolean isIntersect(LocalDate deb, LocalDate fin){ // Verifie l'intersection entre 2 intervalles de date
        for (Chambre room : chambre) {
            for (Reservation r : room.listReserv) {
                if (r.id != this.id && r.getStartdate().isBefore(fin) && r.getEnddate().isAfter(deb)) {
                    return true;
                }
            }
        }
        return false; //Verifie l'intersecton de 2 intervalles
    }
}