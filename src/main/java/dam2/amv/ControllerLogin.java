package dam2.amv;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.ClientDAO;
import model.ClientDAOImpl;
import model.Connexio;

public class ControllerLogin {
	
	@FXML
    private Button BtnLogin;

    @FXML
    private Button BtnSortir;

    @FXML
    private TextField TfContrasenya;

    @FXML
    private TextField TfCorreu;

    @FXML
    private AnchorPane escena;
    
	public static Connexio con = new Connexio();
	
	
    
    @FXML
    void atras(ActionEvent event) throws IOException {
    	AnchorPane nuevo;
    	nuevo = FXMLLoader.load(getClass().getResource("PaginaPrincipal.fxml"));
    	escena.getChildren().setAll(nuevo);
    }

    @FXML
    void entrar(ActionEvent event) throws IOException {
    	
    	String correu = TfCorreu.getText();
    	String pasword = TfContrasenya.getText();
    	
    	con = new Connexio();

		ClientDAOImpl.login(con, correu, pasword);
		
	
    	
    	AnchorPane nuevo;
    	nuevo = FXMLLoader.load(getClass().getResource("Inici.fxml"));
    	escena.getChildren().setAll(nuevo);
    }

}
