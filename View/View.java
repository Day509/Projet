package View;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class View extends JFrame {

    private JPanel contentPane;
    private CardLayout cardLayout;
    
    public View(int h, int w) {
        setSize(w, h);
        contentPane = new JPanel(new CardLayout());

        // Create and add the Name panel
        Name namePanel = new Name();
        namePanel.setBounds(0, 0, w, 100);
        contentPane.add(namePanel, "namePanel");

        // Create and add the HotelInformation panel
        HotelInformation hotelInfoPanel = new HotelInformation(cardLayout, contentPane);
        hotelInfoPanel.setBounds(0, 100, w, h - 100);
        contentPane.add(hotelInfoPanel, "hotelInfoPanel");

        // Create and add the ChambreInformation panel
        ChambreInformation chambreInfoPanel = new ChambreInformation();
        chambreInfoPanel.setBounds(0, 100, w, h - 100);
        contentPane.add(chambreInfoPanel, "chambreInfoPanel");

        MainPage roomPage = new MainPage(h, w); 
        contentPane.add(roomPage, "roomPage");

        Dashboard dashboard = new Dashboard(h, w); 
        contentPane.add(dashboard, "dashboard");
        
        // Set the contentPane to the JFrame
        getContentPane().add(contentPane, BorderLayout.CENTER);
        
        // Initialize the card layout and panel
        cardLayout = (CardLayout) contentPane.getLayout();
    }

    public void showPanel(String panelName) {
        cardLayout.show(contentPane, panelName);
    }

    public static void main(String[] args) {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        View frame = new View(dim.height, dim.width);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
