package fr.eni.groupe4.encheres.bll;

import java.util.List;

import fr.eni.groupe4.encheres.bo.Enchere;
import fr.eni.groupe4.encheres.dal.DaoFactory;
import fr.eni.groupe4.encheres.dal.EnchereDao;

public class EnchereManager {
	
	private EnchereDao enchereDao;
	
	public EnchereManager() {
		enchereDao = DaoFactory.getEnchereDao();
	}

	public Enchere create(Enchere enchere) {	
		return enchereDao.create(enchere);
	}
	
	public List<Enchere> selectAll() {
		return enchereDao.afficher();		
	}
	
	public Enchere update(Enchere enchere) {	
		return enchereDao.update(enchere);
	}
	
	public void delete(int id) {
		enchereDao.supprimer(id);
	}
}
