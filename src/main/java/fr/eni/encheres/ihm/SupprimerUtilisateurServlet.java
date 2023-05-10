package fr.eni.encheres.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bll.exception.BllException;
import fr.eni.encheres.helpers.Flash;


@WebServlet("/supprimer-profil/*")
public class SupprimerUtilisateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String params = request.getPathInfo();
		int noUtilisateur = Integer.parseInt(params.substring(1));
		try {
			
			UtilisateurManager.getInstance().deleteUtilisateur(noUtilisateur);// exception si user a des enchere en cours
			
			HttpSession session = request.getSession(false);
		    if (session != null) {
		            session.invalidate();
		    }
		    
		    // flash => message votre compte a bien été supprimé    
			Flash.send("success", "Votre compte a bien été supprimé", request.getSession());	

		    response.sendRedirect(request.getContextPath());
		    return;    
		} catch (BllException e) {
			// flash = > tu as des encheres en cours
			Flash.send("error", "Vous avez des enchères en cours", request.getSession());	
			response.sendRedirect(request.getContextPath()+"/modifier-profil/"+noUtilisateur);
			e.printStackTrace();
			return;
		}		
	}
}
