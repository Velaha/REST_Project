package fr.uge.rest.serviceweb.convertisseur;

public class ConvertisseurProxy implements fr.uge.rest.serviceweb.convertisseur.Convertisseur {
  private String _endpoint = null;
  private fr.uge.rest.serviceweb.convertisseur.Convertisseur convertisseur = null;
  
  public ConvertisseurProxy() {
    _initConvertisseurProxy();
  }
  
  public ConvertisseurProxy(String endpoint) {
    _endpoint = endpoint;
    _initConvertisseurProxy();
  }
  
  private void _initConvertisseurProxy() {
    try {
      convertisseur = (new fr.uge.rest.serviceweb.convertisseur.ConvertisseurServiceLocator()).getConvertisseur();
      if (convertisseur != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)convertisseur)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)convertisseur)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (convertisseur != null)
      ((javax.xml.rpc.Stub)convertisseur)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public fr.uge.rest.serviceweb.convertisseur.Convertisseur getConvertisseur() {
    if (convertisseur == null)
      _initConvertisseurProxy();
    return convertisseur;
  }
  
  public double convertToEuro(java.lang.String isoMoney, double amount) throws java.rmi.RemoteException{
    if (convertisseur == null)
      _initConvertisseurProxy();
    return convertisseur.convertToEuro(isoMoney, amount);
  }
  
  public double convertEuroTo(java.lang.String isoToConvert, double amount) throws java.rmi.RemoteException{
    if (convertisseur == null)
      _initConvertisseurProxy();
    return convertisseur.convertEuroTo(isoToConvert, amount);
  }
  
  
}