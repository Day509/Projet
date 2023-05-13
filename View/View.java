package View;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public class View extends JFrame {

    public View(int h, int w) {
        setPreferredSize(new Dimension(w, h));

        JLayeredPane window = getLayeredPane();
        
        Name dashBase = new Name();
        dashBase.setOpaque(false);
        dashBase.setBounds(0, 0, w, h);

        window.add(dashBase);

        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        View frame = new View(dim.height, dim.width);
        frame.setVisible(true);
    }
}
