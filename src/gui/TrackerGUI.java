package gui;

import util.DatabaseThread;

import javax.swing.*;

public class TrackerGUI {

    public static void main(String[] args) {
        var databaseThread = new DatabaseThread();
        // Create an instance of DatabaseThread and pass it to the LoginPanel
        SwingUtilities.invokeLater(() -> new Login(databaseThread));
    }    
}