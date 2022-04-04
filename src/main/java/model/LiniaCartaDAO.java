package model;

import java.util.List;

public interface LiniaCartaDAO {
	
	static int TotsPrimers(Connexio con, List<LiniaCarta> liniaCarta , int id) {
		
		return 0;
	}
	static int TotsSegons(Connexio con, List<LiniaCarta> liniaCarta , int id) {
		
		return 0;
	}
	static int TotsPostres(Connexio con, List<LiniaCarta> liniaCarta , int id) {
		
		return 0;
	}
	int create(Connexio con, LiniaCarta liniacarta);
	int update(Connexio con, LiniaCarta liniacarta);
	int delete(Connexio con, LiniaCarta liniacarta);
	

}
