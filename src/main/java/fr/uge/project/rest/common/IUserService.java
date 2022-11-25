package fr.uge.project.rest.common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IUserService extends Remote {
    void addUser(long id, String name) throws RemoteException;

    void removeUser(long id) throws RemoteException;

    List<IUser> getAll() throws RemoteException;
}
