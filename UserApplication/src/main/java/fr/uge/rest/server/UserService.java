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
	private Object lock = new Object();

	public UserService() throws RemoteException {
		super();
		users = new HashMap<>();
	}

	@Override
	public boolean addUser(long id, String name) throws RemoteException {
		synchronized (lock) {
			if (users.containsKey(id)) {
				return false;
			}
			users.put(id, new User(id, name));
			return true;
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
		return value.map(aLong -> aLong + 1).orElse(0L);
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
