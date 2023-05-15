package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.time.LocalDate;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Model.Hotel;
import test.Generate;

public class TableauDeBord extends JPanel {
    Generate generate = new Generate(new Hotel("Hotel de la plage", "Biarritz"));
    LocalDate date = LocalDate.now();
    Hotel hotel;

    public TableauDeBord(int width, int height, Hotel hotel) {
        this.setPreferredSize(new Dimension(width - (width / 3 + 75), height - (height / 3 + 100)));
        this.setBackground(new Color(255, 255, 255, 215));

        JPanel topPanel = topPanel();
        topPanel.setBackground(new Color(255, 255, 255, 0));
        GridBagConstraints gbcpanel = new GridBagConstraints();
        gbcpanel.gridx = 0;
        gbcpanel.gridy = 0;
        gbcpanel.insets = new Insets(10, 10, 10, 10);
        gbcpanel.anchor = GridBagConstraints.NORTHWEST; // aligner en haut
        gbcpanel.weightx = 1; // occuper toute la largeur
        gbcpanel.weighty = 1; // occuper toute la hauteur
        gbcpanel.fill = GridBagConstraints.HORIZONTAL; // remplir horizontalement

        this.add(topPanel, gbcpanel);

        JPanel content = content();
        gbcpanel.gridx = 0;
        gbcpanel.gridy = 1; // mettre sur la deuxième rangée
        gbcpanel.insets = new Insets(10, 10, 10, 10);
        gbcpanel.anchor = GridBagConstraints.NORTHWEST; // aligner en haut
        gbcpanel.weightx = 1; // occuper toute la largeur
        gbcpanel.weighty = 1; // occuper toute la hauteur
        gbcpanel.fill = GridBagConstraints.HORIZONTAL; // remplir horizontalement
        gbcpanel.ipady = 2; // hauteur minimum

        this.add(content, gbcpanel);
    }

    private JPanel topPanel() {

        int nbr = 0, toDay = 0;
        for (int i = 0; i < generate.getHotel().getListChambres().size(); i++) {
            for (int j = 1; j < 7; j++) {
                if (generate.getAllReservations().get(i).getReservation().getStartdate().equals(date.plusDays(j))) {
                    int k = j;

                    while (generate.getAllReservations().get(i).getReservation().getEnddate()
                            .isAfter(date.plusDays(k))) {
                        if (k == 7) {
                            break;
                        }
                        k++;
                    }
                    nbr++;
                } else if (generate.getAllReservations().get(i).getReservation().getStartdate().isEqual(date)){
                    toDay++;
                }
            }
        }
        JPanel panel = new JPanel(new GridBagLayout());

        // Création et ajout des 3 RoomPanel avec espacement
        JPanel roomPanel1 = roomPanel(new Color(0, 255, 0, 127), "Chambre ocupée", "Icon", toDay);
        GridBagConstraints gbcRoomPanel1 = new GridBagConstraints();
        gbcRoomPanel1.gridx = 0;
        gbcRoomPanel1.gridy = 0;
        gbcRoomPanel1.insets = new Insets(10, 10, 10, 10);
        panel.add(roomPanel1, gbcRoomPanel1);

        JPanel roomPanel2 = roomPanel(new Color(0, 0, 255, 127), "Chambre libre", "Icon",
                generate.getHotel().getFreeRooms(date, date.plusDays(7)).size()-toDay);
        GridBagConstraints gbcRoomPanel2 = new GridBagConstraints();
        gbcRoomPanel2.gridx = 1;
        gbcRoomPanel2.gridy = 0;
        gbcRoomPanel2.insets = new Insets(10, 10, 10, 10);
        panel.add(roomPanel2, gbcRoomPanel2);

        JPanel roomPanel3 = roomPanel(new Color(255, 255, 0, 127), "Chambre reservée", "Icon", nbr);
        GridBagConstraints gbcRoomPanel3 = new GridBagConstraints();
        gbcRoomPanel3.gridx = 2;
        gbcRoomPanel3.gridy = 0;
        gbcRoomPanel3.insets = new Insets(10, 10, 10, 10);
        panel.add(roomPanel3, gbcRoomPanel3);

        return panel;
    }

    private JPanel content() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(255, 255, 255, 215));

        return panel;
    }

    private JPanel roomPanel(Color color, String textTitle, String icon, int nbr) {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(new RoundedBorder(10));
        JLabel label = new JLabel(textTitle);
        GridBagConstraints gbcLabel = new GridBagConstraints();
        gbcLabel.gridx = 0;
        gbcLabel.gridy = 0;
        gbcLabel.insets = new Insets(0, 0, 65, 0);
        gbcLabel.anchor = GridBagConstraints.WEST; // Alignement à gauche

        JLabel label2 = new JLabel(icon);
        GridBagConstraints gbcLabel2 = new GridBagConstraints();
        gbcLabel2.gridx = 0;
        gbcLabel2.gridy = 1;
        gbcLabel2.insets = new Insets(0, 0, 0, 70);
        gbcLabel2.anchor = GridBagConstraints.WEST; // Alignement à droite

        JLabel label3 = new JLabel(nbr + "");
        GridBagConstraints gbcLabel3 = new GridBagConstraints();
        gbcLabel3.gridx = 1;
        gbcLabel3.gridy = 1;
        gbcLabel3.insets = new Insets(0, 0, 0, 0);
        gbcLabel3.anchor = GridBagConstraints.WEST; // Alignement à gauche

        panel.add(label, gbcLabel);
        panel.add(label2, gbcLabel2);
        panel.add(label3, gbcLabel3);

        panel.setPreferredSize(new Dimension(200, 100));
        panel.setBackground(color);

        return panel;
    }

}