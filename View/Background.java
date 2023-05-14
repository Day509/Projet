package View;

import java.awt.*;
import javax.swing.*;

public class Background extends JPanel {

    public Background(int h, int w) {
        // Création du panneau principal
        JPanel panel = Background(h, w);
        panel.setLayout(new OverlayLayout(panel));
        this.add(panel);
    }

    // Création du JPanel avec l'image de fond
    private static JPanel Background(int h, int w) {
        JPanel mainPanel = new JPanel();
        mainPanel.add(new JLabel(new ImageIcon(new ImageIcon("View/Image_Hotel/Reception.jpg").getImage()
                .getScaledInstance(w, h, Image.SCALE_DEFAULT))));
        return mainPanel;
    }
}
