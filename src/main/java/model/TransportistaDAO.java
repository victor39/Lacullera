package model;

public interface TransportistaDAO {
	
	static int Tots(Connexio con, List <Transportista> transportistas) {
		return 0;
	}

	// Bicicleta cercaArticle(Bicicleta art, Conexio connexio);
	int create(Transportista transportista, Connexio con);

	int update(Transportista client, Connexio con);

	int delete(Transportista client, Connexio con);


}
