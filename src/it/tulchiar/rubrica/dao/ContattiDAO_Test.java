package it.tulchiar.rubrica.dao;

import java.util.ArrayList;

import it.tulchiar.rubrica.bean.Contatto;



public class ContattiDAO_Test {

	
	
	public static void main(String[] args) {
				
		ContattiDAO dao = new ContattiDAO();
		
//XXX   INSERIMENTO
//		dao.insertContatto(new Contatto("Rolanda","Michelagnoli"));
		
//XXX	CANCELLAZIONE LOGICA		
//		Contatto contattoDaCancellare = new Contatto(4);
//		
//		dao.deleteContatto(contattoDaCancellare);
		
//XXX	RICERCA PER ID
//		Contatto c = dao.getContattoById(1);
//		
//		System.out.println(c);
		
		
//XXX	MODIFICA CONTATTO
		Contatto c = new Contatto();
		c.setNome("Provola");
		c.setCognome("ProvaCognome");
		c.setTelefono("123456789");
		
		System.out.println("ID CONTATTO TEST:" + dao.getContattoById(1).getIdContatto());
		
		dao.updateContatto(dao.getContattoById(1).getIdContatto(), c);
	
//XXX	STAMPA ELENCO CONTATTI
		ArrayList<Contatto> contatti = dao.getContatti();
		
		for (Contatto contatto : contatti) {
			System.out.println(contatto);
		}	
		
	}
}