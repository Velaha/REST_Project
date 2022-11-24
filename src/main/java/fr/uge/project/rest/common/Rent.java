package fr.uge.project.rest.common;

import java.rmi.RemoteException;

//Changer les methodes en ceux qui louent les velos
public interface Rent {
    void addBike(long id, String note, String etat) throws RemoteException;
    void removeBike(long id) throws RemoteException;

}
