package dam2.amv;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Client;
import model.ClientDAOImpl;
import model.Connexio;

public class ControllerConfiguracioUsuari {

    @FXML
    private Button BtnModificar;

    @FXML
    private ComboBox<String> CMM;

    @FXML
    private TextField TFModificar;

    @FXML
    private TextField TFDni;
    
    private ObservableList<String> clientlist;

    public static Connexio con = new Connexio();
    
    public void initialize(URL location, ResourceBundle resources) {
    	
     	clientlist=FXCollections.observableArrayList();
    	
    	clientlist.setAll("Nom","Cognom","Dni","Correu","Adreça","Telefon");
    	
    	CMM = new ComboBox<String>(clientlist);

    }
    
    @FXML
    void modificar(ActionEvent event) {

    	String dni = TFDni.getText();
    	
    	System.out.println("dni:" + dni);
    	
    	String dades = TFModificar.getText();
    	
    	System.out.println("dades a modificar:" + dades);
    	
    	
    }

}
