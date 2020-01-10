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
		new Finestra();
	}

}
