/**
 * WSProviderImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pl.wat.mgr.nfz.services;

public class WSProviderImplServiceLocator extends org.apache.axis.client.Service implements pl.wat.mgr.nfz.services.WSProviderImplService {

    public WSProviderImplServiceLocator() {
    }


    public WSProviderImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public WSProviderImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for WSProviderImpl
    private java.lang.String WSProviderImpl_address = "http://localhost:8080/mgr_nfz/services/WSProviderImpl";

    public java.lang.String getWSProviderImplAddress() {
        return WSProviderImpl_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WSProviderImplWSDDServiceName = "WSProviderImpl";

    public java.lang.String getWSProviderImplWSDDServiceName() {
        return WSProviderImplWSDDServiceName;
    }

    public void setWSProviderImplWSDDServiceName(java.lang.String name) {
        WSProviderImplWSDDServiceName = name;
    }

    public pl.wat.mgr.nfz.services.WSProviderImpl getWSProviderImpl() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WSProviderImpl_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWSProviderImpl(endpoint);
    }

    public pl.wat.mgr.nfz.services.WSProviderImpl getWSProviderImpl(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            pl.wat.mgr.nfz.services.WSProviderImplSoapBindingStub _stub = new pl.wat.mgr.nfz.services.WSProviderImplSoapBindingStub(portAddress, this);
            _stub.setPortName(getWSProviderImplWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setWSProviderImplEndpointAddress(java.lang.String address) {
        WSProviderImpl_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (pl.wat.mgr.nfz.services.WSProviderImpl.class.isAssignableFrom(serviceEndpointInterface)) {
                pl.wat.mgr.nfz.services.WSProviderImplSoapBindingStub _stub = new pl.wat.mgr.nfz.services.WSProviderImplSoapBindingStub(new java.net.URL(WSProviderImpl_address), this);
                _stub.setPortName(getWSProviderImplWSDDServiceName());
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
        if ("WSProviderImpl".equals(inputPortName)) {
            return getWSProviderImpl();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://services.nfz.mgr.wat.pl", "WSProviderImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://services.nfz.mgr.wat.pl", "WSProviderImpl"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("WSProviderImpl".equals(portName)) {
            setWSProviderImplEndpointAddress(address);
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
