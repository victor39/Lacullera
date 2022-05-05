package model;

public class Client extends Persona{

	private String correu;
	private String contraseña;
	
	public Client(String nom, String cognom, String adreça, String dni, int telefon, String correu, String contraseña) {
		super(nom, cognom, adreça, dni, telefon);
		this.correu = correu;
		this.contraseña = contraseña;
	}
	
	public Client(String dni) {
		super(dni);
	}

	public String getCorreu() {
		return this.correu;
	}

	public void setCorreu(String correu) {
		this.correu = correu;
	}
	public String getContraseña() {
		return this.contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	@Override
	public String toString() {
		return super.toString();
	}
	
}
