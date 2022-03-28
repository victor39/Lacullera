package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CambrerDAOImpl implements CambrerDAO {

	@Override
	public int create(Cambrer cambre, Connexio con) {

		int result = 0;

		try {

			String sql = "INSERT INTO personal (dni,nom,cognom,telefon,adreca,correu,administrador,tipus,restaurant) VALUES ('"
					+ cambre.getDni() + "'," + cambre.getNom() + "," + cambre.getCognom() + "," + cambre.getTelefon()
					+ "," + cambre.getCorreu() + "," + cambre.getTipus() + "," + cambre.getRestaurant() + ");";

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
	public int update(Cambrer cambre, Connexio con) {

		int result=0;
		
		try {
			String sql = "UPDATE projecte.personal " + "SET nom = " + cambre.getNom() + "," + "cognom"
					+ cambre.getCognom() + "," + "telefon" + cambre.getTelefon() + "," + "correu = " + cambre.getCorreu() + ","
					+ "tipus = " + cambre.getTipus() + "," + "restaurant = " + cambre.getRestaurant() + ","
					+ "WHERE dni = " + cambre.getDni()
					+ ";";

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
	public int delete(Cambrer cambre, Connexio con) {
		// TODO Auto-generated method stub
		return 0;
	}

}
