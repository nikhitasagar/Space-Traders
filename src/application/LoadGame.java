package application;

import java.net.URL;
import java.util.ResourceBundle;

import view.Main;
import model.GameData;
import model.Person;
import model.savedGames;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * This class loads the game data from file and initializes the previous values
 * onto the screen
 *
 * @author nikhitasagar
 */
public class LoadGame implements Initializable {
	@FXML
	Label savedGameLabel;

	private GameData d;
	private Person person;
	savedGames previousSave;

	/**
	 * This method initializes the variables from a previously saved game
	 */
	@Override
	public final void initialize(final URL location,
			final ResourceBundle resources) {
		previousSave = new savedGames();
		if (previousSave.readFromFile()) {
			d = new GameData();
			GameData.setData(d);
			person = savedGames.getPerson();
			d.setPerson(person);
			savedGameLabel.setText("Click on Continue Game to proceed");
		}
	}

	/**
	 * This method makes a call to return to the main welcome screen
	 */
	@FXML
	public final void returnToWelcomeScreen() {
		Main.setScene("welcomeScreen.fxml");
	}

	/**
	 * If a game was previously saved it loads the previous game or else enters
	 * welcome screen to start a new game
	 */
	@FXML
	public final void continueGame() {
		if (savedGameLabel.getText()
				.equals("Click on Continue Game to proceed")) {
			Main.setScene("Game.fxml");
		} else {
			Main.setScene("welcomeScreen.fxml");
		}
	}
}
