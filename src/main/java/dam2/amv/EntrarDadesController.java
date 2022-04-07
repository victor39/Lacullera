package dam2.amv;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Client;
import model.ClientDAO;
import model.ClientDAOImpl;
import model.Connexio;
import model.Persona;
import model.Reserva;
import model.ReservaDAOImpl;

public class EntrarDadesController {

	public static Connexio con = new Connexio();

	@FXML
	private Button BtnReservar;

	@FXML
	private TextField TFAdreca;

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
	

	public void agafarDades() throws IOException {

		String Nom = TFNom.getText();
		String Cognom = TFCognom.getText();
		String Dni = TFDni.getText();
		String Adreca = TFAdreca.getText();
		String Correu = TFCorreu.getText();
		String Telefon = TFTelefon.getText();
		int Telefono=Integer.parseInt(Telefon);

		con = new Connexio();

		ClientDAO client = new ClientDAOImpl();

		Client cliento = new Client(Dni,Nom,Cognom,Adreca,Telefono,Correu);

		client.create(con, cliento);

		System.out.println("Nom: " + Nom);
		System.out.println("Cognom: " + Cognom);
		System.out.println("Adreça: " + Adreca);
		System.out.println("Dni: " + Dni);
		System.out.println("Correu: " + Correu);
		System.out.println("Telefon: " + Telefon);

		
    	
	}

}
