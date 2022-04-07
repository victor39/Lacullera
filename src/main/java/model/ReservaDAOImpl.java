package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class ReservaDAOImpl implements ReservaDAO {

	@Override
	public int create(Connexio con, Reserva reserva) {
	int res = 0;
		
		try {
			String sql = "INSERT INTO Reserva(idClient, idRestaurant, idTorn, Data, Comensals, Observacions) VALUES (" +"'"+ reserva.getClient().getDni() +"'"+ ", " + reserva.getRestaurant().getIdRestaurant() + ", " + reserva.getTorn().getIdHorari() + ", " +"'"+ reserva.getData()  +"'"+ ", " + reserva.getComensals() + ", "  + reserva.getObservacions() +");";
			
			System.out.println(sql);
			
			PreparedStatement stm = con.getConnexio().prepareStatement(sql);
			res = stm.executeUpdate(sql);
			
			ResultSet rst = stm.executeQuery("SELECT @@Identity as id");
			
			if(rst.next()) {

				reserva.setIdReserva(rst.getInt("id"));
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}
	
	public static int buscar(Connexio con, List<Reserva> llista, String id) {
		
		try {
			String sql = "SELECT * FROM Reserva where idClient = " + id + " and Data = curdate();";
			PreparedStatement stm = con.getConnexio().prepareStatement(sql);
			ResultSet rst = stm.executeQuery(sql);

			while (rst.next()) {
				int idReserva = rst.getInt("idReserva");
				String idClient = rst.getString("idClient");
				Client clt = new Client(idClient, idClient, idClient, idClient, idReserva, idClient);
				int idRestaurant = rst.getInt("idRestaurant");
				Restaurant rest = new Restaurant(idRestaurant, idClient, idClient, idRestaurant);
				int idTorn = rst.getInt("idTorn");
				Torn torn = new Torn(idTorn, idRestaurant, 1, null, idTorn);
				LocalDate Data = rst.getObject("Data", LocalDate.class);
				int Comensals = rst.getInt("Comensals");
				Reserva res = new Reserva(idReserva,clt,rest,Data,torn,Comensals,"");
				llista.add(res);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return llista.size();
		
	}

	@Override
	public int update(Connexio con, Reserva reserva) {
		int result = 0;

		try {
			String sql = "UPDATE reserva " + "SET idClient"
					+ reserva.getClient() + "," + "idRestaurant" + reserva.getRestaurant() + "," + "idTorn = "
					+ reserva.getTorn() + "," + "Data = " + reserva.getData() + "," + "Comensals = "
					+ reserva.getComensals() + "," + "Observacions = " + reserva.getObservacions() + "," + "WHERE idReserva = " + reserva.getIdReserva() + ";";

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

			String sql = "DELETE FROM reserva WHERE idReserva = " + reserva.getIdReserva() + " ;";

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
