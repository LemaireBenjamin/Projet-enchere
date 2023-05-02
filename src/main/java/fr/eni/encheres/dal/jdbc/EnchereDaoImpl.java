/**
 * Bertrand
 */
package fr.eni.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import config.ConnectionProvider;
import fr.eni.encheres.dal.EnchereDao;

public class EnchereDaoImpl implements EnchereDao {
	
	private final static String SELECT_ALL_ENCHERE = "SELECT * FROM encheres";

	@Override
	public List<Enchere> selectAll() {
		try (Connection connection = ConnectionProvider.getConnection();){
			List<Enchere> encheres = new ArrayList<>();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_ALL_ENCHERE);
			
			while(rs.next()) {
				//TODO modifer les getString en fonction des class crées par Marie.
				encheres.add(new Enchere (rs.getInt("id"),
						rs.getString("title"),
						rs.getString("content"),
						rs.getString("author"),
						rs.getDate("date_creation").toLocalDate(),
						rs.getBoolean("is_published")));
			}
			return encheres;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	

	@Override
	public Enchere selectOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Enchere enchere) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Enchere enchere) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEnchere(int id) {
		// TODO Auto-generated method stub
		
	}

	
}
