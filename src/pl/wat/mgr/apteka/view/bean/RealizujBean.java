package pl.wat.mgr.apteka.view.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import pl.wat.mgr.apteka.assembler.ReceptaAssembler;
import pl.wat.mgr.apteka.fascade.NfzFascade;
import pl.wat.mgr.apteka.fascade.ReceptaFascade;
import pl.wat.mgr.apteka.model.PozycjaRecepty;

@ManagedBean
@RequestScoped
public class RealizujBean {

	@ManagedProperty(value="#{realizacjaReceptyBean}")
	private RealizacjaReceptyBean rrb;

	public RealizacjaReceptyBean getRrb() {
		return rrb;
	}

	public void setRrb(RealizacjaReceptyBean rrb) {
		this.rrb = rrb;
	}
	
	public void setSpecyfikacja(List<PozycjaRecepty> specyfikacja) {
		rrb.getrSelected().setSpecyfikacja(specyfikacja);
	}
	
	public List<PozycjaRecepty> getSpecyfikacja() {
		return rrb.getrSelected().getSpecyfikacja();
	}
	
	public String zapisz() {
		
		String receptaXml = ReceptaAssembler.prepareXmlDocument(rrb.getrSelected());
		String result = NfzFascade.wyslijRecepteDoNgf(receptaXml);
		if(result == null || "-1".equals(result)) {
			czysc();
			return "index";
		}
	
		ReceptaFascade rf = new ReceptaFascade();
		if(rf.czyIstnieje(rrb.getrSelected())) {
			rrb.setrSelected(rf.uzupelnijId(rrb.getrSelected()));
			rf.aktualizuj(rrb.getrSelected());
		} else {
			rf.zapisz(rrb.getrSelected());
		}
	
		czysc();
		return "index";
	}
	
	private void czysc() {
		rrb.setPesel(null);
		rrb.setRecepty(null);
		rrb.setrSelected(null);
	}
}
