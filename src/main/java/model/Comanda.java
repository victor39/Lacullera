package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Comanda {

	int idComanda;
	Client client;
	Personal responsable;
	LocalTime hora;
	LocalDate data;
	String descompte;
	float preu;
	Restaurant restaurant;
	
	public Comanda(Client client, Personal responsable, LocalTime hora, LocalDate data, String descompte, float preu,
			Restaurant restaurant) {
		this.client = client;
		this.responsable = responsable;
		this.hora = hora;
		this.data = data;
		this.descompte = descompte;
		this.preu = preu;
		this.restaurant = restaurant;
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

	@Override
	public String toString() {
		return "Comanda [idComanda=" + idComanda + ", client=" + client + ", responsable=" + responsable + ", hora="
				+ hora + ", data=" + data + ", descompte=" + descompte + ", preu=" + preu + ", restaurant=" + restaurant
				+ "]";
	}
	
	
	
	
	
	
}
