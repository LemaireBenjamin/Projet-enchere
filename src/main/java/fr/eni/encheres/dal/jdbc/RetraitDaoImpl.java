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

import bo.Article;
import config.ConnectionProvider;
import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.dal.RetraitDao;

public class RetraitDaoImpl implements RetraitDao {
	
	private final static String SELECT_ALL_RETRAIT = "SELECT * FROM retraits";
	private final static String SELECT_ONE_RETRAIT = "SELECT * FROM retraits WHERE id = ?";
	private final static String UPDATE_RETRAITE = "UPDATE retraits SET title = ?, content = ?, author = ? WHERE id = ?";
	private final static String INSERT_RETRAIT = "INSERT INTO retraits (title, content, author, date_creation, is_published) VALUES (?,?,?,?,?)";
	private final static String DELETE_RETRAIT = "DELETE FROM retraits WHERE id = ?";

	@Override
	public List<Retrait> selectAll() {
		try (Connection connection = ConnectionProvider.getConnection();){
			List<Retrait> retraits = new ArrayList<>();
			
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_ALL_RETRAIT);
			
			while(rs.next()) {
				retraits.add(new Retrait(rs.getInt("no_article"),
						rs.getString("rue"),
						rs.getString("code_postal"),
						rs.getString("ville"));
			}
			return retraits;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Retrait selectOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Retrait retrait) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Retrait retrait) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteRetrait(int id) {
		// TODO Auto-generated method stub
		
	}

}
