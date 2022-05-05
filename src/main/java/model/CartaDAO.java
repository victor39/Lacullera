package model;

import java.util.List;

public interface CartaDAO {
	
	static int Tots(Connexio con, List <Carta> cartas) {
		return 0;
	}

	int create(Carta carta, Connexio con);

	int update(Carta carta, Connexio con);

	int delete(Carta carta, Connexio con);


}
