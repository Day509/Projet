package View;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public class View extends JFrame {

    public View(int h, int w) {
        setSize(w, h);
        JLayeredPane window = getLayeredPane();
        MainPage roomMan = new MainPage(h, w);
        roomMan.setBounds(0, 0, w, h );
        Dashboard dash = new Dashboard(h, w);
        dash.setOpaque(false);
        dash.setBounds(0, 50, w, h);
        window.add(roomMan, new Integer(0));
        window.add(dash, new Integer(1));
    }
    
    public static void main(String[] args) {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        View frame = new View(dim.height, dim.width);
        frame.setVisible(true);
    }
}
