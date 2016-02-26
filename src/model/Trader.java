package model;

import java.io.Serializable;
import java.util.Random;

/**
 * This class helps for other Traders that the player can interact with. The
 * Traders have trade goods which the player can buy. The player can also sell
 * his own trade goods to the trader. If willing, the player may attack and the
 * Trader and steal his cargo, although there is a risk of being attacked and
 * killed in doing so.
 *
 * @author Anugrah Vijay
 */
public class Trader extends Attackable implements Serializable {

	public int techLevel;
	public int[] buyingPrices = new int[10];
	public int[] sellingPrices = new int[10];
	public int money;

	// how to assign trade goods in ship
	// how to assign skills for trader

	public Trader() {
		super();
		ship = new Flea();
		techLevel = 0;
		createCargo();
		setBuyPrices();
		setSellPrices();
		setSkills();
		Random rand = new Random();
		money = rand.nextInt(5000 - 500 + 1) + 500;
	}

	public Trader(final int techLevel, final Ship ship) { // could have
		// techLevel and
		// Ship type.
		super();
		this.ship = ship;
		this.techLevel = techLevel;
		createCargo();
		setBuyPrices();
		setSellPrices();
		setSkills();
		Random rand = new Random();
		money = rand.nextInt(5000 - 500 + 1) + 500;
	}

	// method that determines how much of each item should be in the
	private void createCargo() {
		// at max cargoBayCapacity items
		// have a random num generator to decide how many items a trader has.
		// 5-10
		int maxItems = cargoHold();
		int currentItems = 0;
		int counter = 0;
		Random rand = new Random();
		int index = rand.nextInt(ship.cargoBay.length) % 10;

		// COULD CHANGE THIS: SEE THE DIFFERENCE BETWEEN THE TTP AND THE TRADER
		// TECH LEVEL. AND THE GREATER THE DIFFERENCE, THE
		// LESSER THE PROBABILITY OF THE TRADEGOOD BEING IN THE CARGO. (Think
		// upside down normal curve)
		while (counter < ship.cargoBay.length) {
			if (currentItems < maxItems) {
				// tech level which produces most of the item.
				int itemTechLevel = ship.cargoBay[index].TTP;
				if (Math.abs(itemTechLevel - techLevel) <= 4) {
					int numAdd = determineQuantity();
					ship.cargoBay[index].setQuantity(numAdd);
					currentItems += numAdd;
				}
			} else {
				ship.cargoBay[index].setQuantity(0);
			}
			index = (index + 1) % 10;
			counter++;
		}
	}

	// helper method for createCargo() method
	private int determineQuantity() {
		// return int between 0-3
		Random rand = new Random();
		int probability = rand.nextInt(101);
		if (probability >= 0 && probability < 10) {
			return 3;
		} else if (probability >= 10 && probability < 45) {
			return 2;
		} else {
			return 1;
		}
	}

	// Sets the buying prices. The buying prices are the int amounts that the
	// trader is willing to buy a tradegood for.
	private void setBuyPrices() {
		for (int i = 0; i < ship.cargoBay.length; i++) {

			Random rand = new Random();
			int TTP = ship.cargoBay[i].TTP;
			int MTLU = ship.cargoBay[i].MTLU;
			int maxTechDiff = Math.max(Math.abs(TTP - MTLU), Math.abs(TTP - 7));
			int techDiff = Math.abs(techLevel - TTP);

			double prob = techDiff / maxTechDiff;
			int luckFactor = rand.nextInt(16);
			int luck = rand.nextInt(2);

			int minSellPrice = ship.cargoBay[i].MTL;
			int maxSellPrice = ship.cargoBay[i].MTH;
			int price = minSellPrice
					+ (int) (prob * (maxSellPrice - minSellPrice));
			double bonus = (maxSellPrice - minSellPrice)
					* ((double) luckFactor / 100);

			if (luck == 1) {
				price = price + (int) bonus;
			} else {
				price = price - (int) bonus;
			}
			buyingPrices[i] = price;
		}
	}

	// Sets the selling prices. The selling prices are the int amounts that the
	// trader is willing to sell his items for.
	private void setSellPrices() {
		for (int i = 0; i < ship.cargoBay.length; i++) {

			Random rand = new Random();
			int TTP = ship.cargoBay[i].TTP;
			int maxTechDiff = Math.max(Math.abs(TTP - 0), Math.abs(TTP - 7));
			int techDiff = Math.abs(techLevel - TTP);

			double prob = techDiff / maxTechDiff;
			int luckFactor = rand.nextInt(16);
			int luck = rand.nextInt(2);

			int minSellPrice = ship.cargoBay[i].MTL;
			int maxSellPrice = ship.cargoBay[i].MTH;
			int price = minSellPrice
					+ (int) (prob * (maxSellPrice - minSellPrice));
			double bonus = (maxSellPrice - minSellPrice)
					* ((double) luckFactor / 100);

			if (luck == 1) { // if lucky then trader gives good deal or else bad
				// deal
				price = price - (int) bonus;
			} else {
				price = price + (int) bonus;
			}
			sellingPrices[i] = price;
		}
	}

	// Set skills that will be used in interactions: fighting// trading
	private void setSkills() {
		// max skill points = 100
		// skills depend on tech level

		// can have like a random chance of specialty being fighter // trader //
		// pilot // engineer
		// added feature ==> can have speacial weapons and other equipment and
		// merceneries.

		Random rand = new Random();
		int strong = rand.nextInt(6);
		int counter = 0;
		boolean[] strength = { false, false, false, false, false };
		int strongLow = techLevel * 12;
		int strongHigh = (techLevel + 1) * 12;
		int weakLow = (techLevel - 1) * 12;
		int weakHigh = techLevel * 12;

		// determines which abilities should be strong
		while (counter < strong) {
			int index = rand.nextInt(6);
			if (strength[index] != true) {
				strength[index] = true;
				counter++;
			}
		}

		// if techLevel is 0, the strong and weak range is same.
		if (techLevel == 0) {
			strongLow = techLevel * 12;
			strongHigh = (techLevel + 1) * 12;
			weakLow = strongLow;
			weakHigh = strongHigh;
		}

		for (int i = 0; i < skillDistribution.length; i++) {
			if (strength[i]) {
				skillDistribution[i] = rand.nextInt(strongHigh - strongLow + 1)
						+ strongLow;
			} else {
				skillDistribution[i] = rand.nextInt(weakHigh - weakLow + 1)
						+ weakLow;
			}
		}

		// now randomly choose what the trader will specialize in. and
		// accordingly promote that skill to the next level.

	}

	// NEED ADD TO CARGO AND REMOVE FROM CARGO METHODS

	// method that determines how many items a ship should hold in total.
	private int cargoHold() {
		int lowerBound = 0;
		if (ship.shipType.equalsIgnoreCase("Flea")) {
			lowerBound = 5;
		} else if (ship.shipType.equalsIgnoreCase("Gnat")) {
			lowerBound = 10;
		} else if (ship.shipType.equalsIgnoreCase("FireFly")) {
			lowerBound = 15;
		}
		Random rand = new Random();
		int capacity = rand.nextInt(ship.cargoBayCapacity - lowerBound + 1)
				+ lowerBound;
		return capacity;
	}
}
