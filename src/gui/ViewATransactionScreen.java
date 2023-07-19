package gui;

import java.util.List;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import util.DatabaseThread;
import util.Transaction;
import util.User;

/**
 *
 * @author JC
 */
public class ViewATransactionScreen extends javax.swing.JFrame {

    String type;
    DatabaseThread databaseThread;
    User currentUser;

    /**
     * Creates new form view transaction
     */
    public ViewATransactionScreen() {
        initComponents();
        setVisible(true);
    }

    public ViewATransactionScreen(DatabaseThread databaseThread) {
        this.databaseThread = databaseThread;
        this.currentUser = databaseThread.getCurrentUser();
        initComponents();
        setVisible(true);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        javax.swing.JScrollPane jScrollPane1;
        javax.swing.JLabel viewTransactions;
        javax.swing.JButton searchBttn;

        searchField = new javax.swing.JTextField();
        searchBttn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        transactionTable = new javax.swing.JTable();
        viewTransactions = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        searchField.addActionListener(this::searchFieldActionPerformed);

        searchBttn.setText("SEARCH");
        searchBttn.addActionListener(this::searchBttnActionPerformed);

        transactionTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {

                },
                new String[] {
                        "Date", "Amount", "Category"
                }));
        jScrollPane1.setViewportView(transactionTable);

        viewTransactions.setFont(new java.awt.Font("Rockwell Condensed", 1, 36)); // NOI18N
        viewTransactions.setText("VIEW TRANSACTIONS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane1)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(searchField)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(searchBttn)))
                                .addGap(32, 32, 32))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(263, Short.MAX_VALUE)
                                .addComponent(viewTransactions)
                                .addGap(303, 303, 303)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(viewTransactions, javax.swing.GroupLayout.PREFERRED_SIZE, 52,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 41,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(searchBttn, javax.swing.GroupLayout.PREFERRED_SIZE, 41,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>

    private void searchBttnActionPerformed(java.awt.event.ActionEvent evt) {
        
        DefaultTableModel tblModel = (DefaultTableModel) transactionTable.getModel();
        var input = searchField.getText();
        var transactions = databaseThread.getUserTransactions();
        var searchedTransaction = searchField(transactions, input);
        
        if (searchedTransaction.isEmpty()) {
            int i = tblModel.getRowCount();
            while(i > 0) {
                tblModel.removeRow(i - 1);
                i--;
            }
            JOptionPane.showMessageDialog(ViewATransactionScreen.this, "No results Found", "Error", JOptionPane.ERROR_MESSAGE);
        } 
        if (!searchedTransaction.isEmpty()) {
            for (Transaction tx : searchedTransaction) {
                String[] data = { tx.getDate().toString(), String.valueOf(tx.getAmount()), tx.getCategory().getName() };
                tblModel.addRow(data);
            }
        }
    }

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private List<Transaction> searchField(List<Transaction> transactions, String input) {
        List<Transaction> searchVal = new ArrayList<>();
        for (Transaction tx : transactions) {
            if (tx.getCategory().getName().equals(input)) {
                searchVal.add(tx);
                break;
            }
        }
        return searchVal;
    }

    // Variables declaration - do not modify
    private javax.swing.JTable transactionTable;
    private javax.swing.JTextField searchField;

    // End of variables declaration
}
