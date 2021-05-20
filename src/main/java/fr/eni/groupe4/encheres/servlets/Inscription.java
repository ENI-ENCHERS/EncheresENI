package fr.eni.groupe4.encheres.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.groupe4.encheres.ihm.FormulaireInscription;
import fr.eni.groupe4.encheres.bo.Utilisateur;

/**
 * Servlet implementation class GestionInscription
 */
@WebServlet(description = "Gere la page d'inscription", urlPatterns = { "/inscription" })
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final String ATT_USER = "utilisateur";
	public static final String ATT_FORM = "form";
	public static final String VUE = "/WEB-INF/encheres/inscription.jsp";

	    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
	        /* Affichage de la page d'inscription */
	        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	    }

	    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
	        /* Préparation de l'objet formulaire */
	        FormulaireInscription form = new FormulaireInscription();

	        /* Appel au traitement et à la validation de la requête, et récupération du bean en résultant */
	        Utilisateur utilisateur = form.inscrireUtilisateur( request );

	        /* Stockage du formulaire et du bean dans l'objet request */
	        request.setAttribute( ATT_FORM, form );
	        request.setAttribute( ATT_USER, utilisateur );

	        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	    }
}
