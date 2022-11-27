package fr.uge.rest.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import fr.uge.rest.user.IUser;
import fr.uge.rest.user.IUserService;

public class UserService extends UnicastRemoteObject implements IUserService {
	private HashMap<Long, User> users;

	public UserService() throws RemoteException {
		super();
		users = new HashMap<>();
	}

	@Override
	public boolean addUser(long id, String name) throws RemoteException {
		return users.put(id, new User(id, name)) != null;
	}

	@Override
	public void removeUser(long id) throws RemoteException {
		users.remove(id);
	}

	@Override
	public List<IUser> getAllUsers() throws RemoteException {
		return new ArrayList<>(users.values());
	}
}
