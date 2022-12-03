package fr.uge.rest.serviceweb.banque;

public class BanqueProxy implements fr.uge.rest.serviceweb.banque.Banque {
  private String _endpoint = null;
  private fr.uge.rest.serviceweb.banque.Banque banque = null;
  
  public BanqueProxy() {
    _initBanqueProxy();
  }
  
  public BanqueProxy(String endpoint) {
    _endpoint = endpoint;
    _initBanqueProxy();
  }
  
  private void _initBanqueProxy() {
    try {
      banque = (new fr.uge.rest.serviceweb.banque.BanqueServiceLocator()).getBanque();
      if (banque != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)banque)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)banque)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (banque != null)
      ((javax.xml.rpc.Stub)banque)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public fr.uge.rest.serviceweb.banque.Banque getBanque() {
    if (banque == null)
      _initBanqueProxy();
    return banque;
  }
  
  public void add(long userId, double funds) throws java.rmi.RemoteException{
    if (banque == null)
      _initBanqueProxy();
    banque.add(userId, funds);
  }
  
  public void remove(long userId) throws java.rmi.RemoteException{
    if (banque == null)
      _initBanqueProxy();
    banque.remove(userId);
  }
  
  public void boughtBike(long userId, double price) throws java.rmi.RemoteException{
    if (banque == null)
      _initBanqueProxy();
    banque.boughtBike(userId, price);
  }
  
  public boolean isEnough(long userId, double price) throws java.rmi.RemoteException{
    if (banque == null)
      _initBanqueProxy();
    return banque.isEnough(userId, price);
  }
  
  
}