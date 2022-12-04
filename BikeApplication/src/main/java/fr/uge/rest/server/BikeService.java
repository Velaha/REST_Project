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
		synchronized (bikes) {
			if (bikes.containsKey(id)) {
				return false;
			}
			bikes.put(id, (Bike) bike);
			return true;
		}
	}

	@Override
	public boolean addBike(long id, String etat) throws RemoteException {
		synchronized (bikes) {
			if (bikes.containsKey(id)) {
				return false;
			}
			bikes.put(id, new Bike(id, etat));
			return true;
		}
	}

	@Override
	public void removeBike(long id) throws RemoteException {
		synchronized (bikes) {
			bikes.remove(id);
		}
	}

	@Override
	public long getLastId() throws RemoteException {
		var value = bikes.keySet().stream().max(Long::compare);
		return value.map(aLong -> aLong + 1).orElse(0L);
	}

	@Override
	public ArrayList<IBike> getAllBikes() throws RemoteException {
		synchronized (bikes) {
			return new ArrayList<>(bikes.values());
		}

	}

	@Override
	public List<IBike> getSaleableBike() throws RemoteException {
		synchronized (bikes) {
			return bikes.values().stream().filter(bike -> {
				try {
					return bike.getTimesRented() > 0;
				} catch (RemoteException e) {
					throw new RuntimeException(e);
				}
			}).collect(Collectors.toList());
		}
	}

	@Override
	public IBike getNewBike() throws RemoteException {
		return new Bike();
	}

	@Override
	public boolean doesExists(long id) throws RemoteException {
		return bikes.containsKey(id);
	}

	@Override
	public IBike getBike(long id) throws RemoteException {
		synchronized (bikes) {
			return bikes.get(id);
		}
	}
}
