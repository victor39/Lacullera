package model;

public class Restaurant {
	
	private int idRestaurant;
	private String nom;
	private String adreca;
	private int telefon;
	private int capacitat;
	private int capacitatactual;
	
	public Restaurant(int idRestaurant, String nom, String adreca, int telefon, int capacitat, int capacitatactual) {
		this.idRestaurant = idRestaurant;
		this.nom = nom;
		this.adreca = adreca;
		this.telefon = telefon;
		this.capacitat = capacitat;
		this.capacitatactual = capacitatactual;
	}

	public Restaurant(String nom, String adreca, int telefon,int capacitat, int capacitatactual) {
		this.nom= nom;
		this.adreca = adreca;
		this.telefon = telefon;
		this.capacitat = capacitat;
		this.capacitatactual = capacitatactual;
	}
	
	public Restaurant(int idRestaurant) {
		this.idRestaurant = idRestaurant;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getIdRestaurant() {
		return this.idRestaurant;
	}

	public String getAdreca() {
		return this.adreca;
	}

	public void setAdreca(String adreca) {
		this.adreca = adreca;
	}

	public int getTelefon() {
		return this.telefon;
	}

	public void setTelefon(int telefon) {
		this.telefon = telefon;
	}

	public int getCapacitat() {
		return this.capacitat;
	}

	public void setCapacitat(int capacitat) {
		this.capacitat = capacitat;
	}
	
	public int getCapacitatactual() {
		return this.capacitatactual;
	}

	public void setCapacitatactual(int capacitatactual) {
		this.capacitatactual = capacitatactual;
	}
	
	@Override
	public String toString() {
		return idRestaurant + " - " + nom;
	}
	
	
	
}
