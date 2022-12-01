package fr.uge.rest.bike;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public interface IBikeService extends Remote {
	boolean addBike(long id, String etat) throws RemoteException;
	boolean addBike(long id, IBike bike) throws RemoteException;
	void removeBike(long id) throws RemoteException;
	long getLastId() throws RemoteException;
	ArrayList<IBike> getAllBikes() throws RemoteException;
	List<IBike> getSaleableBike() throws RemoteException;
	IBike getNewBike() throws RemoteException;
	boolean doesExists(long id) throws RemoteException;
	IBike getBike(long id) throws RemoteException;
}
