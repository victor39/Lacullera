package dam2.amv;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import model.Client;
import model.ClientDAO;
import model.ClientDAOImpl;
import model.Connexio;
import model.Reserva;
import model.ReservaDAO;
import model.ReservaDAOImpl;
import model.Restaurant;
import model.RestaurantDAO;
import model.RestaurantDAOImpl;
import model.Torn;
import model.TornDAO;
import model.TornDAOImpl;

public class TornsController implements Initializable {

	@FXML
    private Button BtnEntrar;

    @FXML
    private ComboBox<Restaurant> CBRestaurants;

    @FXML
    private ChoiceBox<String> CbHorari;

    @FXML
    private TextField TFDiaReservesDisponibles;

    @FXML
    private ComboBox<String> CBDiaSemana;

	public Connexio con = new Connexio();

	private ObservableList<Restaurant> listaRestaurant;

	private ObservableList<Torn> llistaTorns;

	private String eleccio;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		CbHorari.getItems().setAll("13:00", "14:00", "21:00", "22:00");
		
		listaRestaurant=FXCollections.observableArrayList();
		CBRestaurants.setItems(listaRestaurant);
		RestaurantDAOImpl.Tots(con, listaRestaurant);
		
		CBDiaSemana.getItems().setAll("Dilluns","Dimarts","Dimecres","Dijous","Divendres","Dissabte","Diumenge");
		
		
		

	}

	@FXML
	void entrar(ActionEvent event) {

		int segons = 0;

		String horaid = CbHorari.getValue().toString();
		int hora2 = Integer.parseInt(horaid.substring(0, 2));
		System.out.println(hora2);

		LocalTime hora = LocalTime.of(hora2, segons);

		String integerid = CBRestaurants.getValue().toString();
		String[] auxId = integerid.split(" - "); 
		int id = Integer.parseInt(auxId[0]);

		String diasemana= CBDiaSemana.getValue();
		
		int diasetmana = 0;
		
		if(diasemana.equalsIgnoreCase("Dilluns")) {
			diasetmana = 1;
		}
		
		if(diasemana.equalsIgnoreCase("Dimarts")) {
			diasetmana = 2;
		}
		
		if(diasemana.equalsIgnoreCase("Dimecres")) {
			diasetmana = 3;
		}
		
		if(diasemana.equalsIgnoreCase("Dijous")) {
			diasetmana = 4;
		}
		
		if(diasemana.equalsIgnoreCase("Divendres")) {
			diasetmana = 5;
		}
		
		if(diasemana.equalsIgnoreCase("Dissabte")) {
			diasetmana = 6;
		}
		
		if(diasemana.equalsIgnoreCase("Diumenge")) {
			diasetmana = 7;
		}

		String reservesdinsponibles = TFDiaReservesDisponibles.getText();
		int reservesd = Integer.parseInt(reservesdinsponibles);
		
		TornDAO torn = new TornDAOImpl();
		Torn torno = new Torn(id, diasetmana, hora, reservesd);
		int resultat = 0;
		
		if(TornDAOImpl.Existeix(con,torno) > 0) {
			System.out.println("hey");
			resultat = 0;
		}else {
			resultat = torn.create(con, torno);
		}
		
		if (resultat == 1) {
			Alert missatge = new Alert(AlertType.INFORMATION);
			missatge.setTitle("Torn afegit ");
			missatge.setContentText("Perfecte , ja tens el teu torn fet ");

			missatge.setHeaderText("Alerta:");
			missatge.show();

		} else {
			Alert missatge = new Alert(AlertType.ERROR);
			missatge.setTitle("Hi ha un problema, no pots fer aquest torn ");
			missatge.setContentText("Ja existeix un torn amb aquestes caracteristiques");
			missatge.setHeaderText("Alerta:");
			missatge.show();

		}
	}

}
