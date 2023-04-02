import java.time.LocalDate;
import java.util.*;



public class Hotel {

    private String nom ;
    private String adresse ;
    private Vector<Chambre> listChambres;
    private Vector<Client> listClient;




    public Hotel(String nom, String adresse) {
        this.nom=nom;
        this.adresse=adresse;
        this.listChambres=new Vector<Chambre>();//prq Set et pas vector ??
        this.listClient=new Vector<Client>();
    }



    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }



    public String getAdresse() {
        return nom;
    }

    public void getAdresse(String nom) {
        this.nom = nom;
    }


    public Vector<Chambre> getListChambres() {
        return listChambres;
    }

    public void setListChambres(Vector<Chambre> listChambres) {
        this.listChambres = listChambres;
    }



    public Vector<Client> getlistClient() {
        return listClient;
    }

    public void setListClient(Vector<Client> listClient) {
        this.listClient = listClient;
    }
    



    public Client getClientByName(String nom){         //retourne le client apartir de son nom
        for (int i = 0; i < listClient.size(); i++) {
            if(listClient.get(i).getNom().equals(nom)) {return listClient.get(i);};   
        }
        return null;
    }

    public Chambre getRoomByNum(int num, int floor){    // retourne le numero de la chambre
        for (int i = 0; i < listChambres.size(); i++) {
            if(listChambres.get(i).getIdChambre()==num && listChambres.get(i).getEtage()==floor ) {return listChambres.get(i);};   
        }
        return null;
    }

    public Vector<Chambre> getFreeRooms(LocalDate deb, LocalDate fin){
        return null; //parcour les chambre et renvoi les chambres dispo
    }

}