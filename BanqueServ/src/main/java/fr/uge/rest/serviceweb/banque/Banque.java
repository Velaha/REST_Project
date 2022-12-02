package fr.uge.rest.serviceweb.banque;

public class Banque {
	
	private final long id;
	private double funds;
	
	public Banque(long userId, double funds) {
		this.id = userId;
		this.funds = funds;
	}
	
	public boolean isEnough(double price) {
		return funds > price;
	}
	
	public void boughtBike(double price) {
		this.funds -= price;
	}

}
