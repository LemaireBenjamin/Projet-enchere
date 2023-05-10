package fr.eni.encheres.ihm.securite;
/**
 * @author msonzia2023
 * 
 */
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import fr.eni.encheres.bll.LoginManager;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DaoFactory;

//a supprimer peut etre? une redite de connexion?

@WebServlet("/mon-compte")
public class MonCompteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//on recupere la session
		HttpSession session= request.getSession();
		Utilisateur utilisateur= (Utilisateur) session.getAttribute("utilisateur");
		if (utilisateur==null) {
			response.sendRedirect(request.getContextPath()+"/connexion");
			return;
		}
		response.getWriter().append("test" +
		utilisateur.getNom() + " " + utilisateur.getPrenom());
		
	}	
}
