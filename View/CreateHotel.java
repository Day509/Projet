package View;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class CreateHotel extends JPanel {

    private final List<JTextField> fieldList = new ArrayList<>();
    private final JPanel panel = new JPanel(new GridBagLayout());
    private final String[] fieldNames = { "Numéro d'étage:", "Nombre de lits:", "Prix par nuit:" };
    private static final Font TITLE_FONT = new Font("Arial", Font.BOLD, 16);

    public CreateHotel() {
        create("Création chambre");
        add(panel);
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
        fieldList.add(field);
        cField.insets.left = 20;
        pan.add(field, cField);
        return pan;
    }

    private void create(String title) {

        JLabel label = new JLabel(title);
        label.setFont(TITLE_FONT);
        GridBagConstraints cLabel = new GridBagConstraints();
        cLabel.gridx = 0;
        cLabel.gridy = 0;
        cLabel.gridwidth = 1;
        cLabel.insets.bottom = 50;
        cLabel.anchor = GridBagConstraints.CENTER;
        panel.add(label, cLabel);

        // Ajouter les champs texte pour les informations de l'hôtel
        for (int i = 0; i < fieldNames.length; i++) {
            JPanel fieldPanel = addField(fieldNames[i]);
            GridBagConstraints cField = new GridBagConstraints();
            cField.gridx = 0;
            cField.gridy = i + 1;
            cField.gridwidth = 1;
            cField.insets.top = 10;
            cField.anchor = GridBagConstraints.WEST;
            panel.add(fieldPanel, cField);
        }

        // Ajouter le bouton Valider
        JButton validerBtn = new JButton("Valider");
        GridBagConstraints cButton = new GridBagConstraints();
        cButton.gridx = 0;
        cButton.gridy = 5;
        cButton.gridwidth = 1;
        cButton.insets.top = 20;
        cButton.anchor = GridBagConstraints.CENTER;
        panel.add(validerBtn, cButton);
    }
}
