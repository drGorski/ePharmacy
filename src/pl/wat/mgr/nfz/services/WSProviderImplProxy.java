package pl.wat.mgr.nfz.services;

public class WSProviderImplProxy implements pl.wat.mgr.nfz.services.WSProviderImpl {
  private String _endpoint = null;
  private pl.wat.mgr.nfz.services.WSProviderImpl wSProviderImpl = null;
  
  public WSProviderImplProxy() {
    _initWSProviderImplProxy();
  }
  
  public WSProviderImplProxy(String endpoint) {
    _endpoint = endpoint;
    _initWSProviderImplProxy();
  }
  
  private void _initWSProviderImplProxy() {
    try {
      wSProviderImpl = (new pl.wat.mgr.nfz.services.WSProviderImplServiceLocator()).getWSProviderImpl();
      if (wSProviderImpl != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)wSProviderImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)wSProviderImpl)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (wSProviderImpl != null)
      ((javax.xml.rpc.Stub)wSProviderImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public pl.wat.mgr.nfz.services.WSProviderImpl getWSProviderImpl() {
    if (wSProviderImpl == null)
      _initWSProviderImplProxy();
    return wSProviderImpl;
  }
  
  public java.lang.String pobierzKolejnyNumerRecepty(java.lang.String npwzLekarza, java.lang.String identSwiadczeniodawcy) throws java.rmi.RemoteException{
    if (wSProviderImpl == null)
      _initWSProviderImplProxy();
    return wSProviderImpl.pobierzKolejnyNumerRecepty(npwzLekarza, identSwiadczeniodawcy);
  }
  
  public java.lang.String zapiszRealizacjeRecepty(java.lang.String receptaXml) throws java.rmi.RemoteException{
    if (wSProviderImpl == null)
      _initWSProviderImplProxy();
    return wSProviderImpl.zapiszRealizacjeRecepty(receptaXml);
  }
  
  public boolean getStatusPozycjiRecepty(java.lang.String numer, java.lang.String nazwa) throws java.rmi.RemoteException{
    if (wSProviderImpl == null)
      _initWSProviderImplProxy();
    return wSProviderImpl.getStatusPozycjiRecepty(numer, nazwa);
  }
  
  public boolean walidujRecepte(java.lang.String receptaXml) throws java.rmi.RemoteException{
    if (wSProviderImpl == null)
      _initWSProviderImplProxy();
    return wSProviderImpl.walidujRecepte(receptaXml);
  }
  
  public java.lang.String pobierzRecepty(java.lang.String pesel) throws java.rmi.RemoteException{
    if (wSProviderImpl == null)
      _initWSProviderImplProxy();
    return wSProviderImpl.pobierzRecepty(pesel);
  }
  
  public java.lang.String zapiszRecepte(java.lang.String receptaXml) throws java.rmi.RemoteException{
    if (wSProviderImpl == null)
      _initWSProviderImplProxy();
    return wSProviderImpl.zapiszRecepte(receptaXml);
  }
  
  
}