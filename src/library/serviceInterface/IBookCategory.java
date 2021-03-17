/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.serviceInterface;
import java.rmi.*;
import java.util.List;
import model.BookCategory;
/**
 *
 * @author placideh
 */
public interface IBookCategory extends Remote {
    void save(BookCategory book) throws RemoteException;
    List<BookCategory> bookCategoryInTable() throws RemoteException;
    void update(BookCategory book) throws RemoteException;
    void delete(String id) throws RemoteException;
    List<BookCategory> bookCategoryInCombo() throws RemoteException;
    
    
}
