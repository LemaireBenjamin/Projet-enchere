package fr.eni.encheres.dal;

import java.util.List;

import fr.eni.encheres.bo.Retrait;

/**
 * 
 * @author bertrand
 *
 */
public interface RetraitDao {
	//CRUD
	public List <Retrait> selectAll();
	
	public Retrait selectOne(int id);
	
	public void insert(Retrait retrait);
	
	public void update(Retrait retrait);

	public void deleteRetrait(int id);
}
