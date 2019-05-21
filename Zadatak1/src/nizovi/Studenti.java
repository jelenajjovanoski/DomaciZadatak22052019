package nizovi;

import java.util.GregorianCalendar;

import fakultet.Datumi;
import fakultet.Predmet;
import fakultet.Student;

public class Studenti {

	private Student [] studenti;
	
	//PARAMETRIZOVANI KONSTRUKTOR
	public Studenti(int kapacitet) {
		studenti = new Student[kapacitet];
		for (int i = 0; i < studenti.length; i++) {
			if (studenti[i] == null) {
				studenti[i]= new Student();
			}}
	}
	
	//1. METODA UNESI STUDENTA
	public void unesiStudenta(String brojIndeksa, int godinaUpisa, String ime, String prezime, String datumRodjenja) throws Exception {

		if (!daLiStudentPostojiUSistemu(brojIndeksa)) {
			GregorianCalendar datum = Datumi.vratiDatum(datumRodjenja);
			for (int i = 0; i < studenti.length; i++) {

				if (studenti[i].getBrojIndeksa() == null) {
					studenti[i].setBrojIndeksa(brojIndeksa);
					studenti[i].setGodinaUpisa(godinaUpisa);
					studenti[i].setImeStudenta(ime);
					studenti[i].setPrezimeStudenta(prezime);
					studenti[i].setDatumRodjenja(datum);
					break;
				}
			} 
		}else throw new Exception("U sistemu vec postoji student sa indeksom broj: " + brojIndeksa);
	}
	
	//2. METODA PREGLED SVIH STUDENATA
	public void pregledSvihStudenata() {
		System.out.println("Registrovani su sledeci studenti u sistemu:");
		System.out.println("--------------------------------------------------------------------------------------------------------------");
		System.out.println(String.format("%-4s%-16s%-23s%-20s%-15s", "#","Broj indeksa","Ime i prezime","Datum rodjenja","Godina upisa"));
		System.out.println("--------------------------------------------------------------------------------------------------------------");
		for (int i = 0; i < studenti.length; i++) {
			if (studenti[i]!=null) {
				System.out.println((i + 1) + ".  " + studenti[i]);
			}else {System.out.println((i+1) + ". student nije registrovan u sistemu!");}
		}
	}
	
	//3. METODA IZMENA PODATAKA O STUDENTU
	public void izmenaPodatakaOStudentu(String brojIndeksa, String noviBrojIndeksa, int godinaUpisa, String ime, String prezime, String datumRodjenja) throws Exception {
		if (daLiStudentPostojiUSistemu(brojIndeksa)) {
			GregorianCalendar datum = Datumi.vratiDatum(datumRodjenja);
			for (Student student : studenti) {
				if (student.getBrojIndeksa().equals(brojIndeksa)) {
					if (!daLiStudentPostojiUSistemu(noviBrojIndeksa) || brojIndeksa.equals(noviBrojIndeksa)) {
						student.setBrojIndeksa(noviBrojIndeksa);
					}else throw new Exception("Pokusali ste da dodelite broj indeksa koji je vec dodeljen drugom studentu!");
					student.setGodinaUpisa(godinaUpisa);
					student.setImeStudenta(ime);
					student.setPrezimeStudenta(prezime);
					student.setDatumRodjenja(datum);
				}}
		}else {System.out.println("Trazeni student ne postoji u sistemu!");}
	}

	
	//POMOCNE METODE:
	
	//A)
	public boolean daLiStudentPostojiUSistemu(String brojIndeksa) throws Exception {
		
		if (daLiJeUnetBrojIndeksaAdekvatno(brojIndeksa)) {
			for (Student student : studenti) {
				if (student.getBrojIndeksa()!=null && student.getBrojIndeksa().equals(brojIndeksa)) return true; }
			return false;
		}return false;
	}
	
	//B)
	public Student getStudent(String brojIndeksa) throws Exception {
		for (Student student : studenti) {
			if (daLiStudentPostojiUSistemu(brojIndeksa) && student.getBrojIndeksa().equals(brojIndeksa)) {
				return student;
			}
		}return new Student();
	}
	
	//C)
	public boolean daLiJeUnetBrojIndeksaAdekvatno(String brojIndeksa) throws Exception {
		boolean kosaCrta = brojIndeksa.contains("/");
		if (kosaCrta) {
			String godina = brojIndeksa.substring(brojIndeksa.indexOf("/")+1);
			int duzinaStringaGodina = godina.length();
			if ((kosaCrta) && (duzinaStringaGodina==2)) {
				return true;
			}else {throw new Exception("Broj indeksa nije adekvatno unet! Neophodno je da se zavrsava sa /yy >>> primer: /11");}
		}else {throw new Exception("Niste stavili kosu crtu izmedju broja i godine upisa!");}
	}
	
	
}
