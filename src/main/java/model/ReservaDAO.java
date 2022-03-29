package model;

import java.util.List;

public interface ReservaDAO {
	
	static int Tots(Connexio con, List<Reserva> array) {
		return 0;
	}
	
	int create(Connexio con, Reserva reserva);
	int update(Connexio con, Reserva reserva);
	int delete(Connexio con, Reserva reserva);

}
