package fr.uge.project.rest.server;

import fr.uge.project.rest.common.IUsers;

import java.rmi.RemoteException;
import java.util.HashMap;

public class Users implements IUsers {

    private final HashMap<Long, Bike> bikes;

    public Users() throws Exception {
        super();
        bikes = new HashMap<>();
    }

    @Override
    public void addBike(long id, java.lang.String note, String etat) throws RemoteException {
        Bike bike = new Bike(id, note, etat);
        bikes.put(id, bike);
    }

    @Override
    public void removeBike(long id) throws RemoteException {
        bikes.remove(id);
    }
}
