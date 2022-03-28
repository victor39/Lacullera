package model;

import java.util.List;

public interface ArticleDAO {
	
	static int Tots(Connexio con, List <Article> articles) {
		return 0;
	}

	// Bicicleta cercaArticle(Bicicleta art, Conexio connexio);
	int create(Article article, Connexio con);

	int update(Article article, Connexio con);

	int delete(Article article, Connexio con);


}
