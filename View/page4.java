import javax.swing.*;
import java.awt.*;

public class page4 extends JFrame {

    // attribut graphique
    //TOUS LES COMPOSONT DE LA PAGE 4 J'AI PREFERER DE LES METTRE COMME BUTTON
    
    JLabel NomHôtel =new JLabel("Nom hôtel");
    JButton TableauDeBord =new JButton("Tableau de bord");
	JButton Chambre =new JButton("Chambre");
    JButton Réservation  =new JButton("Réservation ");
	JButton VotreHôtel =new JButton("Votre hôtel");
     
    JButton chH1 = new JButton("chambre occupe");
    JButton chH2 = new JButton("Chambre libre");
    JButton chH3 = new JButton("Chambre réserver");


    JButton chB1 = new JButton("1 lit");
    JButton chB2 = new JButton("2 lit");
    JButton chB3 = new JButton("3 lit");
    JButton chB4 = new JButton("4 lit");
    JButton chB5 = new JButton("5 lit");

    public page4() {
        //cote droit
        JPanel pageD = new JPanel();
        pageD.setLayout(new GridLayout(2, 1));
        pageD.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));


        JPanel cellPanel1 = new JPanel();
        cellPanel1.setLayout(new GridLayout(1, 3));
        cellPanel1.setBorder(BorderFactory.createEmptyBorder(100, 10, 50, 10));
        pageD.add(cellPanel1);
        cellPanel1.add(chH1);
        cellPanel1.add(chH2);
        cellPanel1.add(chH3);

        JPanel cellPanel2 = new JPanel();
        cellPanel2.setLayout(new GridLayout(1, 5));
        cellPanel2.setBorder(BorderFactory.createEmptyBorder(0, 10, 100, 10));
        pageD.add(cellPanel2);
        cellPanel2.add(chB1);
        cellPanel2.add(chB2);
        cellPanel2.add(chB3);
        cellPanel2.add(chB4);
        cellPanel2.add(chB5);



        //cote gauche 
        JPanel pageG = new JPanel();
        pageG.setLayout(new GridLayout(5, 1));
        pageG.add(NomHôtel);
        pageG.add(TableauDeBord);
        pageG.add(Chambre);
        pageG.add(Réservation);
        pageG.add(VotreHôtel);




        //placement dans la page
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(BorderLayout.CENTER, pageD);
        this.getContentPane().add(BorderLayout.WEST, pageG);

        //pour voir le resultat
        this.setSize(1300, 1200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                page4 id = new page4();
            }
        });
    }
}
