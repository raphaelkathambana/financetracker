package gui;

import javax.swing.*;
import java.awt.*;

public class TestGui extends JFrame {

    public TestGui() {
        // Set up the main frame
        setTitle("Personal Finance Tracker");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());

        // Create and add components to the main frame
        createMenuBar();
        createTransactionForm();
        createTransactionList();
        createReportsSection();

        // Display the main frame
        setVisible(true);
    }

    private void createMenuBar() {
        // Create and add menu bar components
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        // Add file menu items and event listeners

        JMenu editMenu = new JMenu("Edit");
        // Add edit menu items and event listeners

        JMenu viewMenu = new JMenu("View");
        // Add view menu items and event listeners

        JMenu helpMenu = new JMenu("Help");
        // Add help menu items and event listeners

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(viewMenu);
        menuBar.add(helpMenu);

        setJMenuBar(menuBar);
    }

    private void createTransactionForm() {
        // Create and add components for the transaction form
        JPanel transactionFormPanel = new JPanel(new GridLayout(5, 2));

        JLabel amountLabel = new JLabel("Amount:");
        JTextField amountField = new JTextField();

        JLabel descriptionLabel = new JLabel("Description:");
        JTextField descriptionField = new JTextField();

        JLabel categoryLabel = new JLabel("Category:");
        // Add a dropdown or tree view component for category selection

        JLabel typeLabel = new JLabel("Type:");
        // Add radio buttons for income and expense selection

        JButton submitButton = new JButton("Submit");
        // Add event listener for submit button

        transactionFormPanel.add(amountLabel);
        transactionFormPanel.add(amountField);
        transactionFormPanel.add(descriptionLabel);
        transactionFormPanel.add(descriptionField);
        transactionFormPanel.add(categoryLabel);
        // Add category selection component to the panel
        transactionFormPanel.add(typeLabel);
        // Add type selection component to the panel
        transactionFormPanel.add(new JLabel()); // Empty label for spacing
        transactionFormPanel.add(submitButton);

        add(transactionFormPanel, BorderLayout.WEST);
    }

    private void createTransactionList() {
        // Create and add components for the transaction list
        JTable transactionTable = new JTable();
        // Set up the table model and populate it with transaction data

        JScrollPane scrollPane = new JScrollPane(transactionTable);

        add(scrollPane, BorderLayout.CENTER);
    }

    private void createReportsSection() {
        // Create and add components for the reports section
        JPanel reportsPanel = new JPanel(new BorderLayout());

        // Add components for report type selection, date range selector, and generate report button

        // Add a chart visualization component

        add(reportsPanel, BorderLayout.EAST);
    }

    public static void main(String[] args) {
        // Run the application
        SwingUtilities.invokeLater(TestGui::new);
    }
}

