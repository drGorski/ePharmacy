package pl.wat.mgr.apteka.view.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;

import pl.wat.mgr.apteka.assembler.ReceptaAssembler;
import pl.wat.mgr.apteka.fascade.NfzFascade;
import pl.wat.mgr.apteka.model.Recepta;

@ManagedBean
@SessionScoped
public class RealizacjaReceptyBean implements Serializable {
	private static final long serialVersionUID = -6047570248152338298L;
	
	private String pesel;
	private List<Recepta> recepty;
	
	private Recepta rSelected;
	
	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}
	
	public List<Recepta> getRecepty() {
		if(recepty == null)
			recepty = new ArrayList<Recepta>();
		
		return recepty;
	}

	public void setRecepty(List<Recepta> recepty) {
		this.recepty = recepty;
	}
	
	public Recepta getrSelected() {
		return rSelected;
	}

	public void setrSelected(Recepta rSelected) {
		this.rSelected = rSelected;
	}

	public void setValue(AjaxBehaviorEvent abe) {
		
	}
	
	public void wyszukaj(AjaxBehaviorEvent abe) {
		if(recepty == null)
			recepty = new ArrayList<Recepta>();
		else
			recepty.clear();
		
		String receptyXml = NfzFascade.pobierzRecepty(pesel);
		recepty = ReceptaAssembler.resolveRecepty(receptyXml);
	}
	
}
