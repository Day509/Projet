package test;

import java.time.LocalDate;
import java.util.Random;

import Model.*;

public class CreateReservation {
    Hotel p;
    Client client;
    LocalDate startdate; // Random date
    LocalDate enddate;
    Chambre[] cham;
    Random rand = new Random();
    Reservation resa;


    public CreateReservation(Client c) {
        client = c;
        resa = create(c);
    }

    public Reservation create(Client c) {
        LocalDate[] dates = genererDatesAleatoires(2023, 2023, 1, 10);
        
        
       return new Reservation(c, cham, dates[0], dates[1], 1);
    }

    public Reservation getReservation() {
        return resa;
    }

    private LocalDate[] genererDatesAleatoires(int anneeMin, int anneeMax, int dureeSejourMin, int dureeSejourMax) {
        int anneeDebut = rand.nextInt(anneeMax - anneeMin + 1) + anneeMin;
        int moisDebut = 5;
        int jourDebut = rand.nextInt(28) + 1;
    
        LocalDate dateDebut = LocalDate.of(anneeDebut, moisDebut, jourDebut);
    
        int dureeSejour = rand.nextInt(dureeSejourMax - dureeSejourMin + 1) + dureeSejourMin;
        LocalDate dateFin = dateDebut.plusDays(dureeSejour);
    
        return new LocalDate[] { dateDebut, dateFin };
    }
    

}
