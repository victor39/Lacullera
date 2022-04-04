package dam2.amv;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Client;
import model.ClientDAOImpl;
import model.Connexio;

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

    @FXML
    void modificar(ActionEvent event) {
    	
    	con = new Connexio();

		ClientDAOImpl client = new ClientDAOImpl();
		
		Client cliente = new Client(TFNom,TFCognom,TFA);
		
    	String id = TFid.getText();
    	
    	System.out.println("id agafat correctament: " + id);
    	
    	client.Tots(con, client);
    	
    }

}

