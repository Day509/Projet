package View;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public class View extends JFrame {

    public View(int h, int w) {
        setPreferredSize(new Dimension(w, h));

        JLayeredPane window = getLayeredPane();
        MainPage bg = new MainPage(h, w);
        bg.setBounds(0, 0, w, h);

        Dashboard dashBase = new Dashboard(h, w);
        dashBase.setOpaque(false);
        dashBase.setBounds(0, 50, w, h);

        /* HotelInformation hotelInfo = new HotelInformation();
        hotelInfo.setBounds(new Rectangle(0, 0, w, h)); */

        window.add(bg, new Integer(0));
        window.add(dashBase, new Integer(1));

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
