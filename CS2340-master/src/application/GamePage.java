package application;

import java.net.URL;
//import model.Planet;
import java.util.ResourceBundle;

import view.Main;
import model.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
//import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import model.Person;

/**
 * This class generates the welcome screen or the game screen after player
 * configuration. The player can access the Marketplace through this screen.
 *
 * @author Utkarsh Garg
 */

public class GamePage implements Initializable {

	private GameData d;
	private Person person;

	@FXML
	Label locationLabel;
	@FXML
	Label fuelLabel;
	@FXML
	AnchorPane anchor;
	@FXML
	Label playerName;
	@FXML
	Label money;
	@FXML
	Label cargoBayStatus;
	@FXML
	Label playerTurn;
	@FXML
	Label techLabel;
	@FXML
	Label resourceLabel;
	@FXML
	Label resourceLabel1;
	@FXML
	Label drasticEventLabel;
	@FXML
	ImageView activePerson1;
	@FXML
	ImageView inactivePerson1;
	@FXML
	ImageView activePerson2;
	@FXML
	ImageView inactivePerson2;

	/**
	 * This method initializes the values of variables on the GamePage
	 *
	 * @param location
	 * @param resources
	 */
	@Override
	public final void initialize(final URL location,
			final ResourceBundle resources) {
		d = GameData.getData();
		person = d.getPerson();
		// person.getPlanet().getMarketPlace().updatePrice();
		menuBarLabels();
		initLabels();
		crewUpdate();
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

	private void initLabels() {
		locationLabel.setText("Welcome to "
				+ person.getPlanet().getName().toString());
		techLabel.setText("Tech Level: "
				+ person.getPlanet().getTechLevelString());
		if (person.getPlanet().getPriceModifier() > 1) {
			resourceLabel1.setText("The price of "
					+ person.getPlanet().getSpecialGoodName()
					+ " is higher than usual");
		} else if (person.getPlanet().getPriceModifier() < 1) {
			resourceLabel1.setText("The price of "
					+ person.getPlanet().getSpecialGoodName()
					+ " is lower than usual");
		} else {
			resourceLabel1.setText("All prices are fairly normal");
		}
		resourceLabel.setText("Abundant Resource: "
				+ person.getPlanet().getResourceName());
		drasticEventLabel.setText(person.getPlanet().getDrasticEventMessage());
	}

	private void menuBarLabels() {
		playerName.setText("Welcome " + person.getName() + "!");
		money.setText("$" + person.myMoney);
		cargoBayStatus.setText("" + person.getShip().getCargoBayCount() + "/"
				+ person.getShip().getCargoBayCapacity());
		fuelLabel.setText("" + person.getShip().getFuel());
		playerTurn.setText("" + person.getTurn());
	}

	/**
	 * this method saves the current state of the game on file.
	 */
	public final void save() {
		savedGames saveNewGame = new savedGames();
		saveNewGame.writeToFile();
		Main.setScene("welcomeScreen.fxml");
	}

	/**
	 * this method makes a call to the travel page.
	 */
	@FXML
	public final void goToTravelPage() {
		Main.setScene("TravelPage.fxml");
	}

	/**
	 * This method makes a call to the ship yard page.
	 */
	@FXML
	public final void goToShipYard() {
		Main.setScene("ShipyardPage.fxml");
	}

	/**
	 * This method makes a call to the marketplace page.
	 */
	@FXML
	public final void enterMarketPlace() {
		Main.setScene("MarketPlace.fxml");
	}
}
