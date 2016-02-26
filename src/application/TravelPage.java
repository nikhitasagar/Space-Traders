package application;

import java.net.URL;
import java.util.ResourceBundle;

import model.GameData;
import model.Person;
import model.Planet;
import model.Ship;
import model.Universe;
import model.savedGames;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import view.Main;

public class TravelPage implements Initializable {

	// private instance variables
	private GameData d;
	private Person person;
	private Ship ship;
	private Universe universe;
	private Circle currentPlanetCircle;
	private Circle tempPlanet;
	private Circle rangeCircle;
	private int SCALE = 3;
	private Planet currentPlanet;
	private Planet selectedPlanet;
	private Circle clickedCircle;

	// FXML
	@FXML
	Label currentPlanetLabel;
	@FXML
	Label destinationLabel;
	@FXML
	Label fuelLabel;
	@FXML
	Button travelButton;
	@FXML
	Pane universeMap;
	@FXML
	Button refuelButton;
	@FXML
	Label money;
	@FXML
	Label cargoBayStatus;
	@FXML
	Label playerTurn;
	@FXML
	Label playerName;
	@FXML
	ImageView activePerson1;
	@FXML
	ImageView inactivePerson1;
	@FXML
	ImageView activePerson2;
	@FXML
	ImageView inactivePerson2;

	@Override
	public final void initialize(final URL location,
			final ResourceBundle resources) {
		d = GameData.getData();
		person = d.getPerson();
		universe = d.getUniverse();
		ship = person.getShip();
		currentPlanet = person.getPlanet();

		int fuelValue = ship.fuelToFill();
		refuelButton.setText("Refuel (Cost = " + fuelValue + ")");
		currentPlanetLabel.setText("Current Planet: "
				+ person.getPlanet().getName().toString() + ", "
				+ person.getPlanet().getTechLevelString());
		destinationLabel.setText("Destination: " + "None Selected");

		menuBarLabels();
		crewUpdate();
		generatePlot();
	}

	private void menuBarLabels() {
		playerName.setText("Welcome " + person.getName() + "!");
		money.setText("$" + person.myMoney);
		cargoBayStatus.setText("" + person.getShip().getCargoBayCount() + "/"
				+ person.getShip().getCargoBayCapacity());
		fuelLabel.setText("" + person.getShip().getFuel());
		playerTurn.setText("" + person.getTurn());
	}

	private void crewUpdate() {
		inactivePerson2.setVisible(true);
		inactivePerson1.setVisible(false);
		activePerson2.setVisible(false);
		activePerson1.setVisible(false);
		if (person.getShip().getCrewCapacity() == 1) {
			if (person.getShip().getCrewCount() == 1) {
				inactivePerson2.setVisible(false);
				activePerson2.setVisible(true);
			}
		} else {
			inactivePerson1.setVisible(true);
			if (person.getShip().getCrewCount() == 1) {
				inactivePerson2.setVisible(false);
				activePerson2.setVisible(true);
			} else if (person.getShip().getCrewCount() == 2) {
				inactivePerson2.setVisible(false);
				activePerson2.setVisible(true);
				inactivePerson1.setVisible(false);
				activePerson1.setVisible(true);
			}
		}
	}

