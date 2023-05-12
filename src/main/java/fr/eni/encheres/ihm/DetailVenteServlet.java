package fr.eni.encheres.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import fr.eni.encheres.bll.EnchereManager;
import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Utilisateur;

@WebServlet("/detail-vente/*")
public class DetailVenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] params = request.getPathInfo().split("/");
		int noArticle = Integer.parseInt(params[1]);

		Enchere enchere = EnchereManager.getInstance().getArticleByNoArticle(noArticle);
		
		if(enchere == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		request.setAttribute("enchere", enchere);
		
		request.getRequestDispatcher("/WEB-INF/jsp/detailVente.jsp").forward(request, response);
	}

	
}
