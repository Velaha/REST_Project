package fr.uge.project.rest.server;

import fr.uge.project.rest.common.IEBCService;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class EBCServer {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            IEBCService ebcService = new EBCService();
            Naming.rebind("rmi://localhost:1099/EBCService", ebcService);
        } catch (Exception e) {
            System.out.println("Trouble: " + e);
        }
    }
}
