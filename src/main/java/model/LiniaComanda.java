package model;

public class LiniaComanda {
	
	private Comanda comanda;
    private int idLiniaComanda;
	private Article article;
	private int quantitat;
	private float preu;
	
	public LiniaComanda(int idLiniaComanda, Article article, int quantitat, float preu, Comanda comanda) {
		this.idLiniaComanda = idLiniaComanda;
		this.article = article;
		this.quantitat = quantitat;
		this.preu = preu;
		this.comanda = comanda;
	}

	public LiniaComanda(Article article, int quantitat, float preu, Comanda comanda) {
		this.article = article;
		this.quantitat = quantitat;
		this.preu = preu;
		this.comanda = comanda;
	}

	public int getidLiniaComanda() {
		return idLiniaComanda;
	}

	public int getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public int getQuantitat() {
		return quantitat;
	}

	public void setQuantitat(int quantitat) {
		this.quantitat = quantitat;
	}

	public float getPreu() {
		return preu;
	}

	public void setPreu(float preu) {
		this.preu = preu;
	}

	public Comanda getComanda() {
		return comanda;
	}

	public void setComanda(Comanda comanda) {
		this.comanda = comanda;
	}

	@Override
	public String toString() {
		return article.getNom() + ": " + preu;
	}
	
}


