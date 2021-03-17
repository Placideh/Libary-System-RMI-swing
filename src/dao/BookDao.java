/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Book;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author placideh
 */
public class BookDao {
    private static Configuration conf;
    private static SessionFactory sf;
    private static Session session;
    private static Transaction tx;
    
    public void saveBook(Book book){
        conf = new Configuration().configure().addAnnotatedClass(Book.class);
        sf = conf.buildSessionFactory();
        session = sf.openSession();
        tx = session.beginTransaction();
        session.save(book);
        tx.commit();
        session.close();
        
    }
    public List<Book> getBookIntoTable(){
        conf = new Configuration().configure().addAnnotatedClass(Book.class);
        sf = conf.buildSessionFactory();
        session = sf.openSession();
        tx = session.beginTransaction();
        Query query = session.createQuery("from Book");
        List<Book> bookList = query.list();
        tx.commit();
        session.close();
        return bookList;
        
    }
    public void updateBook(Book book){
        conf = new Configuration().configure().addAnnotatedClass(Book.class);
        sf = conf.buildSessionFactory();
        session = sf.openSession();
        tx = session.beginTransaction();
        session.update(book);
        tx.commit();
        session.close();
    }
    public void deleteBook(String  id){
        conf = new Configuration().configure().addAnnotatedClass(Book.class);
        sf = conf.buildSessionFactory();
        session = sf.openSession();
        tx = session.beginTransaction();
        Book book = (Book) session.get(Book.class, id);
        if (book != null) {
            session.delete(book);

        }
        tx.commit();
        session.close();
        
    }
}
