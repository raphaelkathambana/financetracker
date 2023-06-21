package gui;

import javax.swing.*;
import java.awt.*;

public class TestFx {
    private JFrame frame;
    private JMenuBar menuBar;
    private JMenuItem newTransactionMenuItem;
    private JTextField amountTextField;
    private JTextField descriptionTextField;
    private JComboBox<String> categoryComboBox;
    private JRadioButton incomeRadioButton;
    private JRadioButton expenseRadioButton;
    private JButton submitButton;
    private JTable transactionTable;
    private JComboBox<String> reportTypeComboBox;
    private JSpinner fromDateSpinner;
    private JSpinner toDateSpinner;
    private JButton generateReportButton;
    private JPanel chartPanel;

    public TestFx() {
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        // Create the main frame
        frame = new JFrame("Personal Finance Tracker");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Create the menu bar
        menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        newTransactionMenuItem = new JMenuItem("New Transaction");
        fileMenu.add(newTransactionMenuItem);
        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);

        // Create the transaction form panel
        JPanel transactionFormPanel = new JPanel(new GridLayout(5, 2));
        amountTextField = new JTextField();
        descriptionTextField = new JTextField();
        categoryComboBox = new JComboBox<>();
        incomeRadioButton = new JRadioButton("Income");
        expenseRadioButton = new JRadioButton("Expense");
        ButtonGroup typeButtonGroup = new ButtonGroup();
        typeButtonGroup.add(incomeRadioButton);
        typeButtonGroup.add(expenseRadioButton);
        submitButton = new JButton("Submit");
        transactionFormPanel.add(new JLabel("Amount:"));
        transactionFormPanel.add(amountTextField);
        transactionFormPanel.add(new JLabel("Description:"));
        transactionFormPanel.add(descriptionTextField);
        transactionFormPanel.add(new JLabel("Category:"));
        transactionFormPanel.add(categoryComboBox);
        transactionFormPanel.add(new JLabel("Type:"));
        transactionFormPanel.add(incomeRadioButton);
        transactionFormPanel.add(new JLabel(""));
        transactionFormPanel.add(expenseRadioButton);
        transactionFormPanel.add(submitButton);

        // Create the transaction table
        transactionTable = new JTable();
        JScrollPane tableScrollPane = new JScrollPane(transactionTable);

        // Create the reports panel
        JPanel reportsPanel = new JPanel(new GridLayout(4, 2));
        reportTypeComboBox = new JComboBox<>();
        fromDateSpinner = new JSpinner();
        toDateSpinner = new JSpinner();
        generateReportButton = new JButton("Generate Report");
        chartPanel = new JPanel();
        reportsPanel.add(new JLabel("Report Type:"));
        reportsPanel.add(reportTypeComboBox);
        reportsPanel.add(new JLabel("From Date:"));
        reportsPanel.add(fromDateSpinner);
        reportsPanel.add(new JLabel("To Date:"));
        reportsPanel.add(toDateSpinner);
        reportsPanel.add(new JLabel(""));
        reportsPanel.add(generateReportButton);

        // Set the layout for the main frame
        frame.setLayout(new BorderLayout());
        frame.add(transactionFormPanel, BorderLayout.NORTH);
        frame.add(tableScrollPane, BorderLayout.CENTER);
        frame.add(reportsPanel, BorderLayout.SOUTH);

        // Display the main frame
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TestFx::new);
    }
}
