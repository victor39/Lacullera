package model;

import java.time.LocalDate;

public class Reserva {

	private int idReserva;
	private Client client;
	private Restaurant restaurant;
	private LocalDate data;
	private Torn torn;
	private int comensals;
	private String observacions;

	public Reserva(int idReserva, Client client, Restaurant restaurant, LocalDate data, Torn torn, int comensals,
		String observacions) {
		this.idReserva = idReserva;
		this.client = client;
		this.restaurant = restaurant;
		this.data = data;
		this.torn = torn;
		this.comensals = comensals;
		this.observacions = observacions;
	}
	
	public Reserva(Client client, Restaurant restaurant, LocalDate data, Torn torn, int comensals,
		String observacions) {
		this.client = client;
		this.restaurant = restaurant;
		this.data = data;
		this.torn = torn;
		this.comensals = comensals;
		this.observacions = observacions;
	}
	
	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}
	public int getIdReserva() {
		return idReserva;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Torn getTorn() {
		return torn;
	}

	public void setTorn(Torn torn) {
		this.torn = torn;
	}

	public int getComensals() {
		return comensals;
	}

	public void setComensals(int comensals) {
		this.comensals = comensals;
	}

	public String getObservacions() {
		return observacions;
	}

	public void setObservacions(String observacions) {
		this.observacions = observacions;
	}

	@Override
	public String toString() {
		return "Num Reserva: " + idReserva + "/n Client: " + client.toString() + "/n Restaurant: " + restaurant.toString() + "/n Data: " + data + "/n Torn: " + torn.toString() + "/n Comensals: " + comensals;
	}

}
