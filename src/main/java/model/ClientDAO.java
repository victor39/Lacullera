package model;

import java.util.List;

public interface ClientDAO {
	
	public static int Tots(Connexio con, List<Client> array) {
		return 0;
	}
	
	public static int comprovarDni(Connexio con, String Dni) {
		return 0;
	}
	
	int create(Connexio con, Client client);
	int update(Connexio con, Client client);
	int delete(Connexio con, Client client);
	

}
