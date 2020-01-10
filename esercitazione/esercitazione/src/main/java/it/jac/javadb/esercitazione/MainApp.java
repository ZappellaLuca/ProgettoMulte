package it.jac.javadb.esercitazione;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import it.jac.javadb.esercitazione.entity.Multe;
import it.jac.javadb.esercitazione.service.MulteService;
import it.jac.javadb.esercitazione.util.Utils;

public class MainApp {
	
	private static final Logger log = LogManager.getLogger(MainApp.class);

	public static void main(String[] args) {

		log.info("App Started");

		do {

			stampaMenu();
			System.out.print("Scegliere la funzione: ");
			new Finestra();
			Scanner in = new Scanner(System.in);
			String s = in.nextLine();

			MulteService service = new MulteService();
			
			switch (s) {
			case "1": {

				service.testConnessione();
				break;
			}
			case "2": {
				
				break;
			}
			case "3": {
				//inserimento dati nel db
				Multe multa = new Multe();
				/*inserisco dati a caso
				doc.setId("1");
				doc.setNome("nome");
				doc.setCognome("cognome");
				*/
				service.creaDocumento(multa);
				
				break;
			}
			case "4": {

				Multe doc = new Multe();
				doc.setId(1);
				
				service.eliminaDocumento(doc);
				
				break;
			}
			case "5": {

				break;
			}
			default: {

				log.info("Scelta non gestita, l'applicazione termina");
				return;
			}
			}

		} while (true);

	}

	private static void stampaMenu() {

		log.info("1) Test Connessione");
		log.info("2) Stampa lista varchi");
		log.info("3) Crea Multe (Hibernate)");
		log.info("Altro) Esci");
	}

}
