
import java.util.LinkedList;

class IDAStar {
	
	private static LinkedList<Luogo> percorsoTrovato = new LinkedList<>();

	static String getPercorsoTrovato() {
		return percorsoTrovato.toString();
	}

	static void svuotaPercorsoTrovato() {
		for (int i = 0; i < percorsoTrovato.size(); i++) {
			percorsoTrovato.remove();
			i--;
		}
	}
	
	static void IDAStarMetodo(Luogo nodo) {
		double max = nodo.getEuristica();
		while (true) {
			Risultato risultato = ricerca(nodo, 0, max, 0);
			if (risultato.getTipo() == 1) {
				return;
			} else if (risultato.getTipo() == 2) {
				double min = (Double) risultato.getRisultato1();
				if (min == Double.MAX_VALUE) {
					System.out.println("Percorso non trovato");
					return;
				}
			}
			max = (Double) risultato.getRisultato1();
		}
	}

	@SuppressWarnings("removal")
	public static Risultato ricerca(Luogo nodo, double g, double max, int s) {
		Risultato risultato;
		double f = nodo.getEuristica() + g;

		for (int i = 0; i < s; i++) {
		}
		if (f > max) {
			risultato = new Risultato();
			risultato.setTipo(2);
			risultato.setRisultato1(new Double(f));
			return risultato;
		}

		if (nodo.getEuristica() == 0) {
			risultato = new Risultato();
			risultato.setTipo(1);
			percorsoTrovato.addFirst(nodo);
			return risultato;
		}

		double min = Double.MAX_VALUE;
		for (Strada e : nodo.getListaAdiacenti()) {
			Risultato risultato1 = ricerca(e.getIncrocio(), g + e.getCosto(), max, s + 1);
			if (risultato1.getTipo() == 1) {
				percorsoTrovato.addFirst(nodo);
				return risultato1;
			} else if (risultato1.getTipo() == 2) {
				double newMin = (Double) risultato1.getRisultato1();
				if (newMin < min) {
					min = newMin;
				}
			}
		}

		risultato = new Risultato();
		risultato.setTipo(2);
		risultato.setRisultato1(new Double(min));
		return risultato;
	}
}
