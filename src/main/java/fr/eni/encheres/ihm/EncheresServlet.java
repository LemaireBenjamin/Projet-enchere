package fr.eni.encheres.ihm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bll.EnchereManager;
import fr.eni.encheres.bll.exception.BllException;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Utilisateur;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Accueil liste enchères => encheres Detail d'une enchère => /encheres/detail
 * Ajouter une enchère => /encheres/ajouter Modifier une enchère =>
 * /encheres/modifier Supprimer une enchère => /encheres/supprimer
 * 
 * @author bmeunier2023
 */

@WebServlet("")
public class EncheresServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Enchere> encheres = EnchereManager.getInstance().getAllEncheresEC("EC");
		request.setAttribute("encheres", encheres);
		request.getRequestDispatcher("/WEB-INF/jsp/encheres.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		HttpSession session = request.getSession();
	
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
		String optionsRadio = request.getParameter("optionsRadios");
		String achatCheckBox = request.getParameter("achat-checkbox");
		String venteCheckBox = request.getParameter("vente-checkbox");
		
		String search = request.getParameter("search");
		String libelle = request.getParameter("libelle");
		
			
		if (session != null && optionsRadio != null)  {
			if (optionsRadio.equalsIgnoreCase("option1") && achatCheckBox != null) {

				if (achatCheckBox.equals("encheres-ouvertes")) {
					List<Enchere> encheres = EnchereManager.getInstance().getAllEncheresEC("EC");
					request.setAttribute("encheres", encheres);
					request.getRequestDispatcher("/WEB-INF/jsp/encheres.jsp").forward(request, response);
				return;
				}

				if (achatCheckBox.equals("mes-encheres-en-cours")) {
					System.out.println("dans mes encheres en cours");
					System.out.println(utilisateur);
					List<Enchere> encheres = EnchereManager.getInstance().getAllEncheresAchatEnCoursByUser(utilisateur, "EC");
					request.setAttribute("encheres", encheres);
					request.getRequestDispatcher("/WEB-INF/jsp/encheres.jsp").forward(request, response);
				return;

				}

//				if (achatCheckBox.equals("mes-encheres-remportees")) {
//					System.out.println("dans mes encheres remportées");
//					System.out.println(utilisateur);
//					List<Enchere> encheres = EnchereManager.getInstance().getAllEncheresGagneesByUser(utilisateur, "ET");
//					request.setAttribute("encheres", encheres);
//					request.getRequestDispatcher("/WEB-INF/jsp/encheres.jsp").forward(request, response);
//				return;
//
//				}

			} else if (optionsRadio.equalsIgnoreCase("option2") && venteCheckBox != null)  {

					if (venteCheckBox.equals("mes-ventes-en-cours")) {
						System.out.println("dans vente-non-debutees");
						System.out.println(utilisateur);
						List<Enchere> encheres = EnchereManager.getInstance().getAllEncheresEnCoursByUser(utilisateur, "EC");
						request.setAttribute("encheres", encheres);
						request.getRequestDispatcher("/WEB-INF/jsp/encheres.jsp").forward(request, response);
					return;
					}

					if (venteCheckBox.equals("vente-non-debutees")) {
						System.out.println("dans vente-non-debutees");
						System.out.println(utilisateur);
						List<Enchere> encheres = EnchereManager.getInstance().getAllEncheresCommenceesByUser(utilisateur, "CR");
						request.setAttribute("encheres", encheres);
						request.getRequestDispatcher("/WEB-INF/jsp/encheres.jsp").forward(request, response);
					return;

					}

					if (venteCheckBox.equals("ventes-terminees")) {
						System.out.println("dans mes ventes-terminees");
						System.out.println(utilisateur);
						List<Enchere> encheres = EnchereManager.getInstance().getAllEncheresGagneesByUser(utilisateur, "ET");
						request.setAttribute("encheres", encheres);
						request.getRequestDispatcher("/WEB-INF/jsp/encheres.jsp").forward(request, response);
					return;

					}

				}
			} else if((!libelle.equalsIgnoreCase(null))){
			
				 {
					System.out.println("dans mes encheres par libellé");
					System.out.println(libelle);
					List<Enchere> encheres = EnchereManager.getInstance().getAllEncheresByLibelle(libelle);
					request.setAttribute("encheres", encheres);
					request.getRequestDispatcher("/WEB-INF/jsp/encheres.jsp").forward(request, response);
				return;
				} 
			}
		}
}

	

			
			
			