package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransportistaDAOImpl implements TransportistaDAO {

	@Override
	public int create(Transportista transportista, Connexio con) {
		int result = 0;

		try {

			String sql = "INSERT INTO personal (dni,nom,cognom,telefon,adreca,correu,administrador,tipus,restaurant) VALUES ('"
					+ transportista.getDni() + "'," + transportista.getNom() + "," + transportista.getCognom() + "," + transportista.getTelefon()
					+ "," + transportista.getCorreu() + "," + transportista.getTipus() + "," + transportista.getRestaurant() + ");";

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
	public int update(Transportista transportista, Connexio con) {
	
		int result = 0;

		try {
			String sql = "UPDATE personal " + "SET nom = " + transportista.getNom() + "," + "cognom"
					+ transportista.getCognom() + "," + "telefon" + transportista.getTelefon() + "," + "correu = "
					+ transportista.getCorreu() + "," + "tipus = " + transportista.getTipus() + "," + "restaurant = "
					+ transportista.getRestaurant() + "," + "WHERE dni = " + transportista.getDni() + ";";

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
	public int delete(Transportista transportista, Connexio con) {
		
		int result = 0;
		try {

			String sql = "DELETE FROM personal WHERE dni = " + transportista.getDni() + " ;";

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
