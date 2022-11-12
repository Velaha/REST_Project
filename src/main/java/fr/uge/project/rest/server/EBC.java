package fr.uge.project.rest.server;

import fr.uge.project.rest.common.BikeService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class EBC extends UnicastRemoteObject implements BikeService {

    private final ArrayList<Bike> bikes;

    public EBC() throws Exception {
        super();
        bikes = new ArrayList<>();
    }

    @Override
    public void addBike(Bike bike) throws RemoteException {
        bikes.add(bike);
    }

    @Override
    public void removeBike(Bike bike) throws RemoteException {
        bikes.remove(bike);
    }
}
