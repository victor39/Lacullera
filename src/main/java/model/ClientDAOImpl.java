package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ClientDAOImpl implements ClientDAO {

	public static int Tots(Connexio con, List<Client> array) {

		try {
			String sql = "SELECT * FROM Client ;";
			PreparedStatement stm = con.getConnexio().prepareStatement(sql);
			ResultSet rst = stm.executeQuery(sql);

			while (rst.next()) {
				String dni = rst.getString("Dni");
				String Nom = rst.getString("Nom");
				String Cognom = rst.getString("Cognom");
				int Telefon = rst.getInt("Telefon");
				String Adreca = rst.getString("Adreca");
				String  Correu = rst.getString("Correu");
				Client client = new Client(dni,Nom,Cognom,Adreca,Telefon,Correu);
				array.add(client);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return array.size();
	}

	public static int comprovarDni(Connexio con, String Dni ) {

		int res = 0;
		
		try {
			String sql = "SELECT Dni FROM Client where Dni = " + Dni;
			PreparedStatement stm = con.getConnexio().prepareStatement(sql);
			ResultSet rst = stm.executeQuery(sql);

			while (rst.next()) {
				String dni = rst.getString("Dni");
				String Nom = rst.getString("Nom");
				String Cognom = rst.getString("Cognom");
				int Telefon = rst.getInt("Telefon");
				String Adreca = rst.getString("Adreca");
				String  Correu = rst.getString("Correu");
				Client client = new Client(dni,Nom,Cognom,Adreca,Telefon,Correu);
				res = 1;

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}


	@Override
	public int create(Connexio con, Client client) {

		int res = 0;

		try {
			String sql = "INSERT INTO Client (Dni, Nom, Cognom, Telefon, Adreca, Correu) VALUES ('" + client.getDni()
			+ "','" + client.getNom() + "','" + client.getCognom() + "'," + client.getTelefon() + ",'"
			+ client.getAdreça() + "','" + client.getCorreu() + "');";

			System.out.println(sql);

			PreparedStatement stm = con.getConnexio().prepareStatement(sql);
			res = stm.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}

	@Override
	public int update(Connexio con, Client client) {

		int res = 0;

		try {
			String sql = "UPDATE client SET Nom = " + client.getNom() + ", Cognom = " + client.getCognom()
			+ ", Telefon = " + client.getTelefon() + ", Adreca = " + client.getAdreça() + ", Correu = "
			+ client.getCorreu() + " WHERE Dni = " + client.getDni() + ";";

			PreparedStatement stm = con.getConnexio().prepareStatement(sql);
			res = stm.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}

	@Override
	public int delete(Connexio con, Client client) {

		int res = 0;

		try {
			String sql = "DELETE FROM client WHERE Dni = " + client.getDni() + ";";

			PreparedStatement stm = con.getConnexio().prepareStatement(sql);
			res = stm.executeUpdate(sql);
			System.out.println(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}

}


