package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class TornDAOImpl implements TornDAO{


	public static int Tots(Connexio con, List<Torn> torn, int idRestaurant, LocalDate data) {

		int respo = 0;

		try {
			String sql = "SELECT * FROM Torn where idRestaurant = " + idRestaurant + " AND DiaSetmana = " + data.getDayOfWeek().getValue()+";";
			System.out.println(sql);
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

				String[] aux = torn.toString().split("Capacitat: ");
				System.out.println(aux[0] + aux[1]);
				if(aux[1].indexOf(',') < 0) {
					System.out.println("Ho sento estem plens " + (aux[1].substring(0,aux[1].length()-1)));
					respo = Integer.parseInt(aux[1].substring(0,aux[1].length()-1));
					
				}
				else {
					
					System.out.println("Endavant " + aux[1]);
					respo = Integer.parseInt(aux[1].substring(0,aux[1].indexOf(',')));
				}
			}

		} catch (SQLException e) {
			//e.printStackTrace();
		}

		return respo;
	}
	@Override
	public int create(Connexio con, Torn torn) {

		int res = 0;

		try {
			String sql = "INSERT INTO Torn (idRestaurant, DiaSetmana, HoraInici, ReservesDisponibles) VALUES ('" + torn.getRestaurant()
			+ "','" + torn.getDiaSetmana() + "','" + torn.getHoraInici() + "'," + torn.getReservesDisponibles() + ");";


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
	
	public static int Existeix(Connexio con, Torn torn) {

		int respo = 0;

		try {
			String sql = "SELECT count(*) as existeix FROM Torn WHERE idRestaurant = '" + torn.getRestaurant() + "' AND DiaSetmana = '" + torn.getDiaSetmana() + "' AND HoraInici = '" + torn.getHoraInici() + "';";
			System.out.println(sql);
			PreparedStatement stm = con.getConnexio().prepareStatement(sql);
			ResultSet rst = stm.executeQuery(sql);

			if(rst.next()) {
				respo = rst.getInt("existeix");
			}
			

		} catch (SQLException e) {
			//e.printStackTrace();
		}

		return respo;
	}
}
