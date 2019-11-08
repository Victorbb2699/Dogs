package dad.javafx.dogs.mvc;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DogsApp extends Application {

	DogsServiceController controller;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		controller = new DogsServiceController();
		
		
		Scene scene = new Scene(controller.getView(), 320, 200);

		primaryStage.setTitle("Dogs");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
		
	}

}
