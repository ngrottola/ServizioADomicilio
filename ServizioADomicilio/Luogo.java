
import java.util.HashMap;
import java.util.LinkedList;

class Luogo {
	
	private String descrizione; 
	private double euristica;
	private HashMap<String, Double> euristiche = new HashMap<>();
	private LinkedList<Strada> adiacenti;

	Luogo() {};

	Luogo(String descrizione, HashMap<String, Double> euristiche) {
		this.descrizione = descrizione;
		this.euristiche = euristiche;
		euristica = 0;
		adiacenti = new LinkedList<>();
	}

	void setEuristica(Luogo destinazione) {
		euristica = euristiche.get(destinazione.getDescrizione());
	}

	double getEuristica() {
		return euristica;
	}

	String getDescrizione() {
		return descrizione;
	}

	LinkedList<Strada> getListaAdiacenti() {
		return adiacenti;
	}

	void addStradaAdiacente(Luogo luogo, double cost) {
		adiacenti.add(new Strada(luogo, cost));
	}

	@Override
	public String toString() {
		return descrizione;
	}
}
