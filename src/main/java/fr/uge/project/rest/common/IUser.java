package fr.uge.project.rest.common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IUser extends Remote {
    Long getId() throws RemoteException;

    void setId(Long id) throws RemoteException;

    String getName() throws RemoteException;

    void setName(String name) throws RemoteException;
}
