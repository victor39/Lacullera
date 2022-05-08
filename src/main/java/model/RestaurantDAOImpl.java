package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class RestaurantDAOImpl implements RestaurantDAO {
	
	public static int Tots(Connexio con, List <Restaurant> array) {
		
		try {
			String sql = "SELECT * FROM Restaurant ;";
			PreparedStatement stm = con.getConnexio().prepareStatement(sql);
			ResultSet rst = stm.executeQuery(sql);

			while (rst.next()) {
				int idRestaurant = rst.getInt("idRestaurant");
				String Nom = rst.getString("Nom");
				String Adreca = rst.getString("Adreca");
				int Telefon = rst.getInt("Telefon");
		
				Restaurant restaurant = new Restaurant(idRestaurant,Nom , Adreca, Telefon);
				array.add(restaurant);

			}
//			for (int i = 0; i < array.size(); i++) {
//				System.out.println("idRestaurant: " + array.get(i).getIdRestaurant() + "Nom : " + array.get(i).getNom()
//						+ "Adreca" + array.get(i).getAdreca() + "Telefon  " + array.get(i).getTelefon());
//			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return array.size();
	}

	@Override
	public int create(Connexio con, Restaurant restaurant) {

		int result = 0;

		try {
			String sql = "INSERT INTO Restaurant (Nom,Adreca,telefon) VALUES ('" + restaurant.getNom() + "' , '" + restaurant.getAdreca() + "'," + restaurant.getTelefon() + ");";
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
			String sql = "UPDATE restaurant " + "SET Adreca = '"
					+ restaurant.getAdreca() + "'," + "Telefon = '" + restaurant.getTelefon() +  "' WHERE idRestaurant = " + restaurant.getIdRestaurant() + ";";

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

			String sql = "DELETE FROM Restaurant WHERE idRestaurant = " + restaurant.getIdRestaurant() + " ;";

			PreparedStatement stm = con.getConnexio().prepareStatement(sql);
			stm.executeUpdate(sql);
			System.out.println(sql);
			result = 1;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static int cercaRestaurant(Connexio con, Restaurant restaurant) {
		
		try {
			String sql = "SELECT * FROM Restaurant WHERE idRestaurant = " + restaurant.getIdRestaurant() + " ;";
			PreparedStatement stm = con.getConnexio().prepareStatement(sql);
			ResultSet rst = stm.executeQuery(sql);

			while (rst.next()) {
				
				restaurant.setNom(rst.getString("Nom"));
				restaurant.setAdreca(rst.getString("Adreca"));
				restaurant.setTelefon(rst.getInt("Telefon"));
				
			}
//			for (int i = 0; i < array.size(); i++) {
//				System.out.println("idRestaurant: " + array.get(i).getIdRestaurant() + "Nom : " + array.get(i).getNom()
//						+ "Adreca" + array.get(i).getAdreca() + "Telefon  " + array.get(i).getTelefon());
//			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 1;
		
	}

}
