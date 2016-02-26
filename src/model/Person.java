package model;

import java.io.Serializable;

/**
 * This class keeps track of the information regarding the player, as well as
 * contains methods than enable all interactions that the player can have in the
 * game.
 *
 * @author Anugrah Vijay
 */

public class Person implements Serializable {

	protected String name;
	protected int[] skillDistribution;
	public int myMoney = 100000;
	public Ship myShip; // change ship constructor
	protected Planet planet;
	private int turn;
	public int damage = 5;
	public int shield = 0;

	public Person() {
		this(null, null);
	}

	public Person(final String name, final int[] skills) { // add Planet to
		// constructor
		this.name = name;
		skillDistribution = new int[5];
		skillDistribution = skills;
		myShip = new Flea();
	}

	@Override
	public final String toString() {
		return "Person Name: " + name + "\n" + "Skills\n" + "\tPilot: "
				+ skillDistribution[0] + "\n" + "\tFighter: "
				+ skillDistribution[1] + "\n" + "\tTrader: "
				+ skillDistribution[2] + "\n" + "\tEngineer: "
				+ skillDistribution[3] + "\n" + "\tInvestor: "
				+ skillDistribution[4] + "\n";
	}

	public final int[] getSkills() {
		return skillDistribution;
	}

	public final void setSkills(final int[] newSkills) {
		skillDistribution = newSkills;
	}

	public final void setPlanet(final Planet location) {
		planet = location;
	}

	public final int getTurn() {
		return turn;
	}

	public final void incrementTurn() {
		turn += 1;
	}

	public final Planet getPlanet() {
		return planet;
	}

	public final Ship getShip() {
		return myShip;
	}

	public final void setShip(final Ship newShip) {
		myShip = newShip;
	}

	public final String getName() {
		return name;
	}

	public final void buyFromTrader(final TradeGoods item, final Trader trader) {
		int index = 0;
		for (int i = 0; i < trader.ship.cargoBay.length; i++) {
			if (item.toString().equals(trader.ship.cargoBay[i].toString())) {
				index = i;
			}
		}
		int currentQuantity = trader.ship.cargoBay[index].quantity;
		trader.ship.cargoBay[index].setQuantity(currentQuantity - 1);
		trader.money += trader.sellingPrices[index];

		System.out.println(myMoney);
		myMoney -= trader.sellingPrices[index];
		System.out.println(index);
		System.out.println(trader.sellingPrices[index]);
		int shipQuantity = myShip.cargoBay[index].quantity;
		myShip.cargoBay[index].setQuantity(shipQuantity + 1);
		myShip.cargoBayCount++;
	}

	public final void sellToTrader(final TradeGoods item, final Trader trader) {
		int index = 0;
		for (int i = 0; i < trader.ship.cargoBay.length; i++) {
			if (item.toString().equals(trader.ship.cargoBay[i].toString())) {
				index = i;
			}
		}
		int currentQuantity = trader.ship.cargoBay[index].quantity;
		trader.ship.cargoBay[index].setQuantity(currentQuantity + 1);
		trader.money -= trader.buyingPrices[index];

		myMoney += trader.buyingPrices[index];
		int shipQuantity = myShip.cargoBay[index].quantity;
		myShip.cargoBay[index].setQuantity(shipQuantity - 1);
	}
}