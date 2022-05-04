package dam2.amv;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class ControllerPaginaPrincipal {

    @FXML
    private Button BtnLogin;

    @FXML
    private Button BtnRegistre;

    @FXML
    private Text TFTítol;

    @FXML
    private AnchorPane escena;

    @FXML
    void login(ActionEvent event) throws IOException {

    	AnchorPane nuevo;
    	nuevo = FXMLLoader.load(getClass().getResource("Login.fxml"));
    	escena.getChildren().setAll(nuevo);
    	
    }

    @FXML
    void registre(ActionEvent event) throws IOException {

    	AnchorPane nuevo;
    	nuevo = FXMLLoader.load(getClass().getResource("registre.fxml"));
    	escena.getChildren().setAll(nuevo);
    	
    }

}
