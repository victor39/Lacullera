package dam2.amv;

import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import model.Carta;
import model.Connexio;
import model.Reserva;
import model.ReservaDAO;
import model.ReservaDAOImpl;
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
		
		Alert confirmacio=new Alert(AlertType.CONFIRMATION);
    	confirmacio.initModality(Modality.WINDOW_MODAL);
    	confirmacio.setTitle("Estas segur que vols esborrar aquest restaurant ? ");
    	confirmacio.setContentText("Prem Enter si es aixi ");
    	
        	
    	Optional<ButtonType> result = confirmacio.showAndWait();
    	
    	if(result.isPresent() && result.get() == ButtonType.OK) {
    		
    		Restaurant restaurant = CBBRestaurant.getValue();
    		RestaurantDAO resDAO = new RestaurantDAOImpl();
    		int num = resDAO.delete(con,restaurant);
        	if (num == 1)
        	{
        		Alert missatge=new Alert(AlertType.INFORMATION);
    			missatge.setTitle("Restaurant borrat ");
    			missatge.setContentText("Perfecte , restaurant borrat");
    			missatge.setContentText(" Nom Restaurant  : " + restaurant.getNom());
    			
    			missatge.setHeaderText("Alerta:");
    			missatge.show();
    			
        	}else 
        	{
        		Alert missatge=new Alert(AlertType.ERROR);
    			missatge.setTitle("No pots esborrar aquest Restaurant ");
    			missatge.setContentText("Tornar a provar ");
    			missatge.setHeaderText("Alerta:");
    			missatge.show();
        		
        	}
    	}
		
    }
}
