package fr.uge.project.rest.server.users;

import fr.uge.project.rest.common.IUser;
import fr.uge.project.rest.common.IUserService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserService extends UnicastRemoteObject implements IUserService {

    private final HashMap<Long, User> users;

    public UserService() throws RemoteException {
        super();
        users = new HashMap<>();
    }

    @Override
    public void addUser(long id, String name) throws RemoteException {
        this.users.put(id, new User(id, name));
    }

    @Override
    public void removeUser(long id) throws RemoteException {
        this.users.remove(id);
    }

    @Override
    public List<IUser> getAll() throws RemoteException  {
        return new ArrayList<>(users.values());
    }
}
