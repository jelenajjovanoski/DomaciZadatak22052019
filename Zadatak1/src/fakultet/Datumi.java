package fakultet;

import java.util.GregorianCalendar;

public class Datumi {

	public static GregorianCalendar vratiDatum(String datum) throws Exception {
		if (datum.length()==10) {
			int godina = Integer.parseInt(datum.substring(0, 4));
			int mesec = Integer.parseInt(datum.substring(datum.indexOf('-') + 1, datum.indexOf('-') + 3)) - 1;
			int dan = Integer.parseInt(datum.substring((datum.lastIndexOf('-') + 1)));
			GregorianCalendar datumFinalni = new GregorianCalendar();
			datumFinalni.set(godina, mesec, dan);
			return datumFinalni;
		}else {throw new Exception("Datum nije adekvatno unet. Potrebno je ispostovati format yyyy-mm-dd >>> primer: 2019-02-10)");}
	}
	
	public static String vratiDatumUString(GregorianCalendar datum) {
		int godina = datum.get(GregorianCalendar.YEAR);
		int mesec = datum.get(GregorianCalendar.MONTH) + 1;
		int dan = datum.get(GregorianCalendar.DAY_OF_MONTH);
		
		return godina +"-"+ mesec + "-" + dan;
		
	}
}
