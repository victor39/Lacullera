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
import javafx.scene.input.MouseEvent;
import model.Connexio;
import model.Restaurant;
import model.RestaurantDAO;
import model.RestaurantDAOImpl;
import model.Torn;
import model.TornDAO;
import model.TornDAOImpl;

public class TornsController implements Initializable{

	@FXML
	private Button BtnBorrar;


	@FXML
	private ComboBox<Torn> CBHorari;

	@FXML
	private ComboBox<Restaurant> CBRestaurant;


	public Connexio con = new Connexio();

	private ObservableList <Restaurant> listaRestaurant;

	private ObservableList <Torn> llistaTorns;

	private String eleccio;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		listaRestaurant=FXCollections.observableArrayList();
		CBRestaurant.setItems(listaRestaurant);
		RestaurantDAOImpl.Tots(con, listaRestaurant);

	}

	@FXML
	void omplirHorari(MouseEvent event) {

		int idRestaurant = CBRestaurant.getValue().getIdRestaurant();

		llistaTorns=FXCollections.observableArrayList();
		CBHorari.setItems(llistaTorns);

		System.out.println(idRestaurant);

		TornDAOImpl.Tots(con, llistaTorns, idRestaurant);
	}

	@FXML
	void borrar(ActionEvent event) {

		Torn torn = CBHorari.getValue();
		
		int tornr = CBHorari.getValue().getRestaurant();

		TornDAOImpl tornDAO = new TornDAOImpl();

		tornDAO.delete(con,torn,tornr);


	}

}
