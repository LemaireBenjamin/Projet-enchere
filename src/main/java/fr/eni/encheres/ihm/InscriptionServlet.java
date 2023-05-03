package fr.eni.encheres.ihm;

import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.helpers.Flash;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;



@WebServlet("/inscription")
public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/inscription.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("lastname");
		String prenom = request.getParameter("firstName");
		String email = request.getParameter("email");
		String telephone = request.getParameter("tel");
		String rue = request.getParameter("road");
		String codePostal = request.getParameter("postalCode");
		String ville = request.getParameter("ville");
		String motDePasse = request.getParameter("password");
		String confirmeMotDePasse = request.getParameter("confirmpassword");
		
		Utilisateur utilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse, 0,  false);
		
		SecurityService.getInstance().addUser(utilisateur);
		
		Flash.send("SUCCESS", "Votre compte à bien été crée", request.getSession());
		response.sendRedirect(request.getContextPath()+"/connexion");
	}

}
