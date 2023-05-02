package fr.eni.encheres.bo;

import java.util.ArrayList;
import java.util.List;

public class Categorie {
	/**
	 * Attributes
	 */
	private Integer noCategorie;
	private String libelle;

	// association
	private List<ArticleVendu> articles = new ArrayList<>();

	/**
	 * Constructeurs
	 */

	public Categorie() {
	}

	public Categorie(Integer noCategorie, String libelle, List<ArticleVendu> articles) {
		this.noCategorie = noCategorie;
		this.libelle = libelle;
		this.articles = articles;
	}

	public Categorie(String libelle, List<ArticleVendu> articles) {
		super();
		this.libelle = libelle;
		this.articles = articles;
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

	public List<ArticleVendu> getArticles() {
		return articles;
	}

	public void setNoCategorie(Integer noCategorie) {
		this.noCategorie = noCategorie;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public void setArticles(List<ArticleVendu> articles) {
		this.articles = articles;
	}

	

	@Override
	public String toString() {
		return "Categorie [noCategorie=" + noCategorie + ", libelle=" + libelle + "]";
	}

}
