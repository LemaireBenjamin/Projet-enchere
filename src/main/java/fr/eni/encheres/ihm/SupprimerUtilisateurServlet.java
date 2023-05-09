package fr.eni.encheres.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bll.exception.BllException;

@WebServlet("/supprimer-profil/*")
public class SupprimerUtilisateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			String params = request.getPathInfo();
			int noUtilisateur = Integer.parseInt(params.substring(1));
			
			UtilisateurManager.getInstance().deleteUtilisateur(noUtilisateur);
			
		} catch (BllException e) {
			
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath());
	}

	

}
