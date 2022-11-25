package fr.uge.project.rest.server.bikes;

import fr.uge.project.rest.common.IBike;
import fr.uge.project.rest.common.IRenter;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BikeService extends UnicastRemoteObject implements IRenter {

    private final HashMap<Long, Bike> bikes;

    public BikeService() throws Exception {
        super();
        bikes = new HashMap<>();
    }

    @Override
    public void addBike(long id, String etat) throws RemoteException {
        Bike bike = new Bike(id, etat);
        bikes.put(id, bike);
    }

    @Override
    public void removeBike(long id) throws RemoteException {
        bikes.remove(id);
    }

    @Override
    public List<IBike> getAllBike() throws RemoteException {
        return new ArrayList<>(bikes.values());
    }
}
