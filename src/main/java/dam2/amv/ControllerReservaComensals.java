package dam2.amv;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Article;
import model.ArticleDAOImpl;
import model.Carta;
import model.Connexio;
import model.Torn;

public class ControllerReservaComensals implements Initializable{
	
		
		   public  Connexio con = new Connexio();
		   @FXML
		   private Button btnReservar;
		   @FXML
		   private ComboBox<Torn> cmbTorn;
		   
		   
		   //Contenidor de javaFX controla si afegim o eliminem un element al contenidor, de tal manera que queda reflexat en la vista.     
		    private ObservableList <Torn> llistaTorns;
		    
		    private Spinner<Integer> spnComensals;
		    
		    private Torn eleccio;
		    private AnchorPane escena;
		    private Integer idRestaurant;
		 

		    
		    
		    // mètode per inicialitzar els components, per exemple si no inicialitzem els components combobox pot generar una excepció per que es troba a null.
		    //Aquest métode l'hem dimplementar ja que la classe implementa inicializable.
		   
		    public void initialize(URL location, ResourceBundle resources) {
		    	
		    		    	
		    	// Inicialitzem l'obserbableList amb un métode de la classe FXCollections que ens retorna un Observable Arraylist.
		    	llistaTorns=FXCollections.observableArrayList();
		    	
		    	SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1);
		    	spnComensals.setValueFactory(valueFactory);
		    	
		    	
		    	// Inicialitzem la conneci� a la base de dades
		    	
		    	// El ObservableList ha de coincidir en el tipus d'objecte amb la llista que li passem.
		    	/********************************************************************************************Filtrat*/
		    	// per lligar un observable list amb una llista ho fem amb el m�tode setItems
		    	
		    	// Lliguem les llistes amb els combobox
		    
		    	//Cridem al m�tode que ens retorna els elements de la taula Carrera Com els par�metres es passen per refer�ncia el que estem fent �s actualitzar la llista que passem per par�metre

		    	cmbTorn.setItems(llistaTorns);
		    	//TornDAOImpl.Tots(con, llistaTorns, idRestaurant);
		    	
		    	cmbTorn.setOnAction(e -> System.out.println("Nova selecció: " + cmbTorn.getValue()));

		    	cmbTorn.valueProperty().addListener((ov, p1, p2) -> {
		    	    System.out.println("Nueva Selección: " + p2);
		    	    System.out.println("Vieja Selección: " + p1);
		    	});
		  
		    }
		    
		    public void reservar(ActionEvent event) throws IOException {
		    	
		    	
		    	
		        Stage stage = new Stage();
		        FXMLLoader loader = new FXMLLoader(getClass().getResource("EleccioRestaurant.fxml"));
		        Parent parent = loader.load();
		        Scene scene = new Scene(parent);
		        //Map<String, String> rest = new HashMap<>();
		        //rest.put("nom",cmbTorn.getValue().getNom());
		        //rest.put("prova","prova");
		        //scene.setUserData(rest);
		        stage.setScene(scene);
		        stage.show();
		    }
		    
		   
//		    private void enviarDatos () {
//		    	String nomRestaurant = cmbTriaRestaurant.getValue().getNom();
//		        
//		    	
//		    }
		    
	}


