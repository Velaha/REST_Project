package fr.uge.project.rest.client;

import fr.uge.project.rest.common.IRenter;

import java.rmi.Naming;

public class Client {
    public static void main(String[] args) {
        try {
            IRenter service = (IRenter) Naming.lookup("rmi://localhost/EBCService");
            service.addBike(1L,"endommagé");
            service.getAllBike().forEach(System.out::println);

            service.removeBike(1);
            service.getAllBike().forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Trouble: " + e);
        }
    }
}
