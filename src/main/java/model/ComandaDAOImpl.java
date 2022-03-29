package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ComandaDAOImpl implements ComandaDAO {

	@Override
	public int create(Comanda comanda, Connexio con) {
		int result = 0;

		try {

			String sql = "INSERT INTO comanda (idClient ,Responsable,Hora,Data,Descompte,PreuTotal) VALUES ('"
					+ comanda.getClient() + "',"+ comanda.getResponsable() + "'," + comanda.getHora()
					+comanda.getData() + "," + comanda.getDescompte() +
					comanda.getPreu() + "',"  + ");";

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
	public int update(Comanda comanda, Connexio con) {
		int result = 0;

		try {
			String sql = "UPDATE comanda " + "SET  responsable = " + comanda.getResponsable() + "," + "hora"
					+ comanda.getHora() + "," + comanda.getData() + "," + comanda.getDescompte()+ ","
					+ comanda.getPreu() + "," + "WHERE idComanda= " + comanda.getIdComanda()+ ";";

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
	public int delete(Comanda comanda, Connexio con) {
		int result = 0;
		try {

			String sql = "DELETE FROM comanda WHERE idComanda = " + comanda.getIdComanda()+ " ;";

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
