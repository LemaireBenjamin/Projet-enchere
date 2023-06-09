package fr.eni.encheres.dal;
import java.util.List;
import fr.eni.encheres.bo.Categorie;


/**
 * @author bertrand et marie-audrey
 */
public interface CategorieDao {
	//CRUD
	public List <Categorie> selectAll();
	
	public void insert(Categorie categorie);
	
	public void update(Categorie categorie);

	public void deleteCategorie(int id);

	Categorie selectById(int id);

	Categorie selectLibelle(String libel);
}
