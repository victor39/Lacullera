package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RestaurantDAOImpl implements RestaurantDAO {

	@Override
	public int create(Connexio con, Restaurant restaurant) {

		int result = 0;

		try {

			String sql = "INSERT INTO restaurant (Adreca,Telefon) VALUES ('"
					+ restaurant.getAdreca() + "," + restaurant.getTelefon() + ");";

			PreparedStatement stm = con.getConnexio().prepareStatement(sql);
			stm.executeUpdate(sql);
			System.out.println(sql);
			result = 1;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int update(Connexio con, Restaurant restaurant) {
		int result = 0;

		try {
			String sql = "UPDATE restaurant " + "SET Adreca"
					+ restaurant.getAdreca() + "," + "Telefon" + restaurant.getTelefon() + "WHERE idRestaurant = " + restaurant.getIdRestaurant() + ";";

			PreparedStatement stm = con.getConnexio().prepareStatement(sql);
			stm.executeUpdate(sql);
			System.out.println(sql);
			result = 1;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int delete(Connexio con, Restaurant restaurant) {
		int result = 0;
		try {

			String sql = "DELETE FROM restaurant WHERE idRestaurant = " + restaurant.getIdRestaurant() + " ;";

			PreparedStatement stm = con.getConnexio().prepareStatement(sql);
			stm.executeUpdate(sql);
			System.out.println(sql);
			result = 1;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
