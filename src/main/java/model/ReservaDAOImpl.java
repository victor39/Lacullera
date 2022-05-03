package model;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javafx.collections.ObservableList;

public class ReservaDAOImpl implements ReservaDAO {

	@Override
	public int create(Connexio con, Reserva reserva) {
		int res = 0;

		try {
			String sql = "INSERT INTO Reserva(idClient, idRestaurant, idTorn, Data, Comensals, Observacions) VALUES ("
					+ "'" + reserva.getClient().getDni() + "'" + ", " + reserva.getRestaurant().getIdRestaurant() + ", "
					+ reserva.getTorn().getIdHorari() + ", " + "'" + reserva.getData() + "'" + ", "
					+ reserva.getComensals() + ", " + reserva.getObservacions() + ");";

			System.out.println(sql);

			PreparedStatement stm = con.getConnexio().prepareStatement(sql);
			res = stm.executeUpdate(sql);

			ResultSet rst = stm.executeQuery("SELECT @@Identity as id");

			if (rst.next()) {

				reserva.setIdReserva(rst.getInt("id"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}

	public static int buscar(Connexio con, ObservableList<Reserva> llista, String id) {

		try {
			// String sql = "SELECT * FROM Reserva WHERE idClient = " + id + " AND Data =
			// curdate();";
			String sql = " SELECT c.Dni,c.Nom,c.Cognom ,c.Telefon ,c.Adreca, c.Correu , r.capacitat, r.idRestaurant ,r.Nom , r.Adreca , r.telefon, t.idHorari , t.idRestaurant , t.DiaSetmana ,t.HoraInici , t.ReservesDisponibles , re.idReserva , re.idClient, re.idRestaurant , re.idTorn , re.Data , re.Comensals , re.Observacions  FROM Reserva re INNER JOIN Restaurant r ON r.idRestaurant = re.idRestaurant INNER JOIN Torn t ON t.idRestaurant = r.idRestaurant INNER JOIN Client c ON c.Dni = re.idClient WHERE re.idClient = '"
					+ id + "';";
			PreparedStatement stm = con.getConnexio().prepareStatement(sql);
			ResultSet rst = stm.executeQuery(sql);

			while (rst.next()) {
				int idReserva = rst.getInt("idReserva");
				String idClient = rst.getString("idClient");
				String nom = rst.getString("Nom");
				String cognom = rst.getString("Cognom");
				String adreca = rst.getString("Adreca");
				String dni = rst.getString("Dni");
				int telefon = rst.getInt("Telefon");
				String correu = rst.getString("Adreca");
				Client client = new Client(nom, cognom, adreca, dni, telefon, correu);

				int idRestaurant = rst.getInt("idRestaurant");
				String nomRestaurant = rst.getString("r.Nom");
				String adrecaRestaurant = rst.getString("r.Adreca");
				int telefonRestaurant = rst.getInt("r.Telefon");
				int capacitatRestaurant = rst.getInt("r.capacitat");
				Restaurant restaurant = new Restaurant(idRestaurant, nomRestaurant, adrecaRestaurant, telefonRestaurant, capacitatRestaurant,capacitatRestaurant);

				int idHorari = rst.getInt("t.idHorari");
				int diaSetmana = rst.getInt("t.diaSetmana");
				LocalTime horari1 = rst.getTime("t.HoraInici").toLocalTime();
				int reservesDisponibles = rst.getInt("t.reservesDisponibles");
				Torn torn = new Torn(idHorari, idRestaurant, horari1, reservesDisponibles);

				LocalDate Data = rst.getObject("Data", LocalDate.class);
				int Comensals = rst.getInt("Comensals");
				Reserva reserva = new Reserva(idReserva, client, restaurant, Data, torn, Comensals, "");

				llista.add(reserva);
			}
			/*
			for (int i = 0; i < llista.size(); i++) {
				System.out.println("IdReserva: " + llista.get(i).getIdReserva() + ", Observacions : "
						+ llista.get(i).getObservacions() + "NomClient : " + llista.get(i).getClient().getNom());
			}
			*/

		} catch (SQLException e) {
			System.out.println("Error: " + e.toString());
		}

		return llista.size();

	}

	@Override
	public int update(Connexio con, Reserva reserva) {
		int result = 0;

		try {
			String sql = "UPDATE Reserva " + "SET idTorn = " + reserva.getTorn().getIdHorari() + "," + "Data = "
					+"'"+ reserva.getData()+ "'"+ "," + "Comensals = " + reserva.getComensals() + " WHERE idReserva = " + reserva.getIdReserva() + ";";

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
	public int delete(Connexio con, Reserva reserva) {
		int result = 0;
		try {

			String sql = "DELETE FROM Reserva WHERE idReserva = " + reserva.getIdReserva() + " ;";

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
