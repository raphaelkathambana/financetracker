package gui;

import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import com.toedter.calendar.JCalendar;

import util.Budget;
import util.DatabaseThread;
import util.User;

public class MakeBudgetScreen extends JFrame {
    private JCalendar startDate;
    private JCalendar endDate;
    private JLabel lbBudgetName;
    private JTextField tfBudgetName;
    private JLabel lbStartDate;
    private JLabel lbEndDate;
    DatabaseThread databaseThread;
    User currentUser;

    public MakeBudgetScreen(DatabaseThread databaseThread) {
        this.databaseThread = databaseThread;
        this.currentUser = databaseThread.getCurrentUser();
        setSize(900, 700);
        setLocationRelativeTo(null);

        initComponents();
        setLocationRelativeTo(null); // center the frame on screen
        setVisible(true);
    }

    private void initComponents() {

        setLayout(null);
        startDate = new JCalendar();
        endDate = new JCalendar();
        lbBudgetName = new JLabel("Name Your budget");
        tfBudgetName = new JTextField();
        lbStartDate = new JLabel("Select a start date");
        lbEndDate = new JLabel("Select an end date");

        javax.swing.JButton btMakeBudget = new javax.swing.JButton();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        btMakeBudget.setText("Make Budget");
        btMakeBudget.addActionListener(this::btMakeBudgetActionPerformed);

        lbBudgetName.setBounds(12, 12, 200, 34);
        tfBudgetName.setBounds(12, 72, 200, 50);
        lbStartDate.setBounds(12, 132, 200, 30);
        startDate.setBounds(12, 162, 400, 400);
        lbEndDate.setBounds(412, 132, 200, 30);
        endDate.setBounds(412, 162, 400, 400);
        btMakeBudget.setBounds(700, 612, 150, 30);

        this.add(lbBudgetName);
        this.add(tfBudgetName);
        this.add(startDate);
        this.add(lbStartDate);
        this.add(lbEndDate);
        this.add(endDate);
        this.add(btMakeBudget);

    }

    private void btMakeBudgetActionPerformed(ActionEvent e) {
        System.out.println(
            tfBudgetName.getText() + ": " + 
            startDate.getDate().toString() + " - " +
            endDate.getDate().toString()
        );
        Date startPicked = startDate.getDate();
        LocalDate pickedStartDate = startPicked.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Date endPicked = endDate.getDate();
        LocalDate pickedEndDate = endPicked.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Budget budget = new Budget(tfBudgetName.getText(), pickedStartDate.toString(), pickedEndDate.toString());
        databaseThread.createUserBudget(budget);
        SwingUtilities.invokeLater(() -> new BudgetScreen(databaseThread));
    }

}
