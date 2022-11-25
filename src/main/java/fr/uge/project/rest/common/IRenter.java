package fr.uge.project.rest.common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

//Interface des loueurs, qui mettent a disposition les velos
public interface IRenter extends Remote {
    void addBike(long id, String etat) throws RemoteException;
    void removeBike(long id) throws RemoteException;

    List<IBike> getAllBike() throws RemoteException;
}
