package nizovi;

import fakultet.Predmet;
import fakultet.Student;

public class Podaci {
	
	private static Predmeti predmetPodaci;
	private static Studenti studentiPodaci;
	private static Prijave prijavePodaci;
	

	public static void inicijalizujNizove(int kapacitetPredmeti, int kapacitetStudenti) {
		predmetPodaci = new Predmeti(kapacitetPredmeti);
		studentiPodaci = new Studenti(kapacitetStudenti);
		prijavePodaci= new Prijave();
	}
	
	
	//METODE VEZANE ZA PREDMETE 

	public static void napuniNizPredmeti() {
		predmetPodaci.unesiPredmet("Matematika 1", 1111);
		predmetPodaci.unesiPredmet("Programiranje 1", 2222);
		predmetPodaci.unesiPredmet("Baze podataka", 3333);
		predmetPodaci.unesiPredmet("Programiranje 2", 4444);
		predmetPodaci.unesiPredmet("Ekonomija", 5555);
	}
	
	public static void opcija_1a_PregledSvihPredmeta() {
		predmetPodaci.pregledSvihPredmeta();
	}
	
	public static boolean predmetPostojiUSistemu(int sifraPredmeta) throws Exception {
		return predmetPodaci.daLiPredmetPostojiUSistemu(sifraPredmeta);
	}
	
	public static Predmet vratiPredmet(int sifraPredmeta) throws Exception {
		return predmetPodaci.getPredmet(sifraPredmeta);
	}
	
	
	// METODE VEZANE ZA STUDENTE
	public static void napuniNizStudenti() throws Exception {
		studentiPodaci.unesiStudenta("274/11",2011,"Jelena","Jovanoski","1992-07-19");
		studentiPodaci.unesiStudenta("80/13", 2013, "Nemanja", "Klisura", "1994-07-27");
		studentiPodaci.unesiStudenta("45/16", 2016, "Marija", "Stojanovic", "1997-08-01");
		studentiPodaci.unesiStudenta("120/12", 2012, "Sanja", "Kos", "1993-12-13");
		studentiPodaci.unesiStudenta("280/11", 2011, "Tamara", "Pavlovic", "1992-07-08");
	}
	
	//PROVERI DA LI JE OVDE BOLJE
	public static void opcija_3a_izmeniPodatkeOStudentu(String brojIndeksa,String noviBrojIndeksa, int godinaUpisa, String ime, String prezime, String datumRodjenja) throws Exception {
		studentiPodaci.izmenaPodatakaOStudentu(brojIndeksa, noviBrojIndeksa, godinaUpisa, ime, prezime, datumRodjenja);
	}
	
	
	public static void opcija_1b_PregledSvihStudenata() {
		studentiPodaci.pregledSvihStudenata();
	}
	
	public static boolean studentPostojiUSistemu(String brojIndeksa) throws Exception {
		return studentiPodaci.daLiStudentPostojiUSistemu(brojIndeksa);
	}
	
	public static Student vratiStudenta(String brojIndeksa) throws Exception {
		return studentiPodaci.getStudent(brojIndeksa);
	}
	
	
	//METODE VEZANE ZA PRIJAVE
	
	public static void opcija_2_unosPrijaveUSistem(int sifraPredmeta, String brojIndeksa, String datumPolaganja, int ocena) throws Exception {
		prijavePodaci.unesiPrijavu(sifraPredmeta, brojIndeksa, datumPolaganja, ocena);
	}
	
	public static void opcija_1c_PregledPrijava(String brojIndeksa) throws Exception {
			if (studentiPodaci.daLiJeUnetBrojIndeksaAdekvatno(brojIndeksa)) {
				prijavePodaci.pregledSvihPrijavaKonkretnogStudenta(brojIndeksa);
			}
	}
	
	public static void opcija_1d_PregledSvihStudenataKojiSuPoloziliTrazeniPredmet(int sifraPredmeta) throws Exception  {
		if (predmetPodaci.daLiJeUnosSifrePredmetaAdekvatan(sifraPredmeta)) {
			prijavePodaci.pregledSvihStudenataKojiSuPoloziliPredmet(sifraPredmeta);
		}
	}
	
	public static boolean prijavePostoje() {
		return prijavePodaci.daLiPostojePrijaveUSistemu();
	}
	
	
	// DODATNE METODE
	public static boolean brojIndeksaJeUnetAdekvatno(String brojIndeksa) throws Exception {
		return studentiPodaci.daLiJeUnetBrojIndeksaAdekvatno(brojIndeksa);
	}
	
	
}
