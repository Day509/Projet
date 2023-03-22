
import java.util.*;

/**
 * 
 */
public class Chambre {

    private int idChambre; 
    private int etage; 
    private double prix;
    private int nbrLits;
    private boolean estDisponible;

    public Chambre(int idChambre, int etage, double prix, int nbrLits) {
        this.idChambre = idChambre;
        this.etage = etage;
        this.prix = prix;
        this.nbrLits = nbrLits;
        this.estDisponible = true; // Par défaut une chambre est disponible
    }
    public int getIdChambre() {
        return idChambre;
    }
    
    public void setIdChambre(int idChambre) {
        this.idChambre = idChambre;
    }
    
    public int getEtage() {
        return etage;
    }
    
    public void setEtage(int etage) {
        this.etage = etage;
    }
    
    public double getPrix() {
        return prix;
    }
    
    public void setPrix(double prix) {
        this.prix = prix;
    }
    
    public int getNbrLits() {
        return nbrLits;
    }
    
    public void setNbrLits(int nbrLits) {
        this.nbrLits = nbrLits;
    }
    
    public boolean estDisponible() {
        return estDisponible;
    }
    
    public void setDisponibilite(boolean estDisponible) {
        this.estDisponible = estDisponible;
    }
}
