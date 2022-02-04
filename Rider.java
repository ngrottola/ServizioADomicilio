package servizioADomicilio;

import java.util.LinkedList;

class Rider {
	
	private Citta citta;
	
	Rider(){};
	
	Rider(Citta citta) {
		this.citta = citta;
	}
	
	void raggiungiDestinazione(Luogo partenza, Luogo destinazione) {
		LinkedList<Luogo> luoghiSettati = citta.getMappaToDestinazione(destinazione);
		
		Luogo nodo_partenza_settato = new Luogo();
		for (Luogo elemento : luoghiSettati)
			if (elemento.getDescrizione() == partenza.getDescrizione()) {
				nodo_partenza_settato = elemento;
				break;
			}
		
		IDAStar.IDAStarMetodo(nodo_partenza_settato);
		System.out.println("Il sistema ha utilizzato un algoritmo per determinare "
				+ "il percorso del rider sulla mappa " + "considerando le distanze e il traffico.");
		System.out.println("Percorso trovato : " + IDAStar.getPercorsoTrovato());
		IDAStar.svuotaPercorsoTrovato();

		System.out.println("Rider partito verso la destinazione...\n ");
		System.out.println("Il rider e' arrivato a destinazione, consegna in corso...\n");
		System.out.println("La consegna e' andata a buon fine...\n");
		System.out.println("Ricerca del percorso di ritorno...\n");

		nodo_partenza_settato = destinazione;
		destinazione = luoghiSettati.get(0);
		luoghiSettati = citta.getMappaToDestinazione(partenza);
		IDAStar.IDAStarMetodo(nodo_partenza_settato);
		System.out.println("Percorso trovato : " + IDAStar.getPercorsoTrovato());
		System.out.println("Il rider sta tornando al locale.\n");
		IDAStar.svuotaPercorsoTrovato();

	}
	
	@Override
	public String toString() {
		return IDAStar.getPercorsoTrovato();
	}

}
