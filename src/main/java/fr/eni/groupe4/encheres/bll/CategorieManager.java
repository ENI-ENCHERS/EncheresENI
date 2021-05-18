package fr.eni.groupe4.encheres.bll;

import java.util.List;

import fr.eni.groupe4.encheres.bo.Categorie;
import fr.eni.groupe4.encheres.dal.CategorieDao;
import fr.eni.groupe4.encheres.dal.DaoFactory;

public class CategorieManager {

	private CategorieDao categorieDao;
	
	public CategorieManager() {
		categorieDao = DaoFactory.getCategorieDao();
	}
	
	public List<Categorie> selectAll() {
		return categorieDao.afficher();		
	}
	
	public Categorie selectById(int id) {
		return categorieDao.afficherParId(id);
	}
}
