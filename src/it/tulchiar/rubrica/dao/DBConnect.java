package it.tulchiar.rubrica.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	public static Connection getConnection() {
		
		final String jdbcURL = "jdbc:mysql://localhost/rubrica?user=root&password=Chrmrc84a15";
		
		
//		try {
//			Class.forName("com.mysql.jbc.Driver");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//			throw new RuntimeException("Driver JDBC non trovato", e);
//		}
				
		try {
			Connection conn = DriverManager.getConnection(jdbcURL);
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Impossibile connettersi al database", e);
		}
		
	}
}
