package fr.uge.project.rest.server.users;

import fr.uge.project.rest.common.IBike;
import fr.uge.project.rest.common.IRenter;
import fr.uge.project.rest.common.ITenant;
import fr.uge.project.rest.common.IUser;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class User extends UnicastRemoteObject implements IUser, ITenant, IRenter {
    private Long id;
    private String name;
    private IBike bike;


    public User() throws RemoteException {
    }

    public User(Long id, String name) throws RemoteException {
        this.id = id;
        this.name = name;
    }

    @Override
    public Long getId() throws RemoteException {
        return id;
    }

    @Override
    public void setId(Long id) throws RemoteException {
        this.id = id;
    }

    @Override
    public String getName() throws RemoteException {
        return name;
    }

    @Override
    public void setName(String name) throws RemoteException {
        this.name = name;
    }

    @Override
    public void returnBike(IBike bike) throws RemoteException {
        //rendre le velo a la hashmap
        this.bike = null;
    }

    @Override
    public void rentBike(IBike bike) throws RemoteException {
        this.bike = bike;
    }


    @Override
    public void addBike(long id, String etat) throws RemoteException {
        //TODO
    }

    @Override
    public void removeBike(long id) throws RemoteException {
        //TODO
    }

    @Override
    public List<IBike> getAllBike() throws RemoteException {
        return null;
    }
}
