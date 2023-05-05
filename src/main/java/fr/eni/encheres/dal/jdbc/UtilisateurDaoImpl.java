/**
 * Bertrand
 */
package fr.eni.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import config.ConnectionProvider;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.UtilisateurDao;

public class UtilisateurDaoImpl implements UtilisateurDao {
	
	private static final String INSERT_USER = "INSERT INTO utilisateurs"
											+ "(pseudo,"
											+ "nom,"
											+ "prenom,"
											+ "email,"
											+ "telephone,"
											+ "rue,"
											+ "code_postal,"
											+ "ville,"
											+ "mot_de_passe,"
											+ "credit,"
											+ "administrateur)"
											+ "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	
	private final static String SELECT_ALL = "SELECT * FROM utilisateurs";
	private final static String SELECT_BY_ID = "SELECT * FROM utilisateurs WHERE no_utilisateur = ?";
	private final static String SELECT_BY_PSEUDO = "SELECT * FROM utilisateurs WHERE pseudo = ?";
	private final static String SELECT_FOR_CONNEXION = "SELECT * FROM utilisateurs WHERE mot_de_passe = ? AND (pseudo = ? OR email = ?) ";	
	private final static String SELECT_BY_LOGIN = "SELECT * FROM utilisateurs WHERE pseudo = ? OR email = ?";	
	
	private final static String UPDATE = """
				UPDATE utilisateurs 
				SET pseudo = ?, nom = ?,prenom = ?, email = ?, telephone = ?,rue = ?,code_postal = ?,ville = ?,mot_de_passe = ?
				WHERE no_utilisateur = ?;
			""";
	
	private final static String DELETE = "DELETE FROM utilisateurs WHERE no_utilisateur = ?";
	
		
	@Override
	public List<Utilisateur> selectAll() {
		try (Connection connection = ConnectionProvider.getConnection();){
			List<Utilisateur> utilisateurs = new ArrayList<>();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_ALL);
			
			while(rs.next()) {
				utilisateurs.add(new Utilisateur (rs.getInt("no_utilisateur"),
						rs.getString("pseudo"),
						rs.getString("nom"),
						rs.getString("prenom"),
						rs.getString("email"),
						rs.getString("telephone"),
						rs.getString("rue"),
						rs.getString("code_postal"),
						rs.getString("ville"),
						rs.getString("mot_de_passe"),
						rs.getInt("credit"),
						rs.getBoolean("administrateur")));
			}
			return utilisateurs;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	} 

	@Override
	public Utilisateur selectById(int no_utilisateur) {
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement pStmt = connection.prepareStatement(SELECT_BY_ID);
			pStmt.setInt(1, no_utilisateur);
			ResultSet rs = pStmt.executeQuery();
			if(rs.next())
				return new Utilisateur (rs.getInt("no_utilisateur"),
						rs.getString("pseudo"),
						rs.getString("nom"),
						rs.getString("prenom"),
						rs.getString("email"),
						rs.getString("telephone"),
						rs.getString("rue"),
						rs.getString("code_postal"),
						rs.getString("ville"),
						rs.getString("mot_de_passe"),
						rs.getInt("credit"),
						rs.getBoolean("administrateur"));
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Utilisateur selectByPseudo(String pseudo) {
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement pStmt = connection.prepareStatement(SELECT_BY_PSEUDO);
			pStmt.setString(1, pseudo);
			ResultSet rs = pStmt.executeQuery();
			if(rs.next())
				return new Utilisateur (rs.getInt("no_utilisateur"),
						rs.getString("pseudo"),
						rs.getString("nom"),
						rs.getString("prenom"),
						rs.getString("email"),
						rs.getString("telephone"),
						rs.getString("rue"),
						rs.getString("code_postal"),
						rs.getString("ville"),
						rs.getString("mot_de_passe"),
						rs.getInt("credit"),
						rs.getBoolean("administrateur"));
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Utilisateur selectForConnexion(String identifiant, String motDePasse) {
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement pStmt = connection.prepareStatement(SELECT_FOR_CONNEXION);
			pStmt.setString(1, motDePasse);
			pStmt.setString(2, identifiant);
			pStmt.setString(3, identifiant);
			ResultSet rs = pStmt.executeQuery();
			if(rs.next())
				return new Utilisateur (rs.getInt("no_utilisateur"),
						rs.getString("pseudo"),
						rs.getString("nom"),
						rs.getString("prenom"),
						rs.getString("email"),
						rs.getString("telephone"),
						rs.getString("rue"),
						rs.getString("code_postal"),
						rs.getString("ville"),
						rs.getString("mot_de_passe"),
						rs.getInt("credit"),
						rs.getBoolean("administrateur"));
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Utilisateur selectByLogin(String login) {
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement pStmt = connection.prepareStatement(SELECT_BY_LOGIN);
			pStmt.setString(1, login);
			pStmt.setString(2, login);
			ResultSet rs = pStmt.executeQuery();
			if(rs.next())
				return new Utilisateur (rs.getInt("no_utilisateur"),
						rs.getString("pseudo"),
						rs.getString("nom"),
						rs.getString("prenom"),
						rs.getString("email"),
						rs.getString("telephone"),
						rs.getString("rue"),
						rs.getString("code_postal"),
						rs.getString("ville"),
						rs.getString("mot_de_passe"),
						rs.getInt("credit"),
						rs.getBoolean("administrateur"));
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public void insert(Utilisateur utilisateur) {
			System.out.println("avant le try");
		try (Connection connection = ConnectionProvider.getConnection()) {
			System.out.println("dans le try");
			PreparedStatement pStmt = connection.prepareStatement(INSERT_USER, PreparedStatement.RETURN_GENERATED_KEYS);
			pStmt.setString(1, utilisateur.getPseudo());
			pStmt.setString(2, utilisateur.getNom());
			pStmt.setString(3, utilisateur.getPrenom());
			pStmt.setString(4, utilisateur.getEmail());
			pStmt.setString(5, utilisateur.getTelephone());
			pStmt.setString(6, utilisateur.getRue());
			pStmt.setString(7, utilisateur.getCodePostal());
			pStmt.setString(8, utilisateur.getVille());
			pStmt.setString(9, utilisateur.getMotDePasse());
			pStmt.setInt(10, utilisateur.getCredit());
			pStmt.setBoolean(11, utilisateur.isAdministrateur());
			pStmt.executeUpdate();
			ResultSet rs = pStmt.getGeneratedKeys();
			if(rs.next()) {
				utilisateur.setNoUtilisateur(rs.getInt(1)); // pour la redirection
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	@Override
	public void update(Utilisateur utilisateur) {
		try (Connection connection = ConnectionProvider.getConnection()){
			PreparedStatement stmt = connection.prepareStatement(UPDATE);
			stmt.setString(1, utilisateur.getPseudo());	
			stmt.setString(2, utilisateur.getNom());	
			stmt.setString(3, utilisateur.getPrenom());	
			stmt.setString(4, utilisateur.getEmail());	
			stmt.setString(5, utilisateur.getTelephone());	
			stmt.setString(6, utilisateur.getRue());	
			stmt.setString(7, utilisateur.getCodePostal());	
			stmt.setString(8, utilisateur.getVille());	
			stmt.setString(9, utilisateur.getMotDePasse());		
			stmt.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();//Lever DAL Exception
			}
		}

	@Override
	public void delete(int no_utilisateur) {
		try (Connection connection = ConnectionProvider.getConnection();){
			
			PreparedStatement stmt = connection.prepareStatement(DELETE);
			stmt.setInt(1, no_utilisateur);
			stmt.executeUpdate();
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	

	

}
