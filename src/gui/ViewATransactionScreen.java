package gui;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

import util.GetConnection;

import java.sql.Statement;

/**
 *
 * @author JC
 */
public class ViewATransactionScreen extends javax.swing.JFrame {

    String type;

    /**
     * Creates new form viewtransaction
     */
    public ViewATransactionScreen() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        javax.swing.JScrollPane jScrollPane1;
        javax.swing.JLabel ViewTransactions;
        javax.swing.JTextField SearchField;
        javax.swing.JButton SearchBttn;

        SearchField = new javax.swing.JTextField();
        SearchBttn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        transactionTable = new javax.swing.JTable();
        ViewTransactions = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        SearchField.setText(" ");
        SearchField.addActionListener(this::SearchFieldActionPerformed);

        SearchBttn.setText("SEARCH");
        SearchBttn.addActionListener(this::SearchBttnActionPerformed);

        transactionTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {

                },
                new String[] {
                        "Type", "Date ", "Amount", "Category"
                }));
        jScrollPane1.setViewportView(transactionTable);

        ViewTransactions.setFont(new java.awt.Font("Rockwell Condensed", 1, 36)); // NOI18N
        ViewTransactions.setText("VIEW TRANSACTIONS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane1)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(SearchField)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(SearchBttn)))
                                .addGap(32, 32, 32))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(263, Short.MAX_VALUE)
                                .addComponent(ViewTransactions)
                                .addGap(303, 303, 303)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(ViewTransactions, javax.swing.GroupLayout.PREFERRED_SIZE, 52,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 41,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(SearchBttn, javax.swing.GroupLayout.PREFERRED_SIZE, 41,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>

    private void SearchBttnActionPerformed(java.awt.event.ActionEvent evt) {
        try (Statement stmt = GetConnection.getConn().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);){
            String query = "SELECT * from attendees where transactionID = 1;";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String transactionType = rs.getString("type");
                String date = rs.getString("date");
                String amount = rs.getString("amount");
                String category = rs.getString("category");

                String[] data = { transactionType, date, amount, category };
                DefaultTableModel tblModel = (DefaultTableModel) transactionTable.getModel();
                tblModel.addRow(data);
            }
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
    }

    private void SearchFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewATransactionScreen.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }   
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new ViewATransactionScreen().setVisible(true));
    }

    // Variables declaration - do not modify
    private javax.swing.JTable transactionTable;
    // End of variables declaration
}
