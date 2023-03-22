
import java.util.*;

/**
 * 
 */
public class Hotel {
    String nom;
    int nbr_chambre;
    String adresse;
    String nom_Ent;
    /**
     * Default constructor
     */
    public Hotel(String nom, int nbr_chambre, String adresse, String nom_Ent){
        this.nom=nom;
        this.adresse=adresse;
        this.nbr_chambre=nbr_chambre;
        this.nom_Ent=nom_Ent;
    }

    public ajoutChambre(int nbr){
        this.nbr_chambre+=nbr;
    }

}