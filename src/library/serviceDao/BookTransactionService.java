/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.serviceDao;
import dao.BookTransactionDao;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import library.serviceInterface.IBookTransaction;
import model.BookTransaction;
import model.TransactionType;
/**
 *
 * @author placideh
 */
public class BookTransactionService extends UnicastRemoteObject implements IBookTransaction  {
    BookTransactionDao dao=new BookTransactionDao(); 
    public BookTransactionService() throws RemoteException {
        super();
    }

    @Override
    public void save(BookTransaction book) throws RemoteException {
        try {
            dao.saveTransaction(book);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(BookTransaction book) throws RemoteException {
        try {
            dao.updateTransaction(book);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(BookTransaction book) throws RemoteException {
        try {
            dao.deleteTransaction(book);
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }

    @Override
    public List<BookTransaction> bookTransactionInTable() throws RemoteException {
        List<BookTransaction> list=null;
        try {
            list=dao.getBookTransIntoTable();
        } catch (Exception e) {
                e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<TransactionType> transactionTypeInTable() throws RemoteException {
        List<TransactionType> list=null;
        try {
            list=dao.getTransactionTypeIntoCombo();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<String> getFirstNamesInCombo() throws RemoteException {
        List<String> list=null;
        try {
            list=dao.getFirstNameInCombo();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<String> getLastNameInCombo() throws RemoteException {
        List<String> list = null;
        try {
            list = dao.getLastNameInCombo();
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return list;
    }

    @Override
    public List<String> getBookNameInCombo() throws RemoteException {
        List<String> list = null;
        try {
            list = dao.getBookNameInCombo();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }
    
    
}
