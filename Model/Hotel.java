
import java.time.LocalDate;
import java.util.*;

/**
 * 
 */
public class Hotel {

    /**
     * Default constructor
     */
    public Hotel() {
    }

    /**
     * 
     */
    public String Nom;

    /**
     * 
     */
    public String Adresse;

    /**
     * 
     */
    public Set<Chambre> listChambres;

    /**
     * 
     */
    public Set<Client> listClient;

    public Client getClientByName(String s){
        return null; //retourne le nom du 
    }

    public Chambre getRoomByNum(int num, int floor){
        return null;// retourne le numero de la chambre
    }

    public Vector<Chambre> getFreeRooms(LocalDate deb, LocalDate fin){
        return null; //parcour les chambre et renvoi les chambres dispo
    }

}