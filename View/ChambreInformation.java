import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ChambreInformation {

    private List<JTextField> list = new ArrayList<JTextField>();
    private JPanel panel = new JPanel(new GridBagLayout());

    public static void main(String args[]) {
        EventQueue.invokeLater(() -> {
            ChambreInformation id = new ChambreInformation();
            id.create("Information chambre");
           
        });
    }

    
    private void addField(String name, int gridx, int gridy) {
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.LINE_START;
        c.gridx = gridx;
        c.gridy = gridy;
        c.insets.top = 10;
        panel.add(new JLabel(name), c);
        JTextField jtf = new JTextField(16);
        c.gridx = gridx + 1;
        c.insets.left = 10;
        panel.add(jtf, c);
        list.add(jtf);
    }
    
    private void create(String strTitle) {

        JLabel label = new JLabel("Création chambre");
        label.setFont(new Font("Arial", Font.BOLD, 16));
        GridBagConstraints cLabel = new GridBagConstraints();
        cLabel.gridx = 0;
        cLabel.gridy = 0;
        cLabel.gridwidth = 2;
        cLabel.insets.bottom = 50;
        cLabel.anchor = GridBagConstraints.CENTER;
        panel.add(label, cLabel);
      
        // Ajouter les champs texte pour les informations de l'hôtel
        addField("Numéro d'étage:", 0, 1);
        addField("Nombre de lits:", 0, 2);
        addField("Prix par nuit:", 0, 3);
        
    
        // Ajouter le bouton Valider
        JButton validerBtn = new JButton("Valider");
        GridBagConstraints cButton = new GridBagConstraints();
        cButton.gridx = 0;
        cButton.gridy = 5;
        cButton.gridwidth = 2;
        cButton.insets.top = 20;
        cButton.anchor = GridBagConstraints.CENTER;
        panel.add(validerBtn, cButton);
    
        // Créer la fenêtre et l'afficher
        JFrame frame = new JFrame(strTitle);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500, 300));
        frame.setContentPane(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}