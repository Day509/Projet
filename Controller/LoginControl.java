package Controller;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Model.Hotel;
import View.*;
import test.Generate;

public class LoginControl implements ActionListener {
    Generate generate = new Generate(new Hotel("Hotel", "Peut importe"));
    JButton button1;
    Login login;
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    View view;
    String[] textExpected = {"admin", "invite"};
    JTextField text;

    public LoginControl(JButton button1, Login login, JTextField textField) {
        this.button1 = button1;
        this.login = login;
        text = textField;
    }

    public void actionPerformed(ActionEvent e) {
        String textEntered = text.getText();
        if (((JButton) e.getSource()).getText().equals("Se connecter") && containsTextExpected(textEntered)) {
            view = new View(dim.height, dim.width, isAdmin() ? generate.getHotel() : new Hotel("Suu", "Evry"));
            Container parentContainer = login.getParent();
            parentContainer.add(view);
            parentContainer.revalidate();
            parentContainer.repaint();
            view.setVisible(true);
            login.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "Hôtel introuvable", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean isAdmin() {
        return text.getText().equals("admin");
    }

    private boolean containsTextExpected(String text) {
        for (String expected : textExpected) {
            if (text.equals(expected)) {
                return true;
            }
        }
        return false;
    }
}
