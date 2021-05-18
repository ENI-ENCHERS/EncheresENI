package fr.eni.groupe4.encheres.dal;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnexionProvider {
	private static DataSource dataSource;
	
	static {
		try {
			//Lecture du XML et récupération de la ressource
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/enchere");
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
	
}
