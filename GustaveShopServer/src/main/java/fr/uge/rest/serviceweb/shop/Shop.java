package fr.uge.rest.serviceweb.shop;

import java.rmi.Naming;

import fr.uge.rest.bike.IBike;
import fr.uge.rest.bike.IBikeService;
import fr.uge.rest.serviceweb.banque.Banque;
import fr.uge.rest.serviceweb.banque.BanqueServiceLocator;

public class Shop {
	public Shop() {
		
	}
	
	public boolean idExist(long id) {
		try {
			IBikeService bike = (IBikeService) Naming.lookup("rmi://localhost:1099/BikeService");
			return bike.doesExists(id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public boolean setPriceFromId(long id, double price) {
		if (idExist(id)) {
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
		if (idExist(id)) {
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
		if (idExist(id)) {
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
	
	public boolean sellBike(long bikeId, long userId, String isoMoney) {
		if (idExist(bikeId)) {
			try {
				IBikeService bike = (IBikeService) Naming.lookup("rmi://localhost:1099/BikeService");
				IBike soldBike = bike.getBike(bikeId);
				if (soldBike.getAvailable()) {
					Banque banque = new BanqueServiceLocator().getBanque();
					banque.boughtBike(userId, soldBike.getPrice(), isoMoney);
					bike.getSaleableBike().remove(soldBike);
					return true;
				} 
					throw new IllegalArgumentException("Bike is not available");				
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		} else {
			throw new IllegalArgumentException("Id doesn't exist");
		}
	}
	
	public boolean canSell(long bikeId, long userId, String isoMoney) {
		if (idExist(bikeId)) {
			try {
				IBikeService bike = (IBikeService) Naming.lookup("rmi://localhost:1099/BikeService");
				IBike soldBike = bike.getBike(bikeId);
				if (soldBike.getAvailable()) {
					Banque banque = new BanqueServiceLocator().getBanque();
					return banque.isEnough(userId, soldBike.getPrice(), isoMoney);				 
				} 
					throw new IllegalArgumentException("Bike is not available");				
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		} else {
			throw new IllegalArgumentException("Id doesn't exist");
		}
	}
}
