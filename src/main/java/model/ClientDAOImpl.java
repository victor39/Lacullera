package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientDAOImpl implements ClientDAO {

	@Override
	public int create(Connexio con, Client client) {
		
		int res = 0;
		
		try {
			String sql = "INSERT INTO client (Dni, Nom, Cognom, Telefon, Adreca, Correu) VALUES (" + client.getDni() + "," + client.getNom() + "," + client.getCognom() + "," + client.getTelefon() + "," + client.getAdreça() + "," + client.getCorreu() + ");";
			
			System.out.println(sql);
			
			PreparedStatement stm = con.getConnexio().prepareStatement(sql);
			res = stm.executeUpdate(sql);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int update(Connexio con, Client client) {
		
		int res = 0;
		
		try {
			String sql = "UPDATE client SET Nom = " + client.getNom() + ", Cognom = " + client.getCognom() + ", Telefon = " + client.getTelefon() + ", Adreca = " + client.getAdreça() + ", Correu = " + client.getCorreu() + " WHERE Dni = " + client.getDni() + ";";
			
			PreparedStatement stm = con.getConnexio().prepareStatement(sql);
			res = stm.executeUpdate(sql);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int delete(Connexio con, Client client) {

		int res = 0;
		
		try {
			String sql = "DELETE FROM client WHERE Dni = " + client.getDni() +";";
			
			PreparedStatement stm = con.getConnexio().prepareStatement(sql);
			res = stm.executeUpdate(sql);
			System.out.println(sql);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}

}
