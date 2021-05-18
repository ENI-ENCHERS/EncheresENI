package fr.eni.groupe4.encheres.dal;

import java.util.List;

import fr.eni.groupe4.encheres.bo.Enchere;

public interface EnchereDao {

	Enchere create(Enchere enchere);

	List<Enchere> afficher();

	Enchere update(Enchere enchere);

	void supprimer(int id);
}
