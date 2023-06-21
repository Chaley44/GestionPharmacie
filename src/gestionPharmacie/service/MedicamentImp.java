package gestionPharmacie.service;

import java.util.List;

import gestionPharmacie.dao.DaoMedicament;
import gestionPharmacie.domaine.Medicament;
import gestionPharmacie.domaine.User;

public class MedicamentImp implements IMetier<Medicament, Integer> {

	private DaoMedicament daoMedicament = new DaoMedicament();
	@Override
	public List<Medicament> liste() {
		// TODO Auto-generated method stub
		return daoMedicament.listerMedicament() ;
	}

	@Override
	public void creer(Medicament o) {
		daoMedicament.createMedicament(o);
		
	}

	@Override
	public void supprimer(Medicament o) {
		daoMedicament.supprimerMedicament(o);
		
	}

	@Override
	public void modifier(Medicament o) {
		daoMedicament.modifierMedicament(o);
		
	}

	@Override
	public Medicament getById(Integer id) {
		// TODO Auto-generated method stub
		return daoMedicament.findMedicament(0);
	}

	public Medicament getByNom(String nom) {
		for(Medicament o : daoMedicament.listerMedicament()) {
			if(o.getNomMedicament().equals(nom)) {
				return o;
			}
		}
		return null;
	}
}
