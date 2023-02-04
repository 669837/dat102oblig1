package no.hvl.dat102.klient;

import java.util.Scanner;

import no.hvl.dat102.Film;
import no.hvl.dat102.Filmarkiv;
import no.hvl.dat102.Sjanger;
import no.hvl.dat102.adt.FilmarkivADT;

public class Tekstgrensesnitt {
	private Film[] filmTab;
	private int antall = 0;

	// lese opplysningene om en FILM fra tastatur
	public Film lesFilm() {

		Film film;

		Scanner scanner = new Scanner(System.in);
		System.out.println("Skriv inn filmnr.");
		int filmnr = scanner.nextInt();

		System.out.println("Skriv inn Filmskaper");
		String Filmsakper = scanner.nextLine();

		System.out.println("Skriv inn Filmtittel");
		String filmTittel = scanner.nextLine();

		System.out.println("Skriv inn lanseringsår");
		int lanseringsår = scanner.nextInt();

		System.out.println("Skriv inn Filmselskap");
		String Filmselskap = scanner.nextLine();

		System.out.println("Velg sjanger, mellom: Action, Drama, History og Scifi.");
		String sjanger = scanner.nextLine();
		Sjanger sjang = null;

		do {
			if (sjanger.equals("Action")) {
				sjang = Sjanger.ACTION;
			} else if (sjanger.equals("Drama")) {
				sjang = Sjanger.DRAMA;
			} else if (sjanger.equals("History")) {
				sjang = Sjanger.HISTORY;
			} else if (sjanger.equals("Scifi")) {
				sjang = Sjanger.SCIFI;
			} else {
				System.out.println("Ugyldig sjanger, prøv igjen");
				sjanger = scanner.nextLine();
			}
		} while (sjang == null);

		film = new Film(filmnr, Filmsakper, filmTittel, lanseringsår, Filmselskap, sjang);

		return film;

	}

	// vise en film med alle opplysninger på skjerm (husk tekst for sjanger)
	public void visFilm(Film film) {
		for (int i = 0; i < filmTab.length; i++) {
			if (filmTab[i].equals((film))) {
				System.out.println(filmTab[i].getFilmnr());
				System.out.println(filmTab[i].getFilmprodusent());
				System.out.println(filmTab[i].getTittel());
				System.out.println(filmTab[i].getLansering());
				System.out.println(filmTab[i].getFilmselskap());
			}
		}
	}

	// Skrive ut alle Filmer med en spesiell delstreng i tittelen
	public void skrivUtFilmDelstrengITittel(FilmarkivADT filma, String delstreng) {
		Film[] nyF = new Film[antall];
		nyF = filma.soekTittel(delstreng);

		for (int i = 0; i < filmTab.length; i++) {
			if (filmTab[i].getTittel() == delstreng) {
				filmTab[i] = nyF[i];
				System.out.println(filmTab[i]);
			}
		}
	}

	// Skriver ut alle Filmer av en produsent / en gruppe
	public void skrivUtFilmProdusent(FilmarkivADT filma, String delstreng) {
		// TODO
		System.out.print(delstreng + ":");
		for (int i = 0; i < filmTab.length; i++) {
			if (delstreng.toLowerCase() == filmTab[i].getFilmprodusent().toLowerCase()) {
				System.out.print("\n" + filmTab[i].getTittel());
			}
		}
	}

	// Skrive ut en enkel statistikk som inneholder antall Filmer totalt
	// og hvor mange det er i hver sjanger
	public void skrivUtStatistikk(FilmarkivADT filma) {

		System.out.println("Antall filmer totalt: " + filma.antall());
		System.out.println("Antall filmer i Action sjangeren: " + filma.antall(Sjanger.ACTION));
		System.out.println("Antall filmer i Drama sjangeren: " + filma.antall(Sjanger.DRAMA));
		System.out.println("Antall filmer i History sjangeren: " + filma.antall(Sjanger.HISTORY));
		System.out.println("Antall filmer i Scifi sjangeren: " + filma.antall(Sjanger.SCIFI));
		//O(5) den er konstant
	}
	
	// ... Ev. andre metoder

}