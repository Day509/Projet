package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import View.ReservPage;
import View.RoomPage;

public class SideBarControl implements ActionListener {

    private JPanel mainContent;
    private JPanel reservPanel = new ReservPage();
    private JPanel rooms = new RoomPage();

    public SideBarControl(JPanel mainContent) {
        this.mainContent = mainContent;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        switch (button.getText()) {
            case "Tableau de bord":
                reservPanel.setVisible(false);
                rooms.setVisible(false);
                mainContent.setVisible(true);
                break;
            case "Chambres":
                // Code pour changer le mainContent pour les chambres
                break;
            case "Réservations":
                // Code pour changer le mainContent pour les réservations
                break;
            case "Votre hôtel":
                // Code pour changer le mainContent pour votre hôtel
                break;
            default:
                break;
        }
    }

}
