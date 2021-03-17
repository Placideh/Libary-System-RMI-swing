/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import model.Client;
import model.ClientCategory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.sql.*;
import sun.awt.X11.XAtom;

/**
 *
 * @author placideh
 */
public class ClientDao {
    private static Configuration conf;
    private static SessionFactory sf;
    private static Session session;
    private static Transaction tx;
    
    public void saveClient(Client client){
        try{
        conf=new Configuration().configure().addAnnotatedClass(Client.class);
        sf=conf.buildSessionFactory();
        session=sf.openSession();
        tx=session.beginTransaction();
        session.save(client);
        tx.commit();
        session.close();
        }catch(HibernateException ex){
            ex.printStackTrace();
        }
    }
    public List<ClientCategory> getClientCategory() {
        List<ClientCategory> list = new ArrayList<>();
        ClientCategory clCategory = null;
        list.add(clCategory.STAFF);
        list.add(clCategory.STUDENT);
        return list;

    }
    public List<Client> getClientIntoTable(){
        
            conf = new Configuration().configure().addAnnotatedClass(Client.class);
            sf = conf.buildSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();
            Query query=session.createQuery("from Client");
            List<Client>clientList=query.list();
            tx.commit();
            session.close();
        
        return clientList;
    }
    public void updateClient(Client client){
        conf = new Configuration().configure().addAnnotatedClass(Client.class);
        sf = conf.buildSessionFactory();
        session = sf.openSession();
        tx = session.beginTransaction();
        session.update(client);
        tx.commit();
        session.close();
    }
    public void deleteClient(String id){
        conf = new Configuration().configure().addAnnotatedClass(Client.class);
        sf = conf.buildSessionFactory();
        session = sf.openSession();
        tx = session.beginTransaction();
        Client client = (Client) session.get(Client.class, id);
        if (client != null) {
            session.delete(client);

        }
        tx.commit();
        session.close();
    }
    public byte[] getImage(String id){
        
        String sql="select photo from Client where regId='"+id+"'";
//        String sql="select photo from Client where regId=21172";
        conf = new Configuration().configure().addAnnotatedClass(Client.class);
        sf = conf.buildSessionFactory();
        session = sf.openSession();
        tx = session.beginTransaction();
        Query q=session.createQuery(sql);
        byte[] ima=(byte[])q.uniqueResult();
        
        tx.commit();
        session.close();
        return ima;
        
    }
    
}
