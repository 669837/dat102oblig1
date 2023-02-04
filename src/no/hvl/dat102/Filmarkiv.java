package no.hvl.dat102;

import no.hvl.dat102.adt.FilmarkivADT;

public class Filmarkiv implements FilmarkivADT {
	
	private Film[] filmTab;
	private int antall = 0;
	
	public Filmarkiv(int plass) {
		
		filmTab = new Film[plass];
	}
	
	private void utvid() {
		
		int newSize = filmTab.length * 2;
		Film[] nyTab = new Film[newSize];
		
		for (int i = 0; i < filmTab.length; i++) {
			nyTab[i] = filmTab[i];
		}
		filmTab = nyTab;
	}

	@Override
	public Film finnFilm(int filmnr) {
		int n = 0;
		boolean funnet = false;
		for (int i = 0; i < filmTab.length; i++) {
			if (filmTab[i].getFilmnr() == filmnr) {
				funnet = true;
				n = i;
			}
		}
		if (funnet)
			return filmTab[n];
		else
			return null;
	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		if(antall < filmTab.length) {
            
            filmTab[antall] = nyFilm;
            antall++;
        }
        else {
            utvid();
            filmTab[antall] = nyFilm;
            antall++;
        }
		
	}
	
	private Film[] trim(Film[] filmTab) {
		int n = 0;
		
		Film[] trimmet = new Film[antall];
		
		for (int i = 0; i < filmTab.length; i++) {
			if (filmTab[i] != null) {
				trimmet[n] = filmTab[i];
				n++;
			}
		}
		filmTab = trimmet;
		return filmTab;
	}

	@Override
	public boolean slettFilm(int filmnr) {
		boolean slettet = false;
		for (int i = 0; i < filmTab.length; i++) {
			if (filmTab[i].getFilmnr() == filmnr) {
				filmTab[i] = null;
				slettet = true;
			}
		}
		trim(filmTab);
		return slettet;
	}

	@Override
	public Film[] soekTittel(String delstreng) {
		// TODO Auto-generated method stub
		Film[] nyFilm = new Film[1];
		for (int i = 0; i < filmTab.length; i++) {
			if (filmTab[i].getTittel().toLowerCase() == delstreng.toLowerCase()) {
				nyFilm[0] = filmTab[i];
			}
		}
		return nyFilm;
	}

	@Override
	public int antall(Sjanger sjanger) {
        // TODO Auto-generated method stub
        int sjangere = 0;
        int n = 0;
        for ( int i = 0; i<antall; i++) {
            if(Sjanger.ACTION == sjanger) {
                n++;
            	sjangere = n;    
            }
            if(Sjanger.DRAMA == sjanger) {
                n++;
            	sjangere = n;    
            }
            if(Sjanger.HISTORY == sjanger) {
                n++;
            	sjangere = n;    
            }
            if(Sjanger.SCIFI == sjanger) {
                n++;
            	sjangere = n;    
            }
                
        }
        return sjangere;
    } 

	@Override
	public int antall() {
		return antall;
	}

	

}
