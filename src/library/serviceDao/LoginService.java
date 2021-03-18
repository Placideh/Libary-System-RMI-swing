/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.serviceDao;
import dao.LoginDao;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import library.serviceInterface.ILogin;
import model.Login;
/**
 *
 * @author placideh
 */
public class LoginService extends UnicastRemoteObject implements ILogin {
    LoginDao dao=new LoginDao();

    public LoginService() throws RemoteException {
        super();
    }

    @Override
    public void save(Login login) throws RemoteException {
        try {
            dao.saveUser(login);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean checkLogin(Login login) throws RemoteException {
        boolean isLogedIn=false;
        try {
            isLogedIn=dao.checkLogin(login);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isLogedIn;
    }

    @Override
    public void createAcount(Login login) throws RemoteException {
        try {
            dao.createAcount(login);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
}
