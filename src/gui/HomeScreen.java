/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.SwingUtilities;

import com.toedter.calendar.JDateChooser;

import util.DatabaseThread;
import util.Report;
import util.User;
import java.awt.event.ActionEvent;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author manuella
 */
public class HomeScreen extends javax.swing.JFrame {
    User currentUser;
    DatabaseThread databaseThread;
    LocalDate startDate;

    public LocalDate getStartDate() {
        return startDate;
    }

    LocalDate endDate;

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public HomeScreen() {
        initComponents();
        setVisible(true);
    }

    public HomeScreen(DatabaseThread databaseThread) {
        this.databaseThread = databaseThread;
        this.currentUser = databaseThread.getCurrentUser();
        initComponents();
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    private void initComponents() {
        java.awt.Button transaction;
        java.awt.Button signout;
        java.awt.Button makeBudget;
        java.awt.Label label3;
        java.awt.Label label2;
        java.awt.Label label1;
        javax.swing.JPanel jPanel2;
        javax.swing.JPanel jPanel1;
        java.awt.Button contact;
        java.awt.Button accBalance;
        java.awt.Button setGoals;
        java.awt.Button generateReport;
        java.awt.Button viewTransaction;
        java.awt.Button editProfile;
        java.awt.Button viewGoals;
        java.awt.Button viewBudget;
        java.awt.Button viewReports;
        java.awt.Button updateBudget;
        final String DIALOG = "Dialog";

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        viewBudget = new java.awt.Button();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        makeBudget = new java.awt.Button();
        updateBudget = new java.awt.Button();
        signout = new java.awt.Button();
        label3 = new java.awt.Label();
        contact = new java.awt.Button();
        editProfile = new java.awt.Button();
        viewReports = new java.awt.Button();
        viewTransaction = new java.awt.Button();
        generateReport = new java.awt.Button();
        setGoals = new java.awt.Button();
        transaction = new java.awt.Button();
        viewGoals = new java.awt.Button();
        accBalance = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        jPanel2.setBackground(new java.awt.Color(153, 0, 0));

        viewBudget.setBackground(new java.awt.Color(153, 0, 0));
        viewBudget.setFont(new java.awt.Font(DIALOG, 3, 24)); // NOI18N
        viewBudget.setForeground(new java.awt.Color(255, 204, 204));
        viewBudget.setLabel("View budget\n");

        label1.setFont(new java.awt.Font(DIALOG, 3, 48)); // NOI18N
        label1.setForeground(new java.awt.Color(255, 204, 204));
        label1.setText("HOME");

        label2.setFont(new java.awt.Font(DIALOG, 3, 48)); // NOI18N
        label2.setForeground(new java.awt.Color(255, 204, 204));
        label2.setText("SCREEN");

        makeBudget.setBackground(new java.awt.Color(153, 0, 0));
        makeBudget.setFont(new java.awt.Font(DIALOG, 3, 24)); // NOI18N
        makeBudget.setForeground(new java.awt.Color(255, 204, 204));
        makeBudget.setLabel("Make Budget");
        makeBudget.addActionListener(this::makeBudgetActionPerformed);

        updateBudget.setBackground(new java.awt.Color(153, 0, 0));
        updateBudget.setFont(new java.awt.Font(DIALOG, 3, 24)); // NOI18N
        updateBudget.setForeground(new java.awt.Color(255, 204, 204));
        updateBudget.setLabel("Update Budget");
        updateBudget.addActionListener(this::updateBudgetActionPerformed);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label1,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        162,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)
                                .addComponent(label2,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        227,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addGroup(jPanel2Layout.createParallelGroup(
                                        javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(updateBudget,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                255,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(makeBudget,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                255,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)));
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(jPanel2Layout.createParallelGroup(
                                        javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(label1,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                54,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label2,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(98, 98, 98)
                                .addGap(86, 86, 86)
                                .addComponent(makeBudget,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        61,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70)
                                .addComponent(updateBudget,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        56,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)));

        signout.setBackground(new java.awt.Color(153, 0, 0));
        signout.setFont(new java.awt.Font(DIALOG, 3, 36)); // NOI18N
        signout.setForeground(new java.awt.Color(255, 204, 204));
        signout.setLabel("Sign out\n");
        signout.addActionListener(this::signoutActionPerformed);

        label3.setFont(new java.awt.Font(DIALOG, 3, 32)); // NOI18N
        label3.setForeground(new java.awt.Color(153, 0, 0));
        label3.setText("WELCOME TO YOUR PERSONAL FINANCE TRACKER");

        contact.setBackground(new java.awt.Color(153, 0, 0));
        contact.setFont(new java.awt.Font(DIALOG, 3, 36)); // NOI18N
        contact.setForeground(new java.awt.Color(255, 204, 204));
        contact.setLabel("Help/Support");
        contact.addActionListener(this::contactActionPerformed);

        editProfile.setBackground(new java.awt.Color(153, 0, 0));
        editProfile.setFont(new java.awt.Font(DIALOG, 3, 36)); // NOI18N
        editProfile.setForeground(new java.awt.Color(255, 204, 204));
        editProfile.setLabel("Edit Profile");
        editProfile.addActionListener(this::editProfileActionPerformed);

        viewReports.setBackground(new java.awt.Color(255, 204, 204));
        viewReports.setFont(new java.awt.Font(DIALOG, 3, 24)); // NOI18N
        viewReports.setForeground(new java.awt.Color(153, 0, 0));
        viewReports.setLabel("View Reports");
        viewReports.addActionListener(this::viewReportsActionPerformed);

        viewTransaction.setBackground(new java.awt.Color(255, 204, 204));
        viewTransaction.setFont(new java.awt.Font(DIALOG, 3, 24)); // NOI18N
        viewTransaction.setForeground(new java.awt.Color(153, 0, 0));
        viewTransaction.setLabel("View Transactions");
        viewTransaction.addActionListener(this::viewTransactionActionPerformed);

        generateReport.setBackground(new java.awt.Color(255, 204, 204));
        generateReport.setFont(new java.awt.Font(DIALOG, 3, 24)); // NOI18N
        generateReport.setForeground(new java.awt.Color(153, 0, 0));
        generateReport.setLabel("Generate Report");
        generateReport.addActionListener(this::generateReportActionPerformed);

        setGoals.setBackground(new java.awt.Color(255, 204, 204));
        setGoals.setFont(new java.awt.Font(DIALOG, 3, 24)); // NOI18N
        setGoals.setForeground(new java.awt.Color(153, 0, 0));
        setGoals.setLabel("Set Goals");

        transaction.setActionCommand("Add Transaction");
        transaction.setBackground(new java.awt.Color(255, 204, 204));
        transaction.setFont(new java.awt.Font(DIALOG, 3, 24)); // NOI18N
        transaction.setForeground(new java.awt.Color(153, 0, 0));
        transaction.setLabel("Add Transaction");
        transaction.addActionListener(this::addTransactionActionPerformed);

        viewGoals.setBackground(new java.awt.Color(255, 204, 204));
        viewGoals.setFont(new java.awt.Font(DIALOG, 3, 24)); // NOI18N
        viewGoals.setForeground(new java.awt.Color(153, 0, 0));
        viewGoals.setLabel("View Goals");

        accBalance.setBackground(new java.awt.Color(255, 204, 204));
        accBalance.setFont(new java.awt.Font(DIALOG, 3, 24)); // NOI18N
        accBalance.setForeground(new java.awt.Color(153, 0, 0));
        accBalance.setLabel("View account balance");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(
                                        javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout
                                                .createSequentialGroup()
                                                .addGap(13, 13, 13)
                                                .addComponent(label3,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout
                                                .createSequentialGroup()
                                                .addGap(32, 32, 32)
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                                        false)
                                                                .addGroup(jPanel1Layout
                                                                        .createSequentialGroup()
                                                                        .addComponent(editProfile,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                226,
                                                                                Short.MAX_VALUE)
                                                                        .addGap(42, 42, 42))
                                                                .addGroup(jPanel1Layout
                                                                        .createSequentialGroup()
                                                                        .addComponent(viewTransaction,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                        .addGap(42, 42, 42)))
                                                        .addGroup(jPanel1Layout
                                                                .createSequentialGroup()
                                                                .addComponent(transaction,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                        225,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(42, 42, 42)))
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout
                                                                .createSequentialGroup()
                                                                .addComponent(contact,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                        240,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        100)
                                                                .addComponent(signout,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                        196,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap())
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                jPanel1Layout.createSequentialGroup()
                                                                        .addGroup(jPanel1Layout
                                                                                .createParallelGroup(
                                                                                        javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addGroup(
                                                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                                                        jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(
                                                                                                        viewReports,
                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                        196,
                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(
                                                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                                                        jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(
                                                                                                        generateReport,
                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                        216,
                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                        .addGap(50, 50, 50))))
                                        .addGroup(jPanel1Layout
                                                .createSequentialGroup()
                                                .addGap(273, 273,
                                                        273)))));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout
                                .createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addGroup(jPanel1Layout.createParallelGroup(
                                        javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout
                                                .createSequentialGroup()
                                                .addComponent(label3,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        70,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(86, 86, 86)
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(viewTransaction,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                70,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(viewReports,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                71,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(62, 62, 62)
                                .addGroup(jPanel1Layout.createParallelGroup(
                                        javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(generateReport,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                68,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(transaction,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                61,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        67,
                                        Short.MAX_VALUE)
                                .addGap(104, 104, 104)
                                .addGroup(jPanel1Layout.createParallelGroup(
                                        javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(signout,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                66,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(editProfile,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                65,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(contact,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                69,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(16, 16, 16)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
    }// </editor-fold>

    private void signoutActionPerformed(java.awt.event.ActionEvent evt) {
        this.databaseThread.setLoggedIn(false);
        this.databaseThread.interrupt();
        SwingUtilities.invokeLater(() -> new Login(new DatabaseThread()));
        this.dispose();
    }

    /**
     * @param args the command line arguments
     */

    private void contactActionPerformed(ActionEvent e) {
        SwingUtilities.invokeLater(() -> new Support(this.databaseThread));
        this.dispose();
    }

    private void editProfileActionPerformed(ActionEvent e) {
        SwingUtilities.invokeLater(() -> new Profile(this.databaseThread));
        this.dispose();
    }

    private void viewTransactionActionPerformed(ActionEvent e) {
        SwingUtilities.invokeLater(() -> new ViewATransactionScreen(this.databaseThread));
    }

    private void generateReportActionPerformed(ActionEvent e) {
        Object[] options = { "Expenses", "Income" };

        // Show the option dialog with a question icon
        int selectedOption = JOptionPane.showOptionDialog(null,
                "What Report would you like? :", "Question",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, options, options[0]);

        if (selectedOption == JOptionPane.CLOSED_OPTION) {
            // User closed the dialog, exit the program
            System.exit(0);
        }

        // Do something based on the selected option
        switch (selectedOption) {
            case 0:
                System.out.println("Generate expense report");
                getDate("Select Your Dates", 0);
                break;
            case 1:
                System.out.println("Generate income report");
                getDate("Pick Your Dates", 1);
                break;
            default:
                break;
        }
    }

    private void getDate(String title, int option) {
        JFrame showCal = new JFrame();
        showCal.setTitle(title);
        showCal.setSize(400, 300);
        showCal.setLocationRelativeTo(null);
        showCal.setLayout(null);

        // Create a JDateChooser
        JDateChooser startDateChooser = new JDateChooser();
        JDateChooser endDateChooser = new JDateChooser();

        // Add the date selection listener
        startDateChooser.getDateEditor().addPropertyChangeListener(e -> {
            if ("date".equals(e.getPropertyName())) {
                // Date has been selected
                Date selectedDate = startDateChooser.getDate();
                if (selectedDate != null) {
                    // Display a JOptionPane with the selected date
                    String message = "Selected Date: " + selectedDate;

                    JOptionPane.showMessageDialog(showCal, message, "Date Selected",
                            JOptionPane.INFORMATION_MESSAGE);

                    // Close the JFrame
                    setStartDate(selectedDate);
                }
            }
        });
        // Add the date selection listener
        endDateChooser.getDateEditor().addPropertyChangeListener(e -> {
            if ("date".equals(e.getPropertyName())) {
                // Date has been selected
                Date selectedDate = endDateChooser.getDate();
                if (selectedDate != null) {
                    // Display a JOptionPane with the selected date
                    String message = "Selected Date: " + selectedDate;

                    JOptionPane.showMessageDialog(showCal, message, "Date Selected",
                            JOptionPane.INFORMATION_MESSAGE);

                    // Close the JFrame
                    setEndDate(selectedDate);
                }
            }
        });
        JButton btnClose = new JButton("Close");
        btnClose.addActionListener(e -> {
            Properties mySql = new Properties();
            try (FileReader in = new FileReader("db.properties")) {
                mySql.load(in);
            } catch (IOException ex) {
                System.out.println("Error loading db.properties from classpath." + ex);
            }
            String exportUrl = mySql.getProperty("export");
            switch (option) {
                case 0:
                    Report expense = new Report("Expense Summary", this.getStartDate().toString(),
                            this.getEndDate().toString(),
                            databaseThread.getUserTransactions());
                    expense.generateReport();
                    expense.exportReport(exportUrl);
                    break;
                case 1:
                    Report income = new Report("Income Summary", this.getStartDate().toString(),
                            this.getEndDate().toString(),
                            databaseThread.getUserTransactions());
                    income.generateReport();
                    income.exportReport(exportUrl);
                    break;
                default:
                    break;
            }
            JOptionPane.showMessageDialog(showCal, "Report Successfully Generated", "Success",
                    JOptionPane.INFORMATION_MESSAGE);
            showCal.dispose();
        });

        JLabel startDateLabel = new JLabel("Start Date");
        JLabel endDateLabel = new JLabel("End Date");

        startDateLabel.setBounds(5, 5, 100, 30);
        startDateChooser.setBounds(5, 40, 350, 50);
        endDateLabel.setBounds(5, 95, 100, 30);
        endDateChooser.setBounds(5, 125, 350, 50);
        btnClose.setBounds(100, 200, 120, 30);

        // Add the dateChooser to the frame
        showCal.add(startDateChooser);
        showCal.add(startDateLabel);
        showCal.add(endDateChooser);
        showCal.add(endDateLabel);
        showCal.add(btnClose);

        showCal.setVisible(true);
    }

    private void addTransactionActionPerformed(ActionEvent e) {
        SwingUtilities.invokeLater(() -> new InputTransaction(this.databaseThread));
    }

    private void updateBudgetActionPerformed(ActionEvent e) {
        SwingUtilities.invokeLater(() -> new BudgetScreen(this.databaseThread));
    }

    private void makeBudgetActionPerformed(ActionEvent e) {
        SwingUtilities.invokeLater(() -> new MakeBudgetScreen(this.databaseThread));
    }

    private void viewReportsActionPerformed(ActionEvent e) {
        SwingUtilities.invokeLater(ViewReport::new);
    }
}