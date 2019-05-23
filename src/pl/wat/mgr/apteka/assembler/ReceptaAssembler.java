package pl.wat.mgr.apteka.assembler;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import pl.wat.mgr.apteka.model.PozycjaRecepty;
import pl.wat.mgr.apteka.model.Recepta;

public class ReceptaAssembler {
	
	public static List<Recepta> resolveRecepty(String receptaXml) {
		
		List<Recepta> recepty = new ArrayList<Recepta>();
		
        Document doc = null;
        DocumentBuilderFactory dbfac = DocumentBuilderFactory.newInstance();
        try
        {
            DocumentBuilder docBuilder = dbfac.newDocumentBuilder();
            File f = new File("receptaTmp.xml");
            if(!f.exists()) 
                f.createNewFile();
            
            FileWriter fr = new FileWriter(f);
            fr.write(new String(receptaXml.getBytes("ISO-8859-2")));
            fr.flush();
            fr.close();
            doc = docBuilder.parse(f);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        NodeList nl = doc.getElementsByTagName("recepta");
        
        for(int i=0; i<nl.getLength(); i++)
        {
        	Recepta r = new Recepta();
	        Node node = nl.item(0);
	        
	        if(node.getNodeType() == Node.ELEMENT_NODE)
	        {
	            //dane recepty
	            Element el = (Element) node;
	            r.setNumer(el.getElementsByTagName("nr").item(0).getTextContent());
	            r.setOdplatnosc(el.getElementsByTagName("odplatnosc").item(0).getTextContent());
	            r.setOddzialNfz(el.getElementsByTagName("oddzialNfz").item(0).getTextContent());
	            r.setUprawnienia(el.getElementsByTagName("uprawnienia").item(0).getTextContent());
	            boolean chorobyPrzewlekle = true;
	            if(el.getElementsByTagName("chorobyPrzewlekle").item(0).getTextContent().equalsIgnoreCase(""))
	                chorobyPrzewlekle = false;
	            r.setChorobyPrzewlekle(chorobyPrzewlekle);
	            r.setData(new Date(Long.parseLong(el.getElementsByTagName("dataWystawienia").item(0).getTextContent())));
	            r.setDataRealizacajiOd(new Date(Long.parseLong(el.getElementsByTagName("dataRealizacjiOd").item(0).getTextContent())));
	            //dane pacjenta
	            NodeList pacjent = el.getElementsByTagName("pacjent").item(0).getChildNodes();
	            r.setpImie(pacjent.item(1).getTextContent());
	            r.setpNazwisko(pacjent.item(3).getTextContent());
	            r.setpPesel(pacjent.item(7).getTextContent());
	            r.setpPoswiadczenie(pacjent.item(9).getTextContent());
	            Element pacAdres = (Element) pacjent.item(5);
	            r.setpUlica(pacAdres.getElementsByTagName("ulica").item(0).getTextContent());
	            r.setpNrDomu(pacAdres.getElementsByTagName("nrDomu").item(0).getTextContent());  
	            r.setpNrLokalu(pacAdres.getElementsByTagName("nrLokalu").item(0).getTextContent());
	            r.setpKodPocztowy(pacAdres.getElementsByTagName("kodPocztowy").item(0).getTextContent());
	            r.setpMiejscowosc(pacAdres.getElementsByTagName("miejscowosc").item(0).getTextContent());
	            r.setpPoczta(pacAdres.getElementsByTagName("poczta").item(0).getTextContent()); 
	            //dane lekarza
	            NodeList lekarz = el.getElementsByTagName("lekarz").item(0).getChildNodes();
	            r.setlImie(lekarz.item(1).getTextContent());
	            r.setlNazwisko(lekarz.item(3).getTextContent());
	            r.setlNrPrawa(lekarz.item(5).getTextContent());
	            //dane swiadczeniodawcy
	            NodeList swiadczeniodawca = el.getElementsByTagName("swiadczeniodawca").item(0).getChildNodes();
	            r.setsNazwa(swiadczeniodawca.item(1).getTextContent());
	            r.setsTelefon(swiadczeniodawca.item(5).getTextContent());
	            r.setsIdent(swiadczeniodawca.item(7).getTextContent());
	            Element sAdres = (Element) pacjent.item(5);
	            r.setsUlica(sAdres.getElementsByTagName("ulica").item(0).getTextContent());
	            r.setsNrDomu(sAdres.getElementsByTagName("nrDomu").item(0).getTextContent());  
	            r.setsNrLokalu(sAdres.getElementsByTagName("nrLokalu").item(0).getTextContent());
	            r.setsKodPocztowy(sAdres.getElementsByTagName("kodPocztowy").item(0).getTextContent());
	            r.setsMiejscowosc(sAdres.getElementsByTagName("miejscowosc").item(0).getTextContent());
	            r.setsPoczta(sAdres.getElementsByTagName("poczta").item(0).getTextContent());
	           //specyfikacja 
	            NodeList specyfikacja = el.getElementsByTagName("specyfikacja").item(0).getChildNodes();
	            for(int j=0; j<specyfikacja.getLength(); j++)
	            {
	                if(specyfikacja.item(j).getNodeType() == Node.ELEMENT_NODE)
	                {
	                    PozycjaRecepty s = new PozycjaRecepty();
	                    NodeList pozycja = specyfikacja.item(j).getChildNodes();
	                    s.setNazwa(pozycja.item(1).getTextContent());
	                    s.setDawka(pozycja.item(3).getTextContent());
	                    s.setDawka_jednostka(pozycja.item(5).getTextContent());
	                    Element d = (Element) pozycja.item(7);
	                    s.setCzestosc(d.getElementsByTagName("czestosc").item(0).getTextContent());
	                    s.setIlosc(d.getElementsByTagName("ilosc").item(0).getTextContent());
	                    s.setIlosc_jednostka(d.getElementsByTagName("jednostka").item(0).getTextContent());
	                    if(!pozycja.item(9).getTextContent().equalsIgnoreCase(""))
	                        s.setData_realizacji(new Date(Long.parseLong(pozycja.item(9).getTextContent())));
	                    Element res = (Element) pozycja.item(11);
	                    s.setfImie(res.getElementsByTagName("imie").item(0).getTextContent());
	                    s.setfNazwisko(res.getElementsByTagName("nazwisko").item(0).getTextContent());
	                    s.setfIdent(res.getElementsByTagName("ident").item(0).getTextContent());
	                    s.setRecepta(r);
	                    r.addToSpec(s);
	                }
	            }
	            
	            recepty.add(r);
	        }

        }
        
        return recepty;
	}
	
	public static String prepareXmlDocument(Recepta recepta) {
		String receptyXml = "<?xml version=\"1.0\" ?>\n";
		receptyXml += "<recepty>\n";
		receptyXml += buildXmlString(recepta);
	    receptyXml += "</recepty>";
	    return receptyXml;
	}

	private static String buildXmlString(Recepta drb) {
        String recepta = "";
        recepta += "<recepta>\n";
            recepta += "\t<nr>" + drb.getNumer() + "</nr>\n";
            recepta += "\t<odplatnosc>" + drb.getOdplatnosc() + "</odplatnosc>\n";
            recepta += "\t<swiadczeniodawca>\n"; 
                recepta += "\t\t<nazwa>" + drb.getsNazwa() + "</nazwa>\n";
                recepta += "\t\t<adres>\n";
                    recepta += "\t\t\t<ulica>" + drb.getsUlica() + "</ulica>\n";
                    recepta += "\t\t\t<nrDomu>" + drb.getsNrDomu() + "</nrDomu>\n";
                    recepta += "\t\t\t<nrLokalu>" + drb.getsNrLokalu() + "</nrLokalu>\n";
                    recepta += "\t\t\t<kodPocztowy>" + drb.getsKodPocztowy() + "</kodPocztowy>\n";
                    recepta += "\t\t\t<miejscowosc>" + drb.getsMiejscowosc() + "</miejscowosc>\n";
                    recepta += "\t\t\t<poczta>" + drb.getsPoczta() + "</poczta>\n";
                recepta += "\t\t</adres>\n";
                recepta += "\t\t<telefon>" + drb.getsTelefon() + "</telefon>\n";
                recepta += "\t\t<identyfikator>" + drb.getsIdent() + "</identyfikator>\n";
            recepta += "\t</swiadczeniodawca>\n";
            recepta += "\t<oddzialNfz>" + drb.getOddzialNfz() + "</oddzialNfz>\n";
            recepta += "\t<uprawnienia>" + drb.getUprawnienia() + "</uprawnienia>\n";
            recepta += "\t<chorobyPrzewlekle>";
                if(drb.isChorobyPrzewlekle()) 
                    recepta += "X";
            recepta += "</chorobyPrzewlekle>\n";
            recepta += "\t<pacjent>\n";
                recepta += "\t\t<imie>" + drb.getpImie() + "</imie>\n";
                recepta += "\t\t<nazwisko>" + drb.getpNazwisko() + "</nazwisko>\n";
                recepta += "\t\t<adres>\n";
                    recepta += "\t\t\t<ulica>" + drb.getpUlica() + "</ulica>\n";
                    recepta += "\t\t\t<nrDomu>" + drb.getpNrDomu() + "</nrDomu>\n";
                    recepta += "\t\t\t<nrLokalu>" + drb.getpNrLokalu() + "</nrLokalu>\n";
                    recepta += "\t\t\t<kodPocztowy>" + drb.getpKodPocztowy() + "</kodPocztowy>\n";
                    recepta += "\t\t\t<miejscowosc>" + drb.getpMiejscowosc() + "</miejscowosc>\n";
                    recepta += "\t\t\t<poczta>" + drb.getpPoczta() + "</poczta>\n";
                recepta += "\t\t</adres>\n";
                recepta += "\t\t<pesel>" + drb.getpPesel() + "</pesel>\n";
                recepta += "\t\t<nrPoswiadczenia>" + drb.getpPoswiadczenie() + "</nrPoswiadczenia>\n";
            recepta += "\t</pacjent>\n";
            recepta += "\t<dataWystawienia>" + drb.getData().getTime() + "</dataWystawienia>\n";
            recepta += "\t<dataRealizacjiOd>" + drb.getDataRealizacajiOd().getTime() + "</dataRealizacjiOd>\n";
            recepta += "\t<specyfikacja>\n";
                for(PozycjaRecepty s : drb.getSpecyfikacja()) {
                    recepta += "\t\t<pozycja>\n";
                        recepta += "\t\t\t<nazwa>" + s.getNazwa() + "</nazwa>\n";
                        recepta += "\t\t\t<dawka>" + s.getDawka() + "</dawka>\n";
                        recepta += "\t\t\t<jednostka>" + s.getDawka_jednostka() + "</jednostka>\n";
                        recepta += "\t\t\t<dawkowanie>\n";
                            recepta += "\t\t\t\t<czestosc>" + s.getCzestosc() + "</czestosc>\n";
                            recepta += "\t\t\t\t<ilosc>" + s.getIlosc() + "</ilosc>\n";
                            recepta += "\t\t\t\t<jednostka>" + s.getIlosc_jednostka() + "</jednostka>\n";
                        recepta += "\t\t\t</dawkowanie>\n";
                        String date = s.getData_realizacji() != null ? String.valueOf(s.getData_realizacji().getTime()) : "";
                        recepta += "\t\t\t<dataRealizacji>" + date + "</dataRealizacji>\n";
                        recepta += "\t\t\t<ktoRealizowal>\n";
                            recepta += "\t\t\t\t<imie>" + s.getfImie() + "</imie>\n";
                            recepta += "\t\t\t\t<nazwisko>" + s.getfNazwisko() + "</nazwisko>\n";
                            recepta += "\t\t\t\t<ident>" + s.getfIdent() + "</ident>\n";
                        recepta += "\t\t\t</ktoRealizowal>\n";
                    recepta += "\t\t</pozycja>\n";
                }
            recepta += "\t</specyfikacja>\n";
            recepta += "\t<lekarz>\n";
                recepta += "\t\t<imie>" + drb.getlImie() + "</imie>\n";
                recepta += "\t\t<nazwisko>" + drb.getlNazwisko() + "</nazwisko>\n";
                recepta += "\t\t<nrPrawa>" + drb.getlNrPrawa() + "</nrPrawa>\n";
            recepta += "\t</lekarz>\n";
        recepta += "</recepta>\n";
        return recepta;
    }
}
