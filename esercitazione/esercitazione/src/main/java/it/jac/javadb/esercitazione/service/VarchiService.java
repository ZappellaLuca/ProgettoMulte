package it.jac.javadb.esercitazione.service;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import it.jac.javadb.esercitazione.dao.VarchiDao;
import it.jac.javadb.esercitazione.entity.Varchi;

public class VarchiService {

	private static final Logger log = LogManager.getLogger(VarchiService.class);
	private VarchiDao dao = new VarchiDao();

	public void testConnessione() {
		log.info("Test connessione");
		boolean test = dao.testConnessione();
		if (test) {
			log.info("Test avvenuto con successo");
		}

	}

	public List<Varchi> findAll() {
		return this.dao.findAll();
	}

	public void creaDocumento(Varchi varco) {

		dao.creaDocumento(varco);
	}

	public void eliminaDocumento(Varchi varco) {

		dao.eliminaDocumento(varco);
	}

}
