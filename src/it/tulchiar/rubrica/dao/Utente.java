package it.tulchiar.rubrica.dao;

public class Utente {

	private String nome;
	public String cognome;
	
	public String getNome() {
		return nome.toUpperCase();
	}

	public void setNome(String nome) {
		this.nome = nome.toUpperCase();
	}

	public Utente() {
		super();
	}
	
	public Utente(String nome, String cognome) {
		super();
		this.nome = nome;	
		this.cognome = cognome;
	}
	
	public static void main(String[] args) {
	
		
		
	}

}