	private void generatePlot() {
		EventHandler<MouseEvent> updateDestinationLabel = event -> {
			// remove highlight
			clickedCircle.setStrokeWidth(0);

			// update clicked circle
			clickedCircle = (Circle) event.getPickResult().getIntersectedNode();
			int tempx = (int) (clickedCircle.getCenterX() - 5) / 3;
			int tempy = (int) (clickedCircle.getCenterY() - 5) / 3;
			selectedPlanet = universe.findPlanet(tempx, tempy);
			destinationLabel.setText("Destination: " + selectedPlanet.getName()
					+ ", " + selectedPlanet.getTechLevelString());

			// create highlight
			clickedCircle.setStrokeType(StrokeType.OUTSIDE);
			clickedCircle.setStroke(Paint.valueOf("white"));
			clickedCircle.setStrokeWidth(3);

		};

		EventHandler<MouseEvent> cannotTravelHere = event -> {
			// remove highlight
			clickedCircle.setStrokeWidth(0);

			clickedCircle = (Circle) event.getPickResult().getIntersectedNode();
			destinationLabel.setText("Destination: " + "Cannot Travel Here");

			// create highlight
			clickedCircle.setStrokeType(StrokeType.OUTSIDE);
			clickedCircle.setStroke(Paint.valueOf("white"));
			clickedCircle.setStrokeWidth(3);
		};

		rangeCircle();

		Planet temp;
		int techLevel;
		for (int i = 0; i < universe.getSize(); i++) {
			temp = universe.getPlanet(i);
			techLevel = temp.getTechLevel();
			// check if planet is in range
			if (rangeCircle.contains(temp.getX() * 3, temp.getY() * 3)) {
				tempPlanet = new Circle(temp.getX() * 3 + 5,
						temp.getY() * 3 + 5, 5, getColor(techLevel));
				Tooltip t = new Tooltip(temp.getTechLevelString());
				Tooltip.install(tempPlanet, t);
				tempPlanet.addEventHandler(MouseEvent.MOUSE_CLICKED,
						updateDestinationLabel);
			} else {
				tempPlanet = new Circle(temp.getX() * 3 + 5,
						temp.getY() * 3 + 5, 5, Paint.valueOf("grey"));
				tempPlanet.addEventHandler(MouseEvent.MOUSE_CLICKED,
						cannotTravelHere);
			}
			universeMap.getChildren().add(tempPlanet);
		}

		currentPlanetCircle = new Circle(currentPlanet.getX() * 3 + 5,
				currentPlanet.getY() * 3 + 5, 5, Paint.valueOf("lawngreen"));
		universeMap.getChildren().add(currentPlanetCircle);

		clickedCircle = currentPlanetCircle;
		clickedCircle.setStrokeType(StrokeType.OUTSIDE);
		clickedCircle.setStroke(Paint.valueOf("white"));
		clickedCircle.setStrokeWidth(3);
	}

	private void rangeCircle() {
		if (rangeCircle != null) {
			universeMap.getChildren().remove(rangeCircle);
		}
		rangeCircle = new Circle(currentPlanet.getX() * 3 + 5,
				currentPlanet.getY() * 3 + 5, ship.getFuel() * 5 * 3);
		rangeCircle.setStrokeType(StrokeType.OUTSIDE);
		rangeCircle.setStrokeWidth(1);
		rangeCircle.setStroke(Paint.valueOf("white"));
		rangeCircle.setOpacity(0.82);
		rangeCircle.setClip(new Rectangle(460, 310));
		universeMap.getChildren().add(rangeCircle);
	}

	private Color getColor(final int techLevel) {
		if (techLevel == 0) {
			return Color.rgb(28, 188, 255);
		} else if (techLevel == 1) {
			return Color.rgb(0, 179, 255);
		} else if (techLevel == 2) {
			return Color.rgb(0, 159, 228);
		} else if (techLevel == 3) {
			return Color.rgb(0, 119, 171);
		} else if (techLevel == 4) {
			return Color.rgb(0, 100, 142);
		} else if (techLevel == 5) {
			return Color.rgb(0, 80, 114);
		} else if (techLevel == 6) {
			return Color.rgb(0, 60, 85);
		} else {
			return Color.rgb(0, 40, 57);
		}
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

	@FXML
	public final void travel() {
		if (destinationLabel.getText()
				.equals("Destination: Cannot Travel Here")
				|| destinationLabel.getText().equals(
						"Destination: None Selected")) {
			// do nothing
		} else {
			int distance = (int) Math
					.sqrt(Math.pow(
							selectedPlanet.getX() - currentPlanet.getX(), 2)
							+ Math.pow(
									selectedPlanet.getY()
									- currentPlanet.getY(), 2));
			int fuelConsumption = distance / 5;
			if (fuelConsumption < 1) {
				fuelConsumption = 1;
			}
			person.myShip.setFuel(person.myShip.getFuel() - fuelConsumption);
			person.incrementTurn();
			selectedPlanet.toggleDrasticEvents();
			person.setPlanet(selectedPlanet);
			person.getPlanet().getMarketPlace().toggleMercenaries();
			person.getPlanet().createPirates();
			person.getPlanet().createTraders();
			Main.setScene("InteractionPage.fxml");
		}
	}

	@FXML
	public final void refuel() {
		int fuelValue = ship.fuelToFill();
		if (person.myMoney < fuelValue) {
		} else if (ship.isFuelFull()) {
		} else {
			refuelButton.setText("Refuel (Cost = " + 0 + ")");
			person.myMoney = person.myMoney - fuelValue;
			ship.setFuel(ship.getFuelCapacity());
			fuelLabel.setText(Integer.toString(ship.getFuel()));
			money.setText("$" + person.myMoney);
			generatePlot();
		}
	}
}
