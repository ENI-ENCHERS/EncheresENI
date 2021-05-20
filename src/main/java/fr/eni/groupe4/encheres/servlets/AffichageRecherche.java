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
import fr.eni.groupe4.encheres.bo.Categorie;
import fr.eni.groupe4.encheres.bo.Utilisateur;
import fr.eni.groupe4.encheres.dal.CategorieDaoJdbcImpl;
import fr.eni.groupe4.encheres.dal.UtilisateurDaoJdbcImpl;

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
    	
    	List<Categorie> categories = new CategorieDaoJdbcImpl().afficher();
    	for (Categorie categorie : categories) {
			System.out.println(categorie);
		}
    	request.setAttribute("listCat", categories);
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
		Categorie cat =  new Categorie();

		ArticleVendu articleVendu = new ArticleVendu();
		
		String name = request.getParameter("nomArticle");
		System.out.println("name " +name);
		articleVendu.setNomArticle(request.getParameter("nomArticle"));
		
		articleVendu.setDescription(request.getParameter("description"));
		
		String sDate1 = request.getParameter("dateDebutEncheres");
		System.out.println(sDate1);
		
		try {
			Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(sDate1);
			articleVendu.setDateFinEncheres(date1);
			articleVendu.setDateDebutEncheres(date1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		//articleVendu.setDateDebutEncheres(java.sql.Date.valueOf(request.getParameter("dateDebutEncheres")));
		String mPrix = request.getParameter("miseAPrix");
		System.out.println("prix" +mPrix);
		articleVendu.setMiseAPrix(Integer.parseInt(request.getParameter("miseAPrix")));
		articleVendu.setPrixVente(Integer.parseInt(request.getParameter("prixVente")));
		String numCat = request.getParameter("noCategorie");
		int noCat = Integer.valueOf(numCat);
		Categorie categ = new CategorieDaoJdbcImpl().afficherParId(noCat);
		articleVendu.setCategorie(categ);
		System.out.println("numCat" + numCat);
		articleVendu.getCategorie().setNoCategorie(Integer.parseInt(request.getParameter("noCategorie")));
		
		String NoUtil = request.getParameter("noUtilisateur");
		int util = Integer.valueOf(NoUtil);
		Utilisateur utilisateur = new UtilisateurDaoJdbcImpl().afficherParId(util);
		articleVendu.setUtilisateur(utilisateur);
		articleVendu.getUtilisateur().setNoUtilisateur(Integer.parseInt(request.getParameter("noUtilisateur")));
				
		ArticleVendu ArticleVenduManager = new ArticleVenduManager().create(articleVendu);
	
//		Categorie categ = new Categorie();
//		categ.setLibelle(request.getParameter("libelle"));
//		Categorie categorie = new CategorieDaoJdbcImpl().create(categ);
		this.getServletContext().getRequestDispatcher(VUE).forward( request, response );			
	}

}
