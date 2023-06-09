package fr.eni.encheres.bo;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 
 * @author msonzia2023
 *
 */
public class Enchere {

	/**
	 * Attributes
	 */
	private LocalDate dateEnchere;
	private Integer montantEnchere;

	// Association
	private ArticleVendu articleVendu;
	private Utilisateur utilisateur;

	public Enchere() {}

	public Enchere(LocalDate dateEnchere) {
		this.dateEnchere = dateEnchere;
	}

	public Enchere(LocalDate dateEnchere, ArticleVendu articleVendu, Utilisateur utilisateur) {
		this.dateEnchere = dateEnchere;
		this.articleVendu = articleVendu;
		this.utilisateur = utilisateur;
	}
	
	
	public Enchere(LocalDate dateEnchere, Integer montantEnchere, ArticleVendu articleVendu, Utilisateur utilisateur) {
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
		this.articleVendu = articleVendu;
		this.utilisateur = utilisateur;
	}

	public Enchere(LocalDate dateEnchere, int montantEnchere) {
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
	}

	/**
	 * Getters & Setters
	 */

	public LocalDate getDateEnchere() {
		return dateEnchere;
	}

	public Integer getMontantEnchere() {
		return montantEnchere;
	}

	public ArticleVendu getArticleVendu() {
		return articleVendu;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setDateEnchere(LocalDate dateEnchere) {
		this.dateEnchere = dateEnchere;
	}

	public void setMontantEnchere(Integer montantEnchere) {
		this.montantEnchere = montantEnchere;
	}

	public void setArticleVendu(ArticleVendu articleVendu) {
		this.articleVendu = articleVendu;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	/**
	 * ToString
	 */

	@Override
	public String toString() {
		return "Enchere [dateEnchere=" + dateEnchere + ", montantEnchere=" + montantEnchere + ", articleVendu="
				+ articleVendu + ", utilisateur=" + utilisateur + "]";
	}

}
