package dam2.amv;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Client;
import model.ClientDAOImpl;
import model.Connexio;
import model.RestaurantDAOImpl;

public class ControllerConfiguracioUsuari {

	public static Connexio con = new Connexio();
	
	
	
    @FXML
    private Button BtnModificar;

    @FXML
    private TextField TFAdreça;

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
    private TextField TFid;

    public void initialize(URL location, ResourceBundle resources) {
    	
    	String Nom = TFNom.getText();
		String Cognom = TFCognom.getText();
		String Dni = TFDni.getText();
		String Adreca = TFAdreça.getText();
		String Correu = TFCorreu.getText();
		String Telefon = TFTelefon.getText();
		int Telefono=Integer.parseInt(Telefon);

		con = new Connexio();

		ClientDAOImpl client = new ClientDAOImpl();

		List<Client> cliento = (List<Client>) new Client(Dni,Nom,Cognom,Adreca,Telefono,Correu);

		client.Tots(con, cliento);
		
		TFNom.setText(Nom);
		
		TFCognom.setText(Cognom);
		
		TFDni.setText(Dni);
		
		//TFAdreça.setText(value);
	
	
   
    	};
  
    

    @FXML
    void modificar(ActionEvent event) {
    	
    	
    }

}

