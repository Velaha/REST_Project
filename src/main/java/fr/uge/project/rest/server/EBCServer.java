package fr.uge.project.rest.server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class EBCServer {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            EBC ebc = new EBC();
            Naming.rebind("rmi://localhost:1099/EBCService", ebc);
        } catch (Exception e) {
            System.out.println("Trouble: " + e);
        }
    }
}
