package fr.uge.rest.serviceweb.banque;

import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.xml.rpc.ServiceException;

import fr.uge.rest.serviceweb.account.Account;
import fr.uge.rest.serviceweb.convertisseur.Convertisseur;
import fr.uge.rest.serviceweb.convertisseur.ConvertisseurServiceLocator;

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
	
	public boolean isEnough(long userId, double price, String isoMoney) {
	    for (Account account : accounts) {
	        if (account.getUserId() == userId) {
	        	try {
					Convertisseur convert = new ConvertisseurServiceLocator().getConvertisseur();
					price = convert.convertToEuro(isoMoney, price);
					return account.getFunds() >= price;
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
	        }
	    }
	    throw new IllegalArgumentException("User not found");
	}
	
	
	public void boughtBike(long userId, double price, String isoMoney) {
	    for (Account account : accounts) {
	        if (account.getUserId() == userId) {
	        	try {
	        		Convertisseur convert = new ConvertisseurServiceLocator().getConvertisseur();
					price = convert.convertToEuro(isoMoney, price);
					account.setFunds(account.getFunds() - price);
		            return;
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
	        }
	    }
	    throw new IllegalArgumentException("User not found");
	}
	
	
	public double checkFundsInAnotherIso(long userId, String isoMoney) {
		for (Account account : accounts) {
			if (account.getUserId() == userId) {
				try {
					Convertisseur convert = new ConvertisseurServiceLocator().getConvertisseur();
					return convert.convertEuroTo(isoMoney, account.getFunds());
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		}
		throw new IllegalArgumentException("User not found");
	}
}
