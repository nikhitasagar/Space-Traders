package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

import model.GameData;
import model.Person;
import model.PiratePlayer;
import model.Planet;
import model.Ship;
import model.TraderPlayer;
import model.savedGames;
import view.Main;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

/**
 * This class controls the interactions between different game tools on
 * different game pages
 */
public class InteractionController implements Initializable {

	// instance variables
	private GameData d;
	private Person person;
	private Ship ship;
	private Planet planet;
	private ArrayList<ImageView> traderImages;
	private ArrayList<ImageView> pirateImages;
	private ArrayList<TraderPlayer> traders;
	private ArrayList<PiratePlayer> pirates;
	private Shape shape;

	@FXML
	Pane shipPane;

	/**
	 * This method initializes the values of the controllers like players,
	 * pirates, traders, police and positions them on the screen
	 *
	 * @param arg0
	 * @param arg1
	 */
	@Override
	public final void initialize(final URL arg0, final ResourceBundle arg1) {
		shape = new Circle(1, 1, 1);

		// TODO Auto-generated method stub
		d = GameData.getData();
		person = d.getPerson();
		ship = person.getShip();
		planet = person.getPlanet();

		// plot your ship
		ImageView personShip = new ImageView(new Image(
				"resources/spaceShip.png", 80, 80, false, false));
		personShip.relocate(20, 160);
		FadeTransition f = new FadeTransition(Duration.millis(1000), personShip);
		f.setFromValue(1.0);
		f.setToValue(0.7);
		f.setCycleCount(Animation.INDEFINITE);
		f.setAutoReverse(true);
		f.play();
		shipPane.getChildren().add(personShip);
		shape = Shape.union(shape, new Circle(20, 160, 150));

		// event handlers
		EventHandler<MouseEvent> selectPlayer = event -> {
			ImageView temp = (ImageView) event.getPickResult()
					.getIntersectedNode();
			if (pirates != null) {
				for (int i = 0; i < pirates.size(); i++) {
					if (temp == pirateImages.get(i)) {
						planet.setCurrentPirate(pirates.get(i));
						Main.setScene("PirateInteraction.fxml");
					}
				}
			}
			if (traders != null) {
				for (int i = 0; i < traders.size(); i++) {
					if (temp == traderImages.get(i)) {
						planet.setCurrentTrader(traders.get(i));
						Main.setScene("TraderInteraction.fxml");
					}
				}
			}
		};

		// get all the pirates:
		if (planet.getPirateList() == null) {
		} else {
			pirates = planet.getPirateList();
			pirateImages = new ArrayList<>(pirates.size());
			Random gen = new Random();
			for (int i = 0; i < pirates.size(); i++) {
				ImageView ship = new ImageView(new Image(
						"resources/otherShips.png", 40, 40, false, false));
				int x = gen.nextInt(200);
				int y = gen.nextInt(200);
				while (shape.contains(x, y)) {
					x = gen.nextInt(200);
					y = gen.nextInt(200);
				}
				ship.relocate(x, y);
				ship.addEventHandler(MouseEvent.MOUSE_CLICKED, selectPlayer);
				Tooltip t = new Tooltip("Strength = "
						+ pirates.get(i).getStrength());
				Tooltip.install(ship, t);
				shipPane.getChildren().add(ship);
				shape = Shape.union(shape, new Circle(x, y, 80));
				pirateImages.add(ship);
			}
		}

		// get all the traders:
		if (planet.getTradersList() == null) {
		} else {
			traders = planet.getTradersList();
			traderImages = new ArrayList<>(traders.size());
			Random gen = new Random();
			for (int i = 0; i < traders.size(); i++) {
				ImageView ship = new ImageView(new Image(
						"resources/otherShips.png", 40, 40, false, false));
				int x = gen.nextInt(400);
				int y = gen.nextInt(380);
				while (shape.contains(x, y)) {
					x = gen.nextInt(400);
					y = gen.nextInt(380);
				}
				ship.relocate(x, y);
				ship.addEventHandler(MouseEvent.MOUSE_CLICKED, selectPlayer);
				Tooltip t = new Tooltip("Strength = "
						+ traders.get(i).getStrength());
				Tooltip.install(ship, t);
				shipPane.getChildren().add(ship);
				shape = Shape.union(shape, new Circle(x, y, 80));
				traderImages.add(ship);
			}
		}

	}
	
	

	/**
	 * This method makes a call to return to the GamePage
	 */

	@FXML
	public final void returnToMainScreen() {
		Main.setScene("../view/Game.fxml");
	}

	/**
	 * This method saves the state of the game on file
	 */
	@FXML
	public final void save() {
		savedGames saveNewGame = new savedGames();
		saveNewGame.writeToFile();
		Main.setScene("welcomeScreen.fxml");
	}

}
