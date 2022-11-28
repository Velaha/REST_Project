package fr.uge.rest.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import fr.uge.rest.bike.IBike;

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
	public long getLastId() throws RemoteException {
		var value = bikes.keySet().stream().max(Long::compare);
		return value.isPresent() ? value.get() + 1 : 0;
	}

	@Override
	public List<IBike> getAllBikes() throws RemoteException {
		return new ArrayList<>(bikes.values());
	}

	@Override
	public List<IBike> getSaleableBike() throws RemoteException {
		return bikes.values().stream().filter(bike -> {
			try {
				return bike.getTimesRented() > 0;
			} catch (RemoteException e) {
				throw new RuntimeException(e);
			}
		}).collect(Collectors.toList());
	}

	@Override
	public IBike getNewBike() throws RemoteException {
		return new Bike();
	}
}
