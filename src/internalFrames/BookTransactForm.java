/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internalFrames;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalDate;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import library.serviceInterface.IBookTransaction;
import model.BookTransaction;
import model.TransactionType;

/**
 *
 * @author placideh
 */
public class BookTransactForm extends javax.swing.JInternalFrame {

        DefaultTableModel model;
        DefaultComboBoxModel comboModel;
        TransactionType transtype=null;
    /**
     * Creates new form BookTransactForm
     */
    public BookTransactForm() {
        initComponents();
        model = (DefaultTableModel) jTable1.getModel();
        comboModel = (DefaultComboBoxModel) jComboBox1.getModel();
        showBookTransaction();
        populateTransTypeCombo();
        populateFirstNameCombo();
        populateLastNameCombo();
        populateBookNameCombo();
        
    }
    public void saveBookTransaction(){
        try {
            Registry register=LocateRegistry.getRegistry("127.0.0.1", 21172);
            IBookTransaction bookTransactionService=(IBookTransaction)register.lookup("bookTransactionService");
            //ASSIGNING THE TRANSACTION.VALUE TO TRANSACTION OBJECT
             transtype=(TransactionType)jComboBox1.getSelectedItem();
            //ASSIGNING CLIENTS NAMES TO CLIENT OBJECT
            String firstName=(String)jComboBox2.getSelectedItem();
            String lastName=(String)jComboBox4.getSelectedItem();

            //ASSIGNING BOOK NAME TO BOOK OBJECT
            String bookName=(String)jComboBox3.getSelectedItem();

            //GETTING CURRENT TIME AUTOMATIC
            LocalDate transactionDate = LocalDate.now();
            LocalDate returnDate=LocalDate.MIN;

            BookTransaction bookTrans=new BookTransaction(firstName, lastName, bookName, transtype.toString(), transactionDate, returnDate);
            bookTransactionService.save(bookTrans);
            JOptionPane.showMessageDialog(null,"book borrowed !!");
            clearTable();
            showBookTransaction();
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }
    public void updateBookTransaction(){
        try {
            Registry register = LocateRegistry.getRegistry("127.0.0.1", 21172);
            IBookTransaction bookTransactionService = (IBookTransaction) register.lookup("bookTransactionService");
            //ASSIGNING THE TRANSACTION.VALUE TO TRANSACTION OBJECT
             transtype=(TransactionType)jComboBox1.getSelectedItem();
            //ASSIGNING CLIENTS NAMES TO CLIENT OBJECT
            String firstName=(String)jComboBox2.getSelectedItem();
            String lastName=(String)jComboBox4.getSelectedItem();

            //ASSIGNING BOOK NAME TO BOOK OBJECT
            String bookName=(String)jComboBox3.getSelectedItem();

            //GETTING CURRENT TIME AUTOMATIC
            LocalDate transactionDate = LocalDate.now();
            LocalDate returnDate=LocalDate.now();

            BookTransaction bookTrans=new BookTransaction(firstName, lastName, bookName, transtype.toString(), transactionDate, returnDate);
            bookTransactionService.save(bookTrans);
            JOptionPane.showMessageDialog(null,"book returned !!");
            clearTable();
            showBookTransaction();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }
    public void showBookTransaction(){
        try {
            Registry register=LocateRegistry.getRegistry("127.0.0.1", 21172);
            IBookTransaction bookTransactionService=(IBookTransaction)register.lookup("bookTransactionService");
            List<BookTransaction> books = bookTransactionService.bookTransactionInTable();
            for (BookTransaction book : books) {
                model.insertRow(model.getRowCount(), new Object[]{
                   book.getFirstName(),book.getLastName(),
                   book.getBookName(),book.getTransType(),
                   book.getTransactionDate(),book.getReturnDate()

                });
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void clearTable(){
        while (jTable1.getRowCount() != 0) {
            ((DefaultTableModel) jTable1.getModel()).removeRow(0);
        }
    }
    public void populateTransTypeCombo(){
        try {
            Registry register = LocateRegistry.getRegistry("127.0.0.1", 21172);
            IBookTransaction bookTransactionService = (IBookTransaction) register.lookup("bookTransactionService");
            jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(bookTransactionService.transactionTypeInCombo().toArray()));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void populateFirstNameCombo(){
        try {
            Registry register = LocateRegistry.getRegistry("127.0.0.1", 21172);
            IBookTransaction bookTransactionService = (IBookTransaction) register.lookup("bookTransactionService");
            jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(bookTransactionService.getFirstNamesInCombo().toArray()));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void populateLastNameCombo(){
        try {
            Registry register = LocateRegistry.getRegistry("127.0.0.1", 21172);
            IBookTransaction bookTransactionService = (IBookTransaction) register.lookup("bookTransactionService");
            jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(bookTransactionService.getLastNameInCombo().toArray()));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void populateBookNameCombo(){
        try {
            Registry register = LocateRegistry.getRegistry("127.0.0.1", 21172);
            IBookTransaction bookTransactionService = (IBookTransaction) register.lookup("bookTransactionService");
            jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(bookTransactionService.getBookNameInCombo().toArray()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();

        setClosable(true);
        setTitle("Book Transaction ");

        jLabel1.setText("Transaction Type");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "FirstName", "LastName", "Book Name", "Transaction Type", "Transaction Date", "Return Date"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setText(" Client FirstName");

        jLabel3.setText("Book");

        jButton1.setText("Borrow");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Return");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel4.setText(" Client LastName");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 687, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(94, 94, 94)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        saveBookTransaction();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        updateBookTransaction();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try {
            Registry register = LocateRegistry.getRegistry("127.0.0.1", 21172);
            IBookTransaction bookTransactionService = (IBookTransaction) register.lookup("bookTransactionService");
             transtype = (TransactionType) jComboBox1.getSelectedItem();
             BookTransaction bk=new BookTransaction();
             bk.setTransType(transtype.toString());
            bookTransactionService.delete(bk);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int selectedIndex = jTable1.getSelectedRow();
        
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{(String) model.getValueAt(selectedIndex, 3)}));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[]{(String)model.getValueAt(selectedIndex,0)}));
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{(String) model.getValueAt(selectedIndex, 1)}));
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{(String) model.getValueAt(selectedIndex, 2)}));
        
    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
