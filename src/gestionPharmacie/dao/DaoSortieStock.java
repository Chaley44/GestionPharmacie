package gestionPharmacie.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import gestionPharmacie.domaine.SortieStock;

public class DaoSortieStock {

	public List<SortieStock> listerSortieStock(){
		List<SortieStock> listeSortie = new ArrayList<>();
		CreerConnexion creerConnexion = new CreerConnexion();
		try {
			//creation de la requete
			PreparedStatement ts = creerConnexion.getCon().prepareStatement(
					" select * from sortie_stock ent left join "
					+ "medicament m on ent.id_medicament = m.id");
			
			//Execute la requete
			ResultSet rs = ts.executeQuery();
			//affichage des resultat obtenus
			while(rs.next()) {
				//initialistaion de Entree stock
				SortieStock entreeStock = new SortieStock();
				entreeStock.setId(rs.getInt("id"));
				Date date = rs.getDate(2);
				LocalDate dateSortie = date.toLocalDate();
				entreeStock.setDateSortie(dateSortie);
				entreeStock.setQuantiteSortie(rs.getInt(3));
				
				
			}
			creerConnexion.getCon().close();
			rs.close();
			ts.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return listeSortie;
		
	}
	
	public SortieStock findSortieStock(int id){
		CreerConnexion creerConnexion = new CreerConnexion();
		SortieStock sortieStock = new SortieStock();
		
		try {
			PreparedStatement pst = creerConnexion.getCon().prepareStatement(
					" select * from sortie_stock ent where id = ?");
			pst.setInt(1, id);
			
			//Execute la requete
			ResultSet rs = pst.executeQuery();
			
			//affichage des resultat obtenus
			while(rs.next()) {
				//initialistaion de entree stock
				sortieStock.setId(rs.getInt("id"));
				Date date = rs.getDate(1);
				LocalDate dateEntre = date.toLocalDate();
				sortieStock.setDateSortie(dateEntre);
				sortieStock.setQuantiteSortie(rs.getInt(2));
				
			}
			creerConnexion.getCon().close();
			rs.close();
			pst.close();
				
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return sortieStock;
	}
	
	public void createSortieStock(SortieStock sortieStock) {
		CreerConnexion creerConnexion = new CreerConnexion();
		try {
			
			//Creation de requete
			PreparedStatement pst = creerConnexion.getCon().prepareStatement(""
					+ "insert into sortie_stock(dateSortie, quantiteSortie, id_medicament)" 
					+ "values(?, ?, ?)");
			
			
			LocalDate dateEntree = sortieStock.getDateSortie();
			pst.setDate(1, Date.valueOf(dateEntree));
			pst.setInt(2, sortieStock.getQuantiteSortie());
			pst.setInt(3, sortieStock.getMedicament().getId());
			
			
			//Execute la requete
			pst.executeUpdate();
			System.out.println("Insertion effectuee");
		
			creerConnexion.getCon().close();
			pst.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
	}
	
	public void modifierSortieStock(SortieStock sortieStock) {
		CreerConnexion creerConnexion = new CreerConnexion();
		try {
			
			//Creation de requete
			PreparedStatement pst = creerConnexion.getCon().prepareStatement(""
					+ "update sortie_stock set dateSortie = ?, quantiteSortie = ?,"
					+ " id_medicament = ? where id = ? ");
			LocalDate dateSortie = sortieStock.getDateSortie();
			pst.setDate(1, Date.valueOf(dateSortie));
			pst.setInt(2, sortieStock.getQuantiteSortie());
			pst.setInt(3, sortieStock.getMedicament().getId());
			pst.setInt(4, sortieStock.getId());
			
			//Execute la requete
			pst.executeUpdate();
			System.out.println("Modification effectuee");
		
			creerConnexion.getCon().close();
			pst.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
	}
	
	public void supprimerSortieStock(SortieStock sortieStock) {
		CreerConnexion creerConnexion = new CreerConnexion();
		try {
			
			//Creation de requete
			PreparedStatement pst = creerConnexion.getCon().prepareStatement(""
					+ "DELETE FROM sortie_stock s  where s.id = ? ");
			
			pst.setInt(1, sortieStock.getId());
			
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
