package Model;


import java.util.*;

public class Sejour extends Reservation {
    Dictionary<String, Double> facture = new Hashtable<String, Double>();
    Reservation reservation;
    
    public Sejour(int id, Client client, Chambre[] cham, Date deb, Date fin, int np) {
        super(client, cham, deb, fin, np);
    }

    public void afficherFact(){
        System.out.println(facture);
    }

    public void ajoutFact(String nomProd, Double montant){
        facture.put(nomProd, montant);
    }
}