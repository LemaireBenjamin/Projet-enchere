package fr.eni.encheres.ihm;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/**
 * liste enchères => accueil
 * detail d'une enchère => /accueil/detail
 * ajouter une enchère => /accueil/ajouter
 * modifier une enchère => /accueil/modifier
 * supprimer une enchère => /accueil/supprimer
 * @
 * @author bmeunier2023
 */

@WebServlet("/encheres")
public class EncheresServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Enchere> encheres = EnchereManager.getInstance().gettAllEncheres();
		request.setAttribute("encheres", encheres);
		request.getRequestDispatcher("/WEB-INF/jsp/accueil-encheres.jsp").forward(request, response);		
	}

}
