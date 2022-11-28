package fr.uge.rest.user;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IUserService extends Remote {
	public boolean addUser(long id, String name) throws RemoteException;
	public void removeUser(long id) throws RemoteException;
	public List<IUser> getAllUsers() throws RemoteException;
}
