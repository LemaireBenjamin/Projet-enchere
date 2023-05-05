package fr.eni.encheres.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bll.exception.BllException;

@WebServlet("/profil")
public class MonProfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String[] params = request.getPathInfo().split("/");
//		int noUtilisateur = Integer.parseInt(params[1]);
		int noUtilisateur = 1;
		Utilisateur utilisateur = UtilisateurManager.getInstance().getUtilisateur(noUtilisateur);
		if(utilisateur == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		request.setAttribute("utilisateur", utilisateur);
		
		request.getRequestDispatcher("/WEB-INF/jsp/profil.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] params = request.getPathInfo().split("/");
		int noUtilisateur = Integer.parseInt(params[1]);
				
		response.sendRedirect(request.getContextPath()+"/modifier-profil/"+noUtilisateur);
	}
}
