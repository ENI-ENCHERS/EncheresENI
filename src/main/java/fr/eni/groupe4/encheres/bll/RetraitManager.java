package fr.eni.groupe4.encheres.bll;

import fr.eni.groupe4.encheres.dal.DaoFactory;
import fr.eni.groupe4.encheres.dal.RetraitDao;

public class RetraitManager {
	
	private RetraitDao retraitDao;
	
	public RetraitManager() {
		retraitDao = DaoFactory.getRetraitDao();
	}

}
