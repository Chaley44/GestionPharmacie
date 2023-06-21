package gestionPharmacie.dao;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import gestionPharmacie.domaine.Medicament;


public class DaoMedicament {

	public List<Medicament> listerMedicament(){
		List<Medicament> listeMedicament = new ArrayList<>();
		CreerConnexion creerConnexion = new CreerConnexion();

		try {		
			//Creation de requete
			PreparedStatement ts = creerConnexion.getCon().prepareStatement(
					"SELECT * FROM medicament");
			
			//Execute la requete
			ResultSet rs = ts.executeQuery();
			//affichage des resultat obtenus
			while(rs.next()) {
				//initialistaion
				Medicament medicament = new Medicament();
				medicament.setId(rs.getInt("id"));
				medicament.setNomMedicament(rs.getString(2));
				medicament.setQuantiteStock(rs.getInt(3));
				medicament.setStockAlerte(rs.getInt(4));
				
				listeMedicament.add(medicament);
				
			}
			creerConnexion.getCon().close();
			rs.close();
			ts.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return listeMedicament;
	}
	
	public Medicament findMedicament(int id) {
		Medicament medicament = new Medicament();
		CreerConnexion creerConnexion = new CreerConnexion();
		
		try {
		//Creation de requete
		PreparedStatement pst = creerConnexion.getCon().prepareStatement(
				" select * from medicament e where id = ?");
		
		pst.setInt(1, id);
		//Execute la requete
		ResultSet rs = pst.executeQuery();
		
		//affichage des resultat obtenus
		while(rs.next()) {
			//initialistaion de l'emplacement
			
			medicament.setId(rs.getInt("id"));
			medicament.setNomMedicament(rs.getString(2));
			medicament.setQuantiteStock(rs.getInt(3));
			medicament.setStockAlerte(rs.getInt(4));
			
		}
		creerConnexion.getCon().close();
		rs.close();
		pst.close();
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
	return medicament;
		
	}
	
	public Medicament findNomMedicament(String nom) {
		Medicament medicament = new Medicament();
		CreerConnexion creerConnexion = new CreerConnexion();
		
		try {
		//Creation de requete
		PreparedStatement pst = creerConnexion.getCon().prepareStatement(
				" select * from medicament e where nomMedicament = ?");
		
		pst.setString(1, nom);
		//Execute la requete
		ResultSet rs = pst.executeQuery();
		
		//affichage des resultat obtenus
		while(rs.next()) {
			//initialistaion de l'emplacement
			
			medicament.setId(rs.getInt("id"));
			medicament.setNomMedicament(rs.getString(2));
			medicament.setQuantiteStock(rs.getInt(3));
			medicament.setStockAlerte(rs.getInt(4));
			
		}
		creerConnexion.getCon().close();
		rs.close();
		pst.close();
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
	return medicament;
		
	}
	
	public void createMedicament(Medicament medicament) {
		CreerConnexion creerConnexion = new CreerConnexion();
		try {
			
			//Creation de requete
			PreparedStatement pst = creerConnexion.getCon().prepareStatement(""
					+ "insert into medicament(nomMedicament, quantiteStock, stockAlerte)" 
					+ "values(?, ?, ?)");
			pst.setString(1, medicament.getNomMedicament());
			pst.setInt(2, medicament.getQuantiteStock());
			pst.setInt(3, medicament.getStockAlerte());
			
			//Execute la requete
			pst.executeUpdate();
			System.out.println("Insertion effectuee");
		
			creerConnexion.getCon().close();
			pst.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
	}
	
	public void modifierMedicament(Medicament medicament) {
		CreerConnexion creerConnexion = new CreerConnexion();
		try {
			
			//Creation de requete
			PreparedStatement pst = creerConnexion.getCon().prepareStatement(""
					+ "update medicament set nomMedicament = ?, quantiteStock = ?,"
					+ " stockAlerte = ? where id = ?");
			pst.setString(1, medicament.getNomMedicament());
			pst.setInt(2, medicament.getQuantiteStock());
			pst.setInt(3, medicament.getStockAlerte());
			pst.setInt(4, medicament.getId());
			
			//Execute la requete
			pst.executeUpdate();
			System.out.println("Modification effectuee");
		
			creerConnexion.getCon().close();
			pst.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
	}
	
	public void supprimerMedicament(Medicament medicament) {
		CreerConnexion creerConnexion = new CreerConnexion();
		try {
			
			//Creation de requete
			PreparedStatement pst = creerConnexion.getCon().prepareStatement(""
					+ "delete from medicament where medicament.id = ?");
			
			pst.setInt(1, medicament.getId());
			
			//Execute la requete
			pst.executeUpdate();
			System.out.println("Suppression effectuee");
		
			creerConnexion.getCon().close();
			pst.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
	}
}
