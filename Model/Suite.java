
import java.util.*;

public class Suite extends Chambre {

    public Vector<Options> listOption;

    public Suite(int numRoom, int floor, double price, int nbBed, Vector<Options> options) {
        super(numRoom, floor, price, nbBed);
        this.listOption = new Vector<Options>(options);
    }

    public Vector<Options> getOption() {
        return this.listOption;
    }

    public int getNumOpt(){
        return listOption.size();
    }

    public void setOption(Options s) {
        this.listOption.add(s);
    }

    public int getNumRoom(){ // recupérer le numéro de la chambre
        return this.idChambre;
    }

    public LocalDate getLastReservationDate(){
        if (this.listReserv.isEmpty()) {
            return null;
        }
        Reservation r  = listReserv.lastElement();
        return r.getEnddate();
    }

}