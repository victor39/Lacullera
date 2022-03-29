package model;

import java.util.List;

public interface ComandaDAO {
	
	static int Tots(Connexio con, List <Comanda> comandas) {
		return 0;
	}

	// Bicicleta cercaArticle(Bicicleta art, Conexio connexio);
	int create(Comanda comanda, Connexio con);

	int update(Comanda comanda, Connexio con);

	int delete(Comanda comanda, Connexio con);


}
