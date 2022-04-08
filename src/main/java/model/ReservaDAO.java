package model;

import java.util.List;

import javafx.collections.ObservableList;

public interface ReservaDAO {
	
	public static int Tots(Connexio con, List<Reserva> array) {
		return 0;
	}
	
	public static int Buscar(Connexio con, ObservableList<Reserva> array, String DNI) {
		return 0;
	}
	
	int create(Connexio con, Reserva reserva);
	int update(Connexio con, Reserva reserva);
	int delete(Connexio con, Reserva reserva);
	

}
