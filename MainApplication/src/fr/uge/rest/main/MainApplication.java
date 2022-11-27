package fr.uge.rest.main;

import java.rmi.Naming;
import java.rmi.RemoteException;

import fr.uge.rest.bike.IBikeService;
import fr.uge.rest.user.IUserService;

public class MainApplication {
	public static void main(String[] args) {
		try {			
			//BIKE
			IBikeService bikeService = (IBikeService) Naming.lookup("rmi://localhost:1099/BikeService");
			bikeService.addBike(1, "neuf");
			bikeService.getAllBikes().forEach(b -> {
				try {
					System.out.println("id: " + b.getId());
					System.out.println("etat: " + b.getEtat());
					System.out.println("note: " + b.getAvgNote());
					System.out.println("comments: " + b.getComments());
					System.out.println("timesRented: " + b.getTimesRented());
					System.out.println("price: " + b.getPrice());
				} catch (RemoteException e) {
					throw new RuntimeException(e);
				}
			});
			
			//USER
			IUserService userService = (IUserService) Naming.lookup("rmi://localhost:1098/UserService");
			userService.addUser(1, "Althea");
			userService.getAllUsers().forEach(u -> {
				try {
					System.out.println("id: " + u.getId());
					System.out.println("name: " + u.getName());
					u.setBike(bikeService.getAllBikes().get(0));
					System.out.println("bike: " + u.getBike().getEtat());
				} catch (RemoteException e) {
					throw new RuntimeException(e);
				}
			});
			
		} catch (Exception e) {
			System.out.println("Trouble: " + e);
		}
	}
}
