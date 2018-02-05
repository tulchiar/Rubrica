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
	public boolean updateContatto(Contatto contatto) {
		
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
			
			ps.setString(1, contatto.getNome());
			ps.setString(2, contatto.getCognome());
			ps.setString(3, contatto.getTelefono());
			ps.setString(4, contatto.getFax());
			ps.setString(5, contatto.getCellulare());
			ps.setString(6, contatto.getEmail());
			ps.setString(7, contatto.getPec());
			ps.setString(8, contatto.getPasswordPec());
			ps.setString(9, contatto.getNote());
			ps.setInt(10, contatto.getIdContatto());
			
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