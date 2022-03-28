package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ArticleDAOImpl implements ArticleDAO {

	@Override
	public int create(Article article, Connexio con) {

		int res = 0;
		
		try {
			String sql = "INSERT INTO article(preu, nom, Alergens, Descripcio, Observacions) VALUES ("article.getPreu()");";
			
			System.out.println(sql);
			
			PreparedStatement stm = con.getConnexio().prepareStatement(sql);
			res = stm.executeUpdate(sql);
			
			ResultSet rst = stm.executeQuery("SELECT @@Identity as id");
			
			if(rst.next()) {

				tiq.setId(rst.getInt("id"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int update(Article article, Connexio con) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Article article, Connexio con) {
		// TODO Auto-generated method stub
		return 0;
	}

}
