package servizioADomicilio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

class Citta {
	
	private LinkedList<Luogo> luoghiCitta;
	private Luogo luogoFinale;
	private Locale locale;
	private ArrayList<String> listaLuoghi = new ArrayList<String>();
	
	Citta() {
		luoghiCitta = new LinkedList<>();
		costruireMappa();
	}
	
	void setCasa(Locale locale) {
		this.locale = locale;
		locale.setLuogo(luoghiCitta.getFirst()); 
	}

	private static void settareEuristiche(LinkedList<Luogo> mappaDaSettare, Luogo destinazione) {
		for (Luogo elemento : mappaDaSettare)
			elemento.setEuristica(destinazione);
	}

	@SuppressWarnings("unchecked")
	LinkedList<Luogo> getMappaToDestinazione(Luogo destinazione) {
		
		LinkedList<Luogo> mappaSettata = new LinkedList<>();
	
		mappaSettata = (LinkedList<Luogo>) luoghiCitta.clone();
		settareEuristiche(mappaSettata, destinazione);
		return mappaSettata;
	}

	private void costruireMappa() {

		HashMap<String, Double> euristiche_casa = new HashMap<>();
		euristiche_casa.put("Casa", 0.0);
		euristiche_casa.put("Villa Comunale", 1.0);
		euristiche_casa.put("Sushi", 5.0);
		euristiche_casa.put("Kebabberia", 4.0);
		euristiche_casa.put("Scuola", 6.0);
		euristiche_casa.put("Supermercato", 2.0);
		euristiche_casa.put("Chiesa", 13.0);
		euristiche_casa.put("Comune", 7.0);
		euristiche_casa.put("Pizzeria", 7.0);
		euristiche_casa.put("Baguetteria", 8.0);
		euristiche_casa.put("Braceria", 4.0);
		euristiche_casa.put("Concessionario", 8.0);
		euristiche_casa.put("Pescheria", 11.0);
		euristiche_casa.put("Teatro", 11.0);
		euristiche_casa.put("Hamburgeria", 5.0);
		euristiche_casa.put("Cinema", 12.0);
		euristiche_casa.put("Bar", 18.0);
		euristiche_casa.put("Gelateria", 5.0);
		Luogo casa = new Luogo("Casa", euristiche_casa);
		luoghiCitta.add(casa);

		HashMap<String, Double> euristiche_villaComunale = new HashMap<>();
		euristiche_villaComunale.put("Casa", 8.0);
		euristiche_villaComunale.put("Villa Comunale", 0.0);
		euristiche_villaComunale.put("Sushi", 4.0);
		euristiche_villaComunale.put("Kebabberia", 3.0);
		euristiche_villaComunale.put("Scuola", 5.0);
		euristiche_villaComunale.put("Supermercato", 1.0);
		euristiche_villaComunale.put("Chiesa", 12.0);
		euristiche_villaComunale.put("Comune", 6.0);
		euristiche_villaComunale.put("Pizzeria", 6.0);
		euristiche_villaComunale.put("Baguetteria", 7.0);
		euristiche_villaComunale.put("Braceria", 3.0);
		euristiche_villaComunale.put("Concessionario", 7.0);
		euristiche_villaComunale.put("Pescheria", 10.0);
		euristiche_villaComunale.put("Teatro", 10.0);
		euristiche_villaComunale.put("Hamburgeria", 4.0);
		euristiche_villaComunale.put("Cinema", 11.0);
		euristiche_villaComunale.put("Bar", 17.0);
		euristiche_villaComunale.put("Gelateria", 4.0);
		Luogo villaComunale = new Luogo("Villa Comunale", euristiche_villaComunale);
		luoghiCitta.add(villaComunale);

		HashMap<String, Double> euristiche_sushi = new HashMap<>();
		euristiche_sushi.put("Casa", 11.0);
		euristiche_sushi.put("Villa Comunale", 3.0);
		euristiche_sushi.put("Sushi", 0.0);
		euristiche_sushi.put("Kebabberia", 6.0);
		euristiche_sushi.put("Scuola", 8.0);
		euristiche_sushi.put("Supermercato", 4.0);
		euristiche_sushi.put("Chiesa", 8.0);
		euristiche_sushi.put("Comune", 9.0);
		euristiche_sushi.put("Pizzeria", 9.0);
		euristiche_sushi.put("Baguetteria", 10.0);
		euristiche_sushi.put("Braceria", 6.0);
		euristiche_sushi.put("Concessionario", 10.0);
		euristiche_sushi.put("Pescheria", 13.0);
		euristiche_sushi.put("Teatro", 13.0);
		euristiche_sushi.put("Hamburgeria", 7.0);
		euristiche_sushi.put("Cinema", 7.0);
		euristiche_sushi.put("Bar", 13.0);
		euristiche_sushi.put("Gelateria", 7.0);
		Luogo sushi = new Luogo("Sushi", euristiche_sushi);
		luoghiCitta.add(sushi);
		
		HashMap<String, Double> euristiche_kebabberia = new HashMap<>();
		euristiche_kebabberia.put("Casa", 5.0);
		euristiche_kebabberia.put("Villa Comunale", 4.0);
		euristiche_kebabberia.put("Sushi", 1.0);
		euristiche_kebabberia.put("Kebabberia", 0.0);
		euristiche_kebabberia.put("Scuola", 9.0);
		euristiche_kebabberia.put("Supermercato", 5.0);
		euristiche_kebabberia.put("Chiesa", 9.0);
		euristiche_kebabberia.put("Comune", 8.0);
		euristiche_kebabberia.put("Pizzeria", 3.0);
		euristiche_kebabberia.put("Baguetteria", 4.0);
		euristiche_kebabberia.put("Braceria", 5.0);
		euristiche_kebabberia.put("Concessionario", 7.0);
		euristiche_kebabberia.put("Pescheria", 7.0);
		euristiche_kebabberia.put("Teatro", 10.0);
		euristiche_kebabberia.put("Hamburgeria", 8.0);
		euristiche_kebabberia.put("Cinema", 8.0);
		euristiche_kebabberia.put("Bar", 14.0);
		euristiche_kebabberia.put("Gelateria", 8.0);
		Luogo kebabberia = new Luogo("Kebabberia", euristiche_kebabberia);
		luoghiCitta.add(kebabberia);

		HashMap<String, Double> euristiche_scuola = new HashMap<>();
		euristiche_scuola.put("Casa", 5.0);
		euristiche_scuola.put("Villa Comunale", 6.0);
		euristiche_scuola.put("Sushi", 3.0);
		euristiche_scuola.put("Kebabberia", 9.0);
		euristiche_scuola.put("Scuola", 0.0);
		euristiche_scuola.put("Supermercato", 7.0);
		euristiche_scuola.put("Chiesa", 11.0);
		euristiche_scuola.put("Comune", 12.0);
		euristiche_scuola.put("Pizzeria", 12.0);
		euristiche_scuola.put("Baguetteria", 13.0);
		euristiche_scuola.put("Braceria", 9.0);
		euristiche_scuola.put("Concessionario", 13.0);
		euristiche_scuola.put("Pescheria", 16.0);
		euristiche_scuola.put("Teatro", 16.0);
		euristiche_scuola.put("Hamburgeria", 10.0);
		euristiche_scuola.put("Cinema", 10.0);
		euristiche_scuola.put("Bar", 16.0);
		euristiche_scuola.put("Gelateria", 10.0);
		Luogo scuola = new Luogo("Scuola", euristiche_scuola);
		luoghiCitta.add(scuola);

		HashMap<String, Double> euristiche_supermercato = new HashMap<>();
		euristiche_supermercato.put("Casa", 8.0);
		euristiche_supermercato.put("Villa Comunale", 7.0);
		euristiche_supermercato.put("Sushi", 4.0);
		euristiche_supermercato.put("Kebabberia", 3.0);
		euristiche_supermercato.put("Scuola", 4.0);
		euristiche_supermercato.put("Supermercato", 0.0);
		euristiche_supermercato.put("Chiesa", 12.0);
		euristiche_supermercato.put("Comune", 5.0);
		euristiche_supermercato.put("Pizzeria", 6.0);
		euristiche_supermercato.put("Baguetteria", 7.0);
		euristiche_supermercato.put("Braceria", 2.0);
		euristiche_supermercato.put("Concessionario", 6.0);
		euristiche_supermercato.put("Pescheria", 10.0);
		euristiche_supermercato.put("Teatro", 9.0);
		euristiche_supermercato.put("Hamburgeria", 3.0);
		euristiche_supermercato.put("Cinema", 11.0);
		euristiche_supermercato.put("Bar", 17.0);
		euristiche_supermercato.put("Gelateria", 3.0);
		Luogo supermercato = new Luogo("Supermercato", euristiche_supermercato);
		luoghiCitta.add(supermercato);

		HashMap<String, Double> euristiche_chiesa = new HashMap<>();
		euristiche_chiesa.put("Casa", 10.0);
		euristiche_chiesa.put("Villa Comunale", 11.0);
		euristiche_chiesa.put("Sushi", 8.0);
		euristiche_chiesa.put("Kebabberia", 7.0);
		euristiche_chiesa.put("Scuola", 5.0);
		euristiche_chiesa.put("Supermercato", 8.0);
		euristiche_chiesa.put("Chiesa", 0.0);
		euristiche_chiesa.put("Comune", 2.0);
		euristiche_chiesa.put("Pizzeria", 10.0);
		euristiche_chiesa.put("Baguetteria", 11.0);
		euristiche_chiesa.put("Braceria", 6.0);
		euristiche_chiesa.put("Concessionario", 7.0);
		euristiche_chiesa.put("Pescheria", 14.0);
		euristiche_chiesa.put("Teatro", 10.0);
		euristiche_chiesa.put("Hamburgeria", 4.0);
		euristiche_chiesa.put("Cinema", 15.0);
		euristiche_chiesa.put("Bar", 5.0);
		euristiche_chiesa.put("Gelateria", 7.0);
		Luogo chiesa = new Luogo("Chiesa", euristiche_chiesa);
		luoghiCitta.add(chiesa);

		HashMap<String, Double> euristiche_comune = new HashMap<>();
		euristiche_comune.put("Casa", 8.0);
		euristiche_comune.put("Villa Comunale", 9.0);
		euristiche_comune.put("Sushi", 6.0);
		euristiche_comune.put("Kebabberia", 12.0);
		euristiche_comune.put("Scuola", 3.0);
		euristiche_comune.put("Supermercato", 10.0);
		euristiche_comune.put("Chiesa", 14.0);
		euristiche_comune.put("Comune", 0.0);
		euristiche_comune.put("Pizzeria", 15.0);
		euristiche_comune.put("Baguetteria", 16.0);
		euristiche_comune.put("Braceria", 12.0);
		euristiche_comune.put("Concessionario", 16.0);
		euristiche_comune.put("Pescheria", 19.0);
		euristiche_comune.put("Teatro", 19.0);
		euristiche_comune.put("Hamburgeria", 13.0);
		euristiche_comune.put("Cinema", 13.0);
		euristiche_comune.put("Bar", 19.0);
		euristiche_comune.put("Gelateria", 13.0);
		Luogo comune = new Luogo("Comune", euristiche_comune);
		luoghiCitta.add(comune);

		HashMap<String, Double> euristiche_pizzeria = new HashMap<>();
		euristiche_pizzeria.put("Casa", 8.0);
		euristiche_pizzeria.put("Villa Comunale", 7.0);
		euristiche_pizzeria.put("Sushi", 4.0);
		euristiche_pizzeria.put("Kebabberia", 3.0);
		euristiche_pizzeria.put("Scuola", 8.0);
		euristiche_pizzeria.put("Supermercato", 8.0);
		euristiche_pizzeria.put("Chiesa", 12.0);
		euristiche_pizzeria.put("Comune", 5.0);
		euristiche_pizzeria.put("Pizzeria", 0.0);
		euristiche_pizzeria.put("Baguetteria", 1.0);
		euristiche_pizzeria.put("Braceria", 2.0);
		euristiche_pizzeria.put("Concessionario", 4.0);
		euristiche_pizzeria.put("Pescheria", 4.0);
		euristiche_pizzeria.put("Teatro", 7.0);
		euristiche_pizzeria.put("Hamburgeria", 11.0);
		euristiche_pizzeria.put("Cinema", 11.0);
		euristiche_pizzeria.put("Bar", 17.0);
		euristiche_pizzeria.put("Gelateria", 11.0);
		Luogo pizzeria = new Luogo("Pizzeria", euristiche_pizzeria);
		luoghiCitta.add(pizzeria);

		HashMap<String, Double> euristiche_baguetteria = new HashMap<>();
		euristiche_baguetteria.put("Casa", 7.0);
		euristiche_baguetteria.put("Villa Comunale", 6.0);
		euristiche_baguetteria.put("Sushi", 3.0);
		euristiche_baguetteria.put("Kebabberia", 2.0);
		euristiche_baguetteria.put("Scuola", 7.0);
		euristiche_baguetteria.put("Supermercato", 7.0);
		euristiche_baguetteria.put("Chiesa", 11.0);
		euristiche_baguetteria.put("Comune", 4.0);
		euristiche_baguetteria.put("Pizzeria", 5.0);
		euristiche_baguetteria.put("Baguetteria", 0.0);
		euristiche_baguetteria.put("Braceria", 1.0);
		euristiche_baguetteria.put("Concessionario", 3.0);
		euristiche_baguetteria.put("Pescheria", 3.0);
		euristiche_baguetteria.put("Teatro", 6.0);
		euristiche_baguetteria.put("Hamburgeria", 10.0);
		euristiche_baguetteria.put("Cinema", 10.0);
		euristiche_baguetteria.put("Bar", 16.0);
		euristiche_baguetteria.put("Gelateria", 10.0);
		Luogo baguetteria = new Luogo("Baguetteria", euristiche_baguetteria);
		luoghiCitta.add(baguetteria);

		HashMap<String, Double> euristiche_braceria = new HashMap<>();
		euristiche_braceria.put("Casa", 6.0);
		euristiche_braceria.put("Villa Comunale", 5.0);
		euristiche_braceria.put("Sushi", 2.0);
		euristiche_braceria.put("Kebabberia", 1.0);
		euristiche_braceria.put("Scuola", 10.0);
		euristiche_braceria.put("Supermercato", 6.0);
		euristiche_braceria.put("Chiesa", 10.0);
		euristiche_braceria.put("Comune", 9.0);
		euristiche_braceria.put("Pizzeria", 4.0);
		euristiche_braceria.put("Baguetteria", 5.0);
		euristiche_braceria.put("Braceria", 0.0);
		euristiche_braceria.put("Concessionario", 8.0);
		euristiche_braceria.put("Pescheria", 8.0);
		euristiche_braceria.put("Teatro", 11.0);
		euristiche_braceria.put("Hamburgeria", 9.0);
		euristiche_braceria.put("Cinema", 9.0);
		euristiche_braceria.put("Bar", 15.0);
		euristiche_braceria.put("Gelateria", 9.0);
		Luogo braceria = new Luogo("Braceria", euristiche_braceria);
		luoghiCitta.add(braceria);

		HashMap<String, Double> euristiche_concessionario = new HashMap<>();
		euristiche_concessionario.put("Casa", 9.0);
		euristiche_concessionario.put("Villa Comunale", 10.0);
		euristiche_concessionario.put("Sushi", 7.0);
		euristiche_concessionario.put("Kebabberia", 13.0);
		euristiche_concessionario.put("Scuola", 4.0);
		euristiche_concessionario.put("Supermercato", 11.0);
		euristiche_concessionario.put("Chiesa", 15.0);
		euristiche_concessionario.put("Comune", 1.0);
		euristiche_concessionario.put("Pizzeria", 16.0);
		euristiche_concessionario.put("Baguetteria", 17.0);
		euristiche_concessionario.put("Braceria", 13.0);
		euristiche_concessionario.put("Concessionario", 0.0);
		euristiche_concessionario.put("Pescheria", 20.0);
		euristiche_concessionario.put("Teatro", 3.0);
		euristiche_concessionario.put("Hamburgeria", 14.0);
		euristiche_concessionario.put("Cinema", 14.0);
		euristiche_concessionario.put("Bar", 20.0);
		euristiche_concessionario.put("Gelateria", 14.0);
		Luogo concessionario = new Luogo("Concessionario", euristiche_concessionario);
		luoghiCitta.add(concessionario);

		
		HashMap<String, Double> euristiche_pescheria = new HashMap<>();
		euristiche_pescheria.put("Casa", 13.0);
		euristiche_pescheria.put("Villa Comunale", 12.0);
		euristiche_pescheria.put("Sushi", 9.0);
		euristiche_pescheria.put("Kebabberia", 8.0);
		euristiche_pescheria.put("Scuola", 13.0);
		euristiche_pescheria.put("Supermercato", 13.0);
		euristiche_pescheria.put("Chiesa", 17.0);
		euristiche_pescheria.put("Comune", 10.0);
		euristiche_pescheria.put("Pizzeria", 11.0);
		euristiche_pescheria.put("Baguetteria", 6.0);
		euristiche_pescheria.put("Braceria", 7.0);
		euristiche_pescheria.put("Concessionario", 9.0);
		euristiche_pescheria.put("Pescheria", 0.0);
		euristiche_pescheria.put("Teatro", 12.0);
		euristiche_pescheria.put("Hamburgeria", 16.0);
		euristiche_pescheria.put("Cinema", 13.0);
		euristiche_pescheria.put("Bar", 22.0);
		euristiche_pescheria.put("Gelateria", 16.0);
		Luogo pescheria = new Luogo("Pescheria", euristiche_pescheria);
		luoghiCitta.add(pescheria);

		HashMap<String, Double> euristiche_teatro = new HashMap<>();
		euristiche_teatro.put("Casa", 11.0);
		euristiche_teatro.put("Villa Comunale", 12.0);
		euristiche_teatro.put("Sushi", 9.0);
		euristiche_teatro.put("Kebabberia", 15.0);
		euristiche_teatro.put("Scuola", 6.0);
		euristiche_teatro.put("Supermercato", 13.0);
		euristiche_teatro.put("Chiesa", 17.0);
		euristiche_teatro.put("Comune", 3.0);
		euristiche_teatro.put("Pizzeria", 18.0);
		euristiche_teatro.put("Baguetteria", 19.0);
		euristiche_teatro.put("Braceria", 15.0);
		euristiche_teatro.put("Concessionario", 19.0);
		euristiche_teatro.put("Pescheria", 22.0);
		euristiche_teatro.put("Teatro", 0.0);
		euristiche_teatro.put("Hamburgeria", 16.0);
		euristiche_teatro.put("Cinema", 16.0);
		euristiche_teatro.put("Bar", 22.0);
		euristiche_teatro.put("Gelateria", 16.0);
		Luogo teatro = new Luogo("Teatro", euristiche_teatro);
		luoghiCitta.add(teatro);

		HashMap<String, Double> euristiche_hamburgeria = new HashMap<>();
		euristiche_hamburgeria.put("Casa", 8.0);
		euristiche_hamburgeria.put("Villa Comunale", 7.0);
		euristiche_hamburgeria.put("Sushi", 4.0);
		euristiche_hamburgeria.put("Kebabberia", 3.0);
		euristiche_hamburgeria.put("Scuola", 4.0);
		euristiche_hamburgeria.put("Supermercato", 8.0);
		euristiche_hamburgeria.put("Chiesa", 12.0);
		euristiche_hamburgeria.put("Comune", 4.0);
		euristiche_hamburgeria.put("Pizzeria", 6.0);
		euristiche_hamburgeria.put("Baguetteria", 7.0);
		euristiche_hamburgeria.put("Braceria", 2.0);
		euristiche_hamburgeria.put("Concessionario", 3.0);
		euristiche_hamburgeria.put("Pescheria", 10.0);
		euristiche_hamburgeria.put("Teatro", 6.0);
		euristiche_hamburgeria.put("Hamburgeria", 0.0);
		euristiche_hamburgeria.put("Cinema", 11.0);
		euristiche_hamburgeria.put("Bar", 17.0);
		euristiche_hamburgeria.put("Gelateria", 3.0);
		Luogo hamburgeria = new Luogo("Hamburgeria", euristiche_hamburgeria);
		luoghiCitta.add(hamburgeria);

		HashMap<String, Double> euristiche_cinema = new HashMap<>();
		euristiche_cinema.put("Casa", 20.0);
		euristiche_cinema.put("Villa Comunale", 21.0);
		euristiche_cinema.put("Sushi", 18.0);
		euristiche_cinema.put("Kebabberia", 24.0);
		euristiche_cinema.put("Scuola", 15.0);
		euristiche_cinema.put("Supermercato", 22.0);
		euristiche_cinema.put("Chiesa", 26.0);
		euristiche_cinema.put("Comune", 26.0);
		euristiche_cinema.put("Pizzeria", 21.0);
		euristiche_cinema.put("Baguetteria", 22.0);
		euristiche_cinema.put("Braceria", 23.0);
		euristiche_cinema.put("Concessionario", 25.0);
		euristiche_cinema.put("Pescheria", 25.0);
		euristiche_cinema.put("Teatro", 28.0);
		euristiche_cinema.put("Hamburgeria", 25.0);
		euristiche_cinema.put("Cinema", 0.0);
		euristiche_cinema.put("Bar", 31.0);
		euristiche_cinema.put("Gelateria", 14.0);
		Luogo cinema = new Luogo("Cinema", euristiche_cinema);
		luoghiCitta.add(cinema);

		HashMap<String, Double> euristiche_bar = new HashMap<>();
		euristiche_bar.put("Casa", 11.0);
		euristiche_bar.put("Villa Comunale", 10.0);
		euristiche_bar.put("Sushi", 7.0);
		euristiche_bar.put("Kebabberia", 6.0);
		euristiche_bar.put("Scuola", 7.0);
		euristiche_bar.put("Supermercato", 3.0);
		euristiche_bar.put("Chiesa", 15.0);
		euristiche_bar.put("Comune", 8.0);
		euristiche_bar.put("Pizzeria", 9.0);
		euristiche_bar.put("Baguetteria", 10.0);
		euristiche_bar.put("Braceria", 5.0);
		euristiche_bar.put("Concessionario", 9.0);
		euristiche_bar.put("Pescheria", 13.0);
		euristiche_bar.put("Teatro", 12.0);
		euristiche_bar.put("Hamburgeria", 6.0);
		euristiche_bar.put("Cinema", 14.0);
		euristiche_bar.put("Bar", 0.0);
		euristiche_bar.put("Gelateria", 6.0);
		Luogo bar = new Luogo("Bar", euristiche_bar);
		luoghiCitta.add(bar);

		HashMap<String, Double> euristiche_gelateria = new HashMap<>();
		euristiche_gelateria.put("Casa", 6.0);
		euristiche_gelateria.put("Villa Comunale", 7.0);
		euristiche_gelateria.put("Sushi", 4.0);
		euristiche_gelateria.put("Kebabberia", 10.0);
		euristiche_gelateria.put("Scuola", 1.0);
		euristiche_gelateria.put("Supermercato", 8.0);
		euristiche_gelateria.put("Chiesa", 12.0);
		euristiche_gelateria.put("Comune", 12.0);
		euristiche_gelateria.put("Pizzeria", 7.0);
		euristiche_gelateria.put("Baguetteria", 8.0);
		euristiche_gelateria.put("Braceria", 9.0);
		euristiche_gelateria.put("Concessionario", 11.0);
		euristiche_gelateria.put("Pescheria", 11.0);
		euristiche_gelateria.put("Teatro", 14.0);
		euristiche_gelateria.put("Hamburgeria", 11.0);
		euristiche_gelateria.put("Cinema", 11.0);
		euristiche_gelateria.put("Bar", 17.0);
		euristiche_gelateria.put("Gelateria", 0.0);
		Luogo gelateria = new Luogo("Gelateria", euristiche_gelateria);
		luoghiCitta.add(gelateria);

		casa.addStradaAdiacente(villaComunale, traffico());
		casa.addStradaAdiacente(kebabberia, traffico());
		casa.addStradaAdiacente(pizzeria, traffico());

		villaComunale.addStradaAdiacente(kebabberia, traffico());
		villaComunale.addStradaAdiacente(supermercato, traffico());

		kebabberia.addStradaAdiacente(casa, traffico());
		kebabberia.addStradaAdiacente(sushi, traffico());
		kebabberia.addStradaAdiacente(pizzeria, traffico());

		sushi.addStradaAdiacente(villaComunale, traffico());
		sushi.addStradaAdiacente(cinema, traffico());
		sushi.addStradaAdiacente(braceria, traffico());

		scuola.addStradaAdiacente(baguetteria, traffico());
		scuola.addStradaAdiacente(sushi, traffico());

		supermercato.addStradaAdiacente(comune, traffico());
		supermercato.addStradaAdiacente(casa, traffico());

		chiesa.addStradaAdiacente(bar, traffico());

		comune.addStradaAdiacente(pescheria, traffico());
		comune.addStradaAdiacente(hamburgeria, traffico());

		pizzeria.addStradaAdiacente(baguetteria, traffico());
		pizzeria.addStradaAdiacente(gelateria, traffico());

		baguetteria.addStradaAdiacente(braceria, traffico());
		baguetteria.addStradaAdiacente(concessionario, traffico());

		braceria.addStradaAdiacente(kebabberia, traffico());
		braceria.addStradaAdiacente(gelateria, traffico());

		concessionario.addStradaAdiacente(sushi, traffico());
		concessionario.addStradaAdiacente(teatro, traffico());

		pescheria.addStradaAdiacente(bar, traffico());
		pescheria.addStradaAdiacente(chiesa, traffico());
		pescheria.addStradaAdiacente(hamburgeria, traffico());

		teatro.addStradaAdiacente(scuola, traffico());
		teatro.addStradaAdiacente(pizzeria, traffico());

		hamburgeria.addStradaAdiacente(villaComunale, traffico());
		hamburgeria.addStradaAdiacente(cinema, traffico());
		
		cinema.addStradaAdiacente(bar, traffico());

		bar.addStradaAdiacente(supermercato, traffico());

		gelateria.addStradaAdiacente(kebabberia, traffico());
		gelateria.addStradaAdiacente(pizzeria, traffico());

	}

