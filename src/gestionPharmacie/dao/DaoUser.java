package gestionPharmacie.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import gestionPharmacie.domaine.User;

public class DaoUser {

	public boolean authentificationUser(String login, String password) {
		CreerConnexion creerConnexion = new CreerConnexion();
		boolean connecter = false;
		
		try {
			//Creation de requete
			PreparedStatement pst = creerConnexion.getCon().prepareStatement(
					" select * from user u where email= ? and password= ? ");
			
			pst.setString(1, login);
			pst.setString(2, password);
			//Execute la requete
			ResultSet rs = pst.executeQuery();
			//affichage des resultat obtenus
				if(rs.next()) {
					connecter = true;
				}else {
					connecter = false;
				}
				
			
			creerConnexion.getCon().close();
			rs.close();
			pst.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return connecter ;
	}
	public List<User> listerUser(){
		List<User> listeUser = new ArrayList<>();
		CreerConnexion creerConnexion = new CreerConnexion();
		
		try {
			//Creation de requete
			PreparedStatement ts = creerConnexion.getCon().prepareStatement(
					" select * from user u ");
			
			//Execute la requete
			ResultSet rs = ts.executeQuery();
			//affichage des resultat obtenus
			while(rs.next()) {
				//initialistaion de l'user
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setLogin(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setNom(rs.getString(4));
				user.setPrenom(rs.getString(5));
				
			}
			creerConnexion.getCon().close();
			rs.close();
			ts.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return listeUser;
	}
	
	public User findUser(int id) {
		User user = new User();
		CreerConnexion creerConnexion = new CreerConnexion();
		
		try {
			PreparedStatement pst = creerConnexion.getCon().prepareStatement(
					" select * from user u where id = ?");
			pst.setInt(1, id);
			
			//Execute la requete
			ResultSet rs = pst.executeQuery();
			
			//affichage des resultat obtenus
			while(rs.next()) {
				//initialistaion de l'user
				user.setId(rs.getInt("id"));
				user.setLogin(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setNom(rs.getString(4));
				user.setPrenom(rs.getString(5));
			}
			creerConnexion.getCon().close();
			rs.close();
			pst.close();
				
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return user;
	}
	
	public void creerUser(User user) {
		CreerConnexion creerConnexion = new CreerConnexion();
		try {
			
			//Creation de requete
			PreparedStatement pst = creerConnexion.getCon().prepareStatement(""
					+ "insert into user(email, password, nom, prenom)" 
					+ "values(?, ?, ?, ?)");
			
			pst.setString(1, user.getLogin());
			pst.setString(2, user.getPassword());
			pst.setString(3, user.getNom());
			pst.setString(4, user.getPrenom());
			
			
			//Execute la requete
			pst.executeUpdate();
			System.out.println("Insertion effectuee");
		
			creerConnexion.getCon().close();
			pst.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
	
	}
	
	public void modifierUser(User user) {
		CreerConnexion creerConnexion = new CreerConnexion();
		try {
			
			//Creation de requete
			PreparedStatement pst = creerConnexion.getCon().prepareStatement(""
					+ "update user set email = ?, password = ?, nom = ?, "
					+ "prenom = ?  where id = ? ");
			pst.setString(1, user.getLogin());
			pst.setString(2, user.getPassword());
			pst.setString(3, user.getNom());
			pst.setString(4, user.getPrenom());
			pst.setInt(5, user.getId());
			
			//Execute la requete
			pst.executeUpdate();
			System.out.println("Modification effectuee");
		
			creerConnexion.getCon().close();
			pst.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
	
	}
	
	public void supprimerUser(User user) {
		CreerConnexion creerConnexion = new CreerConnexion();
		try {
			
			//Creation de requete
			PreparedStatement pst = creerConnexion.getCon().prepareStatement(""
					+ "DELETE FROM user u WHERE u.id = ?");
			
			pst.setInt(1, user.getId());
			
			//Execute la requete
			pst.executeUpdate();
			System.out.println("suppression effectuee");
		
			creerConnexion.getCon().close();
			pst.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
	
	}
}
