package fr.eni.encheres.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDate;

import org.apache.jasper.runtime.ProtectedFunctionMapper;
import org.eclipse.jdt.internal.compiler.lookup.TypeConstants.DangerousMethod;

import fr.eni.encheres.bll.ArticleManager;
import fr.eni.encheres.bll.CategorieManager;
import fr.eni.encheres.bll.exception.BllException;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.helpers.Flash;

@WebServlet("/nouvelle-vente")
public class NouvelleVenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/nouvelleVente.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Dans le POST");
		try {
			HttpSession session = request.getSession();
			System.out.println("Dans le TRY");
			String nomArticle = request.getParameter("nom-article");
			String description = request.getParameter("description");
			String cat = request.getParameter("categorie");
			String photoArticle = request.getParameter("photo-article");
			Integer miseAPrix = Integer.parseInt(request.getParameter("mise-a-prix"));
			LocalDate debutEnchere = LocalDate.parse(request.getParameter("debut-enchere"));
			LocalDate finEnchere = LocalDate.parse(request.getParameter("fin-enchere"));
			String etatVente = "CR";
			
			System.out.println("Avant CATEGORIE");
			
			Categorie categorie = CategorieManager.getInstance().getOneCategorie(cat);
			Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
			System.out.println(utilisateur);
			System.out.println(categorie);
			System.out.println("Avant ARTICLE VENDU");
			
			ArticleVendu articlevendu = new ArticleVendu(nomArticle, description, debutEnchere, finEnchere, miseAPrix, miseAPrix, utilisateur, categorie, etatVente);
			System.out.println(articlevendu);
			
			ArticleManager.getInstance().addArticle(articlevendu);
				
			if(articlevendu.getNoArticle()>0) {
				Flash.send("SUCCESS", "Votre article à bien été crée", request.getSession());
				response.sendRedirect(request.getContextPath());
			}
			
		} catch (BllException e) {
			request.setAttribute("erreurs", e.getErreurs());
			doGet(request, response);
			e.printStackTrace();
		}
	}

}
