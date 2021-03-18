/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.serviceDao;
import dao.BookDao;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import library.serviceInterface.IBook;
import model.Book;
/**
 *
 * @author placideh
 */
public class BookService extends UnicastRemoteObject implements IBook {
    BookDao dao=new BookDao();
    public BookService() throws RemoteException {
        super();
    }

    @Override
    public void save(Book book) throws RemoteException {
        try {
            dao.saveBook(book);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Book> booksInTable() throws RemoteException {
        List<Book> list=null;
        try {
            list=dao.getBookIntoTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void update(Book book) throws RemoteException {
        try {
            dao.updateBook(book);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) throws RemoteException {
        try {
            dao.deleteBook(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
}
