/**
 * WSProviderImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pl.wat.mgr.nfz.services;

public interface WSProviderImpl extends java.rmi.Remote {
    public java.lang.String pobierzKolejnyNumerRecepty(java.lang.String npwzLekarza, java.lang.String identSwiadczeniodawcy) throws java.rmi.RemoteException;
    public java.lang.String zapiszRealizacjeRecepty(java.lang.String receptaXml) throws java.rmi.RemoteException;
    public boolean getStatusPozycjiRecepty(java.lang.String numer, java.lang.String nazwa) throws java.rmi.RemoteException;
    public boolean walidujRecepte(java.lang.String receptaXml) throws java.rmi.RemoteException;
    public java.lang.String pobierzRecepty(java.lang.String pesel) throws java.rmi.RemoteException;
    public java.lang.String zapiszRecepte(java.lang.String receptaXml) throws java.rmi.RemoteException;
}
