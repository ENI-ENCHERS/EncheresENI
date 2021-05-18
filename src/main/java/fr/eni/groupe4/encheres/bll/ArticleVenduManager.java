package fr.eni.groupe4.encheres.bll;


import java.util.List;

import fr.eni.groupe4.encheres.bo.ArticleVendu;
import fr.eni.groupe4.encheres.dal.ArticleVenduDao;
import fr.eni.groupe4.encheres.dal.DaoFactory;

public class ArticleVenduManager {

	private ArticleVenduDao articleVenduDao;

	//comment
	public ArticleVenduManager() {
		articleVenduDao = DaoFactory.getArticleVenduDao();
	}
	
	public ArticleVendu create(ArticleVendu articleVendu) {	
		return articleVenduDao.create(articleVendu);
	}
	
	public List<ArticleVendu> selectAll() {
		return articleVenduDao.afficher();		
	}
	
	public ArticleVendu selectById(int id) {
		return articleVenduDao.afficherParId(id);
	}
	
	public ArticleVendu update(ArticleVendu articleVendu) {	
		return articleVenduDao.update(articleVendu);
	}
	
	public void delete(int id) {
		articleVenduDao.supprimer(id);
	}
}
