/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.serviceDao;
import dao.ClientDao;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import library.serviceInterface.IClient;
import model.Client;
import model.ClientCategory;
/**
 *
 * @author placideh
 */
public class ClientService extends UnicastRemoteObject implements IClient {
    ClientDao dao=new ClientDao();

    public ClientService() throws RemoteException {
        super();
    }

    @Override
    public void save(Client client) throws RemoteException {
        try {
            dao.saveClient(client);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ClientCategory> getClientCategory() throws RemoteException {
        List<ClientCategory> list=null;
        try {
            list=dao.getClientCategory();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Client> clientInTable() throws RemoteException {
        List<Client> list=null;
        try {
            list=dao.getClientIntoTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void update(Client client) throws RemoteException {
        try {
            dao.updateClient(client);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) throws RemoteException {
        try {
            dao.deleteClient(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public byte[] getImage(String id) throws RemoteException {
        byte[] image=null;
        try {
            image=dao.getImage(id);
        } catch (Exception e) {
            e.printStackTrace();
                    
        }
        return image;
    }
    
    
    
}
