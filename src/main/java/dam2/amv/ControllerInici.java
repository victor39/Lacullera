package dam2.amv;

import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class ControllerInici {
	
	@FXML
    private AnchorPane ApMenu;
	
	@FXML
    private AnchorPane escena;

    @FXML
    private Text BtnBuscarRestaurants;

    @FXML
    private Text BtnReserva;

    
    

    @FXML
    void reserva(MouseEvent event) throws IOException {
    	AnchorPane nuevo;
    	nuevo = FXMLLoader.load(getClass().getResource("Reserva.fxml"));
    	escena.getChildren().setAll(nuevo);
    	
    }

    @FXML
    void modificarReserva(MouseEvent event) throws IOException {
    	AnchorPane nuevo;
    	nuevo = FXMLLoader.load(getClass().getResource("ModificarReserva.fxml"));
    	escena.getChildren().setAll(nuevo);
    	
    }
    
    @FXML
    void entrarRestaurant(MouseEvent event) throws IOException {
    	AnchorPane nuevo;
    	nuevo = FXMLLoader.load(getClass().getResource("entrarRestaurant.fxml"));
    	escena.getChildren().setAll(nuevo);
    	
    }
    
    @FXML
    void borrarRestaurant(MouseEvent event) throws IOException {

    	AnchorPane nuevo;
    	nuevo = FXMLLoader.load(getClass().getResource("BorrarRestaurant.fxml"));
    	escena.getChildren().setAll(nuevo);
    	
    }
    
    @FXML
    void torns(MouseEvent event) throws IOException {
    	AnchorPane nuevo;
    	nuevo = FXMLLoader.load(getClass().getResource("MenuTorns.fxml"));
    	escena.getChildren().setAll(nuevo);
    	
    }
    
    
    
}
