package gui;

import javax.swing.SwingUtilities;

public class TrackerGUI {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Login::new);
    }
}
