/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.BookCategory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author placideh
 */
public class BookCategoryDao {
    
    private static Configuration conf;
    private static SessionFactory sf;
    private static Session session;
    private static Transaction tx;

    public void saveBook(BookCategory book) {
        conf = new Configuration().configure().addAnnotatedClass(BookCategory.class);
        sf = conf.buildSessionFactory();
        session = sf.openSession();
        tx = session.beginTransaction();
        session.save(book);
        tx.commit();
        session.close();

    }

    public List<BookCategory> getBookIntoTable() {
        conf = new Configuration().configure().addAnnotatedClass(BookCategory.class);
        sf = conf.buildSessionFactory();
        session = sf.openSession();
        tx = session.beginTransaction();
        Query query = session.createQuery("from BookCategory");
        List<BookCategory> bookList = query.list();
        tx.commit();
        session.close();
        return bookList;

    }

    public void updateBook(BookCategory book) {
        conf = new Configuration().configure().addAnnotatedClass(BookCategory.class);
        sf = conf.buildSessionFactory();
        session = sf.openSession();
        tx = session.beginTransaction();
        session.update(book);
        tx.commit();
        session.close();
    }

    public void deleteBook(String id) {
        conf = new Configuration().configure().addAnnotatedClass(BookCategory.class);
        sf = conf.buildSessionFactory();
        session = sf.openSession();
        tx = session.beginTransaction();
        BookCategory bookCat = (BookCategory) session.get(BookCategory.class, id);
        if (bookCat != null) {
            session.delete(bookCat);

        }
        tx.commit();
        session.close();

    }
    public List<BookCategory> getBookCatIntoCombo(){
        String hql = "select DISTINCT(name) from BookCategory";
        Configuration conf = new Configuration().configure().addAnnotatedClass(BookCategory.class);
        SessionFactory sf = conf.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery(hql);
        List<BookCategory> bookList = query.list();

        tx.commit();
        session.close();
        return bookList;
    }
}
