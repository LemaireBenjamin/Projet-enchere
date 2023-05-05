package fr.eni.encheres.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bll.exception.BllException;
import fr.eni.encheres.bo.Utilisateur;

@WebServlet("/modifier-profil/*")
public class ModifierProfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] params = request.getPathInfo().split("/");
		int noUtilisateur = Integer.parseInt(params[1]);

		Utilisateur utilisateur = UtilisateurManager.getInstance().getUtilisateur(noUtilisateur);
		if(utilisateur == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		request.setAttribute("utilisateur", utilisateur);
		
		request.getRequestDispatcher("/WEB-INF/jsp/modifierProfil.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String[] params = request.getPathInfo().split("/");
			int noUtilisateur = Integer.parseInt(params[1]);
			
			String pseudo = request.getParameter("pseudo");
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String email = request.getParameter("email");
			String telephone = request.getParameter("telephone");
			String rue = request.getParameter("rue");
			String codePostal = request.getParameter("codePostal");
			String ville = request.getParameter("ville");
			
			Utilisateur utilisateur = new Utilisateur(pseudo, nom, prenom,
					email,telephone,rue,codePostal,ville);
			utilisateur.setNoUtilisateur(noUtilisateur);
		
			UtilisateurManager.getInstance().updateUtilisateur(utilisateur);
			response.sendRedirect(request.getContextPath());
			
		} catch (BllException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
