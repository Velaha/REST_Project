package fr.uge.rest.serviceweb.shop;

import java.rmi.Naming;

import fr.uge.rest.bike.Bike;
import fr.uge.rest.bike.IBike;
import fr.uge.rest.bike.IBikeService;

public class Shop {
	public Shop() {
		
	}
	
	public boolean isAvailable(long id) {
		try {
			IBikeService bike = (IBikeService) Naming.lookup("rmi://localhost:1099/BikeService");
			return bike.doesExists(id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public boolean setPriceFromId(long id, double price) {
		if (isAvailable(id)) {
			try {
				IBikeService bike = (IBikeService) Naming.lookup("rmi://localhost:1099/BikeService");
				IBike bikeRentedAtleastOnce = bike.getBike(id);
				if (bikeRentedAtleastOnce.getTimesRented() > 0) {
					bikeRentedAtleastOnce.setPrice(price);
					return true;
				}
				return false;
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		} else {
			throw new IllegalArgumentException("Id doesn't exist");
		}
	}

	
	public String[] getComments(long id) {
		if (isAvailable(id)) {
			try {
				IBikeService bike = (IBikeService) Naming.lookup("rmi://localhost:1099/BikeService");
				return (String[]) bike.getBike(id).getComments().toArray();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		} else {
			throw new IllegalArgumentException("Id doesn't exist");
		}
	}
	
	public Integer[] getNotes(long id) {
		if (isAvailable(id)) {
			try {
				IBikeService bike = (IBikeService) Naming.lookup("rmi://localhost:1099/BikeService");
				return (Integer[]) bike.getBike(id).getNotes().toArray();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		} else {
			throw new IllegalArgumentException("Id doesn't exist");
		}
	}
	
	public double sellBike(long id) {
		if (isAvailable(id)) {
			try {
				IBikeService bike = (IBikeService) Naming.lookup("rmi://localhost:1099/BikeService");
				IBike soldBike = bike.getBike(id);
				bike.getSaleableBike().remove(soldBike);
				return soldBike.getPrice();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		} else {
			throw new IllegalArgumentException("Id doesn't exist");
		}
	}
}
