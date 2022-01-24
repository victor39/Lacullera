package model;

public class Restaurant {
	
	private int idRestaurant;
	private String adreca;
	private int telefon;
	
	public Restaurant(int idRestaurant, String adreca, int telefon) {
		this.idRestaurant = idRestaurant;
		this.adreca = adreca;
		this.telefon = telefon;
	}

	public Restaurant(String adreca, int telefon) {
		this.adreca = adreca;
		this.telefon = telefon;
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
		return "Restaurant [idRestaurant=" + idRestaurant + ", adreca=" + adreca + ", telefon=" + telefon + "]";
	}
	

}
