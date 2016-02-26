package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import model.BumbleBee;
import model.Equipment;
import model.FireFly;
import model.Flea;
import model.Gadget;
import model.GameData;
import model.Gnat;
import model.Mosquito;
import model.Person;
import model.Planet;
import model.Shield;
import model.Ship;
import model.Weapon;
import model.savedGames;
import view.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * This class generates the shipyard screen of the game.
 *
 * @author Pratik Jain
 */

public class ShipyardPage implements Initializable {
	// instance variables
	private GameData d;
	private Person person;
	private ArrayList<Ship> ships;
	private ArrayList<Gadget> gadgets;
	private ArrayList<Shield> shields;
	private ArrayList<Weapon> weapons;
	private Equipment equipment;
	private Planet planet;
	private int currentView = 0;
	private int currentWeapon = 0;
	private int currentGadget = 0;
	private int currentShield = 0;
	private ImageView[] shipImages;
	private ImageView[] weaponImages;
	private ImageView[] gadgetImages;
	private ImageView[] shieldImages;

	// fxml status
	@FXML
	Label gadgetsLabel;
	@FXML
	Label shieldsLabel;
	@FXML
	Label weaponsLabel;

	// fxml Gadget objects
	@FXML
	Label gadgetName;
	@FXML
	Label gadgetCost;
	@FXML
	ProgressBar gadgetCostBar;
	@FXML
	Label gadgetDescription;

	// fxml Shield objects
	@FXML
	Label shieldName;
	@FXML
	Label shieldCost;
	@FXML
	ProgressBar shieldCostBar;
	@FXML
	Label shieldStrength;
	@FXML
	ProgressBar shieldStrengthBar;

	// fxml weapon objects
	@FXML
	Label weaponName;
	@FXML
	Label weaponCost;
	@FXML
	ProgressBar weaponCostBar;
	@FXML
	Label weaponStrength;
	@FXML
	ProgressBar weaponStrengthBar;

	// fxml Anchor Panes
	@FXML
	AnchorPane shipsPane;
	@FXML
	AnchorPane weaponsPane;
	@FXML
	AnchorPane shieldsPane;
	@FXML
	AnchorPane gadgetsPane;

	// fxml objects on menuBar
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

	// progress bars
	@FXML
	ProgressBar cargoBayCapacity;
	@FXML
	ProgressBar weaponsSlot;
	@FXML
	ProgressBar shieldSlot;
	@FXML
	ProgressBar gadgetSlot;
	@FXML
	ProgressBar crewCapacity;
	@FXML
	ProgressBar fuelCapacity;
	@FXML
	ProgressBar refuelCost;
	@FXML
	ProgressBar hullStrength;

	// Labels
	@FXML
	Label cargoBayLabel;
	@FXML
	Label weaponsSlotLabel;
	@FXML
	Label shieldSlotLabel;
	@FXML
	Label gadgetSlotLabel;
	@FXML
	Label crewCapacityLabel;
	@FXML
	Label fuelRangeLabel;
	@FXML
	Label fuelPriceLabel;
	@FXML
	Label hullStrengthLabel;
	@FXML
	Label cargo1;
	@FXML
	Label cargo2;
	@FXML
	Label weapon1;
	@FXML
	Label weapon2;
	@FXML
	Label shield1;
	@FXML
	Label shield2;
	@FXML
	Label gadget1;
	@FXML
	Label gadget2;
	@FXML
	Label crew1;
	@FXML
	Label crew2;
	@FXML
	Label fuel1;
	@FXML
	Label fuel2;
	@FXML
	Label fuelPrice1;
	@FXML
	Label fuelPrice2;
	@FXML
	Label hull1;
	@FXML
	Label hull2;
	@FXML
	Label unavailable;
	@FXML
	Pane labelPane;

	// max values
	private double maxCargo = 24;
	private double maxWeapons = 2;
	private double maxShields = 2;
	private double maxGadgets = 2;
	private double maxCrew = 2;
	private double maxFuel = 20;
	private double maxFuelCost = 7;
	private double maxHullStrength = 100;

	// ship images
	@FXML
	ImageView ship1;
	@FXML
	ImageView ship2;
	@FXML
	ImageView ship3;
	@FXML
	ImageView ship4;
	@FXML
	ImageView ship5;

	@FXML
	ImageView rightArrow;
	@FXML
	ImageView leftArrow;

	// gadget images
	@FXML
	ImageView g1;
	@FXML
	ImageView g2;
	@FXML
	ImageView g3;
	@FXML
	ImageView g4;

