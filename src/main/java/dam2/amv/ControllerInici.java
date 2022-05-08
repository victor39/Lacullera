package dam2.amv;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.FontSmoothingType;
import javafx.scene.text.Text;
import javafx.scene.transform.Translate;
import model.Client;
import model.Reserva;
import model.Restaurant;
import model.Torn;

public class ControllerInici implements Initializable  {
	
	@FXML
    private AnchorPane ApMenu;

    @FXML
    private Text BtnBuscarRestaurants;

    @FXML
    private Text BtnReserva;

    @FXML
    private Text btnBorrarRestaurant;

    @FXML
    private Text btnRestaurant;

    @FXML
    private Text btnTorns;

    @FXML
    private AnchorPane escena;

    @Override
	public void initialize(URL location, ResourceBundle resources) {
    	
    	if(App.clientLogin.getPasword().equalsIgnoreCase("administrador")) {
    		
    		gestionarEventos();
    		
    	}
    	else  {
    		gestionarEventos();
    		
    		Translate translate = new Translate();     
    		translate.setY(320); 
    	     //Adding transformation to circle2 
    	    BtnReserva.getTransforms().addAll(translate); 
    	    
    		btnBorrarRestaurant.setVisible(false);
    		btnTorns.setVisible(false);
    		btnRestaurant.setVisible(false);
    	}
		
	}

	@FXML
    void reserva(MouseEvent event) throws IOException {
    	AnchorPane nuevo;
    	nuevo = FXMLLoader.load(getClass().getResource("Reserva.fxml"));
    	escena.getChildren().setAll(nuevo);
    	
    }

    @FXML
    void modificarReserva(MouseEvent event) throws IOException {
    	AnchorPane nuevo;
    	nuevo = FXMLLoader.load(getClass().getResource("ModificarReserva.fxml"));
    	escena.getChildren().setAll(nuevo);
    	
    }
    
    @FXML
    void entrarRestaurant(MouseEvent event) throws IOException {
    	AnchorPane nuevo;
    	nuevo = FXMLLoader.load(getClass().getResource("entrarRestaurant.fxml"));
    	escena.getChildren().setAll(nuevo);
    	
    }
    
    @FXML
    void borrarRestaurant(MouseEvent event) throws IOException {

    	AnchorPane nuevo;
    	nuevo = FXMLLoader.load(getClass().getResource("BorrarRestaurant.fxml"));
    	escena.getChildren().setAll(nuevo);
    	
    }
    
    @FXML
    void torns(MouseEvent event) throws IOException {
    	AnchorPane nuevo;
    	nuevo = FXMLLoader.load(getClass().getResource("MenuTorns.fxml"));
    	escena.getChildren().setAll(nuevo);
    	
    		
    	
    }
    
    
    private void gestionarEventos() {
		
    	BtnBuscarRestaurants.hoverProperty().addListener(l->{
    		BtnBuscarRestaurants.setFill(Color.WHITE);
    	});
    	BtnBuscarRestaurants.setOnMouseExited(mouseEvent->{
    		BtnBuscarRestaurants.setFill(Color.GREY);
		});
    	
    	
    	BtnReserva.hoverProperty().addListener(l->{
    		BtnReserva.setFill(Color.WHITE);
    	});
    	BtnReserva.setOnMouseExited(mouseEvent->{
    		BtnReserva.setFill(Color.GREY);
		});
    	
    	
    	btnTorns.hoverProperty().addListener(l->{
    		btnTorns.setFill(Color.WHITE);
    	});
    	btnTorns.setOnMouseExited(mouseEvent->{
    		btnTorns.setFill(Color.GREY);
		});
    	
    	btnBorrarRestaurant.setOnMouseExited(mouseEvent->{
    			btnBorrarRestaurant.setFill(Color.GREY);
    		});
    	btnBorrarRestaurant.hoverProperty().addListener(l->{
    		btnBorrarRestaurant.setFill(Color.WHITE);
    	});
		
    	btnRestaurant.hoverProperty().addListener(l->{
    		btnRestaurant.setFill(Color.WHITE);
    	});
    	btnRestaurant.setOnMouseExited(mouseEvent->{
    		btnRestaurant.setFill(Color.GREY);
		});
    	
	}
    
    
}
