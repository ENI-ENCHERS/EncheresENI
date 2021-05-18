package fr.eni.groupe4.encheres.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AffichageDetailVente
 */
@WebServlet(description = "Affiche le detail d'une vente", urlPatterns = { "/AffichageDetailVente" })
public class AffichageDetailVente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final String VUE = "/WEB-INF/encheres/detailvente.jsp";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* On affiche la page détail vente */
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	public AffichageDetailVente() {
		super();
	}

}
