package model;

public class Personal extends Persona{

	private String correu;
	private boolean administració;
	private int tipus;
	private int restaurant;
	
	public Personal(String nom, String cognom, String adreça, String dni, int telefon, String correu,
		boolean administració, int tipus, int restaurant) {
		super(nom, cognom, adreça, dni, telefon);
		this.correu = correu;
		this.administració = administració;
		this.tipus = tipus;
		this.restaurant = restaurant;
	}

	public String getCorreu() {
		return correu;
	}

	public void setCorreu(String correu) {
		this.correu = correu;
	}

	public boolean isAdministració() {
		return administració;
	}

	public void setAdministració(boolean administració) {
		this.administració = administració;
	}

	public int getTipus() {
		return tipus;
	}

	public void setTipus(int tipus) {
		this.tipus = tipus;
	}

	public int getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(int restaurant) {
		this.restaurant = restaurant;
	}

	@Override
	public String toString(){
		return super.toString();
	}
	
}
