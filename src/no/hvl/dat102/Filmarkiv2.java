package no.hvl.dat102;

import no.hvl.dat102.adt.FilmarkivADT;

public class Filmarkiv2 implements FilmarkivADT {

	private int antall = 0;
	private LinearNode<Film> start = null;

	@Override
	public Film finnFilm(int filmnr) {
		// TODO Auto-generated method stub
		LinearNode<Film> current = start;
		while (current != null) {
			if (current.getElement().getFilmnr() == filmnr) {
				return current.getElement();
			}
			current = current.next;
		}
		return null;

	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		// TODO Auto-generated method stub
		LinearNode<Film> newNode = new LinearNode<Film>(nyFilm);

		newNode.setNeste(start);
		start = newNode;
		antall++;
	}

	@Override
	public boolean slettFilm(int filmnr) {
		// TODO Auto-generated method stub

		LinearNode<Film> current = start;
		LinearNode<Film> prev = null;

		while (current != null) {
			if (current.getElement().getFilmnr() == filmnr) {
				if (prev == null) {
					start = current.getNeste();
				} else {
					prev.setNeste(current.getNeste());
				}
				antall--;
				return true;

			}
			prev = current;
			current = current.getNeste();
		}
		return false;
	}

	@Override
	public Film[] soekTittel(String delstreng) {
		// TODO Auto-generated method stub
		Film[] filmer = new Film[antall];
		LinearNode<Film> current = start;
		int n = 0;
		
		while (current != null) {
			if (current.getElement().getTittel().toLowerCase().contains(delstreng.toLowerCase())) {
				filmer[n] = current.getElement();
				n++;
			}
			current = current.getNeste();
		}
		return filmer;
		
	}

	@Override
	public int antall(Sjanger sjanger) {
        int antSjanger = 0;
        LinearNode<Film> current = start;
        
        while(current != null) {
            if(current.getElement().getSjanger().equals(sjanger)) {
                antSjanger++;
            }
            current = current.getNeste();
        }
        return antSjanger;
        
        /*
         * i = O(n) pga. while loopen vil gå innom alle nodene i kjedet liste.
         */
    }

	@Override
	public int antall() {
		// TODO Auto-generated method stub
		int count = 0;
		LinearNode<Film> current = start;

		while (current != null) {
			count++;
			current = current.getNeste();
		}
		return count;
	}

}
