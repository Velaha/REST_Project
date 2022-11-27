package fr.uge.rest.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BikeService extends UnicastRemoteObject implements fr.uge.rest.bike.IBikeService {
	private final HashMap<Long, Bike> bikes;
	
	public BikeService() throws RemoteException {
		super();
		bikes = new HashMap<>();
	}
	
	@Override
	public boolean addBike(long id, fr.uge.rest.bike.IBike bike) throws RemoteException {
		return bikes.put(id, (Bike) bike) != null;		
	}

	@Override
	public boolean addBike(long id, String etat) throws RemoteException {
		var bike = new Bike(id, etat);
		return bikes.put(id, bike) != null;		
	}

	@Override
	public void removeBike(long id) throws RemoteException {
		bikes.remove(id);
	}

	@Override
	public List<fr.uge.rest.bike.IBike> getAllBikes() throws RemoteException {
		return new ArrayList<>(bikes.values());
	}
}
