package servizioADomicilio;

import java.util.LinkedList;
import java.util.Random;

import servizioADomicilio.KB;

class KB {
	
	private String rider_disponibile_str = "rider_disponibile";
	private String locale_aperto_str = "locale_aperto";
	private String ordine_effettuato_str = "ordine_effettuato";
	
	private Boolean rider_disponibile = casuale();
	private Boolean locale_aperto = casuale();
	private Boolean ordine_effettuato = getOrdineEffettuato();
	
	private LinkedList<Sensor> flags;

	private LinkedList<String> clausoleHowWhynot = new LinkedList<>();
	private LinkedList<String> atomiCorpoFalsi = new LinkedList<>();

	private LinkedList<String> clausola_rider_disponibile_list = new LinkedList<>();
	private LinkedList<String> clausola_locale_aperto_list = new LinkedList<>();
	private LinkedList<String> clausola_ordine_effettuato_list = new LinkedList<>();

	public static void main(String args[]) {
		
		KB kb = new KB();

		System.out.println("ASK : " + kb.askEsterno("ordine_effettuato"));
		System.out.println("HOW : " + kb.how("ordine_effettuato"));
		System.out.println("WHYNOT : " + kb.whyNot("ordine_effettuato"));

	}

	KB() {
		
		flags = new LinkedList<>();
		flags.add(new Sensor("DISP_RIDER", rider_disponibile ));
		flags.add(new Sensor("DISP_LOCALE", locale_aperto));
		flags.add(new Sensor("ORDINE_EFFETTUATO", ordine_effettuato));

		clausola_rider_disponibile_list.add(rider_disponibile_str);
		clausola_locale_aperto_list.add(locale_aperto_str);
		clausola_ordine_effettuato_list.add(ordine_effettuato_str);
		
	}

	private Boolean clausola_rider_disponibile() {

		if(rider_disponibile)
			return true;
		return false;
	}

	private void set_clausola_rider_disponibile_list() {
		
		rider_disponibile = clausola_rider_disponibile();

		if (rider_disponibile) {
			clausola_rider_disponibile_list.add(rider_disponibile_str);
			return;
		}
	}
	
	private Boolean clausola_locale_aperto() {

		if(locale_aperto)
			return true;
		return false;
	}

	private void set_clausola_locale_aperto_list() {
		
		locale_aperto = clausola_locale_aperto();

		if (locale_aperto) {
			clausola_locale_aperto_list.add(locale_aperto_str);
			return;
		}
	}
	
	private Boolean clausola_ordine_effettuato() {

		if(locale_aperto && rider_disponibile)
			return true;
		return false;
	}

	private void set_clausola_ordine_effettuato_list() {
		
		locale_aperto = clausola_locale_aperto();
		rider_disponibile = clausola_rider_disponibile();

		if (locale_aperto && rider_disponibile) {
			clausola_ordine_effettuato_list.add(locale_aperto_str);
			clausola_ordine_effettuato_list.add(rider_disponibile_str);
			return;
		}
	}

	void setFlag(String tipo, boolean stato) {
		try {
			int i;
			for (i = 0; i < flags.size(); i++) {
				if (flags.get(i).isEqual(tipo))
					break;
			}
			if (i == flags.size())
				throw new Exception("Tipo non valido");
			flags.set(i, new Sensor(flags.get(i).getTipo(), stato));
		} catch (Exception e) {
		}
	}

	private void setClausoleHowWhynot(String primoVal, LinkedList<String> lista) {
		clausoleHowWhynot.add(primoVal);
		if(lista.size() <= 2) {
			clausoleHowWhynot.add("<---");
			clausoleHowWhynot.add(lista.get(0));
		}
		if(lista.size() > 2) {
			clausoleHowWhynot.add("<---");
			for (int i = 1; i < lista.size(); i++) {
				clausoleHowWhynot.add(lista.get(i));
				if(i<2)
					clausoleHowWhynot.add("AND");
			}
		}
	}

