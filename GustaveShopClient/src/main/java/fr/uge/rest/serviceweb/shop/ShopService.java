/**
 * ShopService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.uge.rest.serviceweb.shop;

public interface ShopService extends javax.xml.rpc.Service {
    public java.lang.String getShopAddress();

    public fr.uge.rest.serviceweb.shop.Shop getShop() throws javax.xml.rpc.ServiceException;

    public fr.uge.rest.serviceweb.shop.Shop getShop(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
