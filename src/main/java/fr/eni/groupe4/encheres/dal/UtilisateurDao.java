package fr.eni.groupe4.encheres.dal;

import java.util.List;

import fr.eni.groupe4.encheres.bo.Utilisateur;

public interface UtilisateurDao {

	Utilisateur create(Utilisateur utilisateur);

	List<Utilisateur> afficher();

	Utilisateur afficherParId(int id);

	Utilisateur update(Utilisateur utilisateur);

	void supprimer(int id);

	Utilisateur recupererParEmailEtMdp(String identifiant, String mdp);
}
