package gestionPharmacie.service;

import java.util.List;

import gestionPharmacie.dao.DaoEmplacement;
import gestionPharmacie.domaine.Emplacement;

public class EmplacementImp implements IMetier<Emplacement, Integer> {

	private DaoEmplacement bdEmplacement = new DaoEmplacement();
	
	@Override
	public List<Emplacement> liste() {
		// TODO Auto-generated method stub
		return bdEmplacement.listerEmplacement();
	}

	@Override
	public void creer(Emplacement o) {
		bdEmplacement.creerEmplacement(o);
		
	}

	@Override
	public void supprimer(Emplacement o) {
		bdEmplacement.supprimerEmplacement(o);
		
	}

	@Override
	public void modifier(Emplacement o) {
		bdEmplacement.modifierEmplacement(o);
		
	}

	@Override
	public Emplacement getById(Integer id) {
		// TODO Auto-generated method stub
		return bdEmplacement.findEmplacement(id);
	}

}
