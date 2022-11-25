package fr.uge.project.rest.common;

import java.rmi.Remote;
import java.rmi.RemoteException;

//Interface des locataires
public interface ITenant extends Remote {
    void returnBike(IBike bike) throws RemoteException;
    void rentBike(IBike bike) throws RemoteException;
}
