package gestionPharmacie.service;

import java.util.List;

import gestionPharmacie.dao.DaoSortieStock;
import gestionPharmacie.domaine.SortieStock;

public class SortieStockImp implements IMetier<SortieStock , Integer> {

	private DaoSortieStock daoSortieStock = new DaoSortieStock();
	
	@Override
	public List<SortieStock> liste() {
		// TODO Auto-generated method stub
		return daoSortieStock.listerSortieStock();
	}

	@Override
	public void creer(SortieStock o) {
		daoSortieStock.createSortieStock(o);
		
	}

	@Override
	public void supprimer(SortieStock o) {
		daoSortieStock.supprimerSortieStock(o);
		
	}

	@Override
	public void modifier(SortieStock o) {
		daoSortieStock.modifierSortieStock(o);
		
	}

	@Override
	public SortieStock getById(Integer id) {
		// TODO Auto-generated method stub
		return daoSortieStock.findSortieStock(id);
	}

}
