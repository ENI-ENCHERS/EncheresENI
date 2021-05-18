package fr.eni.groupe4.encheres.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOUtil {
	
	public static Connection getConnexion() {
		Connection con = null;
		try {
			// charger le driver de la BDD
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			// établir la connexion 
			con=  DriverManager.getConnection("jdbc:sqlserver://localhost:1433;"
					+ "databasename=BDD_ENCHERES;user=sa;password=Pa$$w0rd"); 
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return con;
	}

}
