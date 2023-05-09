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
		List<Enchere> encheres = EnchereManager.getInstance().gettAllEncheresEC("EC");
		request.setAttribute("encheres", encheres);
		request.getRequestDispatcher("/WEB-INF/jsp/encheres.jsp").forward(request, response);
	
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			HttpSession session = request.getSession();
			Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
			System.out.println(utilisateur);
			String optionsRadio = request.getParameter("optionsRadios");
			String achatCheckBox = request.getParameter("achat-checkbox");
			String venteCheckBox = request.getParameter("vente-checkbox");
			//Utilisateur utilisateur = new Utilisateur();

			if(optionsRadio.equalsIgnoreCase("option1")) {
				
	              if(achatCheckBox.equals("encheres-ouvertes")) { 
	            	  List<Enchere> encheres = EnchereManager.getInstance().gettAllEncheresEC("EC");
	            	  request.setAttribute("encheres", encheres);
	            	  request.getRequestDispatcher("/WEB-INF/jsp/encheres.jsp").forward(request, response);
	            	  return;
	              }
	            	  
	            	  
            	  if(achatCheckBox.equals("mes-encheres-en-cours")) { 
            		  System.out.println("dans mes encheres en cours");
	            	  List<Enchere> encheresEnCoursByUser = EnchereManager.getInstance().gettAllEncheresEnCoursByUser(utilisateur);
	            	  request.setAttribute("encheres", encheresEnCoursByUser);
	            	  response.getWriter().append("Bonjour : " + utilisateur.getPrenom() + " " + utilisateur.getNom());
	            	  request.getRequestDispatcher("/WEB-INF/jsp/encheres.jsp").forward(request, response);
	            	  return;
	             
	              }
            	  
            	  
			}
	       
	            	  
//	                  affichageEncheresEnCours(request, response);
//	                  break;
//	              case "mes_encheres_en_cours" :
//	                  affichageEncheresEnCours(request,utilisateur);
//	                  break;
//	              case "mes_encheres_remportees" :
//	                  affichageEncheresGagnees(request, utilisateur);
//	                  break;
	                  
	                  
	                  
	                  
	                  
	                  
//	              case "mes_ventes_en_cours" :
//	                  affichageVentesEnCours(request, utilisateur);
//	                  break;
//	              case "ventes_non_debutees" :
//	                  affichageVentesNonDebutees(request, utilisateur);
//	                  break;
//	              case "ventes_terminees" :
//	                  affichageVentesTerminees(request, utilisateur);
//	                  break;
	    
				
			 
	
		

		}	
}
//	private void affichageEncheresEnCours(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		List<Enchere> encheres = EnchereManager.getInstance().gettAllEncheresEC("EC");
//		//response.setAttribute("encheres", encheres);
//		response.sendRedirect(request.getContextPath());
//		       
//		}
//		
//	}

