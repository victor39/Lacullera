package model;

import java.util.List;

public interface ReservaDAO {
	
	static int Tots(Connexio con, List<Reserva> array) {
		return 0;
	}
	
	boolean create(Connexio con, Reserva reserva);
	boolean update(Connexio con, Reserva reserva);
	boolean delete(Connexio con, int id);

}
