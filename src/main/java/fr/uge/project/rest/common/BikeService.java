package fr.uge.project.rest.common;

import fr.uge.project.rest.server.Bike;

import java.rmi.Remote;

public interface BikeService extends Remote {
    void addBike(Bike bike) throws Exception;
    void removeBike(Bike bike) throws Exception;
}
