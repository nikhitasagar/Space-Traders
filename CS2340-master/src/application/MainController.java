package application;

import java.io.IOException;

import javax.naming.OperationNotSupportedException;

import model.GameData;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import view.Main;

/**
 * This class generates the welcome screen where the player can choose to start
 * a new game or load a previously saved game.
 *
 * @author Utkarsh Garg
 */
public class MainController {

	/**
	 * This method performs the end game action nd closes the games window
	 *
	 * @param event
	 */
	public final void endGame(final ActionEvent event) {
		Platform.exit();
	}

	/**
	 * This method loads a previously saved game
	 *
	 * @param event
	 * @throws OperationNotSupportedException
	 */
	public final void loadSavedGame(final ActionEvent event)
			throws OperationNotSupportedException {
		Main.setScene("LoadGame.fxml");
	}

	/**
	 * This method sets the scene for a new game
	 *
	 * @param event
	 */
	public final void startGame(final ActionEvent event) {
		Main.setScene("../view/newGamePage.fxml");
	}

	private static GameData data;
	Stage primaryStage;
	private AnchorPane rootLayout;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Space Trader");
		initRootLayout();
		data = GameData.getData();
	}

	public void initRootLayout() {
		try {
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class
					.getResource("../view/welcomeScreen.fxml"));
			rootLayout = (AnchorPane) loader.load();

			// Show the scene containing the root layout.
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void transitionToNewGame() {
		Stage newStage = new Stage();
		try {
			AnchorPane page = (AnchorPane) FXMLLoader.load(Main.class
					.getResource("../view/NewGamePage.fxml"));
			Scene scene = new Scene(page);
			newStage.setScene(scene);
			newStage.show();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static GameData getData() {
		return data;
	}

	public static void main(String[] args) {
		launch(args);
	}

}