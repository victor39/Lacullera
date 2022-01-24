package model;

public class LiniaComanda {
	
    int lineaComanda;
	int article;
	int quantitat;
	float preu;
	Comanda idComanda;
	
	public LiniaComanda(int lineaComanda, int article, int quantitat, float preu, Comanda idComanda) {
		this.lineaComanda = lineaComanda;
		this.article = article;
		this.quantitat = quantitat;
		this.preu = preu;
		this.idComanda = idComanda;
	}

	public int getLineaComanda() {
		return lineaComanda;
	}

	public void setLineaComanda(int lineaComanda) {
		this.lineaComanda = lineaComanda;
	}

	public int getArticle() {
		return article;
	}

	public void setArticle(int article) {
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

	public Comanda getIdComanda() {
		return idComanda;
	}

	public void setIdComanda(Comanda idComanda) {
		this.idComanda = idComanda;
	}

	@Override
	public String toString() {
		return "LiniaComanda [lineaComanda=" + lineaComanda + ", article=" + article + ", quantitat=" + quantitat
				+ ", preu=" + preu + ", idComanda=" + idComanda + "]";
	}
	
	
	
	
}


