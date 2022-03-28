package model;

public interface CartaDAO {
	
	static int Tots(Connexio con, List <Carta> cartas) {
		return 0;
	}

	// Bicicleta cercaArticle(Bicicleta art, Conexio connexio);
	int create(Carta carta, Connexio con);

	int update(Carta carta, Connexio con);

	int delete(Carta carta, Connexio con);


}
