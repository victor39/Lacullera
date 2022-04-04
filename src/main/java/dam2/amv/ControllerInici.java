package dam2.amv;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class ControllerInici {

    @FXML
    private AnchorPane ApMenu;

    @FXML
    private Text BtnBuscarRestaurants;

    @FXML
    private Text BtnReserva;

    @FXML
    private AnchorPane escena;

    @FXML
    void cargarEscena(MouseEvent event) throws IOException {
    	
    	AnchorPane nuevo;
    	nuevo = FXMLLoader.load(getClass().getResource("OtherFXML.fxml"));
    	escena.getChildren().setAll(nuevo);
    }

    @FXML
    void cargarEscenaVerda(MouseEvent event) throws IOException {
    	AnchorPane nuevo;
    	nuevo = FXMLLoader.load(getClass().getResource("BuscarRestaurant.fxml"));
    	escena.getChildren().setAll(nuevo);
    }

}
