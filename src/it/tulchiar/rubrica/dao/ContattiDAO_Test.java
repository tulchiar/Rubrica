package it.tulchiar.rubrica.dao;

import java.util.ArrayList;

import it.tulchiar.rubrica.bean.Contatto;



public class ContattiDAO_Test {

	
	
	public static void main(String[] args) {
				
		ContattiDAO dao = new ContattiDAO();
		
//		dao.insertContatto(new Contatto("Rolanda","Michelagnoli"));
		
		Contatto contattoDaCancellare = new Contatto(4);
		
		dao.deleteContatto(contattoDaCancellare);
		
//		
//		Contatto c = dao.getContattoById(1);
//		
//		System.out.println(c);
//		
		ArrayList<Contatto> contatti = dao.getContatti();
		
		for (Contatto contatto : contatti) {
			System.out.println(contatto);
		}
		
		
		
	

	}



}