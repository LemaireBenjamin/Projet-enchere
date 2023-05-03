package fr.eni.encheres.ihm;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/**
 * Accueil liste enchères => encheres
 * Detail d'une enchère => /encheres/detail
 * Ajouter une enchère => /encheres/ajouter
 * Modifier une enchère => /encheres/modifier
 * Supprimer une enchère => /encheres/supprimer
 * 
 * @author bmeunier2023
 */
@WebServlet("")
public class EncheresServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//List<Enchere> encheres = EnchereManager.getInstance().gettAllEncheres();
		//request.setAttribute("encheres", encheres);
		request.getRequestDispatcher("/WEB-INF/jsp/encheres.jsp").forward(request, response);
	
	}

}