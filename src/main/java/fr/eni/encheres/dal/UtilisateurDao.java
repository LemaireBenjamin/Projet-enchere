/**
 * Bertrand
 */
package fr.eni.encheres.dal;

import java.util.List;

public interface UtilisateurDao {
	//CRUD
	public List <Utilisateur> selectAll();
	
	public Utilisateur selectOne(int id);
	
	public void insert(Utilisateur utlisateur);
	
	public void update(Utilisateur utlisateur);

	public void deleteUtilisateur(int id);
}
