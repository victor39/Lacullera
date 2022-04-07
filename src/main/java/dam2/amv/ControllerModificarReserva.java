package dam2.amv;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.ComandaDAOImpl;
import model.Connexio;
import model.Reserva;
import model.ReservaDAO;
import model.ReservaDAOImpl;
import model.Restaurant;
import model.RestaurantDAOImpl;
import model.Torn;
import model.TornDAOImpl;

public class ControllerModificarReserva implements Initializable{
	
	private ObservableList <Restaurant> llistaRestaurant;
	private ObservableList <Torn> llistaTorn; 
	
	private FilteredList <Reserva> llistaReserva;
	
	public  Connexio con = new Connexio();
	
	//.setMaximize()

    @FXML
    private DatePicker DPData;

    @FXML
    private SplitPane SplitPane;

    @FXML
    private TextField TFClient;

    @FXML
    private AnchorPane anchor;

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnBuscar;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnNeteja;

    @FXML
    private TableColumn<Reserva, String> clmClient;

    @FXML
    private TableColumn<Reserva, String> clmRestaurant;

    @FXML
    private TableColumn<Reserva, String> clmTorn;

    @FXML
    private TableColumn<Reserva, LocalDate> clmData;
    
    @FXML
    private TableColumn<Reserva, Integer> clmComensals;

    @FXML
    private ComboBox<Restaurant> cmbRestaurant;

    @FXML
    private ComboBox<Torn> cmbTorn;

    @FXML
    private Spinner<Integer> spnComensals;

    @FXML
    private TextField textCerca;

    @FXML
    void actualitzarReserva(ActionEvent event) {

    }

    @FXML
    void buscarReserves(ActionEvent event) {
    	
    	String DNI = TFClient.getText();
    	
    	ReservaDAOImpl.buscar(con, llistaReserva, DNI);
    }

    @FXML
    void eliminarReserva(ActionEvent event) {

    }

    @FXML
    void limpiarComponentes(ActionEvent event) {

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		llistaRestaurant = FXCollections.observableArrayList();
		llistaTorn = FXCollections.observableArrayList();
		
		//llistaFiltrada = new FilteredList<>(llistaTiquets, p -> true);
		
		cmbRestaurant.setItems(llistaRestaurant);
		cmbTorn.setItems(llistaTorn);
		
		clmClient.setCellValueFactory(new PropertyValueFactory<Reserva, String>("client"));
		clmRestaurant.setCellValueFactory(new PropertyValueFactory<Reserva, String>("restaurant"));
		clmTorn.setCellValueFactory(new PropertyValueFactory<Reserva, String>("torn"));
		clmData.setCellValueFactory(new PropertyValueFactory<Reserva, LocalDate>("data"));
		clmComensals.setCellValueFactory(new PropertyValueFactory<Reserva, Integer>("comensals"));
		/*
		
		TiquetDAOImpl.Tots(App.con, llistaTiquets);
		*/
		
		//gestionarEventos();
		
	}

}

