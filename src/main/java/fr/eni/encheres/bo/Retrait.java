package fr.eni.encheres.bo;

/**
 * 
 * @author msonzia2023
 *
 */
public class Retrait {
	/**
	 * Attributes
	 */

	private String rue;
	private String codePostal;
	private String ville;

	// Association
	private ArticleVendu articleVendu;

	/**
	 * Consrtucteurs
	 */
	public Retrait() {
	}

	
	
	
	public Retrait(String rue, String codePostal, String ville) {
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	public Retrait(String rue, String codePostal, String ville, ArticleVendu articleVendu) {
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.articleVendu = articleVendu;
	}

	/**
	 * Getter and setter
	 * 
	 * @return
	 */

	public String getRue() {
		return rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public String getVille() {
		return ville;
	}

	public ArticleVendu getArticleVendu() {
		return articleVendu;
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

	public void setArticleVendu(ArticleVendu articleVendu) {
		this.articleVendu = articleVendu;
	}

	/**
	 * ToString
	 */

	@Override
	public String toString() {
		return "Retrait [rue=" + rue + ", codePostal=" + codePostal + ", ville=" + ville + ", articleVendu="
				+ articleVendu + "]";
	}

}
