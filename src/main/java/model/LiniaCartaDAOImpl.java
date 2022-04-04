package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class LiniaCartaDAOImpl implements LiniaCartaDAO {

	/*static int TotsPrimers(Connexio con, List<LiniaCarta> liniaCarta, int id) {

		try {
			String sql = "SELECT Article.nom FROM LiniaCarta INNER JOIN Article ON LiniaCarta.idArticle = Article.idArticle  ";
			PreparedStatement stm = con.getConnexio().prepareStatement(sql);
			ResultSet rst = stm.executeQuery(sql);

			while (rst.next()) {
				int idRestaurant = rst.getInt("idRestaurant");
				String Nom = rst.getString("Nom");
				String Adreca = rst.getString("Adreca");
				int Telefon = rst.getInt("Telefon");
				LiniaCarta linia = new LiniaCarta(idRestaurant, Nom, Adreca, Telefon);
				liniaCarta.add(linia);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return liniaCarta.size();
	}
	*/

	static int TotsSegons(Connexio con, List<LiniaCarta> liniaCarta, int id) {

		return 0;
	}

	static int TotsPostres(Connexio con, List<LiniaCarta> liniaCarta, int id) {

		return 0;
	}

	@Override
	public int create(Connexio con, LiniaCarta liniacarta) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Connexio con, LiniaCarta liniacarta) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Connexio con, LiniaCarta liniacarta) {
		// TODO Auto-generated method stub
		return 0;
	}

}
