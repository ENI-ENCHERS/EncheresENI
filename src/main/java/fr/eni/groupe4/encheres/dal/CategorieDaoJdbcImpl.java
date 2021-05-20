package fr.eni.groupe4.encheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.groupe4.encheres.bo.Categorie;

public class CategorieDaoJdbcImpl implements CategorieDao {

	@Override
	public List<Categorie> afficher() {
		List<Categorie> categories = new ArrayList<>();
		try {
			Connection cnx = DAOUtil.getConnexion();
			String requete = "select * from CATEGORIES";
			PreparedStatement pstmt = cnx.prepareStatement(requete);

			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Integer categorieId = rs.getInt("no_categorie");
				String libelle = rs.getString("libelle");
				Categorie categorie = new Categorie(categorieId, libelle);
				
				categories.add(categorie);
				
			}
			cnx.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return categories;
	}

	@Override
	public Categorie afficherParId(int id) {
		Categorie categorie = null;
		try {
			Connection cnx = DAOUtil.getConnexion();
			String requete = "select * from CATEGORIES where no_categorie=?";
			PreparedStatement pstmt = cnx.prepareStatement(requete);
			
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				 id = rs.getInt("no_categorie");
				 String libelle = rs.getString("libelle");
				 categorie = new Categorie(id, libelle);
			}
			cnx.close();
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categorie;
	}

	@Override
	public Categorie create(Categorie cat) {
		try {
			Connection cnx = DAOUtil.getConnexion();
			String requete = "INSERT INTO CATEGORIES(libelle) VALUES(?)";
			PreparedStatement pstmt = cnx.prepareStatement(requete, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, cat.getLibelle());
			
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();			
			if(rs.next()) {
				cat.setNoCategorie(rs.getInt(1));
			}		
			cnx.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cat;	
	}

}
