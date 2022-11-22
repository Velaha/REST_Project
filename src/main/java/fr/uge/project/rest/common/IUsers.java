package fr.uge.project.rest.common;

import java.rmi.RemoteException;

//Ajouter la possibilité d'emprunter des velos en + de pouvoir les louer
public interface IUsers {
    void addBike(long id, String note, String etat) throws RemoteException;
    void removeBike(long id) throws RemoteException;

}
