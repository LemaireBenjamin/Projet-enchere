package fr.eni.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import config.ConnectionProvider;
import fr.eni.encheres.bll.exception.BllException;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.dal.CategorieDao;

/**
 * 
 * @author betrand
 *
 */
public class CategorieDaoImpl implements CategorieDao {

	
	private final static String SELECT_ALL = "SELECT * FROM  categories";
	private final static String SELECT_ONE_CATEGORIE = "SELECT * FROM categories WHERE no_categorie = ?";
	private final static String SELECT_LIBELLE = "SELECT * from CATEGORIES where libelle = ?;";

	

	@Override
	public List<Categorie> selectAll() {

		try (Connection cnx = ConnectionProvider.getConnection()) {
			List<Categorie> categories = new ArrayList<>();

			Statement stm = cnx.createStatement();
			ResultSet rs = stm.executeQuery(SELECT_ALL);
			while (rs.next()) {
				categories.add(new Categorie(

						rs.getInt("no_categorie"), rs.getString("libelle")));
			}
			return categories;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Categorie selectById(int id) {

		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstm = cnx.prepareStatement(SELECT_ONE_CATEGORIE);
			pstm.setInt(1, id);

			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				return new Categorie(rs.getInt("no_categorie"), rs.getString("libelle"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Categorie selectLibelle(String libelle) {

		try (Connection cnx = ConnectionProvider.getConnection()) {
			
			PreparedStatement pstm = cnx.prepareStatement(SELECT_LIBELLE);
			pstm.setString(1, libelle);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				return new Categorie(rs.getInt("no_categorie"), rs.getString("libelle"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void insert(Categorie categorie) {

		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstm = cnx.prepareStatement("INSERT INTO categories (libelle) VALUES ? ;",
					PreparedStatement.RETURN_GENERATED_KEYS);
			pstm.setString(1, categorie.getLibelle());
			pstm.executeUpdate();
			
			ResultSet rs = pstm.getGeneratedKeys();
			if (rs.next()) {
				categorie.setNoCategorie(rs.getInt(1));
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

	@Override
	public void update(Categorie categorie) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteCategorie(int id) {
		// TODO Auto-generated method stub

	}

}
