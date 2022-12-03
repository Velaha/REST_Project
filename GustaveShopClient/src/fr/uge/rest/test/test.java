package fr.uge.rest.test;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import fr.uge.rest.serviceweb.banque.Banque;
import fr.uge.rest.serviceweb.banque.BanqueServiceLocator;
import fr.uge.rest.serviceweb.shop.Shop;
import fr.uge.rest.serviceweb.shop.ShopServiceLocator;

public class test {
	public static void main(String[] args) throws ServiceException, RemoteException {
		Banque bank = new BanqueServiceLocator().getBanque();
		bank.add(800, 90.50);
		bank.add(700, 190.50);
		
		Shop shop = new ShopServiceLocator().getShop();
		System.out.println(shop.testCanSell(800, 10));
	}
	
}
