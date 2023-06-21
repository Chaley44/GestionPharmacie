package gestionPharmacie.domaine;

import java.time.LocalDate;
import java.util.List;


/**
 * Represente un lot de medicament
 * @author hp
 *
 */
public class Lot {

	private Integer id;
	private Integer reference;
	private Integer nombreMedicament;
	private LocalDate datePeremption;
	private Medicament medicament;
	private Emplacement emplacement;
	private List<EntreeStock> listEntreeStock;
	
	public Lot() {}
	
	public Lot(Integer reference, Integer nombreMedicament) {}
	public Lot(Integer id, Integer reference, Integer nombreMedicament,LocalDate datePeremption ) {
		this.id = id;
		this.reference = reference;
		this.nombreMedicament = nombreMedicament;
		this.datePeremption = datePeremption;
	}
	
	public Integer getNombreMedicament() {
		return nombreMedicament;
	}

	public void setNombreMedicament(Integer nombreMedicament) {
		this.nombreMedicament = nombreMedicament;
	}

	public LocalDate getDatePeremption() {
		return datePeremption;
	}

	public void setDatePeremption(LocalDate datePeremption) {
		this.datePeremption = datePeremption;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getReference() {
		return reference;
	}

	public void setReference(Integer reference) {
		this.reference = reference;
	}

	public Medicament getMedicament() {
		return medicament;
	}

	public void setMedicament(Medicament medicament) {
		this.medicament = medicament;
	}

	public List<EntreeStock> getListEntreeStock() {
		return listEntreeStock;
	}

	public void setListEntreeStock(List<EntreeStock> listEntreeStock) {
		this.listEntreeStock = listEntreeStock;
	}

	public Emplacement getEmplacement() {
		return emplacement;
	}

	public void setEmplacement(Emplacement emplacement) {
		this.emplacement = emplacement;
	}

	

	
	
	
}
