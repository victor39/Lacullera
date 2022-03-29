package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ArticleDAOImpl implements ArticleDAO {

	@Override
	public int create(Article article, Connexio con) {

		int res = 0;
		
		try {
			String sql = "INSERT INTO article(preu, nom, Alergens, Descripcio, Observacions) VALUES (" + article.getPreu() + ", " + article.getNom() + ", " + article.getAlergens() + ", " + article.getDescripcio() + ", " + article.getObservacions() + ");";
			
			System.out.println(sql);
			
			PreparedStatement stm = con.getConnexio().prepareStatement(sql);
			res = stm.executeUpdate(sql);
			
			ResultSet rst = stm.executeQuery("SELECT @@Identity as id");
			
			if(rst.next()) {

				article.setIdArticle(rst.getInt("id"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int update(Article article, Connexio con) {
		
		int res = 0;
		
		try {
			String sql = "UPDATE article SET preu = " + article.getPreu() + ", nom = " + article.getNom() + ", Alergens = " + article.getAlergens() + ", Descripcio = " + article.getDescripcio() + ", Observacions = " + article.getObservacions() + " WHERE idArticle = " + article.getIdArticle() + ";";
			
			PreparedStatement stm = con.getConnexio().prepareStatement(sql);
			res = stm.executeUpdate(sql);
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int delete(Article article, Connexio con) {
		
		int res = 0;
		
		try {
			String sql = "DELETE FROM article WHERE idArticle = " + article.getIdArticle() +";";
			
			PreparedStatement stm = con.getConnexio().prepareStatement(sql);
			res = stm.executeUpdate(sql);
			System.out.println(sql);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}

}
