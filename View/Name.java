import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Name {
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Name");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500, 300));
        
        // Titre centré avec de l'espace avant
        JLabel title = new JLabel("Nom du logiciel");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setHorizontalAlignment(JLabel.CENTER);
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 20));
        titlePanel.add(title);
        
        // Boutons Se connecter et Ajouter un hôtel
        JButton button1 = new JButton("Se connecter");
        JButton button2 = new JButton("Ajouter un hôtel");
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 0));
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        
        // Ajout des éléments dans la fenêtre
        frame.add(titlePanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
