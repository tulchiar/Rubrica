package it.tulchiar.rubrica.dao;

public class Utente_Test {
	public static void main(String[] args) {
		Utente utente1 = new Utente("Carlotta", "Fratoni");
	//	utente1.nome = "Carlotta_1";
		utente1.cognome = "Fratoni_1";
		
		Utente utente2 = new Utente();
		utente2.setNome("Marco");
		utente2.cognome = "Chiarello";
		
		System.out.println(utente1.getNome() + " " + utente1.cognome);
		System.out.println(utente2.getNome() + " " + utente2.cognome);
	}
}