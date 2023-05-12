package Model;

import java.util.Vector;

/**
 * 
 */
public class Suite extends Chambre {

    public Vector<Options> listOption;

    public Suite(int numRoom, int floor, double price, int nbBed, Vector<Options> options, Hotel hotel) {
        super(numRoom, floor, price, nbBed, hotel);
        this.listOption = new Vector<Options>(options);
    }

    public Vector<Options> getOption() {
        return this.listOption;
    }

    public void setOption(Options s) {
        this.listOption.add(s);
    }

}