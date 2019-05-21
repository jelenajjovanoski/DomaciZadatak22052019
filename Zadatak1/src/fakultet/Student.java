package fakultet;
import java.util.GregorianCalendar;

import nizovi.Podaci;

public class Student {

	private String brojIndeksa;
	private int godinaUpisa;
	private String imeStudenta;
	private String prezimeStudenta;
	private GregorianCalendar datumRodjenja;
	
	@Override
	public String toString() {
		return String.format("%-16s%-10s%-13s%-20s%-15d", brojIndeksa, imeStudenta, prezimeStudenta, Datumi.vratiDatumUString(datumRodjenja), godinaUpisa);
	}
	
	
	
	
	//GETERI I SETERI
	public String getBrojIndeksa() {
		return brojIndeksa;
	}
	public void setBrojIndeksa(String brojIndeksa) throws Exception {
			if (Podaci.brojIndeksaJeUnetAdekvatno(brojIndeksa)) {
				this.brojIndeksa = brojIndeksa;
			}
	}
	public int getGodinaUpisa() {
		return godinaUpisa;
	}
	public void setGodinaUpisa(int godinaUpisa) throws Exception {
		boolean daLiJeBroj = true;
		int length = String.valueOf(godinaUpisa).length();
		if (length==4) {
			this.godinaUpisa = godinaUpisa;
		}else throw new Exception("Godinu je potrebno uneti u formatu: yyyy >>> primer 2011");
	}
	public String getImeStudenta() {
		return imeStudenta;
	}
	public void setImeStudenta(String imeStudenta) throws Exception {
		if (imeStudenta!=null && imeStudenta.length()>0) {
			this.imeStudenta = imeStudenta;
		}else throw new Exception("Ime ne sme biti null!");
	}
	public String getPrezimeStudenta() {
		return prezimeStudenta;
	}
	public void setPrezimeStudenta(String prezimeStudenta) throws Exception {
		if (prezimeStudenta!=null && prezimeStudenta.length()>1) {
			this.prezimeStudenta = prezimeStudenta;
		}else throw new Exception("Prezime ne sme biti null!");
	}
	public GregorianCalendar getDatumRodjenja() {
		return datumRodjenja;
	}
	public void setDatumRodjenja(GregorianCalendar datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}
	
	
	
	
	
	
	
}
