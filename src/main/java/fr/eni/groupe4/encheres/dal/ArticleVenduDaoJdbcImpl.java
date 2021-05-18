package fr.eni.groupe4.encheres.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.groupe4.encheres.bo.ArticleVendu;
import fr.eni.groupe4.encheres.bo.Categorie;
import fr.eni.groupe4.encheres.bo.Utilisateur;

public class ArticleVenduDaoJdbcImpl implements ArticleVenduDao {
	UtilisateurDao utilisateurDao = new UtilisateurDaoJdbcImpl();
	CategorieDao categorieDao = new CategorieDaoJdbcImpl();

//	private UtilisateurDao utilisateurDao;
	//private CategorieDao categorieDao;

	@Override
	public List<ArticleVendu> afficher() {
		List<ArticleVendu> listArticleVendus = new ArrayList<>();
		try {
			Connection cnx = DAOUtil.getConnexion();
			String requete = "select * from ARTICLES_VENDUS";
			PreparedStatement pstmt = cnx.prepareStatement(requete);

			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Integer noArticle = rs.getInt("no_article");
				String nomArticle = rs.getString("nom_article");
				String description = rs.getString("description");
				Date dateDebutEncheres = Date.valueOf(rs.getString("date_debut_encheres"));
				Date dateFinEncheres = Date.valueOf(rs.getString("date_fin_encheres"));
				Integer miseAPrix = rs.getInt("prix_initial");
				Integer prixVente = rs.getInt("prix_vente");
				
				Integer utilisateurId = rs.getInt("no_utilisateur");
				Utilisateur utilisateur = utilisateurDao.afficherParId(utilisateurId);
				
				Integer categorieId = rs.getInt("no_categorie");
				Categorie categorie = categorieDao.afficherParId(categorieId);
				 			
				ArticleVendu articleVendu = new ArticleVendu(noArticle, nomArticle, description, dateDebutEncheres, dateFinEncheres, miseAPrix, prixVente, false, categorie, utilisateur);
				listArticleVendus.add(articleVendu);
				
				cnx.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listArticleVendus;
	}

	@Override
	public ArticleVendu afficherParId(int id) {
		ArticleVendu article = null;
		try {
			Connection cnx = DAOUtil.getConnexion();
			String requete = "select * from ARTICLES_VENDUS where id=?";
			PreparedStatement pstmt = cnx.prepareStatement(requete);

			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				id = rs.getInt("[no_article]");
				String nomArticle = rs.getString("nom_article");
				String description = rs.getString("description");
				Date dateDebutEncheres = Date.valueOf(rs.getString("dateDebutEncheres"));
				Date dateFinEncheres = Date.valueOf(rs.getString("dateFinEncheres"));
				Integer miseAPrix = rs.getInt("miseAPrix");
				Integer prixVente = rs.getInt("prixVente");
				Boolean etatVente = rs.getBoolean("etatVente");
				
				Integer categorieId = rs.getInt("categorie");
				Categorie categorie = categorieDao.afficherParId(categorieId);
				 
				Integer utilisateurId = rs.getInt("no_utilisateur");
				Utilisateur utilisateur = utilisateurDao.afficherParId(utilisateurId);
				
				article = new ArticleVendu(id, nomArticle, description, dateDebutEncheres, dateFinEncheres, miseAPrix, prixVente, etatVente, categorie, utilisateur);
							}
			cnx.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return article;
	}

	@Override
	public ArticleVendu update(ArticleVendu articleVendu) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArticleVendu create(ArticleVendu articleVendu) {
		try {
			Connection cnx = DAOUtil.getConnexion();
			String requete = "INSERT INTO ARTICLES_VENDUS(nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie) VALUES(?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = cnx.prepareStatement(requete, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, articleVendu.getNomArticle());
			pstmt.setString(2, articleVendu.getDescription());
			//pstmt.setDate(3, java.sql.Date.valueOf(java.time.LocalDate.now()));
			pstmt.setDate(3, new java.sql.Date(articleVendu.getDateDebutEncheres().getDate()));
			pstmt.setDate(4, new java.sql.Date(articleVendu.getDateFinEncheres().getDate()));
			pstmt.setInt(5, articleVendu.getMiseAPrix());
			pstmt.setInt(6, articleVendu.getPrixVente());
			pstmt.setBoolean(7, false);
			pstmt.setInt(8, articleVendu.getCategorie().getNoCategorie());
			pstmt.setInt(9, articleVendu.getUtilisateur().getNoUtilisateur());
						
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if(rs.next()) {
				articleVendu.setNoArticle(rs.getInt(1));
			}			
			cnx.close();
		} catch (SQLException e) {
			e.printStackTrace();	
		}
		return articleVendu;
	}

	@Override
	public void supprimer(int id) {
		try {
			Connection cnx = DAOUtil.getConnexion();
		String requete = "delete from ARTICLES_VENDUS where id=?";
		PreparedStatement pstmt = cnx.prepareStatement(requete);
		pstmt.setInt(1, id);
		pstmt.executeUpdate();
		
		cnx.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

}
