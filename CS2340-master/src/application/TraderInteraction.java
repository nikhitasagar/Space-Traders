package application;

import java.net.URL;
import java.util.ResourceBundle;

import model.savedGames;
import view.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class TraderInteraction implements Initializable {

	@Override
	public void initialize(final URL arg0, final ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

	@FXML
	public final void returnToMap() {
		Main.setScene("InteractionPage.fxml");
	}

	@FXML
	public final void save() {
		savedGames saveNewGame = new savedGames();
		saveNewGame.writeToFile();
		Main.setScene("welcomeScreen.fxml");
	}

	@FXML
	public final void returnToMainScreen() {
		Main.setScene("../view/Game.fxml");
	}
}
