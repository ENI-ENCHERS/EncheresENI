package fr.eni.groupe4.encheres.dal;

import java.util.List;

import fr.eni.groupe4.encheres.bo.Categorie;

public interface CategorieDao {

	List<Categorie> afficher();

	Categorie afficherParId(int id);

	void create(Categorie cat);
}
