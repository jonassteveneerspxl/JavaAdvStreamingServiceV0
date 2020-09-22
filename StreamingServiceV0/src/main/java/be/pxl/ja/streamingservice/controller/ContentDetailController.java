package be.pxl.ja.streamingservice.controller;

import be.pxl.ja.streamingservice.model.Content;
import be.pxl.ja.streamingservice.model.Movie;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.kordamp.ikonli.javafx.FontIcon;

public class ContentDetailController {

	@FXML
	private Label titleLabel;

	@FXML
	private Label durationLabel;

	@FXML
	private FontIcon genreIcon;


	public void setContent(Content content) {
		titleLabel.setText(content.toString());
		if (content instanceof Movie) {
			Movie movie = (Movie) content;
			durationLabel.setText(movie.getPlayingTime());

			String icon = "mdi-comment-question-outline";
			if (movie.getGenre() != null) {
				icon = movie.getGenre().getIcon();
			}
			genreIcon.setIconLiteral(icon);
		}
	}

	public void onClose(ActionEvent actionEvent) {
		Stage stage =  (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
		stage.close();
	}


}
