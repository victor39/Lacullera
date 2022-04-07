package dam2.amv;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.Client;
import model.ClientDAOImpl;
import model.Connexio;
import model.Restaurant;
import model.RestaurantDAO;
import model.RestaurantDAOImpl;

public class EntrarRestaurantController {
	
	public static Connexio con = new Connexio();
	
    @FXML
    private Button BtnReservar;

    @FXML
    private TextField TFAdreca;

    @FXML
    private TextField TFNom;

    @FXML
    private TextField TFTelefon;

    @FXML
    private AnchorPane escena;

    @FXML
    void entrarDades(ActionEvent event) {
    	System.out.println("fase1");
    	String Nom = TFNom.getText();
		String Adreca = TFAdreca.getText();
		String Telefon = TFTelefon.getText();
		int Telefono=Integer.parseInt(Telefon);
		System.out.println("fase2");
		con = new Connexio();
		System.out.println("fase3");
		RestaurantDAO restaurantDAOI = new RestaurantDAOImpl();
		System.out.println("fase4");
		Restaurant restaurant = new Restaurant(Nom,Adreca,Telefono);
		System.out.println("fase5");
		restaurantDAOI.create(con, restaurant);
		System.out.println("fase6");
		System.out.println("Nom: " + Nom);
		System.out.println("Adreça: " + Adreca);
		System.out.println("Telefon: " + Telefon);

    }
    
}
