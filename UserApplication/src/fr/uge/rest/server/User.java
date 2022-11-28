package fr.uge.rest.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import fr.uge.rest.bike.IBike;
import fr.uge.rest.user.IUser;

public class User extends UnicastRemoteObject implements IUser {
	private long id;
	private String name;
	private IBike bike;
	private IBike bikeToAdd;

	public User() throws RemoteException {
		super();
	}
	
	public User(long id, String name) throws RemoteException {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public void setId(long id) throws RemoteException {
		this.id = id;
	}

	@Override
	public long getId() throws RemoteException {
		return this.id;
	}

	@Override
	public void setName(String name) throws RemoteException {
		this.name = name;
	}

	@Override
	public String getName() throws RemoteException {
		return this.name;
	}

	@Override
	public void setBike(IBike bike) throws RemoteException {
		this.bike = bike;
	}

	@Override
	public IBike getBike() throws RemoteException {
		return this.bike;
	}

	@Override
	public void setBikeToAdd(IBike bike) throws RemoteException {
		this.bikeToAdd = bike;
	}

	@Override
	public IBike getBikeToAdd() throws RemoteException {
		return this.bikeToAdd;
	}
}