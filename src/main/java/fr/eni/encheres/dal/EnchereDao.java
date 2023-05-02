/**
 * Bertrand
 */
package fr.eni.encheres.dal;

import java.util.List;

public interface EnchereDao {
	//CRUD
	public List <Enchere> selectAll();
	
	public Enchere selectOne(int id);
	
	public void insert(Enchere enchere);

	public void update(Enchere enchere);

	public void deleteEnchere(int id);
}
