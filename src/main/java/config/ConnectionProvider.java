package config;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionProvider {
	
	private static DataSource datasource;

	static {
		try {
			Context context = new InitialContext();
			datasource = (DataSource) context.lookup("java:comp/env/jdbc/pool_cnx");
		} catch (NamingException e) {
			throw new RuntimeException("Accès à la base de donnée impossible !");
		}
			
	}
	
	/**
	 * Cette méthode retourne une connexion issue du pool de connection
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		return datasource.getConnection();
	}
}
