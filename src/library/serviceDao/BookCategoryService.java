/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.serviceDao;
import dao.BookCategoryDao;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import library.serviceInterface.IBookCategory;
import model.BookCategory;
/**
 *
 * @author placideh
 */
public class BookCategoryService extends UnicastRemoteObject implements IBookCategory {
    BookCategoryDao dao=new BookCategoryDao();
    public BookCategoryService() throws RemoteException {
        super();
    }

   
    

    @Override
    public void save(BookCategory book) throws RemoteException {
        
        try {
            dao.saveBook(book);
        } catch (Exception e) {
            e.printStackTrace();
        }
          
    }

    @Override
    public List<BookCategory> bookCategoryInTable() throws RemoteException {
        List<BookCategory> list=null;
        try {
            
            list=dao.getBookIntoTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void update(BookCategory book) throws RemoteException {
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

    @Override
    public List<BookCategory> bookCategoryInCombo() throws RemoteException {
        List<BookCategory> list=null;
        try {
            list=dao.getBookCatIntoCombo();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
}
