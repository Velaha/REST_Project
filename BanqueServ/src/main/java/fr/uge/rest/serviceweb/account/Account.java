package fr.uge.rest.serviceweb.account;

public class Account {
	private long userId;
	private double funds;
	
	public Account() {
		
	}
	
	public Account(long userId, double funds) {
		this.userId = userId;
		this.funds = funds;
	}
	
	public double getFunds() {
		return funds;
	}
	
	public long getUserId() {
		return userId;
	}
	
	public void setFunds(double funds) {
		this.funds = funds;
	}
	
	public void setUserId(long userId) {
		this.userId = userId;
	}
}
