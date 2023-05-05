/**
 * Bertrand
 */
package fr.eni.encheres.dal;

import java.util.List;

import fr.eni.encheres.bo.Enchere;

public interface EnchereDao {
	//CRUD
	public List <Enchere> selectAll();
	
	public List<Enchere> selectEncheresEC(String etatEnchere);
	
	public Enchere selectOne(int id);
	
	public void insert(Enchere enchere);

	public void update(Enchere enchere);

	public void deleteEnchere(int id);
}
