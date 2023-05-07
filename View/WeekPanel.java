package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WeekPanel extends JPanel {

    private LocalDate firstDayOfWeek;
    private LocalDate lastDayOfWeek;
    private JLabel label;
    //Dashboard dashboard = (Dashboard) SwingUtilities.getWindowAncestor(this);
    //RoomPage roomPage = (RoomPage) dashboard.getRoomPage();


    public WeekPanel() {
        this.setPreferredSize(new Dimension(400, 50));
        this.setLayout(new BorderLayout());

        // Calcul de la première et dernière date de la semaine en cours
        LocalDate now = LocalDate.now();
        firstDayOfWeek = now.with(java.time.DayOfWeek.MONDAY);
        lastDayOfWeek = now.with(java.time.DayOfWeek.SUNDAY);

        // Label affichant les dates de la semaine en cours
        label = new JLabel(getWeekRange());
        label.setFont(new Font("Arial", Font.BOLD, 14));
        label.setForeground(Color.BLUE);
        label.setHorizontalAlignment(JLabel.CENTER);

        // Panel contenant les boutons pour avancer/reculer d'une semaine
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton prevButton = new JButton("<");
        prevButton.addActionListener(e -> previousWeek());
        buttonPanel.add(prevButton);
        JButton nextButton = new JButton(">");
        nextButton.addActionListener(e -> nextWeek());
        buttonPanel.add(nextButton);
        JButton resetButton = new JButton("Réinitialiser");
        resetButton.addActionListener(e -> resetWeek());
        buttonPanel.add(resetButton);

        this.add(label, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
    }

    // Méthode pour avancer d'une semaine
    private void nextWeek() {
        firstDayOfWeek = firstDayOfWeek.plusWeeks(1);
        lastDayOfWeek = lastDayOfWeek.plusWeeks(1);
        label.setText(getWeekRange());
        //dashboard.getRoomPage().setWeekDates(firstDayOfWeek, lastDayOfWeek);
    }

    // Méthode pour reculer d'une semaine
    private void previousWeek() {
        firstDayOfWeek = firstDayOfWeek.minusWeeks(1);
        lastDayOfWeek = lastDayOfWeek.minusWeeks(1);
        label.setText(getWeekRange());
        //dashboard.getRoomPage().setWeekDates(firstDayOfWeek, lastDayOfWeek);
    }

    // Méthode pour réinitialiser à la semaine en cours
    private void resetWeek() {
        LocalDate now = LocalDate.now();
        firstDayOfWeek = now.with(java.time.DayOfWeek.MONDAY);
        lastDayOfWeek = now.with(java.time.DayOfWeek.SUNDAY);
        label.setText(getWeekRange());
    }

    // Méthode pour formater la chaîne de dates de la semaine en cours
    private String getWeekRange() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return firstDayOfWeek.format(formatter) + " - " + lastDayOfWeek.format(formatter);
    }

    public LocalDate getFirstDayOfWeek() {
        return firstDayOfWeek;
    }
    
    public LocalDate getLastDayOfWeek() {
        return lastDayOfWeek;
    }
    

}
