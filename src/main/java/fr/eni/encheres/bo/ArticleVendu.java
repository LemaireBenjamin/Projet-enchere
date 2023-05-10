package fr.eni.encheres.bo;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author msonzia2023
 *
 */
public class ArticleVendu {

	/**
	 * Attributes
	 */
	private Integer noArticle;
	private String nomArticle;
	private String description;
	private LocalDate dateDebutEncheres;
	private LocalDate dateFinEncheres;
	private Integer prixInitial;
	private Integer prixVente;

	private String etatVente;

	// Association
	private Categorie categorieArticle;
	private Utilisateur utilisateur;
	private Retrait lieuRetrait;

	private List<Enchere> listEncheres = new ArrayList<>();

	/**
	 * Constructeurs
	 */

	public ArticleVendu() {
	}

	public ArticleVendu(Integer noArticle, String nomArticle, Integer prixVente) {
		super();
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.prixVente = prixVente;
	}




	public ArticleVendu(String nomArticle, String description, LocalDate dateDebutEncheres, LocalDate dateFinEncheres,
			Integer prixInitial, Integer prixVente, Utilisateur utilisateur, Categorie categorie) {
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.prixInitial = prixInitial;
		this.prixVente = prixVente;

	}
	
	public ArticleVendu(String nomArticle, String description, LocalDate dateDebutEncheres, LocalDate dateFinEncheres,
			Integer prixInitial, Integer prixVente, Utilisateur utilisateur, Categorie categorie, String etatVente) {
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.prixInitial = prixInitial;
		this.prixVente = prixVente;

	}

	public ArticleVendu(Integer noArticle, String nomArticle, String description, LocalDate dateDebutEncheres,
			LocalDate dateFinEncheres, Integer prixInitial, Integer prixVente, Integer noUtilisateur,
			Integer noCategorie) {
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.prixInitial = prixInitial;
		this.prixVente = prixVente;

	}

	public ArticleVendu(String nomArticle, String description, LocalDate dateDebutEncheres, LocalDate dateFinEncheres,
			Integer prixInitial, Integer prixVente, String etatVente, Categorie categorieArticle,
			Utilisateur utilisateur, Retrait lieuRetrait, List<Enchere> listEncheres) {
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.prixInitial = prixInitial;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
		this.categorieArticle = categorieArticle;
		this.utilisateur = utilisateur;
		this.lieuRetrait = lieuRetrait;
		this.listEncheres = listEncheres;
	}

	
	public ArticleVendu(Integer noArticle, String nomArticle, String description, Date dateDebutEncheres, Date dateFinEncheres, Integer prixInitial, Integer prixVente,
			String etatVente) {
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = this.dateDebutEncheres;
		this.dateFinEncheres = this.dateFinEncheres;
		this.prixInitial = prixInitial;
		this.prixVente = prixVente;
		this.etatVente = etatVente;

	}

	/**
	 * Getter and Setter
	 */

	public Integer getNoArticle() {
		return noArticle;
	}

	public String getNomArticle() {
		return nomArticle;
	}

	public String getDescription() {
		return description;
	}

	public LocalDate getDateDebutEncheres() {
		return dateDebutEncheres;
	}

	public LocalDate getDateFinEncheres() {
		return dateFinEncheres;
	}

	public Integer getPrixInitial() {
		return prixInitial;
	}

	public Integer getPrixVente() {
		return prixVente;
	}

	public String getEtatVente() {
		return etatVente;
	}

	public Categorie getCategorieArticle() {
		return categorieArticle;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public Retrait getLieuRetrait() {
		return lieuRetrait;
	}

	public List<Enchere> getListEncheres() {
		return listEncheres;
	}

	public void setNoArticle(Integer noArticle) {
		this.noArticle = noArticle;
	}

	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDateDebutEncheres(LocalDate dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}

	public void setDateFinEncheres(LocalDate dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}

	public void setPrixInitial(Integer prixInitial) {
		this.prixInitial = prixInitial;
	}

	public void setPrixVente(Integer prixVente) {
		this.prixVente = prixVente;
	}

	public void setEtatVente(String etatVente) {
		this.etatVente = etatVente;
	}

	public void setCategorieArticle(Categorie categorieArticle) {
		this.categorieArticle = categorieArticle;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public void setLieuRetrait(Retrait lieuRetrait) {
		this.lieuRetrait = lieuRetrait;
	}

	public void setListEncheres(List<Enchere> listEncheres) {
		this.listEncheres = listEncheres;
	}

	/**
	 * ToString
	 */

	@Override
	public String toString() {
		return "ArticleVendu [noArticle=" + noArticle + ", nomArticle=" + nomArticle + ", description=" + description
				+ ", dateDebutEncheres=" + dateDebutEncheres + ", dateFinEncheres=" + dateFinEncheres + ", prixInitial="
				+ prixInitial + ", prixVente=" + prixVente + ", etatVente=" + etatVente + ", categorieArticle="
				+ categorieArticle + ", utilisateur=" + utilisateur + ", lieuRetrait=" + lieuRetrait + ", listEncheres="
				+ listEncheres + "]";
	}

}
