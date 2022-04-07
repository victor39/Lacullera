package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;
import java.util.List;

public class TornDAOImpl implements TornDAO{


	public static int Tots(Connexio con, List<Torn> torn, int idRestaurant) {

		try {
			String sql = "SELECT * FROM Torn where idRestaurant = " + idRestaurant + ";";
			PreparedStatement stm = con.getConnexio().prepareStatement(sql);
			ResultSet rst = stm.executeQuery(sql);

			while (rst.next()) {
				int idHorari = rst.getInt("idHorari");
				idRestaurant = rst.getInt("idRestaurant");
				int DiaSetmana= rst.getInt("DiaSetmana");
				LocalTime HoraInici = rst.getObject("HoraInici", LocalTime.class);
				int ReservesDisponibles = rst.getInt("ReservesDisponibles");
				Torn torns = new Torn(idHorari,idRestaurant,DiaSetmana,HoraInici,ReservesDisponibles);
				torn.add(torns);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return torn.size();
	}
	@Override
	public int create(Connexio con, Torn torn) {

		int res = 0;

		try {
			String sql = "INSERT INTO Torn (idRestaurant, DiaSetmana, HoraInici, ReservesDisponibles) VALUES ('" + torn.getRestaurant()
			+ "','" + torn.getDiaSetmana() + "','" + torn.getHoraInici() + "'," + torn.getReservesDisponibles()  + "');";

			System.out.println(sql);

			PreparedStatement stm = con.getConnexio().prepareStatement(sql);
			res = stm.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}
	@Override
	public int update(Connexio con, Torn torn) {

		int res = 0;

		try {
			String sql = "UPDATE Torn SET DiaSetmana = " + torn.getDiaSetmana() + ", HoraInici = " + torn.getHoraInici()
			+ ", ReservesDisponibles = " + torn.getHoraInici() + " WHERE idHorari = " + torn.getIdHorari() + "and idRestaurant = " + torn.getRestaurant() + ";";

			PreparedStatement stm = con.getConnexio().prepareStatement(sql);
			res = stm.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}
	@Override
	public int delete(Connexio con, int torn, int restaurant) {

		int res = 0;

		try {
			String sql = "DELETE FROM Torn WHERE idRestaurant = " + restaurant + "and idHorari = " + torn + ";";

			PreparedStatement stm = con.getConnexio().prepareStatement(sql);
			res = stm.executeUpdate(sql);
			System.out.println(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;

	}
}
