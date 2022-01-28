package model;

import java.util.ArrayList;

public class Carta {
	
	private int idCarta;
	private String nomCarta;
	private boolean activat;
	private ArrayList<LiniaCarta> liniesCarta;
	
	public Carta(int idCarta, String nomCarta, boolean activat) {
		this.idCarta = idCarta;
		this.nomCarta = nomCarta;
		this.activat = activat;
		this.liniesCarta = new ArrayList <LiniaCarta>();
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
	
	public ArrayList<LiniaCarta> getLiniesCarta(){
		return liniesCarta;
	}
	
	public void setLiniesCarta(ArrayList<LiniaCarta> liniesCarta){
		this.liniesCarta = liniesCarta;
	}

	@Override
	public String toString() {
		return  nomCarta;
	}

	
}
