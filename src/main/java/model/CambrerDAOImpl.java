package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CambrerDAOImpl implements CambrerDAO {

	@Override
	public int create(Cambrer cambrer, Connexio con) {

		int result = 0;

		try {

			String sql = "INSERT INTO personal (dni,nom,cognom,telefon,adreca,correu,administrador,tipus,restaurant) VALUES ('"
					+ cambrer.getDni() + "'," + cambrer.getNom() + "," + cambrer.getCognom() + "," + cambrer.getTelefon()
					+ "," + cambrer.getCorreu() + "," + cambrer.getTipus() + "," + cambrer.getRestaurant() + ");";

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
	public int update(Cambrer cambrer, Connexio con) {

		int result = 0;

		try {
			String sql = "UPDATE projecte.personal " + "SET nom = " + cambrer.getNom() + "," + "cognom"
					+ cambrer.getCognom() + "," + "telefon" + cambrer.getTelefon() + "," + "correu = "
					+ cambrer.getCorreu() + "," + "tipus = " + cambrer.getTipus() + "," + "restaurant = "
					+ cambrer.getRestaurant() + "," + "WHERE dni = " + cambrer.getDni() + ";";

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
	public int delete(Cambrer cambrer, Connexio con) {
		
		int result = 0;
		try {

			String sql = "DELETE FROM projecte.personal WHERE dni = " + cambrer.getDni() + " ;";

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
