package fr.uge.rest.server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import fr.uge.rest.user.IUserService;

public class UserServer {

	//@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		try {
			
			//System.setProperty("java.security.policy","./sec.policy");
			//System.setSecurityManager(new RMISecurityManager());
			
			LocateRegistry.createRegistry(1098);
			IUserService userService = new UserService();
			Naming.rebind("rmi://localhost:1098/UserService", userService);			
		} catch (Exception e) {
			System.out.println("Trouble: " + e);
		}		
	}
}
