package gestionPharmacie.dao;



import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import gestionPharmacie.domaine.Emplacement;
import gestionPharmacie.domaine.Lot;
import gestionPharmacie.domaine.Medicament;

public class DaoLot {

	
	public List<Lot> listerLot(){
		List<Lot> listeLot = new ArrayList<>();
		DaoEmplacement emplacementDao = new DaoEmplacement();
		CreerConnexion creerConnexion = new CreerConnexion();
		DaoMedicament medicDao = new DaoMedicament();
		
		try {
			//Creation de requete
			PreparedStatement ts = creerConnexion.getCon().prepareStatement(
					" select * from lot l left join "
					+ "medicament m on l.id_medicament = m.id "
					+ "left join emplacement emp on l.id_emplacement = emp.id;");
			
			//Execute la requete
			ResultSet rs = ts.executeQuery();
			//affichage des resultat obtenus
			while(rs.next()) {
				//initialistaion de lot
				Lot lot = new Lot();
				lot.setId(rs.getInt("id"));
				lot.setReference(rs.getInt(2));
				lot.setNombreMedicament(rs.getInt(3));
				Date date = rs.getDate(4);
				LocalDate date2 = date.toLocalDate();
				lot.setDatePeremption(date2);
				
				int idMedicament = rs.getInt(5);
				Medicament medicament = medicDao.findMedicament(idMedicament);
				lot.setMedicament(medicament);
				
				int idEmplacement = rs.getInt(6);
				Emplacement emplacement = emplacementDao.findEmplacement(idEmplacement);
				lot.setEmplacement(emplacement);
			}
			creerConnexion.getCon().close();
			rs.close();
			ts.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return listeLot;
	}
	
	public Lot findLot(int id) {
		Lot lot = new Lot();
		CreerConnexion creerConnexion = new CreerConnexion();
		DaoMedicament medicDao = new DaoMedicament();
		DaoEmplacement emplacementDao = new DaoEmplacement();
		
		try {
			PreparedStatement pst = creerConnexion.getCon().prepareStatement(
					" select * from lot l where id = ?");
			pst.setInt(1, id);
			
			//Execute la requete
			ResultSet rs = pst.executeQuery();
			
			//affichage des resultat obtenus
			while(rs.next()) {
				//initialistaion de lot
				lot.setId(rs.getInt("id"));
				
				lot.setReference(rs.getInt(2));
				lot.setNombreMedicament(rs.getInt(3));
				Date date = rs.getDate(4);
				LocalDate date2 = date.toLocalDate();
				lot.setDatePeremption(date2);
				
				int idMedicament = rs.getInt(5);
				Medicament medicament = medicDao.findMedicament(idMedicament);
				lot.setMedicament(medicament);
				
				int idEmplacement = rs.getInt(6);
				Emplacement emplacement = emplacementDao.findEmplacement(idEmplacement);
				lot.setEmplacement(emplacement);
			}
			creerConnexion.getCon().close();
			rs.close();
			pst.close();
				
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return lot;
	}
	
	public void creerLot(Lot lot) {
		CreerConnexion creerConnexion = new CreerConnexion();
		try {
			
			//Creation de requete
			PreparedStatement pst = creerConnexion.getCon().prepareStatement(""
					+ "insert into lot(reference, nombreMedicament, datePeremption,"
					+ " id_medicament, id_emplacement)" 
					+ "values(?, ?, ?, ?, ?)");
			
			pst.setInt(1, lot.getReference());
			pst.setInt(2, lot.getNombreMedicament());
			LocalDate datePeremption = lot.getDatePeremption();
			pst.setDate(3, Date.valueOf(datePeremption));
			pst.setInt(4, lot.getMedicament().getId());
			pst.setInt(5, lot.getEmplacement().getId());
			
			//Execute la requete
			pst.executeUpdate();
			System.out.println("Insertion effectuee");
		
			creerConnexion.getCon().close();
			pst.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
	
	}
	
	public void modifierLot(Lot lot) {
		CreerConnexion creerConnexion = new CreerConnexion();
		try {
			
			//Creation de requete
			PreparedStatement pst = creerConnexion.getCon().prepareStatement(""
					+ "update lot set reference = ?,"
					+ "nombreMedicament = ?, datePeremption = ?, id_medicament = ?,"
					+ " id_emplacement = ? where id = ? ");
			pst.setInt(1, lot.getReference());
			pst.setInt(2, lot.getNombreMedicament());
			LocalDate datePeremption = lot.getDatePeremption();
			pst.setDate(3, Date.valueOf(datePeremption));
			pst.setInt(4, lot.getMedicament().getId());
			pst.setInt(5, lot.getEmplacement().getId());
			pst.setInt(5, lot.getId());
			
			//Execute la requete
			pst.executeUpdate();
			System.out.println("Modification effectuee");
		
			creerConnexion.getCon().close();
			pst.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
	
	}
	
	public void supprimerLot(Lot lot) {
		CreerConnexion creerConnexion = new CreerConnexion();
		try {
			
			//Creation de requete
			PreparedStatement pst = creerConnexion.getCon().prepareStatement(""
					+ "DELETE FROM lot l WHERE l.id = ?");
			
			pst.setInt(1, lot.getId());
			
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
