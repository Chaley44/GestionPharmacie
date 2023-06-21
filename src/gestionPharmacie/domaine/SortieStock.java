package gestionPharmacie.domaine;

import java.time.LocalDate;

public class SortieStock {

	private Integer id;
	private LocalDate dateSortie;
	private Integer quantiteSortie;
	private Medicament medicament;
	
	public SortieStock() {}
	
	public SortieStock(LocalDate dateSortie, Integer quantiteSortie) {
		this.dateSortie = dateSortie;
		this.quantiteSortie = quantiteSortie;
	}

	public SortieStock(Integer id, LocalDate dateSortie, Integer quantiteSortie) {
		super();
		this.id = id;
		this.dateSortie = dateSortie;
		this.quantiteSortie = quantiteSortie;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDateSortie() {
		return dateSortie;
	}

	public void setDateSortie(LocalDate dateSortie) {
		this.dateSortie = dateSortie;
	}

	public Integer getQuantiteSortie() {
		return quantiteSortie;
	}

	public void setQuantiteSortie(Integer quantiteSortie) {
		this.quantiteSortie = quantiteSortie;
	}

	public Medicament getMedicament() {
		return medicament;
	}

	public void setMedicament(Medicament medicament) {
		this.medicament = medicament;
	}
	
	
}
