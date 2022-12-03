/**
 * ConvertisseurServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.uge.rest.serviceweb.convertisseur;

public class ConvertisseurServiceLocator extends org.apache.axis.client.Service implements fr.uge.rest.serviceweb.convertisseur.ConvertisseurService {

    public ConvertisseurServiceLocator() {
    }


    public ConvertisseurServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ConvertisseurServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Convertisseur
    private java.lang.String Convertisseur_address = "http://localhost:8081/ConvertisseurServer/services/Convertisseur";

    public java.lang.String getConvertisseurAddress() {
        return Convertisseur_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ConvertisseurWSDDServiceName = "Convertisseur";

    public java.lang.String getConvertisseurWSDDServiceName() {
        return ConvertisseurWSDDServiceName;
    }

    public void setConvertisseurWSDDServiceName(java.lang.String name) {
        ConvertisseurWSDDServiceName = name;
    }

    public fr.uge.rest.serviceweb.convertisseur.Convertisseur getConvertisseur() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Convertisseur_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getConvertisseur(endpoint);
    }

    public fr.uge.rest.serviceweb.convertisseur.Convertisseur getConvertisseur(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            fr.uge.rest.serviceweb.convertisseur.ConvertisseurSoapBindingStub _stub = new fr.uge.rest.serviceweb.convertisseur.ConvertisseurSoapBindingStub(portAddress, this);
            _stub.setPortName(getConvertisseurWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setConvertisseurEndpointAddress(java.lang.String address) {
        Convertisseur_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (fr.uge.rest.serviceweb.convertisseur.Convertisseur.class.isAssignableFrom(serviceEndpointInterface)) {
                fr.uge.rest.serviceweb.convertisseur.ConvertisseurSoapBindingStub _stub = new fr.uge.rest.serviceweb.convertisseur.ConvertisseurSoapBindingStub(new java.net.URL(Convertisseur_address), this);
                _stub.setPortName(getConvertisseurWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("Convertisseur".equals(inputPortName)) {
            return getConvertisseur();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://convertisseur.serviceweb.rest.uge.fr", "ConvertisseurService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://convertisseur.serviceweb.rest.uge.fr", "Convertisseur"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Convertisseur".equals(portName)) {
            setConvertisseurEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
