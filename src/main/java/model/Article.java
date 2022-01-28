package model;

public class Article {
	
	
	private int idArticle;
	private String nom;
	private float preu;
	private String alergens;
	private String descripcio;
	private String observacions;
	
	
	public Article(String nom, float preu, String alergens, String descripcio, String observacions) {
		this.nom = nom;
		this.preu = preu;
		this.alergens = alergens;
		this.descripcio = descripcio;
		this.observacions = observacions;
	}

	public int getIdArticle() {
		return idArticle;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public float getPreu() {
		return preu;
	}

	public void setPreu(float preu) {
		this.preu = preu;
	}

	public String getAlergens() {
		return alergens;
	}

	public void setAlergens(String alergens) {
		this.alergens = alergens;
	}

	public String getDescripcio() {
		return descripcio;
	}

	public void setDescripcio(String descripcio) {
		this.descripcio = descripcio;
	}

	public String getObservacions() {
		return observacions;
	}

	public void setObservacions(String observacions) {
		this.observacions = observacions;
	}
	
	//Hola esto es una prueba

	@Override
	public String toString() {
		return "Article [idArticle=" + idArticle + ", nom=" + nom + ", preu=" + preu + ", alergens=" + alergens
				+ ", descripcio=" + descripcio + ", observacions=" + observacions + "]";
	}
	
	
	
	
	
}
