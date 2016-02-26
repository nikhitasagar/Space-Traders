package application;

import java.net.URL;
import java.util.ResourceBundle;

import view.Main;
import model.*;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;
import javafx.util.Duration;

/**
 * This class generates the marketplace screen which has all market items and
 * ship items along with their quantities and prices. This class also provides
 * the capability to buy and sell objects to and from the marketplace. It also
 * allows the user to navigate to the equipment page and the shipyard.
 *
 * @author Pratik Jain
 */

public class MarketPlaceController implements Initializable {

	// Buy button
	@FXML
	Button buy0;
	@FXML
	Button buy1;
	@FXML
	Button buy2;
	@FXML
	Button buy3;
	@FXML
	Button buy4;
	@FXML
	Button buy5;
	@FXML
	Button buy6;
	@FXML
	Button buy7;
	@FXML
	Button buy8;
	@FXML
	Button buy9;

	// Market Buy Prices
	@FXML
	Label price0;
	@FXML
	Label price1;
	@FXML
	Label price2;
	@FXML
	Label price3;
	@FXML
	Label price4;
	@FXML
	Label price5;
	@FXML
	Label price6;
	@FXML
	Label price7;
	@FXML
	Label price8;
	@FXML
	Label price9;

	// Market Sell Prices
	@FXML
	Label price10;
	@FXML
	Label price11;
	@FXML
	Label price12;
	@FXML
	Label price13;
	@FXML
	Label price14;
	@FXML
	Label price15;
	@FXML
	Label price16;
	@FXML
	Label price17;
	@FXML
	Label price18;
	@FXML
	Label price19;

	// Sell button
	@FXML
	Button sell0;
	@FXML
	Button sell1;
	@FXML
	Button sell2;
	@FXML
	Button sell3;
	@FXML
	Button sell4;
	@FXML
	Button sell5;
	@FXML
	Button sell6;
	@FXML
	Button sell7;
	@FXML
	Button sell8;
	@FXML
	Button sell9;

	// Ship Quantities
	@FXML
	Label items0;
	@FXML
	Label items1;
	@FXML
	Label items2;
	@FXML
	Label items3;
	@FXML
	Label items4;
	@FXML
	Label items5;
	@FXML
	Label items6;
	@FXML
	Label items7;
	@FXML
	Label items8;
	@FXML
	Label items9;

	// Player Info
	@FXML
	Label playerName;
	@FXML
	Label money;
	@FXML
	Label cargoBayStatus;
	@FXML
	Label fuelLabel;
	@FXML
	Label playerTurn;

	// arrow
	@FXML
	ImageView greenArrow0;
	@FXML
	ImageView greenArrow1;
	@FXML
	ImageView greenArrow2;
	@FXML
	ImageView greenArrow3;
	@FXML
	ImageView greenArrow4;
	@FXML
	ImageView greenArrow5;
	@FXML
	ImageView greenArrow6;
	@FXML
	ImageView greenArrow7;
	@FXML
	ImageView greenArrow8;
	@FXML
	ImageView greenArrow9;

	@FXML
	ImageView redArrow0;
	@FXML
	ImageView redArrow1;
	@FXML
	ImageView redArrow2;
	@FXML
	ImageView redArrow3;
	@FXML
	ImageView redArrow4;
	@FXML
	ImageView redArrow5;
	@FXML
	ImageView redArrow6;
	@FXML
	ImageView redArrow7;
	@FXML
	ImageView redArrow8;
	@FXML
	ImageView redArrow9;

	@FXML
	Button buyMercenaries;

	@FXML
	ImageView activePerson1;
	@FXML
	ImageView inactivePerson1;
	@FXML
	ImageView activePerson2;
	@FXML
	ImageView inactivePerson2;

	// instance
	private GameData d;
	private Person person;
	private MarketPlace market;
	private Ship ship;
	private TradeGoods[] shipCargoBay;

	// buying and selling prices
	private int[] buyingPrices;
	private int[] sellingPrices;

