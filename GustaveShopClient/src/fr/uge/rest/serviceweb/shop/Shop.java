/**
 * Shop.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.uge.rest.serviceweb.shop;

public interface Shop extends java.rmi.Remote {
    public boolean isAvailable(long id) throws java.rmi.RemoteException;
    public java.lang.String[] getComments(long id) throws java.rmi.RemoteException;
    public boolean setPriceFromId(long id, int price) throws java.rmi.RemoteException;
    public int[] getNotes(long id) throws java.rmi.RemoteException;
    public long sellBike(long id) throws java.rmi.RemoteException;
}
