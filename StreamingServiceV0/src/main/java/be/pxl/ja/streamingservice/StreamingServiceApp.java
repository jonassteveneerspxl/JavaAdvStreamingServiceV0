package be.pxl.ja.streamingservice;

import be.pxl.ja.streamingservice.controller.Pages;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class StreamingServiceApp extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		URL resource = getClass().getClassLoader().getResource(Pages.LOGIN_PAGE);
		Parent root = FXMLLoader.load(resource);
		Scene scene = new Scene(root);
		stage.setTitle("PXL Streaming service");
		stage.setScene(scene);
		stage.show();
	}

}
