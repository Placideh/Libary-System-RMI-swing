/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.BookTransaction;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author placideh
 */
public class SearchBookDao {
    private static Configuration conf;
    private static SessionFactory sf;
    private static Session session;
    private static Transaction tx;
    
    public List<BookTransaction> getById(int  id) {
        String hql = "from BookTransaction where bTansId='" + id + "'";
        conf = new Configuration().configure().addAnnotatedClass(BookTransaction.class);
        sf = conf.buildSessionFactory();
        session = sf.openSession();
        tx = session.beginTransaction();
        Query q = session.createQuery(hql);
        List<BookTransaction> book = q.list();
        tx.commit();
        session.close();
        return book;
    }
    public List<BookTransaction> getByName(String name) {
        String hql = "from BookTransaction where bookName='" + name + "'";
        conf = new Configuration().configure().addAnnotatedClass(BookTransaction.class);
        sf = conf.buildSessionFactory();
        session = sf.openSession();
        tx = session.beginTransaction();
        Query q = session.createQuery(hql);
        List<BookTransaction> book = q.list();
        tx.commit();
        session.close();
        return book;
    }
    public List<BookTransaction> getByClientName(String name) {
        String hql = "from BookTransaction where firstName='" + name + "'";
        conf = new Configuration().configure().addAnnotatedClass(BookTransaction.class);
        sf = conf.buildSessionFactory();
        session = sf.openSession();
        tx = session.beginTransaction();
        Query q = session.createQuery(hql);
        List<BookTransaction> book = q.list();
        tx.commit();
        session.close();
        return book;
    }
    public List<BookTransaction> getByDateTrans(String date) {
        String hql = "from BookTransaction where transactionDate='" + date + "'";
        conf = new Configuration().configure().addAnnotatedClass(BookTransaction.class);
        sf = conf.buildSessionFactory();
        session = sf.openSession();
        tx = session.beginTransaction();
        Query q = session.createQuery(hql);
        List<BookTransaction> book = q.list();
        tx.commit();
        session.close();
        return book;
    }
    public List<BookTransaction> getByReturnedDate(String date) {
        String hql = "from BookTransaction where returnDate='" + date + "'";
        conf = new Configuration().configure().addAnnotatedClass(BookTransaction.class);
        sf = conf.buildSessionFactory();
        session = sf.openSession();
        tx = session.beginTransaction();
        Query q = session.createQuery(hql);
        List<BookTransaction> book = q.list();
        tx.commit();
        session.close();
        return book;
    }
    public List<BookTransaction> getByStatus(String status) {
        String hql = "from BookTransaction where transType='" + status + "'";
        conf = new Configuration().configure().addAnnotatedClass(BookTransaction.class);
        sf = conf.buildSessionFactory();
        session = sf.openSession();
        tx = session.beginTransaction();
        Query q = session.createQuery(hql);
        List<BookTransaction> book = q.list();
        tx.commit();
        session.close();
        return book;
    }

   
   
}
