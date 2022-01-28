package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Comanda {

	private int idComanda;
	private Client client;
	private Personal responsable;
	private LocalTime hora;
	private LocalDate data;
	private String descompte;
	private float preu;
	private Restaurant restaurant;
	private ArrayList<LiniaComanda> liniesComanda;

	
	public Comanda(Client client, Personal responsable, LocalTime hora, LocalDate data, String descompte, float preu,
			Restaurant restaurant) {
		this.client = client;
		this.responsable = responsable;
		this.hora = hora;
		this.data = data;
		this.descompte = descompte;
		this.preu = preu;
		this.restaurant = restaurant;
		this.liniesComanda = new ArrayList<LiniaComanda>();
	}

	public Comanda(int idComanda, Client client, Personal responsable, LocalTime hora, LocalDate data, String descompte,
			float preu, Restaurant restaurant) {
		this.idComanda = idComanda;
		this.client = client;
		this.responsable = responsable;
		this.hora = hora;
		this.data = data;
		this.descompte = descompte;
		this.preu = preu;
		this.restaurant = restaurant;
		this.liniesComanda = new ArrayList<LiniaComanda>();

	}

	public int getIdComanda() {
		return idComanda;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Personal getResponsable() {
		return responsable;
	}

	public void setResponsable(Personal responsable) {
		this.responsable = responsable;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getDescompte() {
		return descompte;
	}

	public void setDescompte(String descompte) {
		this.descompte = descompte;
	}

	public float getPreu() {
		return preu;
	}

	public void setPreu(float preu) {
		this.preu = preu;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public ArrayList<LiniaComanda> getLiniesComanda(){
		return liniesComanda;
	}
	
	public void setLiniesComanda(ArrayList<LiniaComanda> liniesComanda){
		this.liniesComanda = liniesComanda;
	}

	@Override
	public String toString() {
		return "Num Comanda: " + idComanda + "/n Client: " + client.toString() + "/n Restaurant: " + restaurant.toString() + "/n Preu: " + preu;
	}
	
	
	
	
	
	
}
