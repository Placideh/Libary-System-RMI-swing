/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internalFrames;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import dao.SearchBookDao;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import library.serviceInterface.IBookTransaction;
import library.serviceInterface.ISearchBook;
import model.BookTransaction;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author placideh
 */
public class SearchBook extends javax.swing.JInternalFrame {
        DefaultTableModel model;
        SearchBookDao sDao=new SearchBookDao();


    /**
     * Creates new form SearchBook
     */
    public SearchBook() {
        initComponents();
        model = (DefaultTableModel) jTable1.getModel();

        allSearchedBooks();
    }
    public void showClientId(int id ){
        try {
            Registry register=LocateRegistry.getRegistry("127.0.0.1", 21172);
            ISearchBook searchBookService=(ISearchBook) register.lookup("searchBookService");
            List<BookTransaction> books =searchBookService.getById(id);
            for (BookTransaction book : books) {
                model.insertRow(model.getRowCount(), new Object[]{
                    book.getbTansId(),
                    book.getFirstName(),
                    book.getBookName(),
                    book.getTransactionDate(), book.getReturnDate(),
                     book.getTransType()    

                });
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }
    public void showClientName(String name){
        try {
            Registry register = LocateRegistry.getRegistry("127.0.0.1", 21172);
            ISearchBook searchBookService = (ISearchBook) register.lookup("searchBookService");
            List<BookTransaction> books = searchBookService.getByClientName(name);
            for (BookTransaction book : books) {
                model.insertRow(model.getRowCount(), new Object[]{
                    book.getbTansId(),
                    book.getFirstName(),
                    book.getBookName(), 
                    book.getTransactionDate(), book.getReturnDate(),
                    book.getTransType()

                });
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void showBook(String name){
        try {
            Registry register = LocateRegistry.getRegistry("127.0.0.1", 21172);
            ISearchBook searchBookService = (ISearchBook) register.lookup("searchBookService");
            List<BookTransaction> books = searchBookService.getByName(name);
            for (BookTransaction book : books) {
                model.insertRow(model.getRowCount(), new Object[]{
                    book.getbTansId(),
                    book.getFirstName(),
                    book.getBookName(),
                    book.getTransactionDate(), book.getReturnDate(),
                    book.getTransType()

                });
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   
    public void showDateTrans(String date){
        try {
            Registry register = LocateRegistry.getRegistry("127.0.0.1", 21172);
            ISearchBook searchBookService = (ISearchBook) register.lookup("searchBookService");
            List<BookTransaction> books = searchBookService.getByDateTrans(date);
            for (BookTransaction book : books) {
                model.insertRow(model.getRowCount(), new Object[]{
                    book.getbTansId(),
                    book.getFirstName(),
                    book.getBookName(),
                    book.getTransactionDate(), book.getReturnDate(),
                    book.getTransType()

                });
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }
    public void showReturnDateTrans(String date){
        try {
            Registry register = LocateRegistry.getRegistry("127.0.0.1", 21172);
            ISearchBook searchBookService = (ISearchBook) register.lookup("searchBookService");
            List<BookTransaction> books = searchBookService.getByReturnDateTrans(date);
            for (BookTransaction book : books) {
                model.insertRow(model.getRowCount(), new Object[]{
                    book.getbTansId(),
                    book.getFirstName(),
                    book.getBookName(),
                    book.getTransactionDate(), book.getReturnDate(),
                    book.getTransType()

                });
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }
    public void allSearchedBooks(){
        try {
            Registry register = LocateRegistry.getRegistry("127.0.0.1", 21172);
            IBookTransaction bookTransactionService = (IBookTransaction) register.lookup("bookTransactionService");
            List<BookTransaction> books = bookTransactionService.bookTransactionInTable();
            for (BookTransaction book : books) {
                model.insertRow(model.getRowCount(), new Object[]{
                    book.getbTansId(),
                    book.getFirstName(),
                    book.getBookName(), 
                    book.getTransactionDate(), book.getReturnDate(),
                    book.getTransType()

                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void clearTable() {
        while (jTable1.getRowCount() != 0) {
            ((DefaultTableModel) jTable1.getModel()).removeRow(0);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

        setClosable(true);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setText("SEARCH");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ClientId", "ClientName", "BookName", "TransDate", " ReturnDate", "Status"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setText("Client Id");

        jLabel3.setText("Client Name ");

        jLabel4.setText("Book Name");

        jLabel5.setText("Transaction Date");

        jLabel6.setText("Returned Date");

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Search");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Search");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Search");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel7.setText("Search By Either One Of The Following:");

        jButton6.setText("Export As Excel");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Export As PDF");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("AllBook");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(193, 193, 193)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton8)
                                        .addGap(98, 98, 98)
                                        .addComponent(jLabel7))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel2)
                                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jTextField1))
                                        .addGap(52, 52, 52)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel3)
                                            .addComponent(jTextField2)
                                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
                                        .addGap(49, 49, 49)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel4)
                                            .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(26, 26, 26)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jTextField4)
                                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(42, 42, 42)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField5)
                                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))))))
                        .addGap(0, 31, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton6)
                    .addComponent(jButton7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addGap(0, 42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        clearTable();
        String name= jTextField4.getText().trim();
        showDateTrans(name);
         jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        clearTable();
        int id=Integer.parseInt(jTextField1.getText().trim());
        showClientId(id);
         jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        clearTable();
        String name = jTextField2.getText().trim();
        showClientName(name);
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        clearTable();
        String name = jTextField3.getText().trim();
        showBook(name);
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        clearTable();
        String name = jTextField5.getText().trim();
        showReturnDateTrans(name);
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        FileOutputStream excelFOU = null;
        BufferedOutputStream excelBOU = null;
        XSSFWorkbook excelJTableExporter = null;
//        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        JFileChooser excelFileChooser = new JFileChooser("//home//placideh//Documents//Notes");
        excelFileChooser.setDialogTitle("Save As");
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL_FILES", "xls", "xlsx", "xlsm");
        excelFileChooser.setFileFilter(fnef);

        int excelChooser = excelFileChooser.showSaveDialog(null);
        //check if save button is clicked
        if (excelChooser == JFileChooser.APPROVE_OPTION) {

            try {
                excelJTableExporter = new XSSFWorkbook();
                XSSFSheet excelSheet = excelJTableExporter.createSheet("JTable Sheet");
                for (int i = 0; i < model.getRowCount(); i++) {
                    XSSFRow excelRow = excelSheet.createRow(i);
                    for (int j = 0; j < model.getColumnCount(); j++) {
                        XSSFCell excelCell = excelRow.createCell(j);
                        excelCell.setCellValue(model.getValueAt(i, j).toString());
                    }
                }
                excelFOU = new FileOutputStream(excelFileChooser.getSelectedFile() + ".xlsx");

                excelBOU = new BufferedOutputStream(excelFOU);
                excelJTableExporter.write(excelBOU);
                JOptionPane.showMessageDialog(null, "Excel Exported Successfully!!");
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    if (excelBOU != null) {
                        excelFOU.close();
                    }
                    if (excelFOU != null) {
                        excelFOU.close();

                    }
                    if (excelJTableExporter != null) {
                        excelJTableExporter.close();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

        }

    }//GEN-LAST:event_jButton6ActionPerformed
    
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        String path = "";
        JFileChooser pdfFile = new JFileChooser();
        pdfFile.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int x = pdfFile.showSaveDialog(this);
        if (x == JFileChooser.APPROVE_OPTION) {
            path = pdfFile.getSelectedFile().getPath();
        }
        Document doc = new Document();
        try {
            PdfWriter.getInstance(doc, new FileOutputStream(path + "myPdfFile.pdf"));
            doc.open();
            PdfPTable pdfTable = new PdfPTable(6);
            //adding header
            pdfTable.addCell("ClientId");
            pdfTable.addCell("ClientName");
            pdfTable.addCell("BookName");
            pdfTable.addCell("TransDate");
            pdfTable.addCell("ReturnDate");
            pdfTable.addCell("Status");
            //looping the data from jtable to pdf
            for (int i = 0; i < jTable1.getRowCount(); i++) {
                String clientId = jTable1.getValueAt(i, 0).toString();
                String clientName = jTable1.getValueAt(i, 1).toString();
                String bookName = jTable1.getValueAt(i, 2).toString();
                String TransDate = jTable1.getValueAt(i, 3).toString();
                String ReturnDate = jTable1.getValueAt(i, 4).toString();
                String status = jTable1.getValueAt(i, 5).toString();

                pdfTable.addCell(clientId);
                pdfTable.addCell(clientName);
                pdfTable.addCell(bookName);
                pdfTable.addCell(TransDate);
                pdfTable.addCell(ReturnDate);
                pdfTable.addCell(status);

            }
            doc.add(pdfTable);
            JOptionPane.showMessageDialog(null, "PDF Exported Successfully!!");

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (DocumentException ex) {
            ex.printStackTrace();
        }
        doc.close();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        clearTable();
        allSearchedBooks();
    }//GEN-LAST:event_jButton8ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
