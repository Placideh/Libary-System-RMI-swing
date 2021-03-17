/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.serviceInterface;
import java.rmi.*;
import java.util.List;
import model.Book;
/**
 *
 * @author placideh
 */
public interface IBook extends Remote {
    void save(Book book) throws RemoteException;
    List<Book>booksInTable() throws RemoteException;
    void update(Book book) throws RemoteException;
    void delete(String id) throws RemoteException;
    
    
}
