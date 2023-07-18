/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.List;

import javax.swing.JComboBox;

import util.Budget;
import util.DatabaseThread;
import util.User;

/**
 *
 * @author austi
 */
public class ProgressInternalFrame extends javax.swing.JInternalFrame {

    User currentUser;
    DatabaseThread databaseThread;

    /**
     * Creates new form progressGUI
     */
    public ProgressInternalFrame() {
        initComponents();
    }

    public ProgressInternalFrame(DatabaseThread databaseThread) {
        this.databaseThread = databaseThread;
        this.currentUser = databaseThread.getCurrentUser();
        initComponents();
    }

    private void initComponents() {
        javax.swing.JLabel jLabel3;
        javax.swing.JLabel jLabel2;
        javax.swing.JLabel jLabel1;
        javax.swing.JButton jButton1;

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        bTextField1 = new javax.swing.JTextField();
        amountTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        progressLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        alertLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 204));

        String fontName = "Tahoma";
        jLabel1.setFont(new java.awt.Font(fontName, 0, 18)); // NOI18N
        jLabel1.setText("Budget Amount: ");

        jLabel2.setFont(new java.awt.Font(fontName, 0, 18)); // NOI18N
        jLabel2.setText("Amount Spent: ");
        jButton1.setText("Calculate");
        jButton1.addActionListener(this::jButton1ButtonClicked);

        jLabel3.setFont(new java.awt.Font(fontName, 0, 18)); // NOI18N
        jLabel3.setText("Your Progress Amount is: ");

        budgetComboBox = new JComboBox<>();
        List<Budget> budgetList = this.databaseThread.getUserBudgets();
        for (Budget b : budgetList) {
            budgetComboBox.addItem(b);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(budgetComboBox)
                                        .addGroup(layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(alertLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 279,
                                                Short.MAX_VALUE)
                                        .addGroup(layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(progressLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(bTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 279,
                                                        Short.MAX_VALUE)
                                                .addComponent(amountTextField2)
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 111,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(58, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(budgetComboBox))
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(bTextField1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(amountTextField2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 32,
                                                Short.MAX_VALUE)
                                        .addComponent(progressLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(alertLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(114, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ButtonClicked(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1MouseClicked

        Budget budget = (Budget) budgetComboBox.getSelectedItem();
        bTextField1.setText(String.valueOf(budget.getTotalBudgetAmount()));
        amountTextField2.setText(String.valueOf(budget.getTotalExpenses()));

        bTextField1.setEditable(false);
        amountTextField2.setEditable(false);

        if (Double.parseDouble(String.valueOf(budget.getTotalExpenses())) < Double.parseDouble(String.valueOf(budget.getTotalBudgetAmount()))) {
            alertLabel.setText("You are within budget");
        } else {
            alertLabel.setText("You are beyond your budget");
        }
    }// GEN-LAST:event_jButton1MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amountTextField2;
    private javax.swing.JTextField bTextField1;
    private javax.swing.JLabel alertLabel;
    private javax.swing.JLabel progressLabel;
    private JComboBox<Budget> budgetComboBox;
    // End of variables declaration//GEN-END:variables
}
