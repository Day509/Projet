
import java.util.*;

/**
 * 
 */
public class Hotel {
    public String nom;
    public String adresse;
    public String nomEntreprise;
    /**
     * Default constructor
     */
    public Hotel(String nom, String adresse, String nomEntreprise){
        this.nom=nom;
        this.adresse=adresse;
        this.nomEntreprise=nomEntreprise;
    }



    public afficheHotel(Hotel hotel){
        System.out.println(nom);
        System.out.println(adresse);
        System.out.println(nomEntreprise);
    }
}