package fr.uge.project.rest.server.users;

import fr.uge.project.rest.common.IUserService;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class UserServer {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1089);
            IUserService userService = new UserService();
            Naming.rebind("rmi://localhost:1089/UserService", userService);
        } catch (Exception e) {
            System.out.println("Trouble: " + e);
        }
    }
}
