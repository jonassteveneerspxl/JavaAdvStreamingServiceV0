package be.pxl.ja.streamingservice.controller;

import be.pxl.ja.streamingservice.model.Account;
import be.pxl.ja.streamingservice.model.Content;
import be.pxl.ja.streamingservice.model.Profile;
import be.pxl.ja.streamingservice.StreamingService;
import be.pxl.ja.streamingservice.StreamingServiceFactory;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

	private StreamingService streamingService;

	@FXML
	private GridPane contentGrid;

	private Account account;
	private Profile currentProfile;

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		System.out.println("Initializing");
		streamingService = StreamingServiceFactory.getStreamingService();
	}

	private void showContentForProfile() {
		contentGrid.getChildren().clear();
		int row = 0;
		int col = 0;
		for (Content content: streamingService.getContentList()) {
			if (currentProfile.allowedToWatch(content)) {
				Image image = new Image("streamingservice/images/" + content.getImageUrl());
				ImageView contentImage = new ImageView(image);
				contentImage.setFitHeight(200.0);
				contentImage.setFitWidth(120.0);
				contentImage.setOnMouseClicked((e) -> {
					try {
						FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource(Pages.CONTENT_DETAIL));
						Parent parent = fxmlLoader.load();
						ContentDetailController contentDetailController = fxmlLoader.getController();
						contentDetailController.setContent(content);

						Scene scene = new Scene(parent);
						Stage stage = new Stage();
						stage.initModality(Modality.APPLICATION_MODAL);
						stage.setScene(scene);
						stage.showAndWait();
					} catch (IOException f) {
						f.printStackTrace();
					}
				});
				contentGrid.add(contentImage, col, row);
				col++;
				if (col == 3) {
					col = 0;
					row++;
				}
			}
		}
	}

	public void setAccount(Account account) {
		this.account = account;
		this.currentProfile = account.getFirstProfile();
		showContentForProfile();
	}

	public void onProfileUpdate(MouseEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource(Pages.UPDATE_PROFILE));
			Parent parent = fxmlLoader.load();
			UpdateProfileController dialogController = fxmlLoader.getController();
			dialogController.setProfile(currentProfile);

			Scene scene = new Scene(parent);
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setScene(scene);
			stage.showAndWait();
			showContentForProfile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onLogout(MouseEvent event) {
		try {
			//setAccount(null);
			URL resource = getClass().getClassLoader().getResource(Pages.LOGIN_PAGE);
			FXMLLoader loader = new FXMLLoader(resource);
			Stage stage = (Stage) contentGrid.getScene().getWindow();
			Scene scene = new Scene(loader.load());
			stage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
