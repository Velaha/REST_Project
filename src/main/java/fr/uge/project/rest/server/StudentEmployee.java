package fr.uge.project.rest.server;


import fr.uge.project.rest.common.BikeService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

//Alors pour ca... n'hésitez pas a rename tout, et mieux ranger les dossiers, jsuis trop nul pour ca mdrrr
public class StudentEmployee extends UnicastRemoteObject implements BikeService {

        private final ArrayList<Bike> bikes;

        public StudentEmployee() throws Exception {
            super();
            bikes = new ArrayList<>();
        }

        @Override
        public void addBike(Bike bike) throws RemoteException {
            bikes.add(bike);
        }

        @Override
        public void removeBike(Bike bike) throws RemoteException {
            bikes.remove(bike);
        }
}
