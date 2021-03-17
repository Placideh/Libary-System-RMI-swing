/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Login;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author placideh
 */
public class LoginDao {
    private static Configuration conf;
    private static SessionFactory sf;
    private static Session session;
    private static Transaction tx;
    
    public void saveUser(Login login) {
        conf = new Configuration().configure().addAnnotatedClass(Login.class);
        sf = conf.buildSessionFactory();
        session = sf.openSession();
        tx = session.beginTransaction();
        session.save(login);
        tx.commit();
        session.close();

    }
    public boolean checkLogin(Login login){
        String hql="select name,password from Login where name='"+login.getName()+"'AND password='"+login.getPassword()+"'";
        conf = new Configuration().configure().addAnnotatedClass(Login.class);
        sf = conf.buildSessionFactory();
        session = sf.openSession();
        tx = session.beginTransaction();
        Query q=session.createQuery(hql);
        Object lg=q.uniqueResult();
        tx.commit();
        session.close();
       if(lg!=null){
           
        return true;
       }else{
           return false;
       }
            
        
        
    }
    public void createAcount(Login login){
        conf = new Configuration().configure().addAnnotatedClass(Login.class);
        sf = conf.buildSessionFactory();
        session = sf.openSession();
        tx = session.beginTransaction();
        session.save(login);
        tx.commit();
        session.close();
    }
}
