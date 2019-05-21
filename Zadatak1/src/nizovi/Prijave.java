package nizovi;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import fakultet.Datumi;
import fakultet.Prijava;

public class Prijave {

	
	List<Prijava> prijave = new ArrayList<>();
	
	int sifraPrijave = 1;
	int trenutnaPrijava = 0;

	//1. METODA NAPRAVI PRIJAVU
	public Prijava napraviPrijavu(int sifraPredmeta, String brojIndeksa, String datumPolaganja, int ocena) throws Exception {
		
		Prijava prijava = new Prijava();
		
		
		if (Podaci.predmetPostojiUSistemu(sifraPredmeta) && Podaci.studentPostojiUSistemu(brojIndeksa)) {
			prijava.setOcena(ocena);
			prijava.setDatumPolaganja(Datumi.vratiDatum(datumPolaganja));
			prijava.setPrijavaPredmetSifra(sifraPredmeta);
			prijava.setPrijavaStudentSifra(brojIndeksa);
			prijava.setSifraPrijave(sifraPrijave);
			sifraPrijave++;
			System.out.println("Prijava je napravljena, ali jos uvek nije uneta u sistem...LOADING...");
			return prijava;
		} else {
			if (Podaci.predmetPostojiUSistemu(sifraPredmeta))  throw new Exception("Ne postoji student sa unetim brojem indeksa: " + brojIndeksa + ".");
		    else throw new Exception("Ne postoji predmet sa unetom sifrom: " + sifraPredmeta + ".");
		}
		
	}
	
	//2. METODA UNESI PRIJAVU U SISTEM
	public void unesiPrijavu(int sifraPredmeta, String brojIndeksa, String datumPolaganja, int ocena) throws Exception {
		if (prijave.size()==0) {
			prijave.add(napraviPrijavu(sifraPredmeta, brojIndeksa, datumPolaganja, ocena));
			System.out.println("Prijava je uspesno uneta u sistem!");
		}else {
			for (int i = 0; i < prijave.size(); i++) {
				
				//ukoliko je student vec polagao ovaj ispit, ali je sada dobio visu ocenu
				if (studentJeVecPolozioPredmet(sifraPredmeta, brojIndeksa,ocena) && (prijave.get(i).getSifraPrijave()==trenutnaPrijava)&&(prijave.get(i).getOcena()< ocena)) {
					prijave.remove(i);
					prijave.add(i,napraviPrijavu(sifraPredmeta, brojIndeksa, datumPolaganja, ocena) );
					System.out.println("Prijava je uspesno uneta u sistem. Studentu je upisana bolja ocena!");
					break;
				}
				
				// ukoliko student nije polozio prijavljeni ispit
				if (!studentJeVecPolozioPredmet(sifraPredmeta, brojIndeksa,ocena)) {
					prijave.add(napraviPrijavu(sifraPredmeta, brojIndeksa, datumPolaganja, ocena));
					System.out.println("Prijava je uspesno uneta u sistem!");
					break;
				}												
			}	
		}
	}
	
	//3. PREGLED POSTOJECIH PRIJAVA ZA KONKRETNOG STUDENTA
	
	public void pregledSvihPrijavaKonkretnogStudenta(String brojIndeksa) throws Exception {
				System.out.println();
				System.out.println("Pregled svih prijava studenta " +" ciji je broj indeksa: " + brojIndeksa);
				System.out.println("---------------------------------------------------------------------------------------------------------------");
				if (!studentPostojiUSistemuRegistrovanihPrijava(brojIndeksa)) {
					System.out.println("Nije uneta nijedna prijava studenta ciji je broj indeksa: " + brojIndeksa);
				} else {
					System.out.println(String.format("%-3s%-15s%-15s%-20s%-20s%-17s%-10s", "#", "Ime", "Prezime",
							"Sifra predmeta", "Naziv predmeta", "Datum polaganja", "Ocena"));
					System.out.println("---------------------------------------------------------------------------------------------------------------");
					for (int i = 0; i < prijave.size(); i++) {
						if (prijave.get(i).getPrijavaStudentSifra().equals(brojIndeksa)) {
							System.out.println(String.format("%-3d%-15s%-15s%-20d%-20s%-17s%-10d",
									prijave.get(i).getSifraPrijave(),
									Podaci.vratiStudenta(brojIndeksa).getImeStudenta(),
									Podaci.vratiStudenta(brojIndeksa).getPrezimeStudenta(),
									prijave.get(i).getPrijavaPredmetSifra(),
									Podaci.vratiPredmet(prijave.get(i).getPrijavaPredmetSifra()).getNazivPredmeta(),
									Datumi.vratiDatumUString(prijave.get(i).getDatumPolaganja()),
									prijave.get(i).getOcena()));
						}}} 		
	}
	