	@FXML
	ImageView rightArrow1;
	@FXML
	ImageView leftArrow1;

	// shield images
	@FXML
	ImageView s1;
	@FXML
	ImageView s2;
	@FXML
	ImageView s3;

	@FXML
	ImageView rightArrow11;
	@FXML
	ImageView leftArrow11;

	// weapon images
	@FXML
	ImageView w1;
	@FXML
	ImageView w2;
	@FXML
	ImageView w3;

	@FXML
	ImageView rightArrow12;
	@FXML
	ImageView leftArrow12;

	@FXML
	Label alreadyOwned;
	@FXML
	Label price;
	@FXML
	Label noWeapons;
	@FXML
	Label noGadgets;
	@FXML
	Label noShields;

	@FXML
	Button buyButton;

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
		planet = person.getPlanet();
		equipment = new Equipment(person.getPlanet().getTechLevel());
		menuBarLabels();
		shipArray();
		crewUpdate();
		weaponArray(equipment);
		gadgetArray(equipment);
		shieldArray(equipment);
		updateArrows("ship");
		updateArrows("gadget");

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

	private void shipLabels(final int index) {
		cargo1.setText("" + ships.get(index).getCargoBayCapacity());
		weapon1.setText("" + ships.get(index).getWeaponCapacity());
		shield1.setText("" + ships.get(index).getShieldCapacity());
		gadget1.setText("" + ships.get(index).getGadgetCapacity());
		crew1.setText("" + ships.get(index).getCrewCapacity());
		fuel1.setText("" + ships.get(index).getFuelCapacity());
		fuelPrice1.setText("" + ships.get(index).getFuelCost());
		hull1.setText("" + ships.get(index).getMaxHullStrength());
	}

	private void shipArray() {
		ship1.setVisible(false);
		ship2.setVisible(false);
		ship3.setVisible(false);
		ship4.setVisible(false);
		ship5.setVisible(false);
		ships = new ArrayList<>(5);
		if (planet.getTechLevel() >= 5) {
			// setup array here
			ships.add(new Flea());
			ships.add(new Gnat());
			ships.add(new FireFly());
			ships.add(new Mosquito());
			ships.add(new BumbleBee());
			shipImages = new ImageView[] { ship1, ship2, ship3, ship4, ship5 };
			// System.out.println("The length is :" + shipImages.length);

			// TO DO
			shipImages[currentView].setVisible(true);
			// updateArrows("ship");
			shipLabels(currentView);
			shipInfo(currentView);
			labelInfo(currentView);
			unavailable.setVisible(false);
		} else {
			// leftArrow.setVisible(false);
			// rightArrow.setVisible(false);
			// cargoBayCapacity.setVisible(false);
			// weaponsSlot.setVisible(false);
			// shieldSlot.setVisible(false);
			// gadgetSlot.setVisible(false);
			// crewCapacity.setVisible(false);
			// fuelCapacity.setVisible(false);
			// refuelCost.setVisible(false);
			// hullStrength.setVisible(false);
			// price.setVisible(false);
			// alreadyOwned.setVisible(false);
			// labelPane.setVisible(false);
			// cargoBayLabel.setVisible(false);
			// weaponsSlotLabel.setVisible(false);
			// shieldSlotLabel.setVisible(false);
			// gadgetSlotLabel.setVisible(false);
			// crewCapacityLabel.setVisible(false);
			// fuelRangeLabel.setVisible(false);
			// fuelPriceLabel.setVisible(false);
			// hullStrengthLabel.setVisible(false);
			shipsPane.setVisible(false);
			weaponsPane.setVisible(false);
			shieldsPane.setVisible(false);
			gadgetsPane.setVisible(false);
			buyButton.setVisible(false);
			unavailable.setVisible(true);
		}
	}

	private void shipInfo(final int index) {
		cargoBayCapacity.setProgress(ships.get(index).getCargoBayCapacity()
				/ maxCargo);
		weaponsSlot.setProgress(ships.get(index).getWeaponCapacity()
				/ maxWeapons);
		shieldSlot.setProgress(ships.get(index).getShieldCapacity()
				/ maxShields);
		gadgetSlot.setProgress(ships.get(index).getGadgetCapacity()
				/ maxGadgets);
		crewCapacity.setProgress(ships.get(index).getCrewCapacity() / maxCrew);
		fuelCapacity.setProgress(ships.get(index).getFuelCapacity() / maxFuel);
		refuelCost.setProgress(ships.get(index).getFuelCost() / maxFuelCost);
		hullStrength.setProgress(ships.get(index).getMaxHullStrength()
				/ maxHullStrength);

		price.setText("Price: $" + ships.get(index).getPrice());
	}

