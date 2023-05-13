package test;

import java.util.Random;
import java.util.Vector;

import Model.*;

public class createClient {

    Hotel p;
    Vector<Client> clients;
    String[] noms = { "Dupont", "Martin", "Durand", "Leblanc", "Lefebvre", "Mercier", "Moreau", "Girard",
            "Simon",
            "Lavoie" };
    String[] prenoms = { "Luc", "Sophie", "Jean", "Marie", "Pierre", "Isabelle", "François", "Émilie",
            "Guillaume",
            "Caroline" };
    String[] domains = { "gmail.com", "hotmail.com", "yahoo.com", "outlook.com", "icloud.com" };
    Random rand = new Random();

    public createClient(Hotel h) {
        p = h;
        // Tableaux pour stocker les noms, prénoms et domaines d'email
        clients = new Vector<Client>();
        for (int i = 0; i < 40; i++) {
            clients.add(create());
        }
        
    }

    private Client create(){
        String nom = noms[rand.nextInt(noms.length)];
        String prenom = prenoms[rand.nextInt(prenoms.length)];
        String email = nom + "." + prenom + "@" + domains[rand.nextInt(domains.length)];
        String adresse = rand.nextInt(1000) + " Rue " + nom;
        String telephone = "06" + rand.nextInt(100000000);
        return new Client(nom, prenom, email, adresse, telephone, p);
    }

    Vector<Client> getClients() {
        return clients;
    }

}