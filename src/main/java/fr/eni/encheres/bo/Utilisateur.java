package fr.eni.encheres.bo;

/**
 * @author msonzia2023
 */
import java.util.ArrayList;
import java.util.List;

public class Utilisateur {

	/**
	 * Attributes
	 */
	private Integer noUtilisateur;
	private String pseudo;
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	private String rue;
	private String codePostal;
	private String ville;
	private String motDePasse;
	private Integer credit;
	private boolean administrateur;

	// association
	private List<Enchere> listEncheres = new ArrayList<>();
	private List<ArticleVendu> listVentes = new ArrayList<>();
	private List<ArticleVendu> listAchats = new ArrayList<>();

	/**
	 * Constructeurs
	 */

	public Utilisateur() {}
	
	

	public Utilisateur(Integer noUtilisateur, String pseudo) {
		this();
		this.noUtilisateur = noUtilisateur;
		this.pseudo = pseudo;
	}
	
	public Utilisateur(Integer noUtilisateur, String pseudo, Integer credit) {
		this();
		this.noUtilisateur = noUtilisateur;
		this.pseudo = pseudo;
		this.credit = credit;
	}


	public Utilisateur(String pseudo, String email) {
		this();
		this.pseudo = pseudo;
		this.email = email;
	}
	
	public Utilisateur(String pseudo, String nom, String prenom, String email, String telephone, String rue,
			String codePostal, String ville, String motDePasse, Integer credit, boolean administrateur) {
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.motDePasse = motDePasse;
		this.credit = credit;
		this.administrateur = administrateur;
	}
	
	public Utilisateur(Integer noUtilisateur, String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, String motDePasse, Integer credit, boolean administrateur) {
		this(pseudo,nom,prenom,email,
			telephone,rue,codePostal,ville,motDePasse,credit,administrateur);	
		this.noUtilisateur = noUtilisateur;

	}

	
	
	public Utilisateur(String pseudo, String nom, String prenom, String email, String telephone, String rue,
			String codePostal, String ville,String motDePasse) {
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.motDePasse = motDePasse;
	}
	/**
	 * Getter et Setter
	 */

	public  Integer getNoUtilisateur() {
		return noUtilisateur;
	}

	public String getPseudo() {
		return pseudo;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getEmail() {
		return email;
	}

	public String getTelephone() {
		return telephone;
	}

	public String getRue() {
		return rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public String getVille() {
		return ville;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public Integer getCredit() {
		return credit;
	}

	public boolean isAdministrateur() {
		return administrateur;
	}

	public List<Enchere> getListEncheres() {
		return listEncheres;
	}

	public List<ArticleVendu> getListVentes() {
		return listVentes;
	}

	public List<ArticleVendu> getListAchats() {
		return listAchats;
	}

	public void setNoUtilisateur(Integer noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public void setCredit(Integer credit) {
		this.credit = credit;
	}

	public void setAdministrateur(boolean administrateur) {
		this.administrateur = administrateur;
	}

	public void setListEncheres(List<Enchere> listEncheres) {
		this.listEncheres = listEncheres;
	}

	public void setListVentes(List<ArticleVendu> listVentes) {
		this.listVentes = listVentes;
	}

	public void setListAchats(List<ArticleVendu> listAchats) {
		this.listAchats = listAchats;
	}

	/**
	 * TOString
	 */

	@Override
	public String toString() {
		return "Utilisateur [noUtilisateur=" + noUtilisateur + ", pseudo=" + pseudo + ", nom=" + nom + ", prenom="
				+ prenom + ", email=" + email + ", telephone=" + telephone + ", rue=" + rue + ", codePostal="
				+ codePostal + ", ville=" + ville + ", motDePasse=" + motDePasse + ", credit=" + credit
				+ ", administrateur=" + administrateur + "]";
	}

}
