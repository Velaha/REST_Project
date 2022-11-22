package fr.uge.project.rest.common;

import fr.uge.project.rest.server.Bike;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IEBCService extends Remote {
    void addBike(long id, String note, Etat etat) throws RemoteException;
    void removeBike(long id) throws RemoteException;

    List<IBike> getAllBike() throws RemoteException;
}
