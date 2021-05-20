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
import fr.eni.groupe4.encheres.dal.UtilisateurDaoJdbcImpl;

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
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	Utilisateur util = new Utilisateur();
    	util.setPseudo(request.getParameter("pseudo"));
    	String name = request.getParameter("nom");
    	System.out.println("nom: "+name);
		util.setNom(request.getParameter("nom"));
		util.setPrenom(request.getParameter("prenom"));
		util.setEmail(request.getParameter("email"));
		util.setTelephone(request.getParameter("telephone"));
		util.setRue(request.getParameter("rue"));
		util.setCodePostal(request.getParameter("codePostal"));
		util.setVille(request.getParameter("ville"));
		util.setMotDePasse(request.getParameter("motDePasse"));
		String credit = request.getParameter("credit");
		int cred = Integer.valueOf(credit);
		util.setCredit(cred);
//		boolean isAdministrateur = Boolean.parseBoolean(request.getParameter("isAdministrateur")); 
//		System.out.println("administrateur " +isAdministrateur);
		util.isAdministrateur();
    	new UtilisateurDaoJdbcImpl().create(util);
    	this.getServletContext().getRequestDispatcher(VUE).forward( request, response );
    }

}
