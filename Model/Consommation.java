
import java.util.*;

public class Consommation {

    public String produit;
    public double prix;
    public int quantite;



    public Consommation(String produit,double prix,int quantite) {
        this.produit=produit;
        this.prix=prix;
        this.quantite=quantite;
    }

    
    public String getProduit() {
        return produit;
    }

    public void setProduit(String produit) {
        this.produit = produit;
    }


    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }


    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    

}