/**
 * Convertisseur.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.uge.rest.serviceweb.convertisseur;

public interface Convertisseur extends java.rmi.Remote {
    public double convertToEuro(java.lang.String isoMoney, double amount) throws java.rmi.RemoteException;
    public double convertEuroTo(java.lang.String isoToConvert, double amount) throws java.rmi.RemoteException;
}
