package fr.uge.rest.serviceweb.shop;

public class ShopProxy implements fr.uge.rest.serviceweb.shop.Shop {
  private String _endpoint = null;
  private fr.uge.rest.serviceweb.shop.Shop shop = null;
  
  public ShopProxy() {
    _initShopProxy();
  }
  
  public ShopProxy(String endpoint) {
    _endpoint = endpoint;
    _initShopProxy();
  }
  
  private void _initShopProxy() {
    try {
      shop = (new fr.uge.rest.serviceweb.shop.ShopServiceLocator()).getShop();
      if (shop != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)shop)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)shop)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (shop != null)
      ((javax.xml.rpc.Stub)shop)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public fr.uge.rest.serviceweb.shop.Shop getShop() {
    if (shop == null)
      _initShopProxy();
    return shop;
  }
  
  public boolean isAvailable(long id) throws java.rmi.RemoteException{
    if (shop == null)
      _initShopProxy();
    return shop.isAvailable(id);
  }
  
  public boolean setPriceFromId(long id, int price) throws java.rmi.RemoteException{
    if (shop == null)
      _initShopProxy();
    return shop.setPriceFromId(id, price);
  }
  
  public int[] getNotes(long id) throws java.rmi.RemoteException{
    if (shop == null)
      _initShopProxy();
    return shop.getNotes(id);
  }
  
  public long sellBike(long id) throws java.rmi.RemoteException{
    if (shop == null)
      _initShopProxy();
    return shop.sellBike(id);
  }
  
  public java.lang.String[] getComments(long id) throws java.rmi.RemoteException{
    if (shop == null)
      _initShopProxy();
    return shop.getComments(id);
  }
  
  
}