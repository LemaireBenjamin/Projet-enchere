package fr.eni.encheres.bo;

import java.time.LocalDate;

public class Enchere {

	/**
	 * Attributes
	 */
	private LocalDate dateEnchere;
	private Integer montantEnchere;

	// Association
	private ArticleVendu articleVendu;

	/**
	 * Constructeurs
	 */
	public Enchere() {
	}

	public Enchere(LocalDate dateEnchere, Integer montantEnchere) {

		this.dateEnchere = LocalDate.now();
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

	public void setDateEnchere(LocalDate dateEnchere) {
		this.dateEnchere = dateEnchere;
	}

	public void setMontantEnchere(Integer montantEnchere) {
		this.montantEnchere = montantEnchere;
	}

	public void setArticleVendu(ArticleVendu articleVendu) {
		this.articleVendu = articleVendu;
	}

	/**
	 * ToString
	 */
	@Override
	public String toString() {
		return "Enchere [dateEnchere=" + dateEnchere + ", montantEnchere=" + montantEnchere + ", articleVendu="
				+ articleVendu + "]";
	}

}
