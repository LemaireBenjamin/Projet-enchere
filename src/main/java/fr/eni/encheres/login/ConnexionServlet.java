package fr.eni.encheres.login;
/**
 * @author msonzia2023
 * @Bertrand
 */
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import fr.eni.encheres.bll.LoginManager;
import fr.eni.encheres.bll.exception.BllException;
import fr.eni.encheres.bo.Utilisateur;

@WebServlet("/connexion")
public class ConnexionServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/connexion.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	
		String utilisateurNom = request.getParameter("login");
		String motDePasse = request.getParameter("password");
		Utilisateur utilisateur= new Utilisateur(utilisateurNom, motDePasse);
		// Creation session
		HttpSession session= request.getSession();
		session.setAttribute("utilisateur", session);
		response.sendRedirect(request.getContextPath());
		
		LoginManager.getInstance().Login(utilisateurNom, motDePasse);
	
	}
}
