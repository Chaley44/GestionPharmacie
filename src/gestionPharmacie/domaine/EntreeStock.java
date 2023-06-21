package gestionPharmacie.domaine;

import java.time.LocalDate;

public class EntreeStock {

	private Integer id;
	private LocalDate dateEntree;
	private Lot lot;
	

	public EntreeStock() {}
	
	public EntreeStock(Integer id ,LocalDate dateEntree) {
		this.id = id;
		this.dateEntree = dateEntree;
	}
	public EntreeStock(LocalDate dateEntree) {
		this.dateEntree = dateEntree;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDateEntree() {
		return dateEntree;
	}

	public void setDateEntree(LocalDate dateEntree) {
		this.dateEntree = dateEntree;
	}
	public Lot getLot() {
		return lot;
	}
	public void setLot(Lot lot) {
		this.lot = lot;
	}
	
}
