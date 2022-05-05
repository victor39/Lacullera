package model;

public class Client extends Persona{

	private String correu;
	private String pasword;
	

public Client(String nom, String cognom, String adreça, String dni, int telefon, String correu, String pasword) {
		super(nom, cognom, adreça, dni, telefon);
		this.correu = correu;
		this.pasword = pasword;
	}
	
	public Client(String dni) {
		super(dni);
	}

	public Client() {
		
	}

	public String getCorreu() {
		return correu;
	}

	public void setCorreu(String correu) {
		this.correu = correu;
	}
	
	
	public void setPasword(String pasword) {
		this.pasword = pasword;
	}
	
	public String getPasword() {
		return this.pasword;
	}

	@Override
	public String toString() {
		return super.toString();
	}
	
}
