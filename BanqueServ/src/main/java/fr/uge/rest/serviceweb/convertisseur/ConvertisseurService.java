/**
 * ConvertisseurService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.uge.rest.serviceweb.convertisseur;

public interface ConvertisseurService extends javax.xml.rpc.Service {
    public java.lang.String getConvertisseurAddress();

    public fr.uge.rest.serviceweb.convertisseur.Convertisseur getConvertisseur() throws javax.xml.rpc.ServiceException;

    public fr.uge.rest.serviceweb.convertisseur.Convertisseur getConvertisseur(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