	private void setAtomiCorpoFalsi(LinkedList<String> lista) {
		String str_aux = "";
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).charAt(0) == 'n' && lista.get(i).charAt(1) == 'o' && lista.get(i).charAt(2) == 't') {
				for (int k = 4; k < lista.get(i).length(); k++) {
					str_aux += lista.get(i).charAt(k);
				}
				if (askEsterno(str_aux))
					atomiCorpoFalsi.add(lista.get(i));
			} else if (!askEsterno(lista.get(i))) {
				atomiCorpoFalsi.add(lista.get(i));
			}

		}
	}

	private Boolean askInterno(String atomo) {
		switch (atomo) {
			case ("rider_disponibile"): {
				rider_disponibile = clausola_rider_disponibile();
				set_clausola_rider_disponibile_list(); 
				setClausoleHowWhynot(rider_disponibile_str, clausola_rider_disponibile_list);
				if (!rider_disponibile)
					setAtomiCorpoFalsi(clausola_rider_disponibile_list);
				return rider_disponibile;
			}
			case ("locale_aperto"): {
				locale_aperto = clausola_locale_aperto();
				set_clausola_locale_aperto_list();
				setClausoleHowWhynot(locale_aperto_str, clausola_locale_aperto_list);
				if (!locale_aperto)
					setAtomiCorpoFalsi(clausola_locale_aperto_list);
				return locale_aperto;
			}
			case ("ordine_effettuato"): {
				ordine_effettuato = clausola_ordine_effettuato();
				set_clausola_ordine_effettuato_list();
				setClausoleHowWhynot(ordine_effettuato_str, clausola_ordine_effettuato_list);
				if (!ordine_effettuato)
					setAtomiCorpoFalsi(clausola_ordine_effettuato_list);
				return ordine_effettuato;
			}
		
			default: {
				System.out.println("ECCEZIONE ASK INTERNO");
				return false;
			}
		}
	}

	String whyNot(String atomo) {

		for (int i = 0; i < atomiCorpoFalsi.size(); i++) {
			atomiCorpoFalsi.remove();
			i--;
		}

		for (int i = 0; i < clausoleHowWhynot.size(); i++) {
			clausoleHowWhynot.remove();
			i--;
		}

		if (!askInterno(atomo)) { 
			String clausola = parseClausola(clausoleHowWhynot.toString());
			String falsi = parseFalsi(atomiCorpoFalsi.toString());
			return parseWhynot(clausola, falsi);
		}
		return "Non valido per risposte true";
	}

	private String parseWhynot(String clausola, String falsi) {
		String output = "";
		output = "Nella clausola : " + clausola + " : Risulta FALSE : " + falsi;
		return output;
	}

	private String parseFalsi(String str1) {
		String output = "";
		for (int i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) == ']' || str1.charAt(i) == '[') {
				continue;
			} else {
				output += str1.charAt(i);
			}

		}
		return output;
	}

	String how(String atomo) { 
		
		for (int i = 0; i < clausoleHowWhynot.size(); i++) {
			clausoleHowWhynot.remove();
			i--;
		}

		if (askInterno(atomo)) { 
			return parseClausola(clausoleHowWhynot.toString());
		}
		return "Non valido per risposte false";
	}

	private String parseClausola(String listStr) {
		String output = "";
		for (int i = 0; i < listStr.length(); i++) {
			if (listStr.charAt(i) == ',' || listStr.charAt(i) == ']' || listStr.charAt(i) == '[') {
				continue;
			} else {
				output += listStr.charAt(i);
			}
		}
		return output;
	}

	Boolean askEsterno(String atomo) {
		switch (atomo) {
			case ("rider_disponibile"): {
				return rider_disponibile;
			}
			case ("locale_aperto"): {
				return locale_aperto;
			}
			case ("ordine_effettuato"): {
				return ordine_effettuato;
			}
		
			default: {
				System.out.println("ECCEZIONE ASK ESTERNO");
				return false;
			}
		}
	}
	
	private boolean casuale() {
		Random rnd = new Random();
		int n = rnd.nextInt(2); 
		if(n == 0)
			return false;
	
		return true;
	}
	
	private boolean getOrdineEffettuato() {
		if(locale_aperto) {
			if(rider_disponibile) {
				ordine_effettuato = true;
			}else 
				ordine_effettuato = false;
		}else 
			ordine_effettuato = false;
		return ordine_effettuato;
	}

}
