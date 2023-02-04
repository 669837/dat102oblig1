package no.hvl.dat102;

public class Film {
	
	private int filmnr;
	private String filmprodusent;
	private String tittel;
	private int lansering;
	private String filmselskap;
	private Sjanger Sjanger;
	
	//beast
	public Film() {
	}
	
	
	public Film(int filmnr, String filmprodusent, String tittel, int lansering, String filmselskap, Sjanger sjanger) {
		
		this.filmnr = filmnr;
		this.filmprodusent = filmprodusent;
		this.tittel = tittel;
		this.lansering = lansering;
		this.filmselskap = filmselskap;
		this.Sjanger = sjanger;
	}
	
	public int getFilmnr() {
		return filmnr;
	}
	
	public void setFilmnr(int filmnr) {
		this.filmnr = filmnr;
	}
	
	public String getFilmprodusent() {
		return filmprodusent;
	}
	
	public void setFilmprodusent(String filmprodusent) {
		this.filmprodusent = filmprodusent;
	}
	
	public String getTittel() {
		return tittel;
	}
	
	public void setTittel(String tittel) {
		this.tittel = tittel;
	}
	
	public int getLansering() {
		return lansering;
	}
	
	public void setLansering(int lansering) {
		this.lansering = lansering;
	}
	
	public String getFilmselskap() {
		return filmselskap;
	}
	
	public void setFilmselskap(String filmselskap) {
		this.filmselskap = filmselskap;
	}
	
	public Sjanger getSjanger() {
		return this.Sjanger;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		Film film = (Film) obj;
		return this.filmnr == film.getFilmnr();
	}
	
	@Override
	public int hashCode() {
		
		Integer temp = filmnr;
		return temp.hashCode();
	}

}
