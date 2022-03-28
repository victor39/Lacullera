package model;

public interface ComandaDAO {
	
	static int Tots(Connexio con, List <Comanda> comandas) {
		return 0;
	}

	// Bicicleta cercaArticle(Bicicleta art, Conexio connexio);
	int create(Comanda client, Connexio con);

	int update(Comanda client, Connexio con);

	int delete(Comanda client, Connexio con);


}
