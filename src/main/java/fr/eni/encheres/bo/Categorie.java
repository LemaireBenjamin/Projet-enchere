package fr.eni.encheres.bo;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author msonzia2023
 *
 */
public class Categorie {
	/**
	 * Attributes
	 */
	private Integer noCategorie;
	private String libelle;

	// association
	private List<ArticleVendu> listArticleVendus = new ArrayList<>();

	/**
	 * Constructeurs
	 */

	public Categorie() {
	}
	
	
	public Categorie(Integer noCategorie, String libelle) {
		this.noCategorie = noCategorie;
		this.libelle = libelle;
	}

	public Categorie(Integer noCategorie, String libelle, List<ArticleVendu> listArticleVendus) {
		this.noCategorie = noCategorie;
		this.libelle = libelle;
		this.listArticleVendus = listArticleVendus;
	}
	
	/**
	 * Getter et Setter
	 */

	public Integer getNoCategorie() {
		return noCategorie;
	}

	public String getLibelle() {
		return libelle;
	}

	public List<ArticleVendu> getListArticleVendus() {
		return listArticleVendus;
	}

	public void setNoCategorie(Integer noCategorie) {
		this.noCategorie = noCategorie;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public void setListArticleVendus(List<ArticleVendu> listArticleVendus) {
		this.listArticleVendus = listArticleVendus;
	}

	/**
	 * ToString
	 */

	@Override
	public String toString() {
		return "Categorie [noCategorie=" + noCategorie + ", libelle=" + libelle + ", listArticleVendus="
				+ listArticleVendus + "]";
	}
	
}
