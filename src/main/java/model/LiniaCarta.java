package model;

public class LiniaCarta {
	
	private int idLiniaCarta;
	private Carta carta;
	private Article article;
	private float preu;
	
	public LiniaCarta(Carta carta, Article article, float preu) {
		this.carta = carta;
		this.article = article;
		this.preu = preu;
	}

	public LiniaCarta(int idLiniaCarta, Carta carta, Article article, float preu) {
		this.idLiniaCarta = idLiniaCarta;
		this.carta = carta;
		this.article = article;
		this.preu = preu;
	}

	public int getIdLiniaCarta() {
		return idLiniaCarta;
	}


	public Carta getCarta() {
		return carta;
	}

	public void setCarta(Carta carta) {
		this.carta = carta;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public float getPreu() {
		return preu;
	}

	public void setPreu(float preu) {
		this.preu = preu;
	}

	@Override
	public String toString() {
		return article +": "+ preu;
	}
	
	
	
	

}
