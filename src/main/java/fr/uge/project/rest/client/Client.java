package fr.uge.project.rest.client;

import fr.uge.project.rest.common.IEBCService;

import java.rmi.Naming;

public class Client {
    public static void main(String[] args) {
        try {
            IEBCService service = (IEBCService) Naming.lookup("rmi://localhost/EBCService");
            service.addBike(1L, "Des problèmes pour pédaler", "endommagé");
            service.getAllBike().forEach(System.out::println);

            service.removeBike(1);
            service.getAllBike().forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Trouble: " + e);
        }
    }
}
