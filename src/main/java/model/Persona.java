package model;

public class Persona {

	private String nom;
	private String cognom;
	private String adreça;
	private String dni;
	private int telefon;
	
	public Persona(String nom, String cognom, String adreça, String dni, int telefon) {
		this.nom = nom;
		this.cognom = cognom;
		this.adreça = adreça;
		this.dni = dni;
		this.telefon = telefon;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCognom() {
		return cognom;
	}

	public void setCognom(String cognom) {
		this.cognom = cognom;
	}

	public String getAdreça() {
		return adreça;
	}

	public void setAdreça(String adreça) {
		this.adreça = adreça;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getTelefon() {
		return telefon;
	}

	public void setTelefon(int telefon) {
		this.telefon = telefon;
	}

	@Override
	public String toString() {
		return nom + " " + cognom;
	}
	
	
	
	
}
