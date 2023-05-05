package View;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class HotelInformation {

    private List<JTextField> list = new ArrayList<JTextField>();
    private JPanel panel = new JPanel();
    private JButton validateBtn = new JButton("Valider");
    

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                HotelInformation id = new HotelInformation();
                id.create("Informations sur l'hôtel");
            }
        });
    }

    private void addField(String name) {
        JTextField jtf = new JTextField(16);
        panel.add(new JLabel(name, JLabel.LEFT));
        panel.add(jtf);
        list.add(jtf);
    }

    void create(String strTitle) {
        panel.setLayout(new GridLayout(0, 1));
        addField("Nom de l'hôtel:");
        addField("Adresse de l'hôtel:");
        addField("Nombre de chambres:");
        addField("Nombre d'étages:");

        JPanel btnPanel = new JPanel(new BorderLayout());
        btnPanel.add(validateBtn, BorderLayout.CENTER);

        JFrame frmtest = new JFrame(strTitle);
        frmtest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmtest.add(panel, BorderLayout.NORTH);
        frmtest.add(btnPanel, BorderLayout.SOUTH);
        frmtest.pack();
        frmtest.setLocationRelativeTo(null);
        frmtest.setVisible(true);
        list.get(0).requestFocusInWindow();
    }

}
