package gui;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ViewReport extends JFrame {

    public ViewReport() {
        setTitle("Open .txt File Example");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(300, 100);

        Properties mySql = new Properties();
        try (FileReader in = new FileReader("db.properties")) {
            mySql.load(in);
        } catch (IOException ex) {
            System.out.println("Error loading db.properties from classpath." + ex);
        }
        String exportUrl = mySql.getProperty("export");

        JButton openButton = new JButton("Open .txt File");
        openButton.addActionListener(e -> {

                // Path to the .txt file you want to open
                String filePath = exportUrl + "\\Expense_Summary.txt";

                // Create a File object with the specified file path
                File fileToOpen = new File(filePath);

                // Check if the file exists
                if (fileToOpen.exists()) {
                    try {
                        // Open the file using the default text editor or application
                        Desktop.getDesktop().open(fileToOpen);
                    } catch (IOException ex) {
                        // Handle any IOException that may occur
                        ex.printStackTrace();
                    }
                } else {
                    // If the file does not exist, show an error message
                    JOptionPane.showMessageDialog(ViewReport.this, "File does not exist.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
        });

        add(openButton, BorderLayout.CENTER);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ViewReport().setVisible(true));
    }
}
