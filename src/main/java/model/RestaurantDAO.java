package model;

import java.util.List;

public interface RestaurantDAO {
	
	static int Tots(Connexio con, List<Restaurant> array) {
		return 0;
	}
	
	int create(Connexio con, Restaurant restaurant);
	int update(Connexio con, Restaurant restaurant);
	int delete(Connexio con, Restaurant restaurant);



}
