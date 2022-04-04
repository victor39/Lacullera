package dam2.amv;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import model.Article;
import model.ArticleDAOImpl;
import model.Carta;
import model.Connexio;

public class ControllerSeleccio implements Initializable {
 
	public static Connexio con = new Connexio();
	 
    @FXML
    private Button btComanda;

    @FXML
    private ComboBox<Carta> cmbPostres;

    @FXML
    private ComboBox<Carta> cmbPrimers;

    @FXML
    private ComboBox<Carta> cmbSegons;

    @FXML
    private Text idText;
    
  //Contenidor de javaFX controla si afegim o eliminem un element al contenidor, de tal manera que queda reflexat en la vista.     
    private ObservableList <Carta>listaCarta;
   
    
    
    // mètode per inicialitzar els components, per exemple si no inicialitzem els components combobox pot generar una excepció per que es troba a null.
    //Aquest métode l'hem dimplementar ja que la classe implementa inicializable.
   
    public void initialize(URL location, ResourceBundle resources) {
    	
    		    	
    	// Inicialitzem l'obserbableList amb un métode de la classe FXCollections que ens retorna un Observable Arraylist.
    	listaCarta=FXCollections.observableArrayList();
    	
    	// Inicialitzem la conneci� a la base de dades
    	
    	// El ObservableList ha de coincidir en el tipus d'objecte amb la llista que li passem.
    	/********************************************************************************************Filtrat*/
    	// per lligar un observable list amb una llista ho fem amb el m�tode setItems
    	
    	// Lliguem les llistes amb els combobox
    
    	//Cridem al m�tode que ens retorna els elements de la taula Carrera Com els par�metres es passen per refer�ncia el que estem fent �s actualitzar la llista que passem per par�metre

    	cmbPrimers.setItems(listaCarta);
    	cmbSegons.setItems(listaCarta);
    	cmbPostres.setItems(listaCarta);
    	
  
    }
//    public void getData(ActionEvent event) {
//    	Scene scene = name.getScene();
//    	Map<String, String> userData = (Map<String, String>) scene.getUserData();
//        String name = userData.get("name");
//        String age = userData.get("age");
//        this.name.setText(name);
//        this.age.setText(age);
//  
//    }

}



