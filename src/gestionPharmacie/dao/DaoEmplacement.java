package gestionPharmacie.dao;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import gestionPharmacie.dao.CreerConnexion;
import gestionPharmacie.domaine.Emplacement;

public class DaoEmplacement {

	
	public List<Emplacement> listerEmplacement(){
		List<Emplacement> listeEmplacement = new ArrayList<>();
		CreerConnexion creerConnexion = new CreerConnexion();
		
		try {
			
			//Creation de requete
			PreparedStatement ts = creerConnexion.getCon().prepareStatement(
					" select * from emplacement e");
			
			//Execute la requete
			ResultSet rs = ts.executeQuery();
			//affichage des resultat obtenus
			while(rs.next()) {
				//initialistaion de l'emplacement
				Emplacement emplacement = new Emplacement();
				emplacement.setId(rs.getInt("id"));
				emplacement.setAbscisse(rs.getInt(2));
				emplacement.setOrdonne(rs.getString(3));
				emplacement.setNombreLot(rs.getInt(4));
			}
			creerConnexion.getCon().close();
			rs.close();
			ts.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return listeEmplacement;
	}
	
	public Emplacement findEmplacement(int id) {
		Emplacement emplacement = new Emplacement();
		CreerConnexion creerConnexion = new CreerConnexion();
		
		try {
			PreparedStatement pst = creerConnexion.getCon().prepareStatement(
					"select * from emplacement e where id = ?");
			pst.setInt(1, id);
			
			//Execute la requete
			ResultSet rs = pst.executeQuery();
			
			//affichage des resultat obtenus
			while(rs.next()) {
				//initialistaion de l'emplacement
				emplacement.setId(rs.getInt("id"));
				emplacement.setAbscisse(rs.getInt(2));
				emplacement.setOrdonne(rs.getString(3));
				emplacement.setNombreLot(rs.getInt(4));
			}
			creerConnexion.getCon().close();
			rs.close();
			pst.close();
				
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return emplacement;
	}
	
	public void creerEmplacement(Emplacement emplacement) {
		CreerConnexion creerConnexion = new CreerConnexion();
		try {
			
			//Creation de requete
			PreparedStatement pst = creerConnexion.getCon().prepareStatement(""
					+ "insert into emplacement(abscisse, ordonne, nombreLot)" 
					+ "values(?, ?, ?)");
			pst.setInt(1, emplacement.getAbscisse());
			pst.setString(2, emplacement.getOrdonne());
			pst.setInt(3, emplacement.getNombreLot());
			
			//Execute la requete
			pst.executeUpdate();
			System.out.println("Insertion effectuee");
		
			creerConnexion.getCon().close();
			pst.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
	
	}
	
	public void modifierEmplacement(Emplacement emplacement) {
		CreerConnexion creerConnexion = new CreerConnexion();
		try {
			
			//Creation de requete
			PreparedStatement pst = creerConnexion.getCon().prepareStatement(""
					+ "update emplacement set abscisse = ?,"
					+ "ordonne = ?, nombreLot = ? where id = ? ");
			pst.setInt(1, emplacement.getAbscisse());
			pst.setString(2, emplacement.getOrdonne());
			pst.setInt(3, emplacement.getAbscisse());
			pst.setInt(4, emplacement.getId());
			
			//Execute la requete
			pst.executeUpdate();
			System.out.println("Modification effectuee");
		
			creerConnexion.getCon().close();
			pst.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
	
	}
	
	public void supprimerEmplacement(Emplacement emplacement) {
		CreerConnexion creerConnexion = new CreerConnexion();
		try {
			
			//Creation de requete
			PreparedStatement pst = creerConnexion.getCon().prepareStatement(""
					+ "DELETE FROM emplacement WHERE emplacement.id = ?");
			
			pst.setInt(1, emplacement.getId());
			
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
