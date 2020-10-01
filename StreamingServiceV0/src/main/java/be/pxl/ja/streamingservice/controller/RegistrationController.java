package be.pxl.ja.streamingservice.controller;

import be.pxl.ja.streamingservice.StreamingService;
import be.pxl.ja.streamingservice.StreamingServiceFactory;
import be.pxl.ja.streamingservice.model.Account;
import be.pxl.ja.streamingservice.model.CreditCardType;
import be.pxl.ja.streamingservice.model.PaymentInfo;
import be.pxl.ja.streamingservice.model.StreamingPlan;
import be.pxl.ja.streamingservice.util.PasswordUtil;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXProgressBar;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class RegistrationController implements Initializable {

	@FXML
	private TextField emailTextField;

	@FXML
	private TextField passwordTextField;

	@FXML
	private Button continueButton;

	@FXML
	private Button registerButton;

	@FXML
	private TextField firstnameTextField;

	@FXML
	private TextField lastnameTextField;

	@FXML
	private TextField cardnumberTextField;

	@FXML
	private TextField cvcTextField;

	@FXML
	private JFXComboBox<CreditCardType> creditCardTypeComboBox;

	@FXML
	private JFXComboBox<StreamingPlan> streamingPlanComboBox;

	@FXML
	private JFXDatePicker expirationDatePicker;

	@FXML
	private JFXProgressBar passwordStrengthIndicator;

	private Account newAccount;
	private StreamingService streamingService;

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		streamingService = StreamingServiceFactory.getStreamingService();
		if (streamingPlanComboBox != null) {
			streamingPlanComboBox.setItems(FXCollections.observableList(Arrays.asList(StreamingPlan.values())));
		}
		if (creditCardTypeComboBox != null) {
			creditCardTypeComboBox.setItems(FXCollections.observableList(Arrays.asList(CreditCardType.values())));
		}
	}

	public void setAccount(Account newAccount) {
		this.newAccount = newAccount;
	}

	public void onContinue(ActionEvent actionEvent) {
		newAccount = new Account(emailTextField.getText(), passwordTextField.getText());
		newAccount.setStreamingPlan(streamingPlanComboBox.getValue());
		try {
			URL resource = getClass().getClassLoader().getResource(Pages.REGISTRATION_STEP2);
			FXMLLoader loader = new FXMLLoader(resource);
			Stage stage = (Stage) continueButton.getScene().getWindow();
			Scene scene = new Scene(loader.load());
			RegistrationController controller = loader.getController();
			controller.setAccount(newAccount);
			stage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onPasswordUpdate(KeyEvent event) {
		int strength = PasswordUtil.calculateStrength(passwordTextField.getText());
		passwordStrengthIndicator.setProgress(strength / 10.0);
	}

	public void onRegister(ActionEvent actionEvent) {
		PaymentInfo paymentInfo = new PaymentInfo();
		paymentInfo.setCardNumer(cardnumberTextField.getText());
		paymentInfo.setExpirationDate(expirationDatePicker.getValue());
		paymentInfo.setFirstName(firstnameTextField.getText());
		paymentInfo.setLastName(lastnameTextField.getText());
		paymentInfo.setSecurityCode(Integer.parseInt(cvcTextField.getText()));
		paymentInfo.setType(creditCardTypeComboBox.getValue());
		newAccount.setPaymentInfo(paymentInfo);
		streamingService.addAccount(newAccount);
		try {
			URL resource = getClass().getClassLoader().getResource(Pages.LOGIN_PAGE);
			Parent root = FXMLLoader.load(resource);
			Stage stage = (Stage) registerButton.getScene().getWindow();
			Scene scene = new Scene(root);
			stage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
