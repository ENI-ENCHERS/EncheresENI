package fr.eni.groupe4.encheres.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.groupe4.encheres.bll.UtilisateurManager;
import fr.eni.groupe4.encheres.bo.Utilisateur;
import fr.eni.groupe4.encheres.dal.UtilisateurDao;
import fr.eni.groupe4.encheres.dal.UtilisateurDaoJdbcImpl;

/**
 * Servlet implementation class GestionConnexion
 */
@WebServlet(description = "Gere la page de connexion", urlPatterns = { "/GestionConnexion" })
public class GestionConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final String VUE = "/WEB-INF/encheres/connexion.jsp";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* On affiche la page de connexion */
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}
		
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String Identifiant = req.getParameter("pseudo");
		String mdp = req.getParameter("mdp");
		
		Utilisateur profil = new UtilisateurDaoJdbcImpl().recupererParEmailEtMdp(Identifiant, mdp);
		if(profil.getNoUtilisateur() > 0) {
			req.setAttribute("profil", profil);
			req.getServletContext()
			   .getRequestDispatcher("/WEB-INF/encheres/recherche.jsp")
		       .forward(req, resp);
		} else {
			req.setAttribute("message", "Email ou mot de passe incorrect");
			req.getServletContext()
			   .getRequestDispatcher(VUE)
		       .forward(req, resp);
		}
	}

}
