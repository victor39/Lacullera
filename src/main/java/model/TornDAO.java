package model;

import java.util.List;

public interface TornDAO {
	
	int Tots(Connexio con, List <Torn> torn, int idTorn);
	
	int create(Torn torn, Connexio con);

	int update(Torn torn, Connexio con);

	int delete(Connexio con, Torn torn, int tornr);


}