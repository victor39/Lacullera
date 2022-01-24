package model;

public class Carta {
	
	private int idCarta;
	private String nomCarta;
	private boolean activat;
	
	public Carta(int idCarta, String nomCarta, boolean activat) {
		this.idCarta = idCarta;
		this.nomCarta = nomCarta;
		this.activat = activat;
	}

	public int getIdCarta() {
		return idCarta;
	}

	public String getNomCarta() {
		return nomCarta;
	}

	public void setNomCarta(String nomCarta) {
		this.nomCarta = nomCarta;
	}

	public boolean isActivat() {
		return activat;
	}

	public void setActivat(boolean activat) {
		this.activat = activat;
	}

	@Override
	public String toString() {
		return "Carta [idCarta=" + idCarta + ", nomCarta=" + nomCarta + ", activat=" + activat + "]";
	}

	
}
