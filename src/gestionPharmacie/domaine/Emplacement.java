package gestionPharmacie.domaine;

import java.util.List;

public class Emplacement {

	private Integer id;
	private int abscisse;
	private String ordonne;
	private int nombreLot;
	private List<Lot> listeLot;
	


	public Emplacement() {}
	
	public Emplacement(int abscisse, String ordonne) {
		this.abscisse = abscisse;
		this.ordonne = ordonne;
	}
	
	public Emplacement(Integer id, int abscisse, String ordonne) {
		this.id = id;
		this.abscisse = abscisse;
		this.ordonne = ordonne;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getAbscisse() {
		return abscisse;
	}

	public void setAbscisse(int abscisse) {
		this.abscisse = abscisse;
	}
	public int getNombreLot() {
		return nombreLot;
	}

	public void setNombreLot(int nombreLot) {
		this.nombreLot = nombreLot;
	}

	public String getOrdonne() {
		return ordonne;
	}

	public void setOrdonne(String ordonne) {
		this.ordonne = ordonne;
	}
	

	public List<Lot> getListeLot() {
		return listeLot;
	}

	public void setListeLot(List<Lot> listeLot) {
		this.listeLot = listeLot;
	}
	
	public void localisation() {
		System.out.println("("+ getAbscisse()+"," + getOrdonne()+ ")");
	}

	
	
}
