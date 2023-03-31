
import java.util.*;

/**
 * 
 */
public class Options {

    private String nom;
    private double prix;
    private boolean estSelectionnee;
    
    public Options(String nom, double prix) {
        this.nom = nom;
        this.prix = prix;
        this.estSelectionnee = false; // Par défaut l'option n'est pas sélectionnée
    }
    
    public String getNom() {
        return nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public double getPrix() {
        return prix;
    }
    
    public void setPrixSupplementaire(double prix) {
        this.prix = prix;
    }
    
    public boolean estSelectionnee() {
        return estSelectionnee;
    }
    
    public void setSelection(boolean estSelectionnee) {
        this.estSelectionnee = estSelectionnee;
    }
    

}