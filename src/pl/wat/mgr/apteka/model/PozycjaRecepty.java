package pl.wat.mgr.apteka.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "POZYCJA_RECEPTY")
public class PozycjaRecepty implements Serializable {
	private static final long serialVersionUID = -6043411039439895708L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ManyToOne
	@JoinColumn(name = "recepta_id")
	private Recepta recepta;
	
	private String nazwa;
	
	private String dawka;
    
	private String dawka_jednostka;
    
	private String czestosc;
    
	private String ilosc;
    
	private String ilosc_jednostka;

	private String fImie;
	
	private String fNazwisko;
	
	private String fIdent;
	
	private Date data_realizacji;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public String getDawka() {
		return dawka;
	}

	public void setDawka(String dawka) {
		this.dawka = dawka;
	}

	public String getDawka_jednostka() {
		return dawka_jednostka;
	}

	public void setDawka_jednostka(String dawka_jednostka) {
		this.dawka_jednostka = dawka_jednostka;
	}

	public String getCzestosc() {
		return czestosc;
	}

	public void setCzestosc(String czestosc) {
		this.czestosc = czestosc;
	}

	public String getIlosc() {
		return ilosc;
	}

	public void setIlosc(String ilosc) {
		this.ilosc = ilosc;
	}

	public String getIlosc_jednostka() {
		return ilosc_jednostka;
	}

	public void setIlosc_jednostka(String ilosc_jednostka) {
		this.ilosc_jednostka = ilosc_jednostka;
	}
	
	public String getfImie() {
		return fImie;
	}

	public void setfImie(String fImie) {
		this.fImie = fImie;
	}

	public String getfNazwisko() {
		return fNazwisko;
	}

	public void setfNazwisko(String fNazwisko) {
		this.fNazwisko = fNazwisko;
	}

	public String getfIdent() {
		return fIdent;
	}

	public void setfIdent(String fIdent) {
		this.fIdent = fIdent;
	}

	public Date getData_realizacji() {
		return data_realizacji;
	}

	public void setData_realizacji(Date data_realizacji) {
		this.data_realizacji = data_realizacji;
	}

	public Recepta getRecepta() {
		return recepta;
	}

	public void setRecepta(Recepta recepta) {
		this.recepta = recepta;
	}
	
	public String getOpakowanie() {
		return dawka + " " + dawka_jednostka;
	}
	
	public String getZazywanie() {
		return ilosc + " x " + czestosc + " " + ilosc_jednostka; 
	}
  
	public String getRealizator() {
		if(getZrealizowane())
			return fImie + " " + fNazwisko + " (" + fIdent + ") - " + new SimpleDateFormat("dd-MM-yyyy").format(data_realizacji);
		
		return "not processed";
	}
	
	public boolean getZrealizowane() {
		if(data_realizacji != null)
			return true;
		
		return false;
	}
}
