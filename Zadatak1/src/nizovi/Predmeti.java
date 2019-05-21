package nizovi;
import fakultet.Predmet;

public class Predmeti {

	private Predmet [] predmeti;
	
	public Predmeti(int kapacitet) {
		predmeti = new Predmet[kapacitet];
		for (int i = 0; i < predmeti.length; i++) {
			if (predmeti[i] == null) {
				predmeti[i]= new Predmet();
			}
		}
	}
	
	public void unesiPredmet(String nazivPredmeta, int sifraPredmeta) {
		for (int i = 0; i < predmeti.length; i++) {
			if (predmeti[i].getSifraPredmeta()== 0) {
				predmeti[i].setNazivPredmeta(nazivPredmeta);
				predmeti[i].setSifraPredmeta(sifraPredmeta);
				break;
			}
		}

	}
	
	public void pregledSvihPredmeta() {
		System.out.println("Registrovani su sledeci predmeti u sistemu:");
		System.out.println("--------------------------------------------------------------------------------------------------------------");
		System.out.println(String.format("%-3s%-10s%-20s", "#","Sifra","Naziv predmeta"));
		System.out.println("--------------------------------------------------------------------------------------------------------------");
		for (int i = 0; i < predmeti.length; i++) {
			if (predmeti[i]!=null) {
				System.out.println((i + 1) + ".  " + predmeti[i]);
			}else {System.out.println((i+1)+". predmet nije registrovan u sistemu!");}
		}
		
	}
	
	public boolean daLiPredmetPostojiUSistemu(int sifraPredmeta) throws Exception {
		
		if (daLiJeUnosSifrePredmetaAdekvatan(sifraPredmeta)) {
			for (int i = 0; i < predmeti.length; i++) {
				if (predmeti[i].getSifraPredmeta() == sifraPredmeta) return true;	
			}return false;
		}return false;
		
		
	}
	
	public Predmet getPredmet(int sifraPredmeta) throws Exception {
		for (Predmet predmet : predmeti) {
			if (daLiPredmetPostojiUSistemu(sifraPredmeta) && predmet.getSifraPredmeta() == sifraPredmeta) {	
				return predmet;
			}
		}return new Predmet();		
	}
	
	public boolean daLiJeUnosSifrePredmetaAdekvatan(int sifraPredmeta) throws Exception {
				boolean daLiJeBroj = true;
				int length = String.valueOf(sifraPredmeta).length();
					if (length == 4) {
						return true;
					} else throw new Exception("Duzina sifre predmeta mora da se sastoji od 4 broja!");					
		}
		
	}

	
	

	
	
	
	
	
	

