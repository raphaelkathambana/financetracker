package main;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;

public class BudgetSetterGUI extends JInternalFrame {
    private javax.swing.JTextField amountField2;
    private javax.swing.JTextField categoryField1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;

    public BudgetSetterGUI() {
        JLabel label = new JLabel("Name");
        add(label);

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 204));;

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Category: ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Amount:");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Set");

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setText("Reset");

        jLabel3.setText("Income, Expenses, Transportation,");

        jLabel4.setText("Food, Entertainment, Shopping,");

        jLabel5.setText("Health, Debts, Education.");

        add(jLabel1);
        add(jLabel2);
        add(jButton1);
        add(jButton2);
        add(jLabel3);
        add(jLabel4);
        add(jLabel5);
        pack();
        setVisible(true);
    }
}
