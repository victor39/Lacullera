package dam2.amv;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Connexio;
import model.Restaurant;
import model.RestaurantDAO;
import model.RestaurantDAOImpl;

public class ControllerBuscarRestaurant implements Initializable{
	
	   public  Connexio con = new Connexio();
	   @FXML
	   private Button BtnSeguent;

	   @FXML
	   private ComboBox<Restaurant> cmbTriaRestaurant;
	   
	   
	   //Contenidor de javaFX controla si afegim o eliminem un element al contenidor, de tal manera que queda reflexat en la vista.     
	    private ObservableList <Restaurant>listaRestaurant;
	    
	    private Restaurant eleccio;
	    private AnchorPane escena;
	 

	    
	    
	    // mètode per inicialitzar els components, per exemple si no inicialitzem els components combobox pot generar una excepció per que es troba a null.
	    //Aquest métode l'hem dimplementar ja que la classe implementa inicializable.
	   
	    public void initialize(URL location, ResourceBundle resources) {
	    	
	    		    	
	    	// Inicialitzem l'obserbableList amb un métode de la classe FXCollections que ens retorna un Observable Arraylist.
	    	listaRestaurant=FXCollections.observableArrayList();
	    	
	    	// Inicialitzem la conneci� a la base de dades
	    	
	    	// El ObservableList ha de coincidir en el tipus d'objecte amb la llista que li passem.
	    	/********************************************************************************************Filtrat*/
	    	// per lligar un observable list amb una llista ho fem amb el m�tode setItems
	    	
	    	// Lliguem les llistes amb els combobox
	    
	    	//Cridem al m�tode que ens retorna els elements de la taula Carrera Com els par�metres es passen per refer�ncia el que estem fent �s actualitzar la llista que passem per par�metre

	    	cmbTriaRestaurant.setItems(listaRestaurant);
	    	RestaurantDAOImpl.Tots(con, listaRestaurant);
	    	
	    	cmbTriaRestaurant.setOnAction(e -> System.out.println("Nova selecció: " + cmbTriaRestaurant.getValue()));

	    	cmbTriaRestaurant.valueProperty().addListener((ov, p1, p2) -> {
	    	    System.out.println("Nueva Selección: " + p2);
	    	    System.out.println("Vieja Selección: " + p1);
	    	    
	    	
	    	});
	  
	    }
	    public void submit(ActionEvent event) throws IOException {
	        Stage stage = new Stage();
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("EleccioRestaurant.fxml"));
	        Parent parent = loader.load();
	        Scene scene = new Scene(parent);
	        Map<String, String> rest = new HashMap<>();
	        rest.put("nom",cmbTriaRestaurant.getValue().getNom());
	        rest.put("prova","prova");
	        scene.setUserData(rest);
	        stage.setScene(scene);
	        stage.show();
	    }
	    
	   
//	    private void enviarDatos () {
//	    	String nomRestaurant = cmbTriaRestaurant.getValue().getNom();
//	        
//	    	
//	    }
	    
}
