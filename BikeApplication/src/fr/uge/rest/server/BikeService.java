package fr.uge.rest.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fr.uge.rest.bike.IBike;
import fr.uge.rest.user.IUser;

public class BikeService extends UnicastRemoteObject implements fr.uge.rest.bike.IBikeService {
	private final HashMap<Long, Bike> bikes;
	private final HashMap<Long, ArrayList<IUser>> waitingLine;
	private final AddBikeToUserObserver observer;
	
	public BikeService() throws RemoteException {
		super();
		bikes = new HashMap<>();
		waitingLine = new HashMap<>();
		observer = new AddBikeToUserObserver();
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
		return value.map(aLong -> aLong + 1).orElse(0L);
	}

	@Override
	public ArrayList<IBike> getAllBikes() throws RemoteException {
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

	@Override
	public boolean doesExists(long id) throws RemoteException {
		return bikes.containsKey(id);
	}

	@Override
	public IBike getBike(long id) throws RemoteException {
		return bikes.get(id);
	}
	

	@Override
	public void putInWaitingLine(long id, IUser user) throws RemoteException {
		waitingLine.merge(Long.valueOf(id), 
				new ArrayList<>(List.of(user)), 
				(u1, u2) -> new ArrayList<>(Stream.concat(u1.stream(), u2.stream()).toList()));

	}
	
	@Override
	public IUser takeFirstUserFromWaitingLine(long id) throws RemoteException {
		return waitingLine.get(id).remove(0);
	}

	@Override
	public boolean isUserWaiting(long id, IUser user) throws RemoteException {
		return waitingLine.get(id).contains(user);
	}

	@Override
	public void notifyAvailableBike(Bike bike) throws RemoteException {
		observer.onBikeReturn(this, bike);
		
	}
}
