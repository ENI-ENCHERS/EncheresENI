package fr.eni.groupe4.encheres.dal;

public class DaoFactory {
	
	public static UtilisateurDao getUtilisateurDao() {
		return new UtilisateurDaoJdbcImpl();
	}
	
	public static ArticleVenduDao getArticleVenduDao() {
		return new ArticleVenduDaoJdbcImpl();
	}
	
	public static RetraitDao getRetraitDao() {
		return new RetraitDaoJdbcImpl();
	}

	public static EnchereDao getEnchereDao() {
		return new EnchereDaoJdbcImpl();
	}
	
	public static CategorieDao getCategorieDao() {
		return new CategorieDaoJdbcImpl();
	}
}
