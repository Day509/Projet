import java.util.*;;


public class Sejour extends Reservation {
    Dictionary<String, Double> facture = new Hashtable<String, Double>();
    Reservation reservation;
    
    public Sejour() {
        super(client, NbPersonne, null, DateDebut, DateDeFin, NbPersonne);
    }

    public void afficherFact(){
        System.out.println(facture);
    }

    public void ajoutFact(Double montant, String nomProd){
        facture.put(nomProd, montant);
    }
}