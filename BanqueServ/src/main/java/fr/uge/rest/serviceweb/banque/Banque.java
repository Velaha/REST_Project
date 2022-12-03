package fr.uge.rest.serviceweb.banque;

import java.util.ArrayList;

import fr.uge.rest.serviceweb.account.Account;

public class Banque {
	
	private static ArrayList<Account> accounts = new ArrayList<>();
	
	public Banque() {
	}
	
	public void add(long userId, double funds) {
	    accounts.add(new Account(userId, funds));
	}
	
	public void remove(long userId) {
	    for (Account account : accounts) {
	    	if (account.getUserId() == userId) {
	    		accounts.remove(account);
	    	}
	    } 
	    throw new IllegalArgumentException("User not found");
	}
	
	public boolean isEnough(long userId, double price) {
	    for (Account account : accounts) {
	        if (account.getUserId() == userId) {
	            return account.getFunds() >= price;
	        }
	    }
	    throw new IllegalArgumentException("User not found");
	}
	
	public void boughtBike(long userId, double price) {
	    for (Account account : accounts) {
	        if (account.getUserId() == userId) {
	            account.setFunds(account.getFunds() - price);
	            return;
	        }
	    }
	    throw new IllegalArgumentException("User not found");
	}
}
