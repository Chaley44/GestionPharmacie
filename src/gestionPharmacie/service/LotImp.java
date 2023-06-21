package gestionPharmacie.service;

import java.util.List;

import gestionPharmacie.dao.DaoLot;
import gestionPharmacie.domaine.Lot;
import gestionPharmacie.domaine.Medicament;



public class LotImp implements IMetier<Lot, Integer> {

	
	private DaoLot daoLot = new DaoLot();
	
	@Override
	public List<Lot> liste() {
		// TODO Auto-generated method stub
		return daoLot.listerLot();
	}

	@Override
	public void creer(Lot o) {
		daoLot.creerLot(o);
		
	}

	@Override
	public void supprimer(Lot o) {
		daoLot.supprimerLot(o);
		
	}

	@Override
	public void modifier(Lot o) {
		daoLot.modifierLot(o);
		
	}

	@Override
	public Lot getById(Integer id) {
		// TODO Auto-generated method stub
		return daoLot.findLot(id);
	}
	
	public Lot getByReference(int reference) {
		for(Lot o : daoLot.listerLot()) {
			if(o.getReference().equals(reference)) {
				return o;
			}
		}
		return null;
	}

}
