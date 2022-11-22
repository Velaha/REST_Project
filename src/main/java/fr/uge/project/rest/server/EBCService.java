package fr.uge.project.rest.server;

import fr.uge.project.rest.common.Etat;
import fr.uge.project.rest.common.IBike;
import fr.uge.project.rest.common.IEBCService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EBCService extends UnicastRemoteObject implements IEBCService {

    private final HashMap<Long, Bike> bikes;

    public EBCService() throws Exception {
        super();
        bikes = new HashMap<>();
    }

    @Override
    public void addBike(long id, String note, Etat etat) throws RemoteException {
        Bike bike = new Bike(id, note, etat);
        bikes.put(id, bike);
    }

    @Override
    public void removeBike(long id) throws RemoteException {
        bikes.remove(id);
    }

    @Override
    public List<IBike> getAllBike() throws RemoteException {
        return (List) new ArrayList<Bike>(bikes.values());
    }
}
