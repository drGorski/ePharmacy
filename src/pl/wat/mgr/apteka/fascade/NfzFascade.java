package pl.wat.mgr.apteka.fascade;

import java.rmi.RemoteException;

import pl.wat.mgr.nfz.services.WSProviderImplProxy;

public class NfzFascade {
	
	private static final String ESB = "http://bednarski-hp:9080/SOAPHTTPChannel1/soaphttpengine/SCA.APPLICATION.qcell.Bus/httpservicesnfzmgrwatplWSProviderImplServiceWSProviderImplInboundService/qnode_server1_SOAPHTTPChannel1_InboundPort?wsdl";
	
	public static String pobierzRecepty(String pesel) {
		
		WSProviderImplProxy wspip = new WSProviderImplProxy();
		try {
			return wspip.pobierzRecepty(pesel);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String wyslijRecepteDoNgf(String receptaXml) {
		
		WSProviderImplProxy wspip = new WSProviderImplProxy();
		try {
			return wspip.zapiszRealizacjeRecepty(receptaXml);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
}
