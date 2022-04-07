package dam2.amv;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Client;
import model.ClientDAO;
import model.ClientDAOImpl;
import model.Connexio;
import model.Reserva;
import model.ReservaDAO;
import model.ReservaDAOImpl;
import model.Restaurant;
import model.RestaurantDAOImpl;
import model.Torn;
import model.TornDAOImpl;

public class ControllerReserva implements Initializable{

	public static Connexio con = new Connexio();

	@FXML
	private Button BtnReservar;

	@FXML
	private Button BtnSeguent;

	@FXML
	private TextField TFAdreca;

	@FXML
	private TextField TFCognom;

	@FXML
	private TextField TFCorreu;

	@FXML
	private TextField TFDni;

	@FXML
	private TextField TFNom;

	@FXML
	private TextField TFTelefon;

	@FXML
	private Button btnReservar;
	// panel torn

	@FXML
	private ComboBox<Torn> cmbTorn;

	@FXML
	private ComboBox<Restaurant> cmbTriaRestaurant;

	@FXML
	private AnchorPane idPanelDades;
	
	@FXML
    private AnchorPane panelTorn;

    @FXML
    private AnchorPane panelTria;

	@FXML
	private Spinner<Integer> spnComensals;

	@FXML
	private Text txtNomRestaurant;
	
    @FXML
    private DatePicker data;

	private ObservableList<Restaurant> listaRestaurant;

	private Restaurant eleccio;
	
	private ObservableList <Torn> llistaTorns;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
        panelTria.setDisable(true);
        panelTorn.setDisable(true);

	}
	@FXML
	void agafarDades(ActionEvent event) throws IOException{


        idPanelDades.setDisable(true);
        panelTria.setDisable(false);

		listaRestaurant = FXCollections.observableArrayList();
		
		
		cmbTriaRestaurant.setItems(listaRestaurant);
		RestaurantDAOImpl.Tots(con, listaRestaurant);
		
		
    	SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1);
    	spnComensals.setValueFactory(valueFactory);
    
    	
	}

	@FXML
	void reservar(ActionEvent event) {
		
		String Nom = TFNom.getText();
		String Cognom = TFCognom.getText();
		String Dni = TFDni.getText();
		String Adreca = TFAdreca.getText();
		String Correu = TFCorreu.getText();
		String Telefon = TFTelefon.getText();
		int Telefono = Integer.parseInt(Telefon);

		con = new Connexio();

		ClientDAO client = new ClientDAOImpl();

		Client cliento = new Client(Nom, Cognom, Adreca, Dni, Telefono, Correu);

		client.create(con, cliento);
	
		
		
		
		Alert confirmacio=new Alert(AlertType.CONFIRMATION);
    	confirmacio.initModality(Modality.WINDOW_MODAL);
    	confirmacio.setTitle("Estas segur que vols fer la reserva? ");
    	confirmacio.setContentText("Prem Enter si es aixi ");
    	
        	
    	Optional<ButtonType> result = confirmacio.showAndWait();
    	if(result.isPresent() && result.get() == ButtonType.OK) {
    		Reserva res = new Reserva (cliento, cmbTriaRestaurant.getValue(),LocalDate.now() , cmbTorn.getValue(), spnComensals.getValue(), null);
    		ReservaDAO reserva = new ReservaDAOImpl();
        	int resultat = reserva.create(con, res);
        	if (resultat==1)
        	{
        		Alert missatge=new Alert(AlertType.INFORMATION);
    			missatge.setTitle("Reserva feta ");
    			missatge.setContentText("Perfecte , ja tens la teva reserva");
    			missatge.setContentText("  Nom reserva : " + res.getClient().getNom()+
    					"\n Nom Restaurant :" + res.getRestaurant().getNom()+
    					"\n  Dia :" + data.getValue()+
    					"\n  Hora : " + res.getTorn().getHoraInici().toString());
    			
    			missatge.setHeaderText("Alerta:");
    			missatge.show();
    			
        	}else 
        	{
        		Alert missatge=new Alert(AlertType.ERROR);
    			missatge.setTitle("Hi ha un problema, no pots fer la reserva");
    			missatge.setContentText("Tornar a provar ");
    			missatge.setHeaderText("Alerta:");
    			missatge.show();
        		
        	}
    	}
	

	}

	@FXML
    void submit(ActionEvent event) {
		
		panelTorn.setDisable(false);
		
		//treure id del restaurant d'abans 
    	int idRestaurant = cmbTriaRestaurant.getValue().getIdRestaurant();
    	
    	//posar el nom de restaurant
    	txtNomRestaurant.setText(cmbTriaRestaurant.getValue().getNom());
    	
		llistaTorns=FXCollections.observableArrayList();
		cmbTorn.setItems(llistaTorns);
    	
    	System.out.println(idRestaurant);
    
   
    	TornDAOImpl.Tots(con, llistaTorns, idRestaurant);
    	
    	System.out.println(llistaTorns.size());
    	
    	cmbTorn.setOnAction(e -> System.out.println("Nova selecció: " + cmbTorn.getValue()));


    	panelTria.setDisable(true);

    }

}
