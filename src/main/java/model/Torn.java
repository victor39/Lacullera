package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public class Torn {
	
	private int idHorari;
	private int restaurant;
	private int diaSetmana;
	private LocalTime horaInici;
	private int reservesDisponibles;
	
	private LocalDate dia;

	
	
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
	
	public void setDia(LocalDate data) {
		this.dia = data;
	}
	
	public LocalDate getDia() {
		return this.dia;
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
		
		Connexio con = new Connexio();
		
		String resActu = "";
		
		try {

			String sql =  "SELECT SUM(Comensals) as capacitat FROM Reserva rese INNER JOIN Torn t on rese.idTorn = t.idHorari WHERE rese.idTorn = '" + this.idHorari + "';";
			
			PreparedStatement stm = con.getConnexio().prepareStatement(sql);
			ResultSet rst = stm.executeQuery(sql);
			
			while(rst.next()) {
				resActu = rst.getString("capacitat");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(resActu == null) {
			resActu = "0";
		}
		
		return horaInici.toString() + " | Capacitat: " + (reservesDisponibles - Integer.parseInt(resActu)) ;
	}
	
}
