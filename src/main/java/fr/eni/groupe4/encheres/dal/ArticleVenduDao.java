package fr.eni.groupe4.encheres.dal;

import java.util.List;

import fr.eni.groupe4.encheres.bo.ArticleVendu;

public interface ArticleVenduDao {

	List<ArticleVendu> afficher();

	ArticleVendu afficherParId(int id);

	ArticleVendu update(ArticleVendu articleVendu);

	ArticleVendu create(ArticleVendu articleVendu);

	void supprimer(int id);

}
