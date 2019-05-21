package fakultet;
import java.util.GregorianCalendar;

public class Prijava {

	private int sifraPrijave;
	private GregorianCalendar datumPolaganja =  new GregorianCalendar();
	private int ocena;
	private Predmet prijavaPredmet = new Predmet();
	private Student prijavaStudent = new Student();
	private int prijavaPredmetSifra;
	private String prijavaStudentBrojIndeksa;

	
	
	
	
	//GETERI I SETERI
	public int getSifraPrijave() {
		return sifraPrijave;
	}
	public void setSifraPrijave(int sifraPrijave) {
		this.sifraPrijave = sifraPrijave;
	}
	public GregorianCalendar getDatumPolaganja() {
		return datumPolaganja;
	}
	public void setDatumPolaganja(GregorianCalendar datumPolaganja) {
		this.datumPolaganja = datumPolaganja;
	}
	public int getOcena() {
		return ocena;
	}
	public void setOcena(int ocena) throws Exception {
		if (ocena>4 && ocena <11) {
			this.ocena = ocena;
		}else throw new Exception("Ocena mora biti u opsegu 5-10");
	}
	public Predmet getPrijavaPredmet() {
		return prijavaPredmet;
	}
	public void setPrijavaPredmet(Predmet prijavaPredmet) {
		this.prijavaPredmet = prijavaPredmet;
	}
	public Student getPrijavaStudent() {
		return prijavaStudent;
	}
	public void setPrijavaStudent(Student prijavaStudent) {
		
			this.prijavaStudent = prijavaStudent;
		
	}
	public int getPrijavaPredmetSifra() {
		return prijavaPredmetSifra;
	}
	public void setPrijavaPredmetSifra(int prijavaPredmet) throws Exception {
			this.prijavaPredmetSifra = prijavaPredmet;
	}
	public String getPrijavaStudentSifra() {
		return prijavaStudentBrojIndeksa;
	}
	public void setPrijavaStudentSifra(String prijavaStudent) {
		this.prijavaStudentBrojIndeksa = prijavaStudent;
	}
	
	
	
}
