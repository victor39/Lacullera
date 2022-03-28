package model;

import java.util.List;

public interface ClientDAO {
	
	static int Tots(Connexio con, List<Client> array) {
		return 0;
	}
	
	boolean create(Connexio con, Client client);
	boolean update(Connexio con, Client client);
	boolean delete(Connexio con, int id);

}
