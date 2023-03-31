
import java.util.*;

/**
 * 
 */
public class Client {

    private String nom; 
    private String prenom;
    private String adresse;
    private String email;
    private String telephone;

 
    public Client(String nom, String prenom, String adresse, String email, String telephone) {
        this.nom = nom; 
        this.prenom = prenom;
        this.adresse = adresse;
        this.email = email;
        this.telephone = telephone;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    public String getAdresse() {
    return adresse;
    }

    public void setAdresse(String adresse) {
    this.adresse = adresse;
    }

    public String getEmail() {
    return email;
    }

    public void setEmail(String email) {
    this.email = email;
    }

    public String getTelephone() {
    return telephone;
    }

    public void setTelephone(String telephone) {
    this.telephone = telephone;
    }

    public void afficherInfosClient() {
        System.out.println("Nom : " + nom);
        System.out.println("Prénom : " + prenom);
        System.out.println("Adresse : " + adresse);
        System.out.println("Email : " + email);
        System.out.println("Téléphone : " + telephone);
    }
    


        public static void main(String[] args) {
            Client client1 = new Client("d", "a", "f", "@@@@", "05436");
            client1.setTelephone("03541");
            client1.setNom("harish");
            client1.afficherInfosClient();
        }
    }
    