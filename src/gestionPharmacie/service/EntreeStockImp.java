package gestionPharmacie.service;

import java.util.List;

import gestionPharmacie.dao.DaoEntreeStock;
import gestionPharmacie.domaine.EntreeStock;

public class EntreeStockImp implements IMetier<EntreeStock, Integer> {

	private DaoEntreeStock bdEntreeStock = new DaoEntreeStock();
	
	@Override
	public List<EntreeStock> liste() {
		// TODO Auto-generated method stub
		return bdEntreeStock.listerEntreeStock();
	}

	@Override
	public void creer(EntreeStock o) {
		bdEntreeStock.createEntreeSock(o);
		
	}

	@Override
	public void supprimer(EntreeStock o) {
		bdEntreeStock.supprimerEntreeStock(o);
		
	}

	@Override
	public void modifier(EntreeStock o) {
		bdEntreeStock.modifierEntreeStock(o);
		
	}

	@Override
	public EntreeStock getById(Integer id) {
		// TODO Auto-generated method stub
		return bdEntreeStock.findEntreeStock(0);
	}

}
