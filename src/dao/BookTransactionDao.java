/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.Book;
import model.BookTransaction;
import model.Client;
import model.TransactionType;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author placideh
 */
public class BookTransactionDao {
    private static Configuration conf;
    private static SessionFactory sf;
    private static Session session;
    private static Transaction tx;

    public void saveTransaction(BookTransaction book) {
        conf = new Configuration().configure().addAnnotatedClass(BookTransaction.class);
        sf = conf.buildSessionFactory();
        session = sf.openSession();
        tx = session.beginTransaction();
        session.save(book);
        tx.commit();
        session.close();

    }
    public void updateTransaction(BookTransaction book){
        String hql="select transactionDate from BookTransaction where bTansId='"+book.getbTansId()+"'";
        conf = new Configuration().configure().addAnnotatedClass(BookTransaction.class);
        sf = conf.buildSessionFactory();
        session = sf.openSession();
        tx = session.beginTransaction();
        Query q=session.createQuery(hql);
        LocalDate time=(LocalDate)q.uniqueResult();
        book.setTransactionDate(time);
        session.save(book);
        tx.commit();
        session.close();
    }
    public void deleteTransaction(BookTransaction book){
        String hql="select bTansId from BookTransaction where firstName='"+book.getbTansId()+"'";
        conf = new Configuration().configure().addAnnotatedClass(BookTransaction.class);
        sf = conf.buildSessionFactory();
        session = sf.openSession();
        tx = session.beginTransaction();
        Query q=session.createQuery(hql);
        BookTransaction bookTrans=(BookTransaction)q.uniqueResult();
        session.delete(bookTrans);
        tx.commit();
        session.close();
    }
    public List<BookTransaction> getBookTransIntoTable(){
        conf = new Configuration().configure().addAnnotatedClass(BookTransaction.class);
        sf = conf.buildSessionFactory();
        session = sf.openSession();
        tx = session.beginTransaction();
        Query query = session.createQuery("from BookTransaction");
        List<BookTransaction> bookList = query.list();
        tx.commit();
        session.close();
        return bookList;
        
    }
    public List<TransactionType> getTransactionTypeIntoCombo(){
        List<TransactionType> list=new ArrayList<>() ;
        TransactionType transType = null;
        list.add(transType.BORROW);
        list.add(transType.RETURN);
        return list;
    }
    public List<String> getFirstNameInCombo(){
        String hql="select firstName from Client";
        conf = new Configuration().configure().addAnnotatedClass(Client.class);
        sf = conf.buildSessionFactory();
        session = sf.openSession();
        tx = session.beginTransaction();
        Query query = session.createQuery(hql);
        List<String> name = query.list();
        tx.commit();
        session.close();
        return name;
    }
    public List<String> getLastNameInCombo(){
        String hql="select lastName from Client";
        conf = new Configuration().configure().addAnnotatedClass(Client.class);
        sf = conf.buildSessionFactory();
        session = sf.openSession();
        tx = session.beginTransaction();
        Query query = session.createQuery(hql);
        List<String> name = query.list();
        tx.commit();
        session.close();
        return name;
    }
    public List<String>getBookNameInCombo(){
        String hql = "select title from Book ";
        conf = new Configuration().configure().addAnnotatedClass(Book.class);
        sf = conf.buildSessionFactory();
        session = sf.openSession();
        tx = session.beginTransaction();
        Query query = session.createQuery(hql);
        List<String> name = query.list();
        tx.commit();
        session.close();
        return name;
    }
}
