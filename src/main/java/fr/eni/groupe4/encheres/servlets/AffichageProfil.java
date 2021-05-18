package fr.eni.groupe4.encheres.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.groupe4.encheres.bll.UtilisateurManager;
import fr.eni.groupe4.encheres.bo.Utilisateur;

/**
 * Servlet implementation class AffichageProfil
 */
@WebServlet("/AffichageProfil")
public class AffichageProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public static final String VUE = "/WEB-INF/encheres/profil.jsp";
	
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        /* On affiche la page profil */
    	List<Utilisateur> utilisateurs = new UtilisateurManager().selectAll();
    	for (Utilisateur utilisateur : utilisateurs) {
			System.out.println(utilisateur);
		}
    	request.setAttribute("ListUtilisateurs", utilisateurs);
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AffichageProfil() {
        super();
        // TODO Auto-generated constructor stub
    }

}
