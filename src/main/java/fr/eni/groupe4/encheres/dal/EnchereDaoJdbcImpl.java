package fr.eni.groupe4.encheres.dal;

import java.security.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.chrono.ChronoLocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import fr.eni.groupe4.encheres.bo.ArticleVendu;
import fr.eni.groupe4.encheres.bo.Enchere;
import fr.eni.groupe4.encheres.bo.Utilisateur;

public class EnchereDaoJdbcImpl implements EnchereDao{
	
//	private UtilisateurDao utilisateurDao;
//	private ArticleVenduDao articleVenduDao;
	
	UtilisateurDao utilisateurDao = new UtilisateurDaoJdbcImpl();
	ArticleVenduDao articleVenduDao = new ArticleVenduDaoJdbcImpl();

	@Override
	public Enchere create(Enchere enchere) {
		try {
			Connection cnx = DAOUtil.getConnexion();
			String requete = "INSERT INTO ENCHERES(date_enchere, montant_enchere, no_article, no_utilisateur) VALUES(?,?,?,?)";
			PreparedStatement pstmt = cnx.prepareStatement(requete, PreparedStatement.RETURN_GENERATED_KEYS);

			//Date.from(enchere.getDateEnchere(ZoneOffset.UTC));
	        ZoneOffset systemZoneOffset = ZoneOffset.from(OffsetDateTime.now());
	        Instant instant = enchere.getDateEnchere().toInstant(systemZoneOffset);
	        //pstmt.setTimestamp(1, java.sql.Timestamp.from(instant));
	        System.out.println("Encheres "+ instant);
	        pstmt.setDate(1, new java.sql.Date(instant.toEpochMilli()));
			//pstmt.setDate(1, enchere.getDateEnchere());
			pstmt.setInt(2, enchere.getMontantEnchere());
			pstmt.setInt(3, enchere.getUtilisateur().getNoUtilisateur());
			pstmt.setInt(4, enchere.getArticleVendu().getNoArticle());
			
			pstmt.executeUpdate();
//			ResultSet rs = pstmt.getGeneratedKeys();
//			if(rs.next()) {
//				int encherId = rs.getInt("no_enchere");
//				enchere.set(encherId);
//			}
			cnx.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return enchere;
	}

	@Override
	public List<Enchere> afficher() {
		List<Enchere> encheres = new ArrayList<>();
		try {
			Connection cnx = DAOUtil.getConnexion();
			String requete = "select * from ENCHERES";
			PreparedStatement pstmt = cnx.prepareStatement(requete);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				LocalDateTime dateEnchere = rs.getTimestamp("date_enchere").toLocalDateTime();
				Integer montantEnchere = rs.getInt("montant_enchere");
				
				Integer utilisateurId = rs.getInt("no_utilisateur");
				Utilisateur utilisateur = utilisateurDao.afficherParId(utilisateurId);
				
				Integer noArticle = rs.getInt("no_article");
				ArticleVendu articleVendu = articleVenduDao.afficherParId(noArticle);
				
				Enchere enchere = new Enchere(dateEnchere, montantEnchere, utilisateur, articleVendu);
				encheres.add(enchere);
			}
			cnx.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return encheres;
	}

	@Override
	public Enchere update(Enchere enchere) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void supprimer(int id) {
		try {
			Connection cnx = DAOUtil.getConnexion();
		String requete = "delete from ENCHERES where no_enchere=?";
		PreparedStatement pstmt = cnx.prepareStatement(requete);
		pstmt.setInt(1, id);
		pstmt.executeUpdate();
		
		cnx.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
