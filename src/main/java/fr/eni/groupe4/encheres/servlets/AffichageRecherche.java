package fr.eni.groupe4.encheres.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    	
        this.getServletContext().getRequestDispatcher(VUE).forward( request, response );
	}
    
    public AffichageRecherche() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
		String nomParam = request.getParameter("nomArticle");
		String descParam =request.getParameter("description");	
		String dateDebutParam = request.getParameter("dateDebutEncheres");
		String dateFinParam = request.getParameter("dateFinEncheres");		
		String miseAPrixParam = request.getParameter("miseAPrix");		
		String prixVenteParam = request.getParameter("prixVente");		
		String numCategorieParam = request.getParameter("miseAPrix");
		String numUtilisateurParam = request.getParameter("prixVente");
				
		//conversion
		int miseAPrix = Integer.parseInt(miseAPrixParam);
		int prixVente = Integer.parseInt(prixVenteParam);
		int numCategorie = Integer.parseInt(numCategorieParam);
		int numUtilisateur = Integer.parseInt(numUtilisateurParam);
		Date dateDebut = null, dateFin = null;
		
		try {
			dateDebut = sdf.parse(dateDebutParam);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		try {
			dateFin = sdf.parse(dateFinParam);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		ArticleVendu articleVendu = new ArticleVendu();
		ArticleVendu ArticleVenduManager = new ArticleVenduManager().create(articleVendu);
		this.getServletContext().getRequestDispatcher(VUE).forward( request, response );			

	}

}
