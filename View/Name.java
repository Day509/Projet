package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Name extends JPanel {
    
    public Name() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(500, 300));
        
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
        
        // Ajout des éléments dans le panel
        add(titlePanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        
        // Ajout de l'action du bouton Ajouter un hôtel
        button2.addActionListener(e -> {
            View view = (View) getTopLevelAncestor();
            view.showPanel("hotelInfoPanel");
        });
    }
}