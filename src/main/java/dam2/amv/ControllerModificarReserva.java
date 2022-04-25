package dam2.amv;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.Client;
import model.ComandaDAOImpl;
import model.Connexio;
import model.Reserva;
import model.ReservaDAO;
import model.ReservaDAOImpl;
import model.Restaurant;
import model.RestaurantDAOImpl;
import model.Torn;
import model.TornDAOImpl;

public class ControllerModificarReserva implements Initializable {

	private ObservableList<Torn> llistaTorn;
	private ObservableList<Reserva> llistaReserva;
	private FilteredList<Reserva> filtradaReserva;

	public Connexio con = new Connexio();

	// .setMaximize()

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
    private TableView<Reserva> tblViewReserva;

	@FXML
	private TableColumn<Reserva, Client> clmClient;

	@FXML
	private TableColumn<Reserva, Restaurant> clmRestaurant;

	@FXML
	private TableColumn<Reserva, Torn> clmTorn;

	@FXML
	private TableColumn<Reserva, LocalDate> clmData;

	@FXML
	private TableColumn<Reserva, Integer> clmComensals;

	@FXML
	private TextField TFRestaurant;

	@FXML
	private ComboBox<Torn> cmbTorn;

	@FXML
	private Spinner<Integer> spnComensals;

	@FXML
	private TextField textCerca;

	@FXML
	private TextField tfClient;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		TFRestaurant.setDisable(true);
		cmbTorn.setDisable(true);
		DPData.setDisable(true);
		spnComensals.setDisable(true);

		llistaTorn = FXCollections.observableArrayList();
		llistaReserva = FXCollections.observableArrayList();
		filtradaReserva = new FilteredList<>(llistaReserva, p -> true);

		tblViewReserva.setItems(filtradaReserva);
		
		cmbTorn.setItems(llistaTorn);

		clmClient.setCellValueFactory(new PropertyValueFactory<Reserva,Client>("client"));
		clmRestaurant.setCellValueFactory(new PropertyValueFactory<Reserva,Restaurant>("restaurant"));
		clmTorn.setCellValueFactory(new PropertyValueFactory<Reserva,Torn>("torn"));
		clmData.setCellValueFactory(new PropertyValueFactory<Reserva,LocalDate>("data"));
		clmComensals.setCellValueFactory(new PropertyValueFactory<Reserva,Integer>("comensals"));

		gestionarEventos();

	}

	@FXML
	void buscarReserves(ActionEvent event) {
		
		llistaReserva.clear();
		neteja();

	    String DNI = TFClient.getText();
	    ReservaDAOImpl.buscar(con, llistaReserva, DNI);
		
	}

	@FXML
	void actualitzarReserva(ActionEvent event) {//
		
		Client clt = new Client(TFClient.getText());
		Restaurant rest = new Restaurant(tblViewReserva.getSelectionModel().getSelectedItem().getRestaurant().getIdRestaurant());
		
		Reserva reserv = new Reserva(tblViewReserva.getSelectionModel().getSelectedItem().getIdReserva(),clt, rest, DPData.getValue(), cmbTorn.getValue(), spnComensals.getValue(), "" );
		
		ReservaDAO rDAO = new ReservaDAOImpl();
		int res = rDAO.update(con, reserv);
		
		if(res>0) {
    		llistaReserva.set(tblViewReserva.getSelectionModel().getSelectedIndex(), reserv);
    	}

	}

	@FXML
	void eliminarReserva(ActionEvent event) {
		
		Client clt = new Client(TFClient.getText());
		Restaurant rest = new Restaurant(tblViewReserva.getSelectionModel().getSelectedItem().getRestaurant().getIdRestaurant());
		
		Reserva reserv = new Reserva(tblViewReserva.getSelectionModel().getSelectedItem().getIdReserva(),clt, rest, DPData.getValue(), cmbTorn.getValue(), spnComensals.getValue(), "" );
		
		ReservaDAO rDAO = new ReservaDAOImpl();
		int res = rDAO.delete(con, reserv);
		
		boolean trobat = false;
		int comptador = 0;
		
		if(res>0) {
			while(!trobat & comptador > llistaReserva.size()) {
				if(llistaReserva.get(comptador).getIdReserva() == tblViewReserva.getSelectionModel().getSelectedItem().getIdReserva()) {
					llistaReserva.remove(comptador);
					trobat = true;
				}
			}
		}
	}

	@FXML
	void limpiarComponentes(ActionEvent event) {
		
		TFRestaurant.setDisable(true);
		cmbTorn.setDisable(true);
		DPData.setDisable(true);
		spnComensals.setDisable(true);
		
		tfClient.setText(null);
		TFRestaurant.setText(null);
		cmbTorn.setValue(null);
		DPData.setValue(null);
		spnComensals.getValueFactory().setValue(0);
		
	}
	
	public void neteja() {
		
		TFRestaurant.setDisable(true);
		cmbTorn.setDisable(true);
		DPData.setDisable(true);
		spnComensals.setDisable(true);
		
	}
	
	public void gestionarEventos() {
    	//Aquest mètode crea un Listener al tableView en el que tenim els alumnes. 
		tblViewReserva.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Reserva>() {//ChangeListhener ens obliga a definir el m tode abstracte changed

			@Override
			public void changed(ObservableValue<? extends Reserva> valorActual, Reserva valorAnterior, Reserva valorSeleccionat) {
				//per evitar errors de nullPointerException a l'hora de desseleccionar/actualitzar dades ens hem d'assegurar que el valorSeleccionat no sigui null
				if (valorSeleccionat!=null) {
				// Els arguments que ens dona el m tode changed, es refereixen al valor actual, el calor anterior(guarda l'ultim valor seleccionat) i el valor seleccionat, el que tenim actualment
				System.out.println("Nom de la reserva seleccionada: "+ valorSeleccionat.getIdReserva()); // Com el valor seleccionat és de tipus Alumne, podem accedir a tots els seus métodes.
				//Agafarem tots els atributs que surten a la taula i els afegirem als elements
				
				// Per afegir els elements als TextFields nom s accepta dades de tipus String
				TFRestaurant.setText(String.valueOf(valorSeleccionat.getRestaurant()));
				cmbTorn.setValue(valorSeleccionat.getTorn());
				TornDAOImpl.Tots(con, llistaTorn, valorSeleccionat.getRestaurant().getIdRestaurant());
				DPData.setValue(valorSeleccionat.getData());
				
				SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, valorSeleccionat.getComensals());
				spnComensals.setValueFactory(valueFactory);
				
				TFRestaurant.setDisable(false);
				cmbTorn.setDisable(false);
				DPData.setDisable(false);
				spnComensals.setDisable(false);
				
				//Els botons actualitzar i guardar, est n deshabilitats per defecte. quan cliquem dintre d'una fila de la taula volem que s'habilitin per a poder modificar el seu contingut
				//botonActualizar.setDisable(false);
				//botonEliminar.setDisable(false);
				//botonGuardar.setDisable(true);
			}
			}
		});
    	
    }
}
