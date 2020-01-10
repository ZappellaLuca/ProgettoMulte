package main;

import java.io.IOException;

import pattern.Multa;

public class Main {
	public static void main(String args[]) throws IOException {
		new Multa(new Persona("Mario","Rossi"),new Veicolo("az344ag"), new Varco("Corso di porta ticinese, Milano"));
	}
}
