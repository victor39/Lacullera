package model;

public class Transportista extends Personal{

	public Transportista(String nom, String cognom, String adreça, String dni, int telefon, String correu,
			boolean administració, int tipus, int restaurant) {
		super(nom, cognom, adreça, dni, telefon, correu, administració, tipus, restaurant);
	}

	@Override
	public String toString(){
		return super.toString();
	}
	
}
