package dam2.amv;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import model.Client;
import model.ClientDAOImpl;
import model.Connexio;
import model.Reserva;
import model.ReservaDAO;
import model.ReservaDAOImpl;
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

		if(!TFNom.getText().isEmpty() && !TFAdreca.getText().isEmpty() && !TFTelefon.getText().isEmpty()) {

			String Nom = TFNom.getText();
			String Adreca = TFAdreca.getText();
			String Telefon = TFTelefon.getText();
			int Telefono=Integer.parseInt(Telefon);

			con = new Connexio();



			System.out.println("Nom: " + Nom);
			System.out.println("Adreça: " + Adreca);
			System.out.println("Telefon: " + Telefon);

			Alert confirmacio=new Alert(AlertType.CONFIRMATION);
			confirmacio.initModality(Modality.WINDOW_MODAL);
			confirmacio.setTitle("Estas segur ? ");
			confirmacio.setContentText("Prem Enter si vols entrar un Restaurant nou ");


			Optional<ButtonType> result = confirmacio.showAndWait();
			if(result.isPresent() && result.get() == ButtonType.OK) {

				RestaurantDAO restaurantDAOI = new RestaurantDAOImpl();
				Restaurant restaurant = new Restaurant(Nom,Adreca,Telefono);

				int resultat = restaurantDAOI.create(con, restaurant);
				if (resultat==1)
				{
					Alert missatge=new Alert(AlertType.INFORMATION);
					missatge.setTitle("Restaurant Afegit ");
					missatge.setContentText(" Restaurant afegit :  " + restaurant.getNom());
					missatge.setHeaderText("Alerta:");
					missatge.show();

				}else 
				{
					Alert missatge=new Alert(AlertType.ERROR);
					missatge.setTitle("Hi ha un problema, no pots fer aquest restaurant ");
					missatge.setContentText("Tornar a provar ");
					missatge.setHeaderText("Alerta:");
					missatge.show();

				}
			}



		}

	}

}
