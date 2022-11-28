package fr.uge.rest.user;

import java.rmi.Remote;
import java.rmi.RemoteException;

import fr.uge.rest.bike.IBike;

public interface IUser extends Remote {
	public void setId(long id) throws RemoteException;
	public long getId() throws RemoteException;
	
	public void setName(String name) throws RemoteException;
	public String getName() throws RemoteException;
	
	public void setBike(IBike bike) throws RemoteException;
	public IBike getBike() throws RemoteException;
	
	
	public void setBikeToAdd(IBike bike) throws RemoteException;
	public IBike getBikeToAdd() throws RemoteException;
}
