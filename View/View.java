package View;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JLayeredPane;

public class View extends JPanel {

    public View(int h, int w) {
        setBackground(Color.YELLOW);
        setLayout(null); // Utilisation d'un positionnement absolu
        setPreferredSize(new Dimension(w, h));

        JLayeredPane window = new JLayeredPane();
        window.setBounds(0, 0, w, h);

        Background bg = new Background(h, w);
        bg.setBounds(0, 0, w, h);

        Dashboard dashBase = new Dashboard(h, w);
        dashBase.setOpaque(false);
        dashBase.setBounds(0, 50, w, h);

        window.add(bg, new Integer(0));
        window.add(dashBase, new Integer(1));

        add(window);
    }
}
