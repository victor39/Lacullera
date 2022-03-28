package model;

public class Restaurant {
	
	private int idRestaurant;
	private String nom;
	private String adreca;
	private int telefon;
	
	public Restaurant(int idRestaurant, String nom, String adreca, int telefon) {
		this.idRestaurant = idRestaurant;
		this.nom = nom;
		this.adreca = adreca;
		this.telefon = telefon;
	}

	public Restaurant(String nom, String adreca, int telefon) {
		this.nom= nom;
		this.adreca = adreca;
		this.telefon = telefon;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getIdRestaurant() {
		return idRestaurant;
	}

	public String getAdreca() {
		return adreca;
	}

	public void setAdreca(String adreca) {
		this.adreca = adreca;
	}

	public int getTelefon() {
		return telefon;
	}

	public void setTelefon(int telefon) {
		this.telefon = telefon;
	}

	@Override
	public String toString() {
		return nom;
	}
	
}
