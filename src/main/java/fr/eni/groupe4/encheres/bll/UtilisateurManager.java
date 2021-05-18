package fr.eni.groupe4.encheres.bll;

import java.util.List;

import fr.eni.groupe4.encheres.bo.Utilisateur;
import fr.eni.groupe4.encheres.dal.DaoFactory;
import fr.eni.groupe4.encheres.dal.UtilisateurDao;

public class UtilisateurManager {
	
	private UtilisateurDao utilisateurDao;
	
	public UtilisateurManager() {
		utilisateurDao = DaoFactory.getUtilisateurDao();
	}
	 
	 public Utilisateur create(Utilisateur utilisateur) {	
		return utilisateurDao.create(utilisateur);
	}
	
	public List<Utilisateur> selectAll() {
		return utilisateurDao.afficher();		
	}
	
	public Utilisateur selectById(int id) {
		return utilisateurDao.afficherParId(id);
	}
	
	public Utilisateur update(Utilisateur utilisateur) {	
		return utilisateurDao.update(utilisateur);
	}
	
	public void delete(int id) {
		utilisateurDao.supprimer(id);
	}
	 

}
