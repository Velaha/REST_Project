/**
 * Banque.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.uge.rest.serviceweb.banque;

public interface Banque extends java.rmi.Remote {
    public void add(long userId, double funds) throws java.rmi.RemoteException;
    public void remove(long userId) throws java.rmi.RemoteException;
    public boolean isEnough(long userId, double price, java.lang.String isoMoney) throws java.rmi.RemoteException;
    public void boughtBike(long userId, double price, java.lang.String isoMoney) throws java.rmi.RemoteException;
    public double checkFundsInAnotherIso(long userId, java.lang.String isoMoney) throws java.rmi.RemoteException;
}
