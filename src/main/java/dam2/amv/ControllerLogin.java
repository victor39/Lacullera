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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
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

		if (!TfContrasenya.getText().isEmpty() && !TfCorreu.getText().isEmpty()) {

			String correu = TfCorreu.getText();
			String pasword = TfContrasenya.getText();
			
			con = new Connexio();
			Alert confirmacio = new Alert(AlertType.CONFIRMATION);
			confirmacio.initModality(Modality.WINDOW_MODAL);
			Optional<ButtonType> result = confirmacio.showAndWait();
			if (result.isPresent() && result.get() == ButtonType.OK) {
		
				int resultat = ClientDAOImpl.login(con, correu, pasword);
				
				if (resultat == 1) {
					Alert missatge = new Alert(AlertType.INFORMATION);
					missatge.setTitle("Login correcte  ");
					missatge.setContentText("Ja pots començar ");
					missatge.show();
					AnchorPane nuevo;
					nuevo = FXMLLoader.load(getClass().getResource("Inici.fxml"));
					escena.getChildren().setAll(nuevo);

				} else {
					Alert missatge = new Alert(AlertType.ERROR);
					missatge.setTitle("Correu o contrasenya incorrecte ");
					missatge.setContentText("Tornar a provar ");
					missatge.setHeaderText("Alerta: ");
					missatge.show();
				}
			}
		}
	}
}