	// 4. PREGLED SVIH STUDENATA KOJI SU POLOZILI PREDMET
	
	public void pregledSvihStudenataKojiSuPoloziliPredmet(int sifraPredmeta) throws Exception {
			System.out.println();
			System.out.println("PREGLED SVIH PRIJAVA STUDENATA KOJI SU POLOZILI PREDMET CIJA JE SIFRA: " + sifraPredmeta);
			System.out.println("---------------------------------------------------------------------------------------------------------------");
			System.out.println(String.format("%-3s%-16s%-20s%-18s%-18s%-15s%-17s%-10s", "#","Sifra Predmeta","Naziv Predmeta","Datum polaganja","Broj indeksa","Ime", "Prezime", "Ocena"));
			System.out.println("---------------------------------------------------------------------------------------------------------------");
			
			if (Podaci.predmetPostojiUSistemu(sifraPredmeta)) {
				for (int i = 0; i < prijave.size(); i++) {
					
					if ((prijave.get(i).getPrijavaPredmetSifra() == sifraPredmeta) && (prijave.get(i).getOcena() > 5)) {
						System.out.println(String.format("%-3s%-16d%-20s%-18s%-18s%-15s%-17s%-10s",
								prijave.get(i).getSifraPrijave(), prijave.get(i).getPrijavaPredmetSifra(),
								Podaci.vratiPredmet(sifraPredmeta).getNazivPredmeta(),
								Datumi.vratiDatumUString(prijave.get(i).getDatumPolaganja()),
								prijave.get(i).getPrijavaStudentSifra(),
								Podaci.vratiStudenta(prijave.get(i).getPrijavaStudentSifra()).getImeStudenta(),
								Podaci.vratiStudenta(prijave.get(i).getPrijavaStudentSifra()).getPrezimeStudenta(),
								prijave.get(i).getOcena()));
					}}
			} else {
				System.out.println("---------------------------------------------------------------------------------------------------------------");
				System.out.println("Trazeni predmet nije registrovan u sistemu!"); 
				System.out.println("---------------------------------------------------------------------------------------------------------------");}
	}
	
	
	
	//POMOCNE METODE:
	public boolean studentJeVecPolozioPredmet(int sifraPredmeta, String brojIndeksa, int ocena) {
		for (int i = 0; i < prijave.size(); i++) {
			if (prijave.get(i).getPrijavaPredmetSifra() == sifraPredmeta && (prijave.get(i).getPrijavaStudentSifra().equals(brojIndeksa) 
					&& (prijave.get(i).getOcena()>5))) {
				trenutnaPrijava = prijave.get(i).getSifraPrijave();
				return true;}
		}return false;
	}
	
	public boolean studentPostojiUSistemuRegistrovanihPrijava(String brojIndeksa) {
		for (int i = 0; i < prijave.size(); i++) {
			if (prijave.get(i).getPrijavaStudentSifra().equals(brojIndeksa)) return true;
		}return false;
	}
	
	public boolean daLiPostojePrijaveUSistemu() {
		if (prijave.size()>0) {
			return true;
		}else {
			System.out.println();
			System.out.println("---------------------------------------------------------------------------------------------------------------");
			System.out.println("Ne postoji nijedna registrovana prijava u sistemu. Neophodno je prvo uneti prijave!");
			System.out.println("---------------------------------------------------------------------------------------------------------------");
			System.out.println();
			return false;
		}
	}
	
//	public boolean predmetPostojiuSistemuRegistrovanihPrijava(int sifraPredmeta) {
//		for (int i = 0; i < prijave.size(); i++) {
//			if (prijave.get(i).getPrijavaPredmetSifra()==sifraPredmeta) return true;
//		}return false;
//	}
//	
	

}
