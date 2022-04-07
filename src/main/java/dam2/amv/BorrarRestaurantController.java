package dam2.amv;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import model.Carta;
import model.Connexio;
import model.Restaurant;
import model.RestaurantDAO;
import model.RestaurantDAOImpl;

public class BorrarRestaurantController implements Initializable {


	public Connexio con = new Connexio();

	private ObservableList <Restaurant> listaRestaurant;

	private String eleccio;

	@FXML
	private Button BtnBorrar;

	@FXML
	private ComboBox<Restaurant> CBBRestaurant;

	@FXML
	private AnchorPane escena;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		listaRestaurant=FXCollections.observableArrayList();
		CBBRestaurant.setItems(listaRestaurant);
		RestaurantDAOImpl.Tots(con, listaRestaurant);

	}
	
	@FXML
    void borrarDades(ActionEvent event) {

		Restaurant restaurant = CBBRestaurant.getValue();
		
		RestaurantDAO resDAO = new RestaurantDAOImpl();
		
		resDAO.delete(con,restaurant);
		
		System.out.println("Restaurant borrat: " + restaurant);
		
    }
}
