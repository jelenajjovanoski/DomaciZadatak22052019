package main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import fakultet.Prijava;
import nizovi.Podaci;

public class MainMenu {

	public void generisiMeni(int kapacitetPredmeti, int kapacitetStudenti) {
		Podaci.inicijalizujNizove(kapacitetPredmeti, kapacitetStudenti);
		try {
			Podaci.napuniNizPredmeti();
			Podaci.napuniNizStudenti();
		} catch (Exception e1) {System.out.println("Greska pri punjenju niza: " + e1.getMessage());}
		
		int izbor;

		
		do {
			System.out.println("--------------------------------------------------------------------------------------------------------------");
			System.out.println("************************************************* GLAVNI MENI ************************************************");
			System.out.println("--------------------------------------------------------------------------------------------------------------");
			System.out.println("1. Pregled");
			System.out.println("2. Unos  nove prijave");
			System.out.println("3. Izmena");
			System.out.println("4. Kraj");
			System.out.println("--------------------------------------------------------------------------------------------------------------");
			System.out.println("Vas izbor: ");
			Scanner scanner = new Scanner(System.in);
			izbor = scanner.nextInt();
			
			switch(izbor) {
			case 1:
				int izborUnutarOpcije2;
				
				do {
					System.out.println();
					System.out.println("**************************************************************************************************************");
					System.out.println("************************************************* PREGLEDI ***************************************************");
					System.out.println("**************************************************************************************************************");
					System.out.println("U okviru sistema dozvoljene su sledece vrste pregleda: ");
					System.out.println("--------------------------------------------------------------------------------------------------------------");
					System.out.println("1. Pregled svih predmeta");
					System.out.println("2. Pregled svih studenata");
					System.out.println("3. Pregled svih prijava trazenog studenta");
					System.out.println("4. Prikaz svih studenata koji su polozili odredjeni predmet");
					System.out.println("5. Povratak u glavni meni");
					System.out.println("-------------------------------------------------------------------------------------------------------------");
					System.out.println("Vas izbor: ");
					Scanner scanner2 = new Scanner(System.in);
					izborUnutarOpcije2 = scanner2.nextInt();
					
					switch(izborUnutarOpcije2) {
					case 1: 
						System.out.println();
						System.out.println("**************************************************************************************************************");
						System.out.println("**************************************** PREGLED SVIH PREDMETA ***********************************************");
						System.out.println("**************************************************************************************************************");
						Podaci.opcija_1a_PregledSvihPredmeta();
						System.out.println("______________________________________________________________________________________________________________");
						System.out.println();
						break;
						
					case 2:
						System.out.println();
						System.out.println("**************************************************************************************************************");
						System.out.println("********************************************* PREGLED SVIH STUDENATA *****************************************");
						System.out.println("**************************************************************************************************************");
						Podaci.opcija_1b_PregledSvihStudenata();
						System.out.println("______________________________________________________________________________________________________________");
						System.out.println();
						break;
						
					case 3:
						System.out.println();
						System.out.println("**************************************************************************************************************");
						System.out.println("******************************* PREGLED SVIH PRIJAVA ZA TRAZENOG STUDENTA ************************************");
						System.out.println("**************************************************************************************************************");
						System.out.println("--------------------------------------------------------------------------------------------------------------");
						int brojac1 = 0;
						if (Podaci.prijavePostoje()) {
							do {
								try {
									scanner2.nextLine();
									System.out.println("Unesite broj indeksa (u formatu bbbb/yy; b-broj, /-kosa crta, y-godina): ");
									String brojIndeksa = scanner2.nextLine();
									Podaci.opcija_1c_PregledPrijava(brojIndeksa);
									System.out.println("______________________________________________________________________________________________________________");
									System.out.println();								
									break;
								}   catch (Exception e1) {
									System.out.println("---------------------------------------------------------------------------------------------------------------");
									System.out.println("Greska: " + e1.getMessage());
									System.out.println("---------------------------------------------------------------------------------------------------------------");}
									brojac1++;
									System.out.println("Iskoristili ste " + brojac1 + ". pokusaj od ukupno tri! ");
									System.out.println("Ukoliko niste iskoristili sva tri pokusaja, pritisnite JOS JEDNOM ENTER za ponovni unos.");
							} while (brojac1<3);		
						}break;
					case 4:
						System.out.println();
						System.out.println("**************************************************************************************************************");
						System.out.println("************************* PRIKAZ SVIH STUDENATA KOJI SU POLOZILI ODREDJENI PREDMET ***************************");
						System.out.println("**************************************************************************************************************");
						System.out.println("--------------------------------------------------------------------------------------------------------------");
						int brojac = 0;
						if (Podaci.prijavePostoje()) {
							do {
								try {
									scanner.nextLine();
									System.out.println("Unesite sifru predmeta za koji zelite prikaz (u formatu bbbb):");
									int sifraPredmeta = scanner2.nextInt();
									Podaci.opcija_1d_PregledSvihStudenataKojiSuPoloziliTrazeniPredmet(sifraPredmeta);
									System.out.println(
											"______________________________________________________________________________________________________________");
									System.out.println();
							
									break;
								}   catch(InputMismatchException ime){
									System.out.println("===============================================================================================================");
									System.out.println("Greska: Potrebno je uneti broj, bez specijalnih znakova!");
									System.out.println("===============================================================================================================");
									brojac++;
									System.out.println("Iskoristili ste " + brojac + ". pokusaj od ukupno tri!");
									System.out.println("Ukoliko niste iskoristili sva tri pokusaja, pritisnite JOS JEDNOM ENTER za ponovni unos.");
								}
								    catch (Exception e) {
									System.out.println("==============================================================================================================");
									System.out.println("Greska: " + e.getMessage());
									System.out.println("==============================================================================================================");		
									brojac++;
									System.out.println("Iskoristili ste " + brojac + ". pokusaj od ukupno tri! ");
									System.out.println("Ukoliko niste iskoristili sva tri pokusaja, pritisnite JOS JEDNOM ENTER za ponovni unos.");
								    } 
							} while (brojac<3);}
							break;
						
					case 5:	break;
					default: System.err.println("Niste uneli odgovarajucu opciju!"); break;
					}
					
					
				}while(izborUnutarOpcije2!=5); break; // NE ZNAM DA LI TREBA
				
			case 2: 
				System.out.println("______________________________________________________________________________________________________________");
				System.out.println("**************************************************************************************************************");
				System.out.println("********************************************** UNOS NOVE PRIJAVE *********************************************");
				System.out.println("**************************************************************************************************************");
				int brojac2 = 0;
				do {
					try {
						System.out.println(
								"--------------------------------------------------------------------------------------------------------------");
						System.out.println("Unesite podatke potrebne da bi prijava bila uspesno uneta: ");
						System.out.println("--------------------------------------------------------------------------------------------------------------");
						scanner.nextLine();
						System.out.println("Unesite sifru predmeta u formatu bbbb (b-broj): ");
						int sifraPredmeta = scanner.nextInt();
						System.out.println("Unesite broj indeksa u formatu bbbb/yy (b-broj, /- kosa crta, y - godina): ");
						scanner.nextLine();
						String brojIndeksa = scanner.nextLine();
						System.out.println("Unesite ocenu koju je student dobio na ispitu: ");
						int ocena = scanner.nextInt();
						System.out.println("Unesite datum polaganja u formatu yyyy-mm-dd: ");
						scanner.nextLine();
						String datumPolaganja = scanner.nextLine();
						System.out.println("--------------------------------------------------------------------------------------------------------------");
						Podaci.opcija_2_unosPrijaveUSistem(sifraPredmeta, brojIndeksa, datumPolaganja, ocena);
						System.out.println("______________________________________________________________________________________________________________");
						System.out.println();
						break;
					}   catch(InputMismatchException ime){
						System.out.println("===============================================================================================================");
						System.out.println("Greska: Potrebno je uneti broj, bez specijalnih znakova!");
						System.out.println("===============================================================================================================");
						brojac2++;
						System.out.println("Iskoristili ste " + brojac2 + ". pokusaj od ukupno tri! ");
						System.out.println("Ukoliko niste iskoristili sva tri pokusaja, pritisnite JOS JEDNOM ENTER za ponovni unos.");
					}
					    catch (Exception e) {
						System.out.println("==============================================================================================================");
						System.err.println("Greska: " + e.getMessage());
						System.out.println("==============================================================================================================");
						brojac2++;
						System.out.println("Iskoristili ste " + brojac2 + ". pokusaj od ukupno tri! ");
						System.out.println("Ukoliko niste iskoristili sva tri pokusaja, pritisnite JOS JEDNOM ENTER za ponovni unos.");
					} 
				} while (brojac2<3); break;
				
				
			
			case 3: 
				int izborUnutarOpcije3;
				
				do {
					System.out.println("______________________________________________________________________________________________________________");
					System.out.println("**************************************************************************************************************");
					System.out.println("*********************************************** IZMENA *******************************************************");
					System.out.println("**************************************************************************************************************");
					System.out.println("U okviru sistema dozvoljena je sledeca vrsta izmene: ");
					System.out.println("--------------------------------------------------------------------------------------------------------------");
					System.out.println("1. Izmena podataka o studentu");
					System.out.println("2. Povratak u glavni meni");
					System.out.println("--------------------------------------------------------------------------------------------------------------");
					System.out.println("Vas izbor: ");
					Scanner scanner2 = new Scanner(System.in);
					izborUnutarOpcije3 = scanner2.nextInt();
					
					switch(izborUnutarOpcije3) {
					case 1: 

						System.out.println();
						System.out.println("**************************************************************************************************************");
						System.out.println("*************************************** IZMENA PODATAKA O STUDENTU *******************************************");
						System.out.println("**************************************************************************************************************");
						int brojac3 = 0;
						
						do {
							try {
								
								System.out.println("--------------------------------------------------------------------------------------------------------------");
								System.out.println("Unesite broj indeksa studenta ciju izmenu zelite da izvrsite (zahtevani format broja indeksa >>>> bbbb/yy): ");
								scanner2.nextLine();
								String brojIndeksa = scanner2.nextLine();
								System.out.println("Unesite novi broj indeksa studenta ili ponovo unesite stari: ");
								String noviBrojIndeksa = scanner2.nextLine();
								System.out.println("Unesite izmenjenu godinu upisa, ili ponovo unesite staru (zahtevani format yyyy >>> primer: 2011): ");
								int godinaUpisa = scanner2.nextInt();
								System.out.println("Unesite novo ime studenta, ili ponovo unesite staro: ");
								scanner2.nextLine();
								String ime = scanner2.nextLine();
								System.out.println("Unesite novo prezime studenta, ili ponovo unesite staro: ");
								String prezime = scanner2.nextLine();
								System.out.println("Unesite novi datum rodjenja u formatu yyyy-mm-dd, ili ponovo unesite stari: ");
								String datumRodjenja = scanner2.nextLine();
								Podaci.opcija_3a_izmeniPodatkeOStudentu(brojIndeksa, noviBrojIndeksa, godinaUpisa, ime,prezime, datumRodjenja);
								System.out.println("Uspesno ste izmenili podatke!");
								break;
								
							} catch (InputMismatchException ime) {
								System.out.println("===============================================================================================================");
								System.out.println("Greska: Potrebno je uneti broj, bez specijalnih znakova!");
								System.out.println("===============================================================================================================");
								brojac3++;
								System.out.println("Iskoristili ste " + brojac3 + ". pokusaj od ukupno tri! ");
								System.out.println("Ukoliko niste iskoristili sva tri pokusaja, pritisnite JOS JEDNOM ENTER za ponovni unos.");
							} catch (Exception e) {
								System.out.println("==============================================================================================================");
								System.out.println("Greska: " + e.getMessage());
								System.out.println("==============================================================================================================");
								brojac3++;
								System.out.println("Iskoristili ste " + brojac3 + ". pokusaj od ukupno tri! ");
								System.out.println("Ukoliko niste iskoristili sva tri pokusaja, pritisnite JOS JEDNOM ENTER za ponovni unos.");
							} 
						} while (brojac3<3); break;
						
					case 2: break;
					default: System.err.println("Niste uneli odgovarajucu opciju!"); break;
					}}while(izborUnutarOpcije3!=2);break;
				
			case 4: 
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("**************************************************************************************************************");
				System.out.println("************************************************** KRAJ PROGRAMA *********************************************");
				System.out.println("**************************************************************************************************************");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				break;
				
				
			default:	
				System.out.println("Niste uneli odgovarajucu opciju!");
				break;
	
				
			}}while(izbor!=4);
		
		
	}

}
