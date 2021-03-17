/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.serviceInterface;
import java.rmi.*;
import model.Login;
/**
 *
 * @author placideh
 */
public interface ILogin extends Remote {
    void save(Login login) throws RemoteException;
    boolean checkLogin(Login login ) throws RemoteException;
    void createAcount(Login login) throws RemoteException;
    
}
