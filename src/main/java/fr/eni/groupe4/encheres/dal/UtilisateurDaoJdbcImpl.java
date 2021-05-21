package fr.eni.groupe4.encheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.groupe4.encheres.bo.Utilisateur;

public class UtilisateurDaoJdbcImpl implements UtilisateurDao {

	@Override
	public List<Utilisateur> afficher() {
		List<Utilisateur> utilisateurs = new ArrayList<>();
		try {
			Connection cnx = DAOUtil.getConnexion();
			String requete = "select * from UTILISATEURS";
			PreparedStatement pstmt = cnx.prepareStatement(requete);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Integer utilisateurId = rs.getInt("no_utilisateur");
				String pseudo = rs.getString("pseudo");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String email = rs.getString("email");
				String telephone = rs.getString("telephone");
				String rue = rs.getString("rue");
				String codePostal = rs.getString("code_postal");
				String ville = rs.getString("ville");
				String motDePasse = rs.getString("mot_de_passe");
				Integer credit = rs.getInt("credit");
				Boolean administrateur = rs.getBoolean("administrateur");
				Utilisateur util = new Utilisateur(utilisateurId, pseudo, nom, prenom, email, telephone, rue,
						codePostal, ville, motDePasse, credit, administrateur);
				utilisateurs.add(util);

			}
			cnx.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return utilisateurs;
	}

	@Override
	public Utilisateur create(Utilisateur utilisateur) {
		try {
			Connection cnx = DAOUtil.getConnexion();
			String requete = "INSERT INTO UTILISATEURS(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = cnx.prepareStatement(requete, PreparedStatement.RETURN_GENERATED_KEYS);

			pstmt.setString(1, utilisateur.getPseudo());
			pstmt.setString(2, utilisateur.getNom());
			pstmt.setString(3, utilisateur.getPrenom());
			pstmt.setString(4, utilisateur.getEmail());
			pstmt.setString(5, utilisateur.getTelephone());
			pstmt.setString(6, utilisateur.getRue());
			pstmt.setString(7, utilisateur.getCodePostal());
			pstmt.setString(8, utilisateur.getVille());
			pstmt.setString(9, utilisateur.getMotDePasse());
			pstmt.setInt(10, utilisateur.getCredit());
			pstmt.setBoolean(11, false);

			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				utilisateur.setNoUtilisateur(rs.getInt(1));
			}
			cnx.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return utilisateur;
	}

	@Override
	public Utilisateur afficherParId(int id) {
		Utilisateur util = null;
		try {
			Connection cnx = DAOUtil.getConnexion();
			String requete = "select * from UTILISATEURS where no_utilisateur=?";
			PreparedStatement pstmt = cnx.prepareStatement(requete);

			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				id = rs.getInt("no_utilisateur");
				String pseudo = rs.getString("pseudo");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String email = rs.getString("email");
				String telephone = rs.getString("telephone");
				String rue = rs.getString("rue");
				String codePostal = rs.getString("code_postal");
				String ville = rs.getString("ville");
				String motDePasse = rs.getString("mot_de_passe");
				Integer credit = rs.getInt("credit");
				Boolean administrateur = rs.getBoolean("administrateur");
				
				util = new Utilisateur(id, pseudo, nom, prenom, email, telephone, rue,
						codePostal, ville, motDePasse, credit, administrateur);	
				//System.out.println(util);
				}
			cnx.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return util;
	}

	@Override
	public Utilisateur update(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void supprimer(int id) {
		Connection cnx;
		try {
			 cnx = DAOUtil.getConnexion();
			String requete = "delete from UTILISATEURS where no_utilisateur=?";
			PreparedStatement pstmt = cnx.prepareStatement(requete);

			pstmt.setInt(1, id);
			pstmt.executeUpdate();

			cnx.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Utilisateur recupererParEmailEtMdp(String identifiant, String mdp) {
		Utilisateur util = new Utilisateur();
		try {
		Connection cnx = DAOUtil.getConnexion();
		String requete = "select * from UTILISATEURS where pseudo=? AND mot_de_passe=?";
		PreparedStatement pstmt = cnx.prepareStatement(requete);

		pstmt.setString(1, identifiant);
		pstmt.setString(2, mdp);
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			util.setNoUtilisateur(rs.getInt("no_utilisateur"));
			util.setPseudo(rs.getString("pseudo"));
			util.setNom(rs.getString("nom"));
			util.setPrenom(rs.getString("prenom"));
			util.setEmail(rs.getString("email"));	
			util.setTelephone(rs.getString("telephone"));
			util.setRue(rs.getString("rue"));
			util.setTelephone(rs.getString("code_postal"));
			util.setVille(rs.getString("ville"));
			util.setMotDePasse(rs.getString("mot_de_passe"));
			util.setCredit(rs.getInt("credit"));
			util.setAdministrateur(rs.getBoolean("administrateur"));			
		}
		cnx.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
		return util;
	}
}
