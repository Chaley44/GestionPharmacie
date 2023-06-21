package gestionPharmacie.domaine;

import java.util.List;

/**
 * Represente un medicament pharmacetique
 * @author hp
 *
 */
public class Medicament {

	private Integer id;
	private String nomMedicament;
	private Integer quantiteStock;
	private Integer stockAlerte;
	private List<Lot> listLot;
	private List<SortieStock> listSortieStock;
	
	
	public Medicament() {}
	
	public Medicament(String nomMedicament, Integer quantiteStock,Integer stockAlerte) {
		this.nomMedicament = nomMedicament;
		this.quantiteStock = quantiteStock;
		this.stockAlerte = stockAlerte;
	}
	
	public Medicament(Integer id, String nomMedicament, Integer quantiteStock,Integer stockAlerte) {
		this.id = id;
		this.nomMedicament = nomMedicament;
		this.quantiteStock = quantiteStock;
		this.stockAlerte = stockAlerte;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		
		this.id = id;
	}

	public Integer getStockAlerte() {
		return stockAlerte;
	}

	public void setStockAlerte(Integer stockAlerte) {
		this.stockAlerte = stockAlerte;
	}

	public Integer getQuantiteStock() {
		return quantiteStock;
	}

	public void setQuantiteStock(Integer quantiteStock) {
		this.quantiteStock = quantiteStock;
	}

	public String getNomMedicament() {
		return nomMedicament;
	}

	public void setNomMedicament(String nomMedicament) {
		this.nomMedicament = nomMedicament;
	}

	public List<Lot> getListLot() {
		return listLot;
	}

	public void setListLot(List<Lot> listLot) {
		this.listLot = listLot;
	}

	public List<SortieStock> getListSortieStock() {
		return listSortieStock;
	}

	public void setListSortieStock(List<SortieStock> listSortieStock) {
		this.listSortieStock = listSortieStock;
	}
}
