package fr.eni.groupe4.encheres.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fr.eni.groupe4.encheres.bll.EnchereManager;
import fr.eni.groupe4.encheres.bo.ArticleVendu;
import fr.eni.groupe4.encheres.bo.Enchere;
import fr.eni.groupe4.encheres.bo.Utilisateur;
import fr.eni.groupe4.encheres.dal.ArticleVenduDaoJdbcImpl;
import fr.eni.groupe4.encheres.dal.EnchereDaoJdbcImpl;
import fr.eni.groupe4.encheres.dal.UtilisateurDaoJdbcImpl;


/**
 * Servlet implementation class AffichageDetailVente
 */
@WebServlet(description = "Affiche le detail d'une vente", urlPatterns = { "/AffichageDetailVente" })
public class AffichageDetailVente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final String VUE = "/WEB-INF/encheres/detailvente.jsp";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* On affiche la page détail vente */
		List<Enchere> encheres = new EnchereManager().selectAll();
		for (Enchere enchere : encheres) {
			System.out.println(enchere);
		}
		request.setAttribute("listEncheres", encheres);
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	public AffichageDetailVente() {
		super();
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Enchere enchere = new Enchere();
		String dateEnh = request.getParameter("dateDebutEncheres");
		System.out.println(dateEnh);
		//enchere.setDateEnchere(dateEnh);		
	     
		String mont = request.getParameter("montantEnchere");
		int cred = Integer.valueOf(mont);
		enchere.setMontantEnchere(cred);
		String noArt = request.getParameter("idArticle");
		int art = Integer.valueOf(noArt);
		ArticleVendu articleVendu = new ArticleVenduDaoJdbcImpl().afficherParId(art);
		enchere.setArticleVendu(articleVendu);
		
		String noUtil = request.getParameter("idUtilisateur");
		int util = Integer.valueOf(noUtil);
		Utilisateur utilisateur = new UtilisateurDaoJdbcImpl().afficherParId(util);
		enchere.setUtilisateur(utilisateur);
		//enchere.getUtilisateur().setNoUtilisateur(request.getParameter("idUtilisateur"));
		new EnchereDaoJdbcImpl().create(enchere);
		
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

}
