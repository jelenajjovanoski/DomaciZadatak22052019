package fakultet;

public class Predmet {

	private int sifraPredmeta;
	private String nazivPredmeta;
	
	//REDEFINISANI TO STRING
	@Override
	public String toString() {
		return String.format("%-10d%-20s", sifraPredmeta,nazivPredmeta);
	}
	
	
	
	
	//GETERI I SETERI
	public int getSifraPredmeta() {
		return sifraPredmeta;
	}
	public void setSifraPredmeta(int sifraPredmeta) {
			this.sifraPredmeta = sifraPredmeta;
	}
	public String getNazivPredmeta() {
		return nazivPredmeta;
	}
	public void setNazivPredmeta(String nazivPredmeta) {
		this.nazivPredmeta = nazivPredmeta;
	}
	
	
	
}
