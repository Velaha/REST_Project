package fr.uge.project.rest.client;

import fr.uge.project.rest.common.IEBCService;
import static fr.uge.project.rest.common.Etat.EN_SERVICE;

import java.rmi.Naming;

public class Client {
    public static void main(String[] args) {
        try {
            IEBCService service = (IEBCService) Naming.lookup("rmi://localhost/EBCService");
            service.addBike(1L, "Bike1", EN_SERVICE);
            service.getAllBike().forEach(System.out::println);

            service.removeBike(1);
            service.getAllBike().forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Trouble: " + e);
        }
    }
}
