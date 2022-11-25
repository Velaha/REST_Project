package fr.uge.project.rest.common;


import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IBike extends Remote {
    Long getId() throws RemoteException;
    void setId(Long id) throws RemoteException;

    int getNote() throws RemoteException;
    void setNote(int note) throws RemoteException;
    void addNote(int note) throws RemoteException;

    String getEtat_de_restitution() throws RemoteException;
    void setEtat_de_restitution(String etat_de_restitution) throws RemoteException;

}
