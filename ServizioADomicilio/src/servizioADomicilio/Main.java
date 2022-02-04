package servizioADomicilio;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

class Main {
	
	private static Citta citta = new Citta();
	private static Locale locale;
	private static String[] clausole = { "rider_disponibile", "locale_aperto","ordine_effettuato" };

	public static void main(String[] args) {
		
		while (true) {
			locale = new Locale(citta);
			citta.setCasa(locale);
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			System.out.println(
					"Inserisci: \n1)Cosa vuoi mangiare? \n2)Ask\n3)Visualizza Mappa della citta'\n4)Creatori del progetto\n5)Esci \n");
			int scelta;
			scelta = sc.nextInt();
			switch (scelta) {
				case (1):
				citta.ordineCliente();
				break;
			
				case (2): {
					System.out.println("1)rider_disponibile(il rider e' disponibile?)\n"
							+ "2)il locale e' aperto(il locale e' aperto?)\n"
							+ "3)ordine_effettuato(e' possibile effettuare l'ordine?)\n");
					
					System.out.println("Inserisci il numero corrispondente\n");
					scelta=0;
					while(scelta<1 || scelta>3) {
						scelta = sc.nextInt();
						if(scelta<1 || scelta>3)
							System.out.println("Scelta errata! Inserire nuovo numero");

					}
					ask(scelta);
					System.out.println("1) per \"How\" \n2) per \"WhyNot\" \n");
					int scelta2;
					scelta2 = sc.nextInt();
					switch (scelta2) {
					case (1):
						how(scelta);
						break;
					case (2):
						whyNot(scelta);
						break;
					}
					break;
				}
					case (3): {
						System.out.println("Mappa della citta'");
						apriMappa();
						break;
					}
					case (4):
						System.out.println(
							"Creatori del progetto:\nGrottola Nicola\nSoragnese Michele\nVitucci Emiliano\n");
					break;
				case (5):
					System.out.println("Sei sicuro di voler chiudere il programma?\n1)Si \n2)No");
					scelta = sc.nextInt();
					while (scelta != 1 || scelta != 2) {
						if (scelta == 1) {
							System.exit(0);
						}
						if (scelta == 2) {
							break;
						}
						if (scelta != 1 && scelta != 2) {
							System.out.println("Scelta errata! Inserire nuovo numero");
							scelta = sc.nextInt();
						}
					}
				}
			}
	}
	
	private static void ask(int scelta) {
		boolean risp;
		risp = locale.getKb().askEsterno(clausole[scelta - 1]);
		System.out.println(clausole[scelta - 1] + ":" + risp);
	}

	private static void how(int scelta) {
		String text;
		text = locale.getKb().how(clausole[scelta - 1]);
		System.out.println(text + "\n");
	}

	private static void whyNot(int scelta) {
		String text;
		text = locale.getKb().whyNot(clausole[scelta - 1]);
		System.out.println(text + "\n");
	}

	private static void apriMappa() {
		File file = new File("mappa.jpg");
		try {
			Desktop.getDesktop().open(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

