package model;

import java.util.List;

public interface TornDAO {
	
	static int Tots(Connexio con, List <Torn> torn, int idTorn) {
		return 0;
	}
	
	static int Existeix(Connexio con, Torn torn) {
		return 0;
	}
	
	int create(Connexio con, Torn torn);

	int update(Connexio con, Torn torn);

	int delete(Connexio con, int torn, int tornr);
}