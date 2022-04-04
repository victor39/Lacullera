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
	
	static AnchorPane nuevo = new AnchorPane();
	
	@FXML
    private AnchorPane ApMenu;
	
	@FXML
    static AnchorPane escena;

    @FXML
    private Text BtnBuscarRestaurants;

    @FXML
    private Text BtnReserva;

    
    

    @FXML
    void cargarEscena(MouseEvent event) throws IOException {
    	
    	
    	nuevo = FXMLLoader.load(getClass().getResource("EntrarDadesClient.fxml"));
    	escena.getChildren().setAll(nuevo);
    	
    }

    @FXML
    void cargarEscenaVerda(MouseEvent event) throws IOException {
    	
    	nuevo = FXMLLoader.load(getClass().getResource("BuscarRestaurant.fxml"));
    	escena.getChildren().setAll(nuevo);
    	
    }
    
    @FXML
    void configuració(MouseEvent event) throws IOException {

     	
    	nuevo = FXMLLoader.load(getClass().getResource("ConfiguracioUsuari.fxml"));
    	escena.getChildren().setAll(nuevo);
    	
    }
    void cargarTorn(MouseEvent event) throws IOException {
    	AnchorPane nuevo;
    	nuevo = FXMLLoader.load(getClass().getResource("ReservaComensals.fxml"));
    	escena.getChildren().setAll(nuevo);
    	
    }
    
}
