package fr.uge.project.rest.server.bikes;

import fr.uge.project.rest.common.IRenter;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class BikeServer {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            IRenter bikeService = new BikeService();
            Naming.rebind("rmi://localhost:1099/BikeService", bikeService);
        } catch (Exception e) {
            System.out.println("Trouble: " + e);
        }
    }
}