	void ordineCliente() {
		
		System.out.println("Inserisci: \n1)Pizza\n2)Gelato\n3)Hamburger\n4)Panino\n5)Carne\n6)Pesce\n7)Sushi\n8)Kebab \n");
		
		int scelta;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		scelta = sc.nextInt();
		
		if(scelta<9 && scelta>0) {
			System.out.println("Dove preferisci ordinare? \n");
			Luogo luogo = new Luogo();
			luogo = cspRicerca(scelta);
		
			setCasa(locale);
			luogoFinale = luogo;
			locale.disponibilita(luogo);
		}
	}

	private double traffico() {
		int a = 80; // numero minimo
		int b = 500; // numero massimo
		int c = ((b - a) + 1);
		Random rd = new Random();
		double risultato = rd.nextInt(c) + a;
		return risultato;
	}
	
	Luogo getLuogo() {
		return luogoFinale;
	}
	
	Luogo getCasa() {
		return luoghiCitta.get(0);
	}
	
	private Luogo cspRicerca(Integer scelta) {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		listaLuoghi.add("Pizzeria"); 
		listaLuoghi.add("Gelateria");
		listaLuoghi.add("Hamburgeria");
		listaLuoghi.add("Braceria");
		listaLuoghi.add("Baguetteria");
		listaLuoghi.add("Pescheria");
		listaLuoghi.add("Sushi");
		listaLuoghi.add("Kebabberia");
		
		ArrayList<Luogo> luogo = new ArrayList<Luogo>();
		int s=0;
		System.out.println("Inserisci:");

		for(int locale=1; locale<9; locale++) {
			
			if(scelta == 1 && locale == 1) {
				System.out.println("1)" + listaLuoghi.get(locale-1));
				while(s!= 1) {
					s = sc.nextInt();
					if(s!=1)
						System.out.println("Scelta errata! Inserire nuovo numero");
				}
				luogo.add(luoghiCitta.get(8));

			}
			else if(scelta == 2 && locale == 1) {
				System.out.println("1)" + listaLuoghi.get(locale-1));
				luogo.add(luoghiCitta.get(8));

			}
			else if(scelta == 2 && locale == 2) {
				System.out.println("2)" + listaLuoghi.get(locale-1));
				while(s<1 || s>2) {
					s = sc.nextInt();
					if(s<1 || s>2)
						System.out.println("Scelta errata! Inserire nuovo numero");
				}
				luogo.add(luoghiCitta.get(17));
			}
			else if(scelta == 3 && locale == 3) {
				System.out.println("1)" + listaLuoghi.get(locale-1));
				luogo.add(luoghiCitta.get(14));
			}
			else if(scelta == 3 && locale == 4) {
				System.out.println("2)" + listaLuoghi.get(locale-1));
				while(s<1 || s>2) {
					s = sc.nextInt();
					if(s<1 || s>2)
						System.out.println("Scelta errata! Inserire nuovo numero");
				}
				luogo.add(luoghiCitta.get(10));
			}
			else if(scelta == 4 && locale == 3) {
				System.out.println("1)" + listaLuoghi.get(locale-1));
				luogo.add(luoghiCitta.get(14));
			}
			else if(scelta == 4 && locale == 5) {
				System.out.println("2)" + listaLuoghi.get(locale-1));
				while(s<1 || s>2) {
					s = sc.nextInt();
					if(s<1 || s>2)
						System.out.println("Scelta errata! Inserire nuovo numero");
				}
				luogo.add(luoghiCitta.get(9));
			}
			else if(scelta == 5 && locale == 3) {
				System.out.println("1)" + listaLuoghi.get(locale-1));
				luogo.add(luoghiCitta.get(14));
			}
			else if(scelta == 5 && locale == 4) {
				System.out.println("2)" + listaLuoghi.get(locale-1));
				luogo.add(luoghiCitta.get(10));
			}
			else if(scelta == 5 && locale == 5) {
				System.out.println("3)" + listaLuoghi.get(locale-1));
				while(s<1 || s>3) {
					s = sc.nextInt();
					if(s<1 || s>3)
						System.out.println("Scelta errata! Inserire nuovo numero");
				}
				luogo.add(luoghiCitta.get(9));
			}
			else if(scelta == 6 && locale == 5) {
				System.out.println("1)" + listaLuoghi.get(locale-1));
				luogo.add(luoghiCitta.get(9));
			}
			else if(scelta == 6 && locale == 6) {
				System.out.println("2)" + listaLuoghi.get(locale-1));
				luogo.add(luoghiCitta.get(12));
			}
			else if(scelta == 6 && locale == 7) {
				System.out.println("3)" + listaLuoghi.get(locale-1));
				while(s<1 || s>3) {
					s = sc.nextInt();
					if(s<1 || s>3)
						System.out.println("Scelta errata! Inserire nuovo numero");
				}
				luogo.add(luoghiCitta.get(2));
			}
			else if(scelta == 7 && locale == 6) {
				System.out.println("1)" + listaLuoghi.get(locale-1));
				luogo.add(luoghiCitta.get(12));
			}
			else if(scelta == 7 && locale == 7) {
				System.out.println("2)" + listaLuoghi.get(locale-1));
				while(s<1 || s>2) {
					s = sc.nextInt();
					if(s<1 || s>2)
						System.out.println("Scelta errata! Inserire nuovo numero");
				}
				luogo.add(luoghiCitta.get(2));
			}
			else if(scelta == 8 && locale == 8) {
				System.out.println("1)" + listaLuoghi.get(locale-1));
				while(s!= 1) {
					s = sc.nextInt();
					if(s!=1)
						System.out.println("Scelta errata! Inserire nuovo numero");
				}
				luogo.add(luoghiCitta.get(3));
			}
		}
	
		return luogo.get(s-1);
	}
}
