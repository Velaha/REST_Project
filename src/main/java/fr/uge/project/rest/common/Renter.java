package fr.uge.project.rest.common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface Renter extends Remote {
    void addBike(long id, String note, String etat) throws RemoteException;
    void removeBike(long id) throws RemoteException;

    List<IBike> getAllBike() throws RemoteException;
}
