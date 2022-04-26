package model;

public class Client extends Persona{

	private String correu;
	
	public Client(String nom, String cognom, String adreça, String dni, int telefon, String correu) {
		super(nom, cognom, adreça, dni, telefon);
		this.correu = correu;
	}
	
	public Client(String dni) {
		super(dni);
	}

	public String getCorreu() {
		return correu;
	}

	public void setCorreu(String correu) {
		this.correu = correu;
	}

	@Override
	public String toString() {
		return super.toString();
	}
	
}
