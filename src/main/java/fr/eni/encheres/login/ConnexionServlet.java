package fr.eni.encheres.login;

/**
 * @author msonzia2023
 * @Bertrand
 */
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import fr.eni.encheres.bll.LoginManager;
import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bll.exception.BllException;
import fr.eni.encheres.bo.Utilisateur;

@WebServlet("/connexion")
public class ConnexionServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private final static int WEEK = 60 * 60 * 24 * 7;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		/**
		 * Creation du cookie
		 */
		Cookie cookie = new Cookie("prenom", "cookieProjetEnchere");
		// duree de vie en seconde
		cookie.setMaxAge(WEEK);
		response.addCookie(cookie);
		//pour afficher
		//response.getWriter().write("test cookie");
		
		/**
		 * Lecture du cookie il retourne un tableau de cookie
		 */
		Cookie[] cookies = request.getCookies();
		
		
		request.getRequestDispatcher("/WEB-INF/jsp/connexion.jsp").forward(request, response);
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String utilisateurNom = request.getParameter("login");
			String motDePasse = request.getParameter("password");
			//ouvrir une session si utilisateur existe
			Utilisateur utilisateur = UtilisateurManager.getInstance().getUtilisateurByConnexion(utilisateurNom, motDePasse);
			if(utilisateur == null) {
				response.sendError(HttpServletResponse.SC_NOT_FOUND);
				return;
			}
		
			// Creation session
			HttpSession session = request.getSession();
			session.setAttribute("utilisateur", utilisateur);
			response.sendRedirect(request.getContextPath());
		} catch (Exception e) { // Ici BLLEXCEPTion? Mais creee une erreur et je ne peux pas propager)
			e.printStackTrace();
		}
		

	}
}
