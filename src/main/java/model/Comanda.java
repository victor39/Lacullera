package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Comanda {

	int idComanda;
	Client client;
	Personal responsable;
	LocalTime hora;
	LocalDate data;
	String descompte;
	float preu;
	Restaurant restaurant;
	
}
