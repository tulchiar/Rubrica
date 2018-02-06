package it.tulchiar.rubrica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import it.tulchiar.rubrica.bean.Contatto;

public class ContattiDAO {
	
	public ArrayList<Contatto> getContatti() {
		
		Connection conn = DBConnect.getConnection();
		
		String sql = "SELECT * FROM rubrica.contatti"
				+ " WHERE `cancellato` != '1';";
		
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			
			ResultSet rs = st.executeQuery();
			
			ArrayList<Contatto> contatti = new ArrayList<Contatto>();			
			
			while(rs.next()) {
				
				Contatto c = new Contatto();
				
				c.setIdContatto(rs.getInt("idContatto"));
				c.setNome(rs.getString("nome"));
				c.setCognome(rs.getString("cognome"));
				c.setTelefono(rs.getString("telefono"));
				c.setFax(rs.getString("fax"));
				c.setCellulare(rs.getString("cellulare"));
				c.setEmail(rs.getString("email"));
				c.setPec(rs.getString("pec"));
				c.setPasswordPec(rs.getString("passwordPec"));
				c.setNote(rs.getString("note"));
				
				contatti.add(c);
		} 
			
			conn.close();
			return contatti;
			
		} catch (SQLException e) {		
			e.printStackTrace();
			throw new RuntimeException("Errore nell'ottenimento dei contatti", e);
		}
	
		
	}

	public Contatto getContattoById(Integer idContatto) {
		
		Connection conn = DBConnect.getConnection();
		
		String sql = "SELECT * FROM rubrica.contatti"
				+ " WHERE `idContatto` = ?;";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, idContatto);
			
			ResultSet rs = ps.executeQuery();
			
			Contatto c = new Contatto();
			
			while (rs.next()) {
				c.setIdContatto(idContatto);
				c.setNome(rs.getString("nome"));
				c.setCognome(rs.getString("cognome"));
			}
			
			return c;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Errore recupero contatto byId", e);
		}
		
	}
	
	
	public boolean insertContatto(Contatto contatto) {
		
			Connection conn = DBConnect.getConnection();
			
			String sql = "INSERT INTO `rubrica`.`contatti`" + 
					"(`nome`," + 
					"`cognome`," + 
					"`telefono`," + 
					"`fax`," + 
					"`cellulare`," + 
					"`email`," + 
					"`pec`," + 
					"`passwordPec`," + 
					"`note`)" + 
					"VALUES" + 
					"(?,?,?,?,?,?,?,?,?);";	
			
			int result = 0;
			
			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				
				ps.setString(1, contatto.getNome());
				ps.setString(2, contatto.getCognome());
				ps.setString(3, contatto.getTelefono());
				ps.setString(4, contatto.getFax());
				ps.setString(5, contatto.getCellulare());
				ps.setString(6, contatto.getEmail());
				ps.setString(7, contatto.getPec());
				ps.setString(8, contatto.getPasswordPec());
				ps.setString(9, contatto.getNote());
				
				result = ps.executeUpdate();
				conn.close();	
				
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("Errore inserimento contatto", e);
			} 	
	
			if(result > 0) {
				return true;
			} else {
				return false;
			}	
	}			

	// TODO - SISTEMARE
	public boolean updateContatto(Integer idContatto, Contatto contatto) {
		
		Connection conn = DBConnect.getConnection();
		
		String sql = "UPDATE `rubrica`.`contatti`" + 
				"SET" + 
				"`nome` = ? ," + 
				"`cognome` = ? ," + 
				"`telefono` = ? ," + 
				"`fax` = ? ," + 
				"`cellulare` = ? ," + 
				"`email` = ? ," + 
				"`pec` = ? ," + 
				"`passwordPec` = ? ," + 
				"`note` = ? " + 
				"WHERE `idcontatto` = ?;";
		
		int result = 0;
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			if(contatto.getNome() != null) {
				System.out.println("NOME: " + contatto.getNome());
				ps.setString(1, contatto.getNome());
			} else {
				throw new RuntimeException("Nome non può essere null.");
			}
			
			if(contatto.getCognome() != null) {
				ps.setString(2, contatto.getCognome());
			} else {
				throw new RuntimeException("Cognome no può essere null.");
			}
			
			if(contatto.getTelefono() != null) {
				ps.setString(3, contatto.getTelefono());
			} else {
				ps.setNull(3, java.sql.Types.NULL);
			}

			if(contatto.getFax() != null) {
				ps.setString(4, contatto.getFax());
			} else {
				ps.setNull(4, java.sql.Types.NULL);
			}

			if(contatto.getCellulare() != null) {
				ps.setString(5, contatto.getCellulare());
			} else {
				ps.setNull(5, java.sql.Types.NULL);
			}

			if(contatto.getEmail() != null) {
				ps.setString(6, contatto.getEmail());
			} else {
				ps.setNull(6, java.sql.Types.NULL);
			}

			if(contatto.getPec() != null) {
				ps.setString(7, contatto.getPec());
			} else {
				ps.setNull(7, java.sql.Types.NULL);
			}

			if(contatto.getPasswordPec() != null) {
				ps.setString(8, contatto.getPasswordPec());
			} else {
				ps.setNull(8, java.sql.Types.NULL);
			}
			
			if(contatto.getNote() != null) {
				ps.setString(9, contatto.getNote());
			} else {
				ps.setNull(9, java.sql.Types.NULL);
			}
			
//TODO 		FINIRE DI SISTEMARE	
			
			System.out.println("ID CONTATTO: " + idContatto);
			
			ps.setInt(10, idContatto);
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Errore nell'aggiornamento del contatto", e);
		}
		
		if(result > 0) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public boolean deleteContatto(Contatto contatto) {
		
		Connection conn = DBConnect.getConnection();
		
		String sql = "UPDATE `rubrica`.`contatti`" + 
				" SET" + 
				" `cancellato` = '1' " + 
				" WHERE `idcontatto` = ?;";
		
		int result = 0;
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, contatto.getIdContatto());
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Errore nell'aggiornamento del contatto", e);
		}
		
		if(result > 0) {
			return true;
		} else {
			return false;
		}
		
	}
}
//
//SELECT * FROM rubrica.contatti;SELECT `contatti`.`idcontatto`,
//`contatti`.`nome`,
//`contatti`.`cognome`,
//`contatti`.`telefono`,
//`contatti`.`fax`,
//`contatti`.`cellulare`,
//`contatti`.`email`,
//`contatti`.`pec`,
//`contatti`.`passwordPec`,
//`contatti`.`note`
//FROM `rubrica`.`contatti`;
//
//
//1	Marco	Chiarello	0557957027	0557957050	3490773441	tulchiar@gmail.com			Marito
//2	Carlotta	Fratoni	0574483138	0574405571	3283730569	carlottafratoni@gmail.com			Moglie
//									