	private void labelInfo(final int index) {
		alreadyOwned.setVisible(true);
		alreadyOwned.setText("");
		if (person.getShip().getShipType()
				.equals(ships.get(index).getShipType())) {
			alreadyOwned.setText("Already Owned");
		} else {
			if (person.myMoney < ships.get(index).getPrice()) {
				alreadyOwned.setText("Not Enough Money");
			} else {

				if (person.getShip().getCargoBayCount() > ships.get(index)
						.getCargoBayCapacity()) {
					alreadyOwned.setText("Empty Some Goods");
					if (alreadyOwned.getText().equals("")) {
						alreadyOwned.setText("Too Many Crew");
					} else {
						alreadyOwned.setText(alreadyOwned.getText() + "\n"
								+ "Too Many Crew");
					}
				} else if (person.getShip().getCrewCount() > ships.get(index)
						.getCrewCapacity()) {
					if (alreadyOwned.getText().equals("")) {
						alreadyOwned.setText("Too Many Crew");
					} else {
						alreadyOwned.setText(alreadyOwned.getText() + "\n"
								+ "Too Many Crew");
					}
				} else {
					alreadyOwned.setVisible(false);
				}
			}
		}
	}

	private void updateArrows(final String tab) {
		leftArrow.setVisible(false);
		// rightArrow.setVisible(false);
		leftArrow1.setVisible(false);
		// rightArrow1.setVisible(false);
		leftArrow11.setVisible(false);
		// rightArrow11.setVisible(false);
		leftArrow12.setVisible(false);
		// rightArrow12.setVisible(false);
		// System.out.println("OUTSIDE");

		// to keep the console happy:
		if (planet.getTechLevel() >= 5) {
			if (currentView > 0) {
				leftArrow.setVisible(true);
			}
			if (currentWeapon > 0) {
				leftArrow12.setVisible(true);
			}
			if (currentGadget > 0) {
				leftArrow1.setVisible(true);
			}
			if (currentShield > 0) {
				leftArrow11.setVisible(true);
			}
			if (currentView == ships.size() - 1) {
				rightArrow.setVisible(false);
			}
			if (currentWeapon == weapons.size() - 1) {
				rightArrow12.setVisible(false);
			}
			if (currentGadget == gadgets.size() - 1) {
				rightArrow1.setVisible(false);
			}
			if (currentShield == shields.size() - 1) {
				rightArrow11.setVisible(false);
			}
			if (tab.equals("ship")) {
				if (currentView < (ships.size() - 1)) {
					rightArrow.setVisible(true);
				}
			}
			if (tab.equals("weapon")) {
				// System.out.println("entered Outside!");
				// System.out.println(current weepon);
				// System.out.println(equipment.getWeapons().size());
				// System.out.println(equipment.techLevel);
				if (currentWeapon < weapons.size() - 1) {
					// System.out.println("enetered!");
					rightArrow12.setVisible(true);
				}
			}
			if (tab.equals("shield")) {
				if (currentShield < shields.size() - 1) {
					rightArrow11.setVisible(true);
				}
			}
			if (tab.equals("gadget")) {
				// System.out.println(currentGadget);
				// System.out.println(equipment.getGadgets().size());
				// System.out.println(equipment.techLevel);
				if (currentGadget < gadgets.size() - 1) {
					// System.out.println("ARROW SHOULD BE VISIBLE");
					rightArrow1.setVisible(true);
				}
			}
		}
	}

	@FXML
	public final void moveShipRight() {
		moveRight("ship");
	}

	@FXML
	public final void moveShipLeft() {
		moveLeft("ship");
	}

	@FXML
	public final void moveWeaponRight() {
		moveRight("weapon");
	}

	@FXML
	public final void moveWeaponLeft() {
		moveLeft("weapon");
	}

	@FXML
	public final void moveGadgetRight() {
		moveRight("gadget");
	}

	@FXML
	public final void moveGadgetLeft() {
		moveLeft("gadget");
	}

	@FXML
	public final void moveShieldRight() {
		moveRight("shield");
	}

	@FXML
	public final void moveShieldLeft() {
		moveLeft("shield");
	}

