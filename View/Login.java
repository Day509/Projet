package View;

import javax.swing.*;
import java.awt.*;
import Controller.*;
public class Login extends JPanel {
    private JTextField textField;

    public Login() {
        setLayout(new GridBagLayout());
        

        // Création du titre
        JLabel titleLabel = new JLabel("Se connecter à votre hôtel");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36)); // Police de caractères agrandie
        GridBagConstraints titleConstraints = new GridBagConstraints();
        titleConstraints.gridx = 0;
        titleConstraints.gridy = 0;
        titleConstraints.gridwidth = 2;
        titleConstraints.insets = new Insets(20, 0, 20, 0); // Espace avant augmenté
        add(titleLabel, titleConstraints);

        // Création de la zone de texte
        textField = new JTextField(30); // Largeur augmentée
        textField.setFont(new Font("Arial", Font.PLAIN, 24)); // Police de caractères agrandie
        GridBagConstraints textFieldConstraints = new GridBagConstraints();
        textFieldConstraints.gridx = 0;
        textFieldConstraints.gridy = 1;
        textFieldConstraints.gridwidth = 2;
        textFieldConstraints.insets = new Insets(0, 20, 20, 20); // Espace autour augmenté
        add(textField, textFieldConstraints);

        // Création du bouton
        JButton connectButton = new JButton("Se connecter");
        connectButton.setFont(new Font("Arial", Font.BOLD, 24)); // Police de caractères agrandie
        GridBagConstraints buttonConstraints = new GridBagConstraints();
        buttonConstraints.gridx = 0;
        buttonConstraints.gridy = 2;
        buttonConstraints.gridwidth = 2;
        buttonConstraints.insets = new Insets(0, 20, 20, 20); // Espace autour augmenté
        buttonConstraints.ipadx = 20; // Largeur horizontale augmentée
        buttonConstraints.ipady = 10; // Hauteur verticale augmentée
        add(connectButton, buttonConstraints);

        LoginControl LoginControl=new LoginControl(connectButton,this);
        connectButton.addActionListener(LoginControl);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Charger et dessiner l'image de fond ici
        ImageIcon backgroundImage = new ImageIcon("View/Image_Hotel/Hotel7.jpg");
        g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("HotelHub");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600); // Ajustez les dimensions selon vos besoins
            frame.setContentPane(new Login());
            frame.setVisible(true);
        });
    }
}