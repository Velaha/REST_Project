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
	private final Object lock = new Object();

	public UserService() throws RemoteException {
		super();
		synchronized (lock) {
			users = new HashMap<>();
		}
	}

	@Override
	public boolean addUser(long id, String name) throws RemoteException {
		synchronized (lock) {
			return users.put(id, new User(id, name)) != null;
		}
	}

	@Override
	public void removeUser(long id) throws RemoteException {
		synchronized (lock) {
			users.remove(id);
		}
	}

	@Override
	public void replaceUser(long id, IUser user) throws RemoteException {
		synchronized (lock) {
			users.replace(id, (User) user);
		}
	}

	@Override
	public long getLastId() throws RemoteException {
		var value = users.keySet().stream().max(Long::compare);
		return value.isPresent() ? value.get() + 1 : 0;
	}

	@Override
	public IUser getUser(long id) throws RemoteException {
		return users.get(id);
	}

	@Override
	public List<IUser> getAllUsers() throws RemoteException {
		return new ArrayList<>(users.values());
	}

}
