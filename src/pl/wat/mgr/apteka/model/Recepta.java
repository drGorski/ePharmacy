package pl.wat.mgr.apteka.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table
@Entity(name = "RECEPTA")
public class Recepta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy="recepta", fetch=FetchType.EAGER)
	private List<PozycjaRecepty> specyfikacja;
	
	private String numer;
    
	private String sNazwa;
    
	private String sUlica;
    
	private String sNrDomu;
    
	private String sNrLokalu;
    
	private String sKodPocztowy;
    
	private String sPoczta;
    
	private String sMiejscowosc;
    
	private String sTelefon;
    
	private String sIdent;
    
	private String oddzialNfz;
    
    private String uprawnienia;
    
    private boolean chorobyPrzewlekle;
    
    private String pImie;
    
    private String pNazwisko;
    
    private String pUlica;
    
    private String pNrDomu;
    
    private String pNrLokalu;
    
    private String pKodPocztowy;
    
    private String pPoczta;
    
    private String pMiejscowosc;
    
    private String pPesel;
    
    private String pPoswiadczenie;
    
    private Date data;
    
    private Date dataRealizacajiOd;
    
    private String lImie;
    
    private String lNazwisko;
    
    private String lNrPrawa;

    private String odplatnosc;
    
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumer() {
		return numer;
	}

	public void setNumer(String numer) {
		this.numer = numer;
	}

	public String getsNazwa() {
		return sNazwa;
	}

	public void setsNazwa(String sNazwa) {
		this.sNazwa = sNazwa;
	}

	public String getsUlica() {
		return sUlica;
	}

	public void setsUlica(String sUlica) {
		this.sUlica = sUlica;
	}

	public String getsNrDomu() {
		return sNrDomu;
	}

	public void setsNrDomu(String sNrDomu) {
		this.sNrDomu = sNrDomu;
	}

	public String getsNrLokalu() {
		return sNrLokalu;
	}

	public void setsNrLokalu(String sNrLokalu) {
		this.sNrLokalu = sNrLokalu;
	}

	public String getsKodPocztowy() {
		return sKodPocztowy;
	}

	public void setsKodPocztowy(String sKodPocztowy) {
		this.sKodPocztowy = sKodPocztowy;
	}

	public String getsPoczta() {
		return sPoczta;
	}

	public void setsPoczta(String sPoczta) {
		this.sPoczta = sPoczta;
	}

	public String getsMiejscowosc() {
		return sMiejscowosc;
	}

	public void setsMiejscowosc(String sMiejscowosc) {
		this.sMiejscowosc = sMiejscowosc;
	}

	public String getsTelefon() {
		return sTelefon;
	}

	public void setsTelefon(String sTelefon) {
		this.sTelefon = sTelefon;
	}

	public String getsIdent() {
		return sIdent;
	}

	public void setsIdent(String sIdent) {
		this.sIdent = sIdent;
	}

	public String getOddzialNfz() {
		return oddzialNfz;
	}

	public void setOddzialNfz(String oddzialNfz) {
		this.oddzialNfz = oddzialNfz;
	}

	public String getUprawnienia() {
		return uprawnienia;
	}

	public void setUprawnienia(String uprawnienia) {
		this.uprawnienia = uprawnienia;
	}

	public boolean isChorobyPrzewlekle() {
		return chorobyPrzewlekle;
	}

	public void setChorobyPrzewlekle(boolean chorobyPrzewlekle) {
		this.chorobyPrzewlekle = chorobyPrzewlekle;
	}

	public String getpImie() {
		return pImie;
	}

	public void setpImie(String pImie) {
		this.pImie = pImie;
	}

	public String getpNazwisko() {
		return pNazwisko;
	}

	public void setpNazwisko(String pNazwisko) {
		this.pNazwisko = pNazwisko;
	}

	public String getpUlica() {
		return pUlica;
	}

	public void setpUlica(String pUlica) {
		this.pUlica = pUlica;
	}

	public String getpNrDomu() {
		return pNrDomu;
	}

	public void setpNrDomu(String pNrDomu) {
		this.pNrDomu = pNrDomu;
	}

	public String getpNrLokalu() {
		return pNrLokalu;
	}

	public void setpNrLokalu(String pNrLokalu) {
		this.pNrLokalu = pNrLokalu;
	}

	public String getpKodPocztowy() {
		return pKodPocztowy;
	}

	public void setpKodPocztowy(String pKodPocztowy) {
		this.pKodPocztowy = pKodPocztowy;
	}

	public String getpPoczta() {
		return pPoczta;
	}

	public void setpPoczta(String pPoczta) {
		this.pPoczta = pPoczta;
	}

	public String getpMiejscowosc() {
		return pMiejscowosc;
	}

	public void setpMiejscowosc(String pMiejscowosc) {
		this.pMiejscowosc = pMiejscowosc;
	}

	public String getpPesel() {
		return pPesel;
	}

	public void setpPesel(String pPesel) {
		this.pPesel = pPesel;
	}

	public String getpPoswiadczenie() {
		return pPoswiadczenie;
	}

	public void setpPoswiadczenie(String pPoswiadczenie) {
		this.pPoswiadczenie = pPoswiadczenie;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getDataRealizacajiOd() {
		return dataRealizacajiOd;
	}

	public void setDataRealizacajiOd(Date dataRealizacajiOd) {
		this.dataRealizacajiOd = dataRealizacajiOd;
	}

	public String getlImie() {
		return lImie;
	}

	public void setlImie(String lImie) {
		this.lImie = lImie;
	}

	public String getlNazwisko() {
		return lNazwisko;
	}

	public void setlNazwisko(String lNazwisko) {
		this.lNazwisko = lNazwisko;
	}

	public String getlNrPrawa() {
		return lNrPrawa;
	}

	public void setlNrPrawa(String lNrPrawa) {
		this.lNrPrawa = lNrPrawa;
	}
	
	public List<PozycjaRecepty> getSpecyfikacja() {
		return specyfikacja;
	}

	public void setSpecyfikacja(List<PozycjaRecepty> specyfikacja) {
		this.specyfikacja = specyfikacja;
	}
	
	public String getOdplatnosc() {
		return odplatnosc;
	}

	public void setOdplatnosc(String odplatnosc) {
		this.odplatnosc = odplatnosc;
	}
	
	public String getLekarz() {
		return lImie + " " + lNazwisko + " (" + lNrPrawa + ")";
	}
	
	public String getPacjent() {
		return pImie + " " + pNazwisko + " (" + pPesel + ")";
	}
	
	public void addToSpec(PozycjaRecepty pr) {
		if(specyfikacja == null)
			specyfikacja = new ArrayList<PozycjaRecepty>();
		
		specyfikacja.add(pr);
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(obj instanceof Recepta) {
			Recepta r = (Recepta) obj;
			if(r.getNumer().equals(this.numer))
				return true;
			
			return false;
		}
		
		return false;
	}
}
