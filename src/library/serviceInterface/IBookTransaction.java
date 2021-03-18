/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.serviceInterface;
import java.rmi.*;
import java.util.List;
import model.BookTransaction;
import model.TransactionType;
/**
 *
 * @author placideh
 */
public interface IBookTransaction extends Remote {
    void save(BookTransaction book) throws RemoteException;
    void update(BookTransaction book) throws RemoteException;
    void delete(BookTransaction book) throws RemoteException;
    List<BookTransaction> bookTransactionInTable() throws RemoteException;
    List<TransactionType> transactionTypeInCombo() throws RemoteException;
    List<String>getFirstNamesInCombo() throws RemoteException;
    List<String> getLastNameInCombo() throws RemoteException;
    List<String>getBookNameInCombo() throws RemoteException;
    
    
    
}
