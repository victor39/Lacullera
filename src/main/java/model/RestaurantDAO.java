package model;

import java.util.List;

public interface RestaurantDAO {
	
	static int Tots(Connexio con, List<Restaurant> array) {
		return 0;
	}
	
	boolean create(Connexio con, Restaurant restaurant);
	boolean update(Connexio con, Restaurant restaurant);
	boolean delete(Connexio con, int id);

}
