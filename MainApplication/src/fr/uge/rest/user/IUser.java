package fr.uge.rest.user;

import java.rmi.Remote;
import java.rmi.RemoteException;

import fr.uge.rest.bike.IBike;

public interface IUser extends Remote {
	void setId(long id) throws RemoteException;
	long getId() throws RemoteException;
	
	void setName(String name) throws RemoteException;
	String getName() throws RemoteException;
	
	void setBike(IBike bike) throws RemoteException;
	IBike getBike() throws RemoteException;
	
	
	void setBikeToAdd(IBike bike) throws RemoteException;
	IBike getBikeToAdd() throws RemoteException;
}
