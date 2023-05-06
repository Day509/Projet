package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class HotelInformation extends JPanel {

    private final JPanel panel;
    private final String[] fieldNames = {"Nom de l'hôtel:", "Adresse de l'hôtel:", "Nombre de chambres:", "Nombre d'étages:"};
    private static final Font TITLE_FONT = new Font("Arial", Font.BOLD, 16);
    private CardLayout cardLayout;
    private JPanel parentPanel;

    public HotelInformation(CardLayout cardLayout, JPanel parentPanel) {
        this.cardLayout = cardLayout;
        this.parentPanel = parentPanel;
        panel = new JPanel(new GridBagLayout());
        create("Informations sur l'hôtel");
        add(panel);

        JButton validerBtn = new JButton("Valider");
        validerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((View) SwingUtilities.getWindowAncestor(HotelInformation.this)).showPanel("dashboard");
            }
        });
        GridBagConstraints cButton = new GridBagConstraints();
        cButton.gridx = 0;
        cButton.gridy = 5;
        cButton.gridwidth = 2;
        cButton.insets.top = 20;
        cButton.anchor = GridBagConstraints.CENTER;
        panel.add(validerBtn, cButton);
    }

    private void create(String title) {

        JLabel label = new JLabel(title);
        label.setFont(TITLE_FONT);
        GridBagConstraints cLabel = new GridBagConstraints();
        cLabel.gridx = 0;
        cLabel.gridy = 0;
        cLabel.gridwidth = 2;
        cLabel.insets.bottom = 50;
        cLabel.anchor = GridBagConstraints.CENTER;
        panel.add(label, cLabel);

        // Ajouter les champs texte pour les informations de l'hôtel
        for (int i = 0; i < fieldNames.length; i++) {
            JPanel fieldPanel = addField(fieldNames[i]);
            GridBagConstraints cField = new GridBagConstraints();
            cField.gridx = 0;
            cField.gridy = i + 1;
            cField.gridwidth = 2;
            cField.insets.top = 10;
            cField.anchor = GridBagConstraints.WEST;
            panel.add(fieldPanel, cField);
        }
    }

    private JPanel addField(String name) {
        JPanel pan = new JPanel(new GridBagLayout());
        GridBagConstraints cLabel = new GridBagConstraints();
        cLabel.gridx = 0;
        cLabel.gridy = 0;
        cLabel.weightx = 0.5;
        cLabel.anchor = GridBagConstraints.WEST;
        cLabel.insets.right = 20;
        JLabel label = new JLabel(name);
        pan.add(label, cLabel);
        GridBagConstraints cField = new GridBagConstraints();
        cField.gridx = 1;
        cField.gridy = 0;
        cField.weightx = 0.5;
        cField.anchor = GridBagConstraints.WEST;
        JTextField field = new JTextField();
        field.setColumns(16);
        cField.insets.left = 20;
        pan.add(field, cField);
        return pan;
    }
    
    public void showPanel(String panelName) {
        cardLayout.show(parentPanel, panelName);
    }
}
