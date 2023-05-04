package fr.eni.encheres.login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import fr.eni.encheres.bll.LoginManager;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.helpers.Flash;

@WebServlet("/inscription")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomUtilisateur = request.getParameter("nomUtilisateur");
		String motDePasse = request.getParameter("motDePasse");
		
		Utilisateur utilisateur = new Utilisateur(nomUtilisateur, motDePasse) ;	
		
		//
		LoginManager.getInstance().addUtilisateur(utilisateur);		
		
		Flash.send("success", "Votre compte a bien été créé", request.getSession());
		response.sendRedirect(request.getContextPath()+"/connexion");
	}
	

}
