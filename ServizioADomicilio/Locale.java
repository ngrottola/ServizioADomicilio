
import java.util.Random;

class Locale {
	
	private Citta citta;
	private static KB kb;
	private Luogo LUOGO;

	private Boolean disp_rider = dispCasualeRider(); 
	private Boolean disp_locale = dispCasualeLocale();
	private Boolean ordine_effettuato = dispOrdineEffettuato();
	
	Locale(Citta citta) {
		
		kb = new KB();
		this.citta = citta;
		
		if (disp_rider == true)
			kb.setFlag("DISP_RIDER", true);
		else
			kb.setFlag("DISP_RIDER", false);

		if (disp_locale == true)
			kb.setFlag("DISP_LOCALE", true);
		else
			kb.setFlag("DISP_LOCALE", false);
		
		if (ordine_effettuato == true)
			kb.setFlag("ORDINE_EFFETTUATO", true);
		else
			kb.setFlag("ORDINE_EFFETTUATO", false);

	}

	KB getKb() {
		return kb;
	}

	void setLuogo(Luogo LUOGO) {
		this.LUOGO = LUOGO;
	}

	private boolean dispCasualeRider() {
		Random rnd = new Random();
		int n = rnd.nextInt(2); 
		if(n == 0)
			disp_rider = false;
		else 
			disp_rider = true;
			
		return disp_rider;
	}
	
	private boolean dispCasualeLocale() {
		Random rnd = new Random();
		int n = rnd.nextInt(2); 
		if(n == 0)
			disp_locale = false;
		else 
			disp_locale = true;
			
		return disp_locale;
	}
	
	private boolean dispOrdineEffettuato() {
		if(disp_rider == true && disp_locale == true)
			ordine_effettuato = true;
		else 
			ordine_effettuato = false;
			
		return ordine_effettuato;
	}


	void disponibilita(Luogo luogo) {
		
		if (disp_locale) {
			if(disp_rider) {
				mandaRider();
			}else 
				System.out.println("Il rider non e' disponibile. Riprovare piu' tardi\n");

		}else 
			System.out.println("Ordine non accettato. Il locale e' chiuso\n");

	}
	
	private Boolean mandaRider() {
		Rider rider = new Rider(citta);
		if(ordine_effettuato) {
			rider.raggiungiDestinazione(citta.getLuogo(),citta.getCasa());
		}	
		return false;
	}

	public String toString() {
		String s = "";
		s += LUOGO;
		return s;
	}
}
