/**
 * Bertrand
 */
package fr.eni.encheres.dal;

import java.util.List;

public interface CategorieDao {
	//CRUD
	public List <Categorie> selectAll();
	
	public Categorie selectOne(int id);
	
	public void insert(Categorie categorie);
	
	public void update(Categorie categorie);

	public void deleteCategorie(int id);
}
