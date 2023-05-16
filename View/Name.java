package View;

import java.awt.*;
//import java.util.ResourceBundle.Control;

import javax.swing.*;
import Controller.*;

public class Name extends JPanel {

    JPanel HotelInformation = new HotelInformation();
    JPanel Login = new Login();
    JButton button1;
    JButton button2;
    public JPanel panelContainer;

    public Name() {
        setLayout(new GridBagLayout());

        panelContainer = new JPanel();
        panelContainer.setLayout(new CardLayout());
        panelContainer.add(this);
        panelContainer.add(HotelInformation);
        panelContainer.add(Login);
        HotelInformation.setVisible(false);
        Login.setVisible(false);
        this.setVisible(true);

        // Titre centré avec de l'espace avant
        JLabel title = new JLabel("HotelHub");
        title.setFont(new Font("Arial", Font.BOLD, 36)); // Police de caractères agrandie
        GridBagConstraints titleConstraints = new GridBagConstraints();
        titleConstraints.gridx = 0;
        titleConstraints.gridy = 0;
        titleConstraints.gridwidth = 2;
        titleConstraints.insets = new Insets(0, 0, 40, 0); // Espace avant augmenté
        titleConstraints.anchor = GridBagConstraints.PAGE_START;
        add(title, titleConstraints);

        // Boutons Se connecter et Ajouter un hôtel
        button1 = new JButton("Se connecter");
        button1.setFont(new Font("Arial", Font.BOLD, 24));
        button2 = new JButton("Ajouter un hôtel");
        button2.setFont(new Font("Arial", Font.BOLD, 24));
        GridBagConstraints buttonConstraints = new GridBagConstraints();
        buttonConstraints.gridx = 0;
        buttonConstraints.gridy = 1;
        buttonConstraints.insets = new Insets(50, 0, 0, 100); // Espace entre les boutons augmenté
        buttonConstraints.ipadx = 20; // Largeur horizontale augmentée
        buttonConstraints.ipady = 10; // Hauteur verticale augmentée
        add(button1, buttonConstraints);
        buttonConstraints.gridx = 1;
        buttonConstraints.insets = new Insets(50, 20, 0, 0);
        add(button2, buttonConstraints);

        NameControl NameControl = new NameControl(button1, button2, HotelInformation, Login, this);
        button1.addActionListener(NameControl);
        button2.addActionListener(NameControl);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Charger et dessiner l'image de fond ici
        ImageIcon backgroundImage = new ImageIcon("View/Image_Hotel/planningSoutenacePOO.jpeg");
        g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Ma fenêtre");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width,
                    Toolkit.getDefaultToolkit().getScreenSize().height)); // Ajustez les dimensions selon vos besoins
            Name Name = new Name();
            frame.setContentPane(Name.panelContainer);
            frame.setVisible(true);
        });
    }
}