	// arrays of Buttons and Labels
	private Button[] buyButtons;
	private Label[] prices;
	private Label[] prices2;
	private Button[] sellButtons;
	private Label[] shipQuantity;
	private ImageView[] greenArrows;
	private ImageView[] redArrows;

	private AudioClip laserShot;

	/**
	 * This method initializes the values for the market place. i.e prices and
	 * number of goods
	 *
	 * @param location
	 * @param resource
	 */
	@Override
	public final void initialize(final URL location,
			final ResourceBundle resource) {
		d = GameData.getData();
		person = d.getPerson();
		market = person.getPlanet().getMarketPlace();
		ship = person.getShip();
		shipCargoBay = ship.getCargoBay();
		laserShot = new AudioClip(MarketPlaceController.class.getResource(
				"laser_shot.mp3").toString());
		menuBarUpdate();
		getPrices();
		initButtons();
		initLabels();
		initImages();
		mercenaryButton();
		crewUpdate();
	}

	private void menuBarUpdate() {
		playerName.setText("Welcome " + person.getName() + "!");
		money.setText("$" + person.myMoney);
		cargoBayStatus.setText(ship.getCargoBayCount() + "/"
				+ ship.getCargoBayCapacity());
		fuelLabel.setText("" + ship.getFuel());
		playerTurn.setText("" + person.getTurn());
	}

