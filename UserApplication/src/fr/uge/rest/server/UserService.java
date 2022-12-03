package fr.uge.rest.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import fr.uge.rest.bike.IBike;
import fr.uge.rest.user.IUser;
import fr.uge.rest.user.IUserService;

public class UserService extends UnicastRemoteObject implements IUserService {
	private HashMap<Long, User> users;
	private final HashMap<Long, ArrayList<IUser>> waitingLine; 

	public UserService() throws RemoteException {
		super();
		users = new HashMap<>();
		waitingLine = new HashMap<>();
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
	public void replaceUser(long id, IUser user) throws RemoteException {
		users.replace(id, (User) user);
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
	
	@Override
	public void putInWaitingLine(long id, IUser user) throws RemoteException {
		waitingLine.merge(Long.valueOf(id), 
				new ArrayList<>(List.of(user)), 
				(u1, u2) -> new ArrayList<>(Stream.concat(u1.stream(), u2.stream()).toList()));

	}
	
	@Override
	public IUser takeFirstUserFromWaitingLine(long id) throws RemoteException {
		return waitingLine.get(id).remove(0);
	}

	@Override
	public boolean isUserWaiting(long id, IUser user) throws RemoteException {
		return waitingLine.get(id).contains(user);
	}
}
