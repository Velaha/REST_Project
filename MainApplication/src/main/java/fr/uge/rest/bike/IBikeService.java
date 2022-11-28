package fr.uge.rest.bike;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IBikeService extends Remote {
	public boolean addBike(long id, String etat) throws RemoteException;
	public boolean addBike(long id, IBike bike) throws RemoteException;
	public void removeBike(long id) throws RemoteException;
	public long getLastId() throws RemoteException;
	public List<IBike> getAllBikes() throws RemoteException;
	public List<IBike> getSaleableBike() throws RemoteException;
	public IBike getNewBike() throws RemoteException;
}

