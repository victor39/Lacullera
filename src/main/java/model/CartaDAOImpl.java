package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CartaDAOImpl implements CartaDAO {

	public static int Tots(Connexio con, List <Carta> cartas) {
		return 0;
	}
	
	@Override
	public int create(Carta carta, Connexio con) {
		
		int result = 0;

		try {

			String sql = "INSERT INTO carta (idCarta,NomCarta,activitat,) VALUES ('"
					+ carta.getNomCarta() + "'," + carta.isActivat() + ","  + ");";

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
	public int update(Carta carta, Connexio con) {
		int result = 0;

		try {
			String sql = "UPDATE carta " + "SET nomCarta = " + carta.getNomCarta() + "," + "activitat"
					+ carta.isActivat() + "," + "WHERE idCarta = " + carta.getIdCarta() + ";";

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
	public int delete(Carta carta, Connexio con) {
		int result = 0;
		try {

			String sql = "DELETE FROM carta WHERE dni = " + carta.getIdCarta() + " ;";

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
