package fr.uge.rest.server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class BikeServer {
	public static void main(String[] args) {
		try {
			System.setProperty("java.security.policy/", "sec.policy");
			
			LocateRegistry.createRegistry(1099);
			fr.uge.rest.bike.IBikeService bikeService = new BikeService();
			Naming.rebind("rmi://localhost:1099/BikeService", bikeService);
		} catch (Exception e) {
			System.out.println("Trouble: " + e);
		}
	}
}
