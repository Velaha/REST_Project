package fr.uge.rest.user;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IUserService extends Remote {
	boolean addUser(long id, String name) throws RemoteException;
	void removeUser(long id) throws RemoteException;
	void replaceUser(long id, IUser user) throws RemoteException;
	long getLastId() throws RemoteException;
	IUser getUser(long id) throws RemoteException;
	List<IUser> getAllUsers() throws RemoteException;
}