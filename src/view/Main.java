package view;

import java.io.IOException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.GameData;

/**
 * This is the main class that is run to run the game.
 *
 * @author Pratik
 *
 */
public class Main extends Application {
	private static Stage primaryStage;
	private static GameData game;

	/**
	 * The start method sets the screen and the scene.
	 * 
	 * @param primaryStage
	 *            the stage to be displayed
	 *
	 */
	@Override
	public final void start(final Stage primaryStage) {
		Main.primaryStage = primaryStage;
		primaryStage.setTitle("SpaceTraders");
		primaryStage.setResizable(false);
		Main.game = GameData.getData();
		Main.setScene("welcomeScreen.fxml");
	}

	/**
	 * This method sets the scene for each location within the game.
	 * 
	 * @param fxmlURL
	 *            the location of the fxml file
	 *
	 */
	public static void setScene(final String fxmlURL) {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource(fxmlURL));
			loader.setLocation(Main.class.getResource(fxmlURL));
			Parent root = loader.load();
			Scene newPane = new Scene(root);
			primaryStage.setScene(newPane);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method allows you to quit.
	 *
	 */
	@Override
	public final void stop() {
		Platform.exit();
	}

	/**
	 * This method starts the application
	 *
	 */
	public static void main(final String[] args) {
		launch(args);
	}

	/**
	 * This method returns the primaryStage
	 * 
	 * @return Stage the primaryStage
	 *
	 */
	public static Stage getPrimaryStage() {
		return primaryStage;
	}

	/**
	 * This method returns the gameData
	 * 
	 * @return GameData the data
	 *
	 */
	public static GameData getGame() {
		return game;
	}

}
