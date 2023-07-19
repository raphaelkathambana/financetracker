package gui;

import util.DatabaseThread;

import javax.swing.*;

public class TrackerGUI {

    public static void main(String[] args) {
        var databaseThread = new DatabaseThread();

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeScreen.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // Create an instance of DatabaseThread and pass it to the LoginPanel
        SwingUtilities.invokeLater(() -> new Login(databaseThread));
    }    
}