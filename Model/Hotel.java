package Model;

import java.time.LocalDate;
import java.util.*;

public class Hotel {

    private String nom;
    private String adresse;
    private Vector<Chambre> listChambres;
    private Vector<Client> listClient;
    private Vector<Reservation> listReservations;

    public Hotel(String nom, String adresse) {
        this.nom = nom;
        this.adresse = adresse;
        this.listChambres = new Vector<Chambre>();// prq Set et pas vector ??
        this.listClient = new Vector<Client>();
        this.listReservations = new Vector<Reservation>();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String a) {
        this.adresse = a;
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

    public Client getClientByName(String nom, String prenom) { // retourne le client apartir de son nom
        for (int i = 0; i < listClient.size(); i++) {
            if (listClient.get(i).getNom().equals(nom) && listClient.get(i).getPrenom().equals(prenom)) {
                return listClient.get(i);
            }
            ;
            return listClient.get(i);
        }
        return null;
    }

    public Chambre getRoomByNum(int num, int floor) { // retourne le numero de la chambre
        for (int i = 0; i < listChambres.size(); i++) {
            if (listChambres.get(i).getIdChambre() == num && listChambres.get(i).getEtage() == floor) {
                return listChambres.get(i);
            }
            ;
        }
        return null;
    }

    public Vector<Chambre> getFreeRooms(LocalDate deb, LocalDate fin) {
        return null; // parcour les chambre et renvoi les chambres dispo
    }

    public void ajouterChambre(Chambre chambre) {
        this.listChambres.add(chambre);
    }

    public void ajouterClient(Client client) {

    }

    public Vector<Reservation> getReservations() {
        return listReservations;
    }
//pour recuperer la reservation avec l'id et faire la facture....
    public Reservation getReservationById(int id) {
        for (Reservation reservation : listReservations) {
            if (reservation.getId() == id) {
                return reservation;
            }
        }
        return null;
    }
    public void setReservations(Vector<Reservation> listReservations) {
        this.listReservations = listReservations;
    }

    public void ajoutResa(Reservation reservation) {
        listReservations.add(reservation);
    }

    public void annuleResa(Reservation reservation) {
        listReservations.remove(reservation);
    }
}