	private void getPrices() {
		buyingPrices = market.getBuyingPrices();
		sellingPrices = market.getSellingPrices();
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

	private void initButtons() {
		buyButtons = new Button[] { buy0, buy1, buy2, buy3, buy4, buy5, buy6,
				buy7, buy8, buy9 };
		sellButtons = new Button[] { sell0, sell1, sell2, sell3, sell4, sell5,
				sell6, sell7, sell8, sell9 };
		for (int i = 0; i < buyButtons.length; i++) {
			// for buy button
			if (buyingPrices[i] == 0) {
				buyButtons[i].setDisable(true);
				buyButtons[i].setStyle("-fx-background-color: grey");
			}
			if (sellingPrices[i] == 0) {
				sellButtons[i].setDisable(true);
				sellButtons[i].setStyle("-fx-background-color: grey");
			}
			if (shipCargoBay[i].returnQuantity() == 0) {
				sellButtons[i].setStyle("-fx-background-color: grey");
			}
		}
	}

	private void initLabels() {
		prices = new Label[] { price0, price1, price2, price3, price4, price5,
				price6, price7, price8, price9 };
		prices2 = new Label[] { price10, price11, price12, price13, price14,
				price15, price16, price17, price18, price19 };
		shipQuantity = new Label[] { items0, items1, items2, items3, items4,
				items5, items6, items7, items8, items9 };
		for (int i = 0; i < prices.length; i++) {
			prices[i].setText("$" + buyingPrices[i]);
			prices2[i].setText("$" + sellingPrices[i]);
			shipQuantity[i].setText("" + shipCargoBay[i].returnQuantity());
		}
		// priceIncrease();
	}

	private void initImages() {
		greenArrows = new ImageView[] { greenArrow0, greenArrow1, greenArrow2,
				greenArrow3, greenArrow4, greenArrow5, greenArrow6,
				greenArrow7, greenArrow8, greenArrow9 };
		redArrows = new ImageView[] { redArrow0, redArrow1, redArrow2,
				redArrow3, redArrow4, redArrow5, redArrow6, redArrow7,
				redArrow8, redArrow9 };
		for (int i = 0; i < greenArrows.length; i++) {
			greenArrows[i].setVisible(false);
			redArrows[i].setVisible(false);
		}
		if (person.getPlanet().getPriceModifier() < 1) {
			// System.out.println("The special Good is " +
			// person.getPlanet().getSpecialGood());
			greenArrows[person.getPlanet().getSpecialGood()].setVisible(true);
		} else if (person.getPlanet().getPriceModifier() > 1) {
			redArrows[person.getPlanet().getSpecialGood()].setVisible(true);
		}
		// change the arrows for drasticEvents
		int[] index = person.getPlanet().getDrasticEvent();
		if (index == null) {
		} else {
			for (int i = 0; i < index.length; i++) {
				int value = index[i];
				redArrows[value].setVisible(true);
			}
		}

	}

	private void mercenaryButton() {
		if (market.getMercenaries() == null
				|| market.getMercenaries().size() == 0) {
			buyMercenaries.setVisible(false);
		} else {
			FadeTransition f = new FadeTransition(Duration.millis(500),
					buyMercenaries);
			f.setFromValue(1.0);
			f.setToValue(0.3);
			f.setCycleCount(Animation.INDEFINITE);
			f.setAutoReverse(true);
			f.play();
		}
	}

	private void genericBuy(final int index) {
		laserShot.play();
		if (ship.hasCargoBaySpace() && person.myMoney >= buyingPrices[index]) {
			ship.addTradeGood(index);
			person.myMoney -= buyingPrices[index];
			updateLabels(index);
			// makes sure that we can sell what we just bought
			sellButtons[index].setStyle("-fx-background-color: #480000");
		}
	}

	public final void genericSell(final int index) {
		laserShot.play();
		if (shipCargoBay[index].returnQuantity() > 0) {
			ship.removeTradeGood(index);
			person.myMoney += sellingPrices[index];
			updateLabels(index);
			if (shipCargoBay[index].returnQuantity() == 0) {
				sellButtons[index].setStyle("-fx-background-color: grey");
			}
		}
	}

	private void updateLabels(final int index) {
		// update money
		money.setText("" + person.myMoney);
		// update quantity on ship
		cargoBayStatus.setText(ship.getCargoBayCount() + "/"
				+ ship.getCargoBayCapacity());
		shipQuantity[index].setText("" + shipCargoBay[index].returnQuantity());
	}

	/**
	 * This method starts the buy water output
	 */
	@FXML
	public final void buyWater() {
		genericBuy(0);
	}

	/**
	 * This method starts the buy water output
	 */
	@FXML
	public final void sellWater() {
		genericSell(0);
	}

	@FXML
	public final void buyFurs() {
		genericBuy(1);
	}

	@FXML
	public final void sellFurs() {
		genericSell(1);
	}

	@FXML
	public final void buyFood() {
		genericBuy(2);
	}

	@FXML
	public final void sellFood() {
		genericSell(2);
	}

	@FXML
	public final void buyOre() {
		genericBuy(3);
	}

	@FXML
	public final void sellOre() {
		genericSell(3);
	}

	@FXML
	public final void buyGames() {
		genericBuy(4);
	}

	@FXML
	public final void sellGames() {
		genericSell(4);
	}

	@FXML
	public final void buyFireArms() {
		genericBuy(5);
	}

	@FXML
	public final void sellFireArms() {
		genericSell(5);
	}

	@FXML
	public final void buyMedicine() {
		genericBuy(6);
	}

	@FXML
	public final void sellMedicine() {
		genericSell(6);
	}

	@FXML
	public final void buyMachines() {
		genericBuy(7);
	}

	@FXML
	public final void sellMachines() {
		genericSell(7);
	}

	@FXML
	public final void buyNarcotics() {
		genericBuy(8);
	}

	@FXML
	public final void sellNarcotics() {
		genericSell(8);
	}

	@FXML
	public final void buyRobots() {
		genericBuy(9);
	}

	@FXML
	public final void sellRobots() {
		genericSell(9);
	}

	@FXML
	public final void returnToMainScreen() {
		Main.setScene("../view/Game.fxml");
	}

	@FXML
	public final void buyMercenaries() {
		Main.setScene("../view/MercenaryPage.fxml");
	}

	@FXML
	public final void save() {
		savedGames saveNewGame = new savedGames();
		saveNewGame.writeToFile();
		Main.setScene("welcomeScreen.fxml");
	}
}
