


public class Chambre {
    public enum typeChambre {Simple, Double, SuiteNormale, SuitePresidentiel};
    private static int idChambre = 1;
    private int id; 
    private int Etage;
    private double Prix;
    private int nbrLits;
    
    public Chambre(typeChambre chambre) {
        this.id = idChambre;
        this.Etage = chambre.ordinal() + 1;
        this.Prix = ((chambre.ordinal() + 1) * 1.7) * 100; //exemple
        this.Etage = chambre.ordinal() + 1;
        idChambre++;        
    }

    
    
}
