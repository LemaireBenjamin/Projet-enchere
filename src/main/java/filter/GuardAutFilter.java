package filter;
import jakarta.servlet.DispatcherType;



import jakarta.servlet.Filter;

import jakarta.servlet.FilterChain;

import jakarta.servlet.FilterConfig;

import jakarta.servlet.ServletException;

import jakarta.servlet.ServletRequest;

import jakarta.servlet.ServletResponse;

import jakarta.servlet.annotation.WebFilter;

import jakarta.servlet.http.HttpServlet;

import jakarta.servlet.http.HttpServletRequest;

import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import fr.eni.encheres.bo.Utilisateur;


/**
 * 
 * @author msonzia2023
 * @version 1.0
 */
@WebFilter(dispatcherTypes = { DispatcherType.REQUEST }, 
urlPatterns = { 
		"/detail-vente/*", 
		"/nouvelle-vente",
		"/supprimer-profil/*",
		"/modifier-profil/*",
		"/profil/*",
		"/mon-compte",
		"/deconnexion"
		})

public class GuardAutFilter extends HttpServlet implements Filter {
	private static final long serialVersionUID = 1L;

	@Override
		public void destroy() {
			super.destroy();
		}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		// place your code here

		HttpServletRequest req =(HttpServletRequest) request;

		HttpSession session = req.getSession();

		Utilisateur user = (Utilisateur)session.getAttribute("utilisateur");

		//Guard
		
		
		// Si on essaie d'accéder au page protéger en passant par l'URL, redirection vers la page de connexion
		if (user == null) {
			HttpServletResponse res= (HttpServletResponse) response;
			res.sendRedirect(req.getContextPath()+"/connexion");
			return;

		}

		// pass the request along the filter chain
		chain.doFilter(request, response);
		
	}


	public void init(FilterConfig fConfig) throws ServletException {
	
		System.out.println("****Stating Filtre Guard");
	
	}

}