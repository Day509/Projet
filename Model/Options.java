package Model;

import java.util.Vector;

public class Options {

    private double prix;
    private String nom; 
    private Vector<Suite> listSuite;
    
    public Options(double prix, String nom) {
    
    this.prix = prix; 
    this.nom = nom; 
    this.listSuite = new Vector<Suite>();

    }

    public double getPrixOption() {
        return prix;
    }

    public void setPrixOption(double prix) {
        this.prix = prix;
    }
 
    public String getNomOption() {
        return nom;
    }

    public void setNomOption(String nom) {
        this.nom = nom;
    }
  
    public Vector<Suite> getListSuite(){
        return listSuite;
    }
    public void setListSuite(Vector<Suite> listSuite) {
        this.listSuite = listSuite;
    }
    public void ajouterOption(Suite option){
        listSuite.add(option);
    }
    public void annulerOption(Suite option) {
        listSuite.remove(option);
    }
}

