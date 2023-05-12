package Model;

import java.time.LocalDate;
import java.util.Dictionary;
import java.util.Hashtable;

public class Sejour extends Reservation {
    Dictionary<String, Double> facture = new Hashtable<String, Double>();
    Reservation reservation;
    
    public Sejour(int id, Client client, Chambre[] cham, LocalDate deb, LocalDate fin, int np) {
        super(client, cham, deb, fin, np);
    }

    public void afficherFact(){
        System.out.println(facture);
    }

    public void ajoutFact(String nomProd, Double montant){
        facture.put(nomProd, montant);
    }
}