	public final void moveRight(final String tab) {
		if (tab.equals("ship")) {
			shipImages[currentView].setVisible(false);
			currentView++;
			shipInfo(currentView);
			shipLabels(currentView);
			labelInfo(currentView);
			shipImages[currentView].setVisible(true);
			updateArrows("ship");
		} else if (tab.equals("weapon")) {
			weaponImages[currentWeapon].setVisible(false);
			currentWeapon++;
			weaponInfo(currentWeapon);
			weaponImages[currentWeapon].setVisible(true);
			updateArrows("weapon");
		} else if (tab.equals("gadget")) {
			gadgetImages[currentGadget].setVisible(false);
			currentGadget++;
			gadgetInfo(currentGadget);
			gadgetImages[currentGadget].setVisible(true);
			updateArrows("gadget");
		} else if (tab.equals("shield")) {
			shieldImages[currentShield].setVisible(false);
			currentShield++;
			shieldInfo(currentShield);
			shieldImages[currentShield].setVisible(true);
			updateArrows("shield");
		}
	}

	public final void moveLeft(final String tab) {
		if (tab.equals("ship")) {
			shipImages[currentView].setVisible(false);
			currentView--;
			shipInfo(currentView);
			labelInfo(currentView);
			shipLabels(currentView);
			shipImages[currentView].setVisible(true);
			updateArrows("ship");
		} else if (tab.equals("weapon")) {
			weaponImages[currentWeapon].setVisible(false);
			currentWeapon--;
			weaponInfo(currentWeapon);
			weaponImages[currentWeapon].setVisible(true);
			updateArrows("weapon");
		} else if (tab.equals("gadget")) {
			gadgetImages[currentGadget].setVisible(false);
			currentGadget--;
			gadgetInfo(currentGadget);
			gadgetImages[currentGadget].setVisible(true);
			updateArrows("gadget");
		} else if (tab.equals("shield")) {
			shieldImages[currentShield].setVisible(false);
			currentShield--;
			shieldInfo(currentShield);
			shieldImages[currentShield].setVisible(true);
			updateArrows("shield");
		}
	}

	public final void buy() {
		// check if its the same ship
		if (!person.getShip().getShipType()
				.equals(ships.get(currentView).getShipType())) {
			// check if you have enough money
			if (person.myMoney > ships.get(currentView).getPrice()) {
				// check if you have more goods than the new ship can hold
				if (person.getShip().getCargoBayCount() < ships
						.get(currentView).getCargoBayCapacity()) {
					// check if you have more crew than the new ship can hold
					if (person.getShip().getCrewCount() < ships
							.get(currentView).getCrewCapacity()) {
						person.myMoney = person.myMoney
								- ships.get(currentView).getPrice();
						Ship newShip = ships.get(currentView);
						// update cargoBay
						if (person.getShip().getCargoBayCount() > 0) {
							newShip.setTradeGoods(person.getShip()
									.getCargoBay());
							newShip.setCargoBayCount(person.getShip()
									.getCargoBayCount());
						}
						// update crew
						if (person.getShip().getCrewCount() > 0) {
							newShip.addMercenary(person.getShip()
									.getMercenary());
						}
						person.setShip(newShip);
						Main.setScene("Game.fxml");
					}
				}
			}
		}
	}

	private void weaponArray(final Equipment equipment) {
		w1.setVisible(false);
		w2.setVisible(false);
		w3.setVisible(false);
		weapons = equipment.getWeapons();
		if (planet.getTechLevel() == 5) {
			weaponImages = new ImageView[] { w1 };
		} else if (planet.getTechLevel() == 6) {
			weaponImages = new ImageView[] { w1, w2 };
		} else if (planet.getTechLevel() == 7) {
			weaponImages = new ImageView[] { w1, w2, w3 };
		}
		if (planet.getTechLevel() >= 5) {
			noWeapons.setVisible(false);
			weaponImages[currentWeapon].setVisible(true);
			weaponInfo(currentWeapon);
			// updateArrows("gadget");
		}
	}

	private void weaponInfo(final int index) {
		weaponImages[currentWeapon].setVisible(true);
		weaponName.setText("Name: " + weapons.get(index).getName());
		weaponCost.setText("$" + weapons.get(index).getCost());
		weaponCostBar.setProgress((double) weapons.get(index).getCost()
				/ weapons.get(index).getMaxCost());
		weaponStrength.setText("" + weapons.get(index).getStrength());
		weaponStrengthBar.setProgress((double) weapons.get(index).getStrength()
				/ weapons.get(index).getMaxStrength());
		System.out.println("The weapon capacity is: "
				+ person.getShip().getWeaponCapacity());
		System.out.println("The weapon count is: "
				+ person.getShip().getWeaponCount());
		weaponsLabel.setText(""
				+ (person.getShip().getWeaponCapacity() - person.getShip()
						.getWeaponCount()));
	}

