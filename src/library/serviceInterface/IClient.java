/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.serviceInterface;
import java.rmi.*;
import java.util.List;
import model.Client;
import model.ClientCategory;
/**
 *
 * @author placideh
 */
public interface IClient extends Remote {
    void save(Client client) throws RemoteException;
    List<ClientCategory> getClientCategory() throws RemoteException;
    List<Client>clientInTable() throws RemoteException;
    void update(Client client) throws RemoteException;
    void delete(String id) throws RemoteException;
    byte[] getImage(String id) throws RemoteException;
    
    
}
