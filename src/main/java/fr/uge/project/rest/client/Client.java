package fr.uge.project.rest.client;

import fr.uge.project.rest.common.BikeService;
import fr.uge.project.rest.server.Bike;

import static fr.uge.project.rest.server.Bike.Etat.EN_SERVICE;

public class Client {
    public static void main(String[] args) {
        try {
            BikeService service = (BikeService) java.rmi.Naming.lookup("rmi://localhost:1099/EBCService");
            service.addBike(new Bike("Bike1", EN_SERVICE));
        } catch (Exception e) {
            System.out.println("Trouble: " + e);
        }
    }
}
