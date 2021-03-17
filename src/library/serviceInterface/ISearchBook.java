/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.serviceInterface;
import java.rmi.*;
import java.util.List;
import model.BookTransaction;
/**
 *
 * @author placideh
 */
public interface ISearchBook extends Remote {
    List<BookTransaction> getById(int id) throws RemoteException;
    List<BookTransaction> getByName(String name) throws RemoteException;
    List<BookTransaction> getByClientName(String name) throws RemoteException;
    List<BookTransaction> getByDateTrans (String date) throws RemoteException;
    List<BookTransaction> getByReturnDateTrans (String date) throws RemoteException;
    List<BookTransaction> getByStatus(String status) throws RemoteException;
    
}