	private void gadgetArray(final Equipment equipment) {
		g1.setVisible(false);
		g2.setVisible(false);
		g3.setVisible(false);
		g4.setVisible(false);
		gadgets = equipment.getGadgets();
		if (planet.getTechLevel() == 5) {
			gadgetImages = new ImageView[] { g1 };
		} else if (planet.getTechLevel() == 6) {
			gadgetImages = new ImageView[] { g1, g2 };
		} else if (planet.getTechLevel() == 7) {
			gadgetImages = new ImageView[] { g1, g2, g3, g4 };
		}
		if (planet.getTechLevel() >= 5) {
			noGadgets.setVisible(false);
			gadgetImages[currentGadget].setVisible(true);
			gadgetInfo(currentGadget);
			// updateArrows("gadget");
		}
	}

	private void gadgetInfo(final int index) {
		gadgetImages[currentGadget].setVisible(true);
		gadgetName.setText("Name: " + gadgets.get(index).getName());
		gadgetCost.setText("$" + gadgets.get(index).getCost());
		gadgetCostBar.setProgress((double) gadgets.get(index).getCost()
				/ gadgets.get(index).getMaxCost());
		gadgetDescription.setText(gadgets.get(index).getDescription());
		gadgetsLabel.setText(""
				+ (person.getShip().getGadgetCapacity() - person.getShip()
						.getGadgetCount()));
	}

	private void shieldArray(final Equipment equipment) {
		s1.setVisible(false);
		s2.setVisible(false);
		s3.setVisible(false);
		shields = equipment.getShields();
		if (planet.getTechLevel() == 5) {
			shieldImages = new ImageView[] { s1 };
		} else if (planet.getTechLevel() == 6) {
			shieldImages = new ImageView[] { s1, s2 };
		} else if (planet.getTechLevel() == 7) {
			shieldImages = new ImageView[] { s1, s2, s3 };
		}
		if (planet.getTechLevel() >= 5) {
			noShields.setVisible(false);
			shieldImages[currentShield].setVisible(true);
			shieldInfo(currentShield);
			// updateArrows("gadget");
		}
	}

	private void shieldInfo(final int index) {
		shieldImages[currentShield].setVisible(true);
		shieldName.setText("Name: " + shields.get(index).getName());
		shieldCost.setText("$" + shields.get(index).getCost());
		shieldCostBar.setProgress((double) shields.get(index).getCost()
				/ shields.get(index).getMaxCost());
		shieldStrength.setText("" + shields.get(index).getStrength());
		shieldStrengthBar.setProgress((double) shields.get(index).getStrength()
				/ shields.get(index).getMaxStrength());
		shieldsLabel.setText(""
				+ (person.getShip().getShieldCapacity() - person.getShip()
						.getShieldCount()));
	}

	public final void buyGadget() {
		if (person.getShip().getGadgetCount() < person.getShip()
				.getGadgetCapacity()) {
			if (person.myMoney > gadgets.get(currentGadget).getCost()) {
				person.getShip().addGadget(gadgets.get(currentGadget));
				person.myMoney = person.myMoney
						- gadgets.get(currentGadget).getCost();
				money.setText("$" + person.myMoney);
				gadgetInfo(currentGadget);
			}
		}
	}

	public final void buyShield() {
		if (person.getShip().getShieldCount() < person.getShip()
				.getShieldCapacity()) {
			if (person.myMoney > shields.get(currentShield).getCost()) {
				person.getShip().addShield(shields.get(currentShield));
				person.myMoney = person.myMoney
						- shields.get(currentShield).getCost();
				money.setText("$" + person.myMoney);
				shieldInfo(currentShield);
			}
		}
	}

	public final void buyWeapon() {
		if (person.getShip().getWeaponCount() < person.getShip()
				.getWeaponCapacity()) {
			if (person.myMoney > weapons.get(currentWeapon).getCost()) {
				person.getShip().addWeapon(weapons.get(currentWeapon));
				person.myMoney = person.myMoney
						- weapons.get(currentWeapon).getCost();
				money.setText("$" + person.myMoney);
				weaponInfo(currentWeapon);
			}
		}
	}

	public final void goToMarketPlace() {
		Main.setScene("MarketPlace.fxml");
	}

	public final void returnToMainScreen() {
		Main.setScene("../view/Game.fxml");
	}

	public final void save() {
		savedGames saveNewGame = new savedGames();
		saveNewGame.writeToFile();
		Main.setScene("welcomeScreen.fxml");
	}
}
