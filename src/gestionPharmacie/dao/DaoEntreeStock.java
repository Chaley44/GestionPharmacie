package gestionPharmacie.dao;

import java.sql.Date;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import gestionPharmacie.domaine.EntreeStock;

public class DaoEntreeStock {

	
	public List<EntreeStock> listerEntreeStock(){
		List<EntreeStock> listeEntree = new ArrayList<>();
		CreerConnexion creerConnexion = new CreerConnexion();
		try {
			//creation de la requete
			PreparedStatement ts = creerConnexion.getCon().prepareStatement(
					" select * from entree_stock en left join "
					+ "lot l on en.id_lot = l.id");
			
			//Execute la requete
			ResultSet rs = ts.executeQuery();
			//affichage des resultat obtenus
			while(rs.next()) {
				//initialistaion de Entree stock
				EntreeStock entreeStock = new EntreeStock();
				entreeStock.setId(rs.getInt("id"));
				Date date = rs.getDate(2);
				LocalDate dateEntre = date.toLocalDate();
				entreeStock.setDateEntree(dateEntre);
				listeEntree.add(entreeStock);
				
			}
			creerConnexion.getCon().close();
			rs.close();
			ts.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return listeEntree;
		
	}
	
	public EntreeStock findEntreeStock(int id){
		CreerConnexion creerConnexion = new CreerConnexion();
		EntreeStock entreeStock = new EntreeStock();
		
		try {
			PreparedStatement pst = creerConnexion.getCon().prepareStatement(
					" select * from entree_stock en where id = ?");
			pst.setInt(1, id);
			
			//Execute la requete
			ResultSet rs = pst.executeQuery();
			
			//affichage des resultat obtenus
			while(rs.next()) {
				//initialistaion de entree stock
				entreeStock.setId(rs.getInt("id"));
				Date date = rs.getDate(1);
				LocalDate dateEntre = date.toLocalDate();
				entreeStock.setDateEntree(dateEntre);
			}
			creerConnexion.getCon().close();
			rs.close();
			pst.close();
				
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return entreeStock;
	}
	
	public void createEntreeSock(EntreeStock entreeStock) {
		CreerConnexion creerConnexion = new CreerConnexion();
		try {
			
			//Creation de requete
			PreparedStatement pst = creerConnexion.getCon().prepareStatement(""
					+ "insert into entree_stock(dateEntree, id_lot)" 
					+ "values(?,?)");
			
			
			LocalDate dateEntree = entreeStock.getDateEntree();
			pst.setDate(1, Date.valueOf(dateEntree));
			pst.setInt(2, entreeStock.getLot().getId());
			
			//Execute la requete
			pst.executeUpdate();
			System.out.println("Insertion effectuee");
		
			creerConnexion.getCon().close();
			pst.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
	}
	
	public void modifierEntreeStock(EntreeStock entreeStock) {
		CreerConnexion creerConnexion = new CreerConnexion();
		try {
			
			//Creation de requete
			PreparedStatement pst = creerConnexion.getCon().prepareStatement(""
					+ "update entree_stock set dateEntree = ?, id_lot = ? where id = ? ");
			LocalDate dateEntree = entreeStock.getDateEntree();
			pst.setDate(1, Date.valueOf(dateEntree));
			pst.setInt(2, entreeStock.getLot().getId());
			pst.setInt(3, entreeStock.getId());
			
			//Execute la requete
			pst.executeUpdate();
			System.out.println("Modification effectuee");
		
			creerConnexion.getCon().close();
			pst.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
	}
	
	public void supprimerEntreeStock(EntreeStock entreeStock) {
		CreerConnexion creerConnexion = new CreerConnexion();
		try {
			
			//Creation de requete
			PreparedStatement pst = creerConnexion.getCon().prepareStatement(""
					+ "DELETE FROM entree_stock ent where ent.id = ? ");
			
			pst.setInt(1, entreeStock.getId());
			
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
