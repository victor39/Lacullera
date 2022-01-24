package model;

import java.time.LocalTime;

public class Torn {
	
	private int idHorari;
	private Restaurant restaurant;
	private int diaSetmana;
	private LocalTime horaInici;
	private int reservesDisponibles;
	
	public Torn(int idHorari, Restaurant restaurant, int diaSetmana, LocalTime horaInici, int reservesDisponibles) {
		this.idHorari = idHorari;
		this.restaurant = restaurant;
		this.diaSetmana = diaSetmana;
		this.horaInici = horaInici;
		this.reservesDisponibles = reservesDisponibles;
	}

	public Torn(Restaurant restaurant, int diaSetmana, LocalTime horaInici, int reservesDisponibles) {
		this.restaurant = restaurant;
		this.diaSetmana = diaSetmana;
		this.horaInici = horaInici;
		this.reservesDisponibles = reservesDisponibles;
	}

	public int getIdHorari() {
		return idHorari;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public int getDiaSetmana() {
		return diaSetmana;
	}

	public void setDiaSetmana(int diaSetmana) {
		this.diaSetmana = diaSetmana;
	}

	public LocalTime getHoraInici() {
		return horaInici;
	}

	public void setHoraInici(LocalTime horaInici) {
		this.horaInici = horaInici;
	}

	public int getReservesDisponibles() {
		return reservesDisponibles;
	}

	public void setReservesDisponibles(int reservesDisponibles) {
		this.reservesDisponibles = reservesDisponibles;
	}

	@Override
	public String toString() {
		return "Torn [idHorari=" + idHorari + ", restaurant=" + restaurant + ", diaSetmana=" + diaSetmana
				+ ", horaInici=" + horaInici + ", reservesDisponibles=" + reservesDisponibles + "]";
	}
	
}
