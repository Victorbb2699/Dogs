package dad.javafx.dogs.mvc;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class DogsServiceController implements Initializable {

	@FXML
	private GridPane root;

	@FXML
	private ImageView dogImageView;

	@FXML
	private Button actualizarButton;

	@FXML
	private ComboBox<?> dogsCombo;
	
	public DogsServiceController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/DogsView.fxml"));
		loader.setController(this);
		loader.load();
		
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//bindeos
		
		
		
	}
	public GridPane getView() {
		return root;
	}

}
