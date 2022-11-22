package fr.uge.project.rest.common;


import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IBike extends Remote {
    Long getId() throws RemoteException;
    void setId(Long id) throws RemoteException;

    String getNote() throws RemoteException;
    void setNote(java.lang.String note) throws RemoteException;

    String getEtat_de_restitution() throws RemoteException;
    void setEtat_de_restitution(String etat_de_restitution) throws RemoteException;

}
