package fr.uge.rest.gbs;

import fr.uge.rest.bike.IBike;
import fr.uge.rest.bike.IBikeService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Application {
    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
        var bike = (IBikeService) Naming.lookup("rmi://localhost:1099/BikeService");
        GustaveBikeService gbs = new GustaveBikeService();
    }
}
