package model;

import java.util.List;

public interface CambrerDAO {
	
	static int Tots(Connexio con, List <Cambrer> cambrers) {
		return 0;
	}

	// Bicicleta cercaArticle(Bicicleta art, Conexio connexio);
	int create(Cambrer cambre, Connexio con);

	int update(Cambrer cambre, Connexio con);

	int delete(Cambrer cambre, Connexio con);


}
