package test;

import java.util.Vector;

import Model.*;

public class Generate {

        static Hotel p;
        static createClient c = new createClient(p);
        static createRoom listRoom = new createRoom(p);
        static Vector<CreateReservation> allReservations = new Vector<CreateReservation>();

        public Generate(Hotel h) {
                p = h;
                p.setListClient(c.getClients());
                p.setListChambres(listRoom.getRooms());
                
                for (int i = 0; i < p.getlistClient().size(); i++) {
                        allReservations.add(new CreateReservation(p.getlistClient().get(i)));
                }
                for (int i = 0; i < p.getListChambres().size(); i++) {
                        Chambre room = p.getListChambres().get(i);
                        room.ajoutResa(allReservations.get(i).getReservation());
                }
                // afficher les clients
                /*
                 * for (int i = 0; i < p.getlistClient().size(); i++) {
                 * System.out.println(
                 * "Client " + i + ": " + p.getlistClient().get(i).getNom() + " " +
                 * p.getlistClient().get(i).getPrenom() + ", email: "
                 * + p.getlistClient().get(i).getEmail()
                 * + ", adresse: " + p.getlistClient().get(i).getAdresse()
                 * + ", téléphone: "
                 * + p.getlistClient().get(i).getTelephone() + ", hôtel: "
                 * + p.getNom());
                 * }
                 * // afficher les chambres
                 * System.out.print("\n\n\n\n");
                 * 
                 * for (int i = 0; i < p.getListChambres().size(); i++) {
                 * System.out.println(
                 * "Chambre " + ": " + p.getListChambres().get(i).getIdChambre()
                 * + ", étage: " + p.getListChambres().get(i).getEtage()
                 * + ", prix: " + p.getListChambres().get(i).getPrixParNuit()
                 * + "E, nombre de lits: "
                 * + p.getListChambres().get(i).getNbrLits()
                 * + ", hôtel: " + p.getNom());
                 * }
                 * 
                 * System.out.print("\n\n\n\n");
                 */
                // initialise les reservations
                
                // affiche les reservations
                /*
                 * for (CreateReservation r : allReservations) {
                 * 
                 * System.out.println("Nom : " +
                 * r.getReservation().getClient().getNom() +
                 * ", Prenom : " + r.getReservation().getClient().getPrenom() +
                 * ", N°Resa : " + r.getReservation().getResaNum() +
                 * ", DateDebut : " + r.getReservation().getStartdate() +
                 * ", DateFin : " + r.getReservation().getEnddate());
                 * 
                 * }
                 */

        }

        public Hotel getHotel() {
                return p;
        }

        public createClient getListClient() {
                return c;
        }

        public createRoom getListRoom() {
                return listRoom;
        }

        public Vector<CreateReservation> getAllReservations() {
                return allReservations;
        }
}
