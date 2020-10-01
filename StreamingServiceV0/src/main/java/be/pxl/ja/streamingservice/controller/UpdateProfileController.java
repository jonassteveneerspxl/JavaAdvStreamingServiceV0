package be.pxl.ja.streamingservice.controller;

import be.pxl.ja.streamingservice.model.Profile;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

public class UpdateProfileController {

	@FXML
	private DatePicker dateOfBirthDatePicker;

	@FXML
	private JFXTextField profileTextField;

	private Profile profile;

	public void setProfile(Profile profile) {
		this.profile = profile;
		profileTextField.setText(profile.getName());
		dateOfBirthDatePicker.setValue(profile.getDateOfBirth());
	}

	public void onUpdate(ActionEvent actionEvent) {
		profile.setName(profileTextField.getText());
		profile.setDateOfBirth(dateOfBirthDatePicker.getValue());
		Stage stage =  (Stage) ((JFXButton) actionEvent.getSource()).getScene().getWindow();
		stage.close();
	}
}
