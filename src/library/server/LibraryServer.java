/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import library.serviceDao.BookCategoryService;
import library.serviceDao.BookService;
import library.serviceDao.BookTransactionService;
import library.serviceDao.ClientService;
import library.serviceDao.LoginService;
import library.serviceDao.SearchBookService;

/**
 *
 * @author placideh
 */
public class LibraryServer {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(21172);
            registry.rebind("bookCategoryService", new BookCategoryService());
            registry.rebind("bookService", new BookService());
            registry.rebind("bookTransactionService", new BookTransactionService());
            registry.rebind("clientService", new ClientService());
            registry.rebind("loginService", new LoginService());
            registry.rebind("searchBookService", new SearchBookService());
            System.out.println("Server Started...");
        } catch (RemoteException ex) {
            Logger.getLogger(LibraryServer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
