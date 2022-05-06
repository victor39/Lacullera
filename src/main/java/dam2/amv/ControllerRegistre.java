package dam2.amv;

import java.io.IOException;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import model.Client;
import model.ClientDAO;
import model.ClientDAOImpl;
import model.Connexio;

public class ControllerRegistre {

	@FXML
	private Button BtnRegistre;

	@FXML
	private TextField TFAdreca;

	@FXML
	private TextField TFCognom;

	@FXML
	private TextField TFContrasenya;

	@FXML
	private TextField TFCorreu;

	@FXML
	private TextField TFDni;

	@FXML
	private TextField TFNom;

	@FXML
	private TextField TFTelefon;

	@FXML
	private AnchorPane escena;

	public static Connexio con = new Connexio();

	static boolean validarDNI(String dni) {
		int contadorNumero;
		int contadorTabla;
		char[] letraDni = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V',
				'H', 'L', 'C', 'K', 'E' };
		char[] numero = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		boolean letra = false;
		contadorNumero = 0;
		if (dni.length() == 9) {
			for (int i = 0; i < 8; i++) {

				for (int j = 0; j < numero.length; j++) {
					if (dni.charAt(i) == numero[j]) {
						contadorNumero++;
					}
				}
			}
		}
		contadorTabla = 0;
		while (letra == false && contadorNumero == 8) {
			if (dni.charAt(8) == letraDni[contadorTabla]) {
				letra = true;
			} else {
				contadorTabla++;
			}

		}
		return letra;
	}

	static boolean validarContra(String contra) {

		int contNumero = 0, contLetraMay = 0, contLetraMin = 0;
		char clave;

		for (int i = 0; i < contra.length(); i++) {

			clave = contra.charAt(i);

			String passValue = String.valueOf(clave);

			if (passValue.matches("[A-Z]")) {

				contLetraMay++;

			} else if (passValue.matches("[a-z]")) {

				contLetraMin++;

			} else if (passValue.matches("[0-9]")) {

				contNumero++;

			}

		}
		return true;
	}

	@FXML
	void agafarDades(ActionEvent event) throws IOException {

		String Nom = TFNom.getText();
		String Cognom = TFCognom.getText();

		String Dni = TFDni.getText();
		String Adreca = TFAdreca.getText();
		String Correu = TFCorreu.getText();

		String Telefon = TFTelefon.getText();
		int Telefono = Integer.parseInt(Telefon);

		String password = TFContrasenya.getText();

		con = new Connexio();

		ClientDAO client = new ClientDAOImpl();

		if (!validarDNI(TFDni.getText())) {
			Alert confirmacio = new Alert(AlertType.CONFIRMATION);
			confirmacio.initModality(Modality.WINDOW_MODAL);
			confirmacio.setTitle("El dni no es el correcte  ");
			confirmacio.setContentText("Dni incorrecte");

			Optional<ButtonType> result = confirmacio.showAndWait();
			if (result.isPresent() && result.get() == ButtonType.OK) {

				Alert missatge = new Alert(AlertType.ERROR);
				missatge.setTitle("Posa un Dni correcte ");
				missatge.setContentText("Tornar a posar un Dni correcte");
			}

		} else if (TFTelefon.getText().length() != 9) {
			Alert confirmacio = new Alert(AlertType.CONFIRMATION);
			confirmacio.initModality(Modality.WINDOW_MODAL);
			confirmacio.setTitle("El telefon no es correcte  ");
			confirmacio.setContentText("Telefon incorrecte");

			Optional<ButtonType> result = confirmacio.showAndWait();
			if (result.isPresent() && result.get() == ButtonType.OK) {

				Alert missatge = new Alert(AlertType.ERROR);
				missatge.setTitle("Posa un Telefon correcte ");
				missatge.setContentText("Tornar a posar un Telefon correcte");
			}

		}

		Alert confirmacio = new Alert(AlertType.CONFIRMATION);
		confirmacio.initModality(Modality.WINDOW_MODAL);
		Optional<ButtonType> result = confirmacio.showAndWait();
		if (result.isPresent() && result.get() == ButtonType.OK) {

			boolean resultat = validarContra(TFContrasenya.getText());

			if (resultat == true) {

				Alert missatge = new Alert(AlertType.INFORMATION);
				missatge.setTitle("Usuari afegit correctament  ");
				missatge.setContentText("Usuari afegit correctament  " + Nom);
				missatge.show();

				Client cliento = new Client(Nom, Cognom, Adreca, Dni, Telefono, Correu, password);
				client.create(con, cliento);

				AnchorPane nuevo;
				nuevo = FXMLLoader.load(getClass().getResource("PaginaPrincipal.fxml"));
				escena.getChildren().setAll(nuevo);

			} else {
				Alert missatge = new Alert(AlertType.ERROR);
				missatge.setTitle("Contrasenya incorrecta ");
				missatge.setContentText("Tornar a provar ");
				missatge.setHeaderText("Alerta: ");
				missatge.show();
			}

		}
	}
}
