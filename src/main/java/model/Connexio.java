package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexio {

	private Connection connexio;
	
	public Connexio() {
		try {
			
			this.connexio = DriverManager.getConnection("jdbc:mysql://localhost:3306/practica","aduran","Dam2020!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}
	}
	
	public Connexio(String host, String bd, int port, String usuari, String contrasenya) {
		try {
			this.connexio = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+bd,usuari,contrasenya);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnexio() {
		return connexio;
	}
}
