package fr.uge.project.rest.server;

import fr.uge.project.rest.common.IBike;
import fr.uge.project.rest.common.Rent;
import fr.uge.project.rest.common.Renter;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Users implements Renter, Rent {

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

    @Override
    public List<IBike> getAllBike() throws RemoteException {
        return (List) new ArrayList(bikes.values());
    }
}
