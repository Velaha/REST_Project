/**
 * Shop.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.uge.rest.serviceweb.shop;

public interface Shop extends java.rmi.Remote {
    public java.lang.String[] getComments(long id) throws java.rmi.RemoteException;
    public boolean sellBike(long bikeId, long userId, java.lang.String isoMoney) throws java.rmi.RemoteException;
    public boolean idExist(long id) throws java.rmi.RemoteException;
    public int[] getNotes(long id) throws java.rmi.RemoteException;
    public void addBasket(long bikeId) throws java.rmi.RemoteException;
    public void removeBasket(long bikeId) throws java.rmi.RemoteException;
    public void buyBasket(long userId, java.lang.String isoMoney) throws java.rmi.RemoteException;
    public boolean canSell(long bikeId, long userId, java.lang.String isoMoney) throws java.rmi.RemoteException;
    public boolean setPriceFromId(long id, double price) throws java.rmi.RemoteException;
}
