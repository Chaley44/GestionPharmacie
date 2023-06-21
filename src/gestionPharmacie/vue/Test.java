package gestionPharmacie.vue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import gestionPharmacie.domaine.Emplacement;
import gestionPharmacie.domaine.EntreeStock;
import gestionPharmacie.domaine.Lot;
import gestionPharmacie.domaine.Medicament;
import gestionPharmacie.domaine.SortieStock;
import gestionPharmacie.service.EmplacementImp;
import gestionPharmacie.service.EntreeStockImp;
import gestionPharmacie.service.LotImp;
import gestionPharmacie.service.MedicamentImp;
import gestionPharmacie.service.SortieStockImp;

public class Test {

	public Test() {}
	
	public static void main(String[] args) {
		Medicament medic1 = new Medicament(1,"Paracetamol", 150, 15);
		MedicamentImp servMedic = new MedicamentImp();
		List<SortieStock> listSortie = new ArrayList<>();
		List<Lot> listLot = new ArrayList<>();
	
//		servMedic.creer(medic1);
		Emplacement emp = new Emplacement(1, 2,"B");
		EmplacementImp servEmp = new EmplacementImp();
//		servEmp.creer(emp);
		
		
		
		LotImp servLot = new LotImp();
		Lot lot1 = new Lot(1, 1, 200, LocalDate.now());
		listLot.add(lot1);
		List<EntreeStock> listEntree = new ArrayList<>(); 
		lot1.setListEntreeStock(listEntree);
		
		Lot lot2 = new Lot(1, 23, 160, LocalDate.now());
//		lot2.setMedicament(medic1);
//		lot2.setEmplacement(emp);
//		servLot.liste();
//		lot1.setMedicament(medic1);
//		lot1.setEmplacement(emp);
//		servLot.creer(lot1);
		
		EntreeStock ent1 = new EntreeStock(1, LocalDate.now());
		EntreeStockImp servEntre = new EntreeStockImp();
		ent1.setLot(lot1);
		
		listEntree.add(ent1);
		servEntre.liste();
		

		SortieStockImp servSortie = new SortieStockImp();
		SortieStock sortie1 = new SortieStock(1, LocalDate.now(), 75);
		sortie1.setMedicament(medic1);
		listSortie.add(sortie1);
		servSortie.liste();
	}

}
