/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.serviceDao;
import dao.SearchBookDao;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import library.serviceInterface.ISearchBook;
import model.BookTransaction;
/**
 *
 * @author placideh
 */
public class SearchBookService extends UnicastRemoteObject implements ISearchBook {
    SearchBookDao dao=new SearchBookDao();

    public SearchBookService() throws RemoteException {
        super();
    }

    @Override
    public List<BookTransaction> getById(int id) throws RemoteException {
        List<BookTransaction> list=null;
          try {
            list=dao.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<BookTransaction> getByName(String name) throws RemoteException {
        List<BookTransaction> list = null;
        try {
            list = dao.getByName(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<BookTransaction> getByClientName(String name) throws RemoteException {
        List<BookTransaction> list = null;
        try {
            list = dao.getByClientName(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<BookTransaction> getByDateTrans(String date) throws RemoteException {
        List<BookTransaction> list = null;
        try {
            list = dao.getByDateTrans(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<BookTransaction> getByReturnDateTrans(String date) throws RemoteException {
        List<BookTransaction> list = null;
        try {
            list = dao.getByReturnedDate(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<BookTransaction> getByStatus(String status) throws RemoteException {
        List<BookTransaction> list = null;
        try {
            list = dao.getByStatus(status);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    
}
