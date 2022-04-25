package model;

import java.sql.Time;
import java.time.LocalTime;

public class Torn {
	
	private int idHorari;
	private int restaurant;
	private int diaSetmana;
	private LocalTime horaInici;
	private int reservesDisponibles;
	
	
	
	public Torn(int idHorari, int idRestaurant, int diaSetmana, LocalTime horaInici, int reservesDisponibles) {
		this.idHorari = idHorari;
		this.restaurant = idRestaurant;
		this.diaSetmana = diaSetmana;
		this.horaInici = horaInici;
		this.reservesDisponibles = reservesDisponibles;
	}
	
	public Torn(LocalTime horaInici) {
		this.horaInici = horaInici;
	}

	public Torn(int restaurant, int diaSetmana, LocalTime horaInici, int reservesDisponibles) {
		this.restaurant = restaurant;
		this.diaSetmana = diaSetmana;
		this.horaInici = horaInici;
		this.reservesDisponibles = reservesDisponibles;
	}

	public int getIdHorari() {
		return idHorari;
	}

	public int getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(int restaurant) {
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
		return this.horaInici.toString();
	}
	
}
