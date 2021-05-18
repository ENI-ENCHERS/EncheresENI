package fr.eni.groupe4.encheres.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.groupe4.encheres.bll.ArticleVenduManager;
import fr.eni.groupe4.encheres.bo.ArticleVendu;

/**
 * Servlet implementation class AffichageRecherche
 */
@WebServlet("/AffichageRecherche")
public class AffichageRecherche extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public static final String VUE = "/WEB-INF/encheres/recherche.jsp";
	
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        /* On affiche la page recherche */
    	List<ArticleVendu> articleVendus = new ArticleVenduManager().selectAll();
    	for (ArticleVendu articleVendu : articleVendus) {
			   //System.out.println("mes articles "+articleVendu.getNoArticle());
			   System.out.println(articleVendu);
		}
    	request.setAttribute("listArticles", articleVendus);
    	
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}
    
    public AffichageRecherche() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
