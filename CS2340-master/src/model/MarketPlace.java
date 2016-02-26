/**
 * Players visit the marketplace to buy and sell goods. Prices vary by planet, government and current situation.
 * Players cannot buy more than will fit into their ship's cargo hold.
 * Players cannot sell more than they own in their cargo hold.
 * @author Chakshu Agarwal
 * @version 1.0 09/29/2014
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;

public class MarketPlace implements Serializable {

	private int level;
	private int specialGood;
	double priceModifier;
	private TradeGoods[] tradeGoodsList;
	private int[] sellingPrices = new int[10];
	private int[] buyingPrices = new int[10];

	// mercenaries
	private ArrayList<Mercenaries> mercenaries;

	/**
	 * Creates a default MarketPlace for each planet on initiation based on the
	 * planet's tech level. Calls upon on other helper methods to initiate the
	 * resources and set their prices.
	 *
	 * @param planet
	 *            's tech level
	 */
	public MarketPlace(final int techLevel) {
		level = techLevel;
		tradeGoodsList = new TradeGoods[10];
		tradeGoodsList[0] = new Water();
		tradeGoodsList[1] = new Furs();
		tradeGoodsList[2] = new Food();
		tradeGoodsList[3] = new Ore();
		tradeGoodsList[4] = new Games();
		tradeGoodsList[5] = new Firearms();
		tradeGoodsList[6] = new Medicine();
		tradeGoodsList[7] = new Machines();
		tradeGoodsList[8] = new Narcotics();
		tradeGoodsList[9] = new Robots();
		createGoods();
		setPrices();
		mercenaries = (new createMercenaries()).getMercenaries();
	}

	private void createGoods() {
		for (int n = 0; n < tradeGoodsList.length; n++) {
			if (tradeGoodsList[n].buy_from_market(level) > 0) {
				tradeGoodsList[n].quantity = tradeGoodsList[n]
						.changeQuantity(10);
			} else {
				tradeGoodsList[n].quantity = tradeGoodsList[n]
						.changeQuantity(0);
			}
		}
	}

	private void setPrices() {
		for (int i = 0; i < sellingPrices.length; i++) {
			sellingPrices[i] = tradeGoodsList[i].sell_to_market(level);
			buyingPrices[i] = tradeGoodsList[i].buy_from_market(level);
		}
	}

	public final void setResourcePrice(final int goodAffected,
			final double priceModifier) {
		if (goodAffected >= 0) {
			// System.out.println("The initial price for " +
			// tradeGoodsList[goodAffected].getName() + " is" +
			// sellingPrices[goodAffected]);
			int price = (int) (sellingPrices[goodAffected] * priceModifier);
			sellingPrices[goodAffected] = price;
			price = (int) (buyingPrices[goodAffected] * priceModifier);
			buyingPrices[goodAffected] = price;
			// System.out.println("The final price for " +
			// tradeGoodsList[goodAffected].getName() + " is" +
			// sellingPrices[goodAffected]);
		}
	}

	public final void toggleMercenaries() {
		mercenaries = (new createMercenaries()).getMercenaries();
	}

	public final ArrayList<Mercenaries> getMercenaries() {
		return mercenaries;
	}

	public final void updatePrice() {
		setPrices();
	}

	public final void setDrasticPrices(final int[] index) {
		if (index == null) {
		} else {
			for (int i = 0; i < index.length; i++) {
				int indexToChange = index[i];
				sellingPrices[indexToChange] = sellingPrices[indexToChange] * 5;
				buyingPrices[indexToChange] = buyingPrices[indexToChange] * 5;
			}
		}
	}

	public final void resetDrasticPrices(final int[] index) {
		if (index == null) {
		} else {
			for (int i = 0; i < index.length; i++) {
				int indexToChange = index[i];
				sellingPrices[indexToChange] = sellingPrices[indexToChange] / 5;
				buyingPrices[indexToChange] = buyingPrices[indexToChange] / 5;
			}
		}
	}

	/**
	 * returns the the planet's tech level
	 *
	 * @return planet's tech level
	 */
	public final int getTechLevel() {
		return level;
	}

	/**
	 * getter method for resources in the MarketPlace
	 *
	 * @return a list of TradeGoods in the MarketPlace
	 */
	public final TradeGoods[] getTradeGoodsList() {
		return tradeGoodsList;
	}

	/**
	 * getter method for selling price of each resource bought by the
	 * MarketPlace
	 *
	 * @return list of selling prices
	 */
	public final int[] getSellingPrices() {
		return sellingPrices;
	}

	/**
	 * getter method for buying price of each resource sold by the MarketPlace
	 *
	 * @return list of buying prices
	 */
	public final int[] getBuyingPrices() {
		return buyingPrices;
	}

	/**
	 * checks if a certain good requested by the player exists within the
	 * marketplace
	 *
	 * @return yes if it does exist in the marketplace and no otherwise
	 * @param requested
	 *            tradegood by the player
	 */
	public final boolean hasGood(final TradeGoods tradeGood) {
		return tradeGood.returnQuantity() > 0;
	}

	/**
	 * checks and returns the available quantity of requested good by the player
	 *
	 * @return quantity available at the marketplace
	 * @param requested
	 *            tradegood by the player
	 */
	public final int getQuantity(final TradeGoods tradeGood) {
		return tradeGood.returnQuantity();
	}

	/**
	 * Updates the MarketPlace to reflect on any changes/ trade between
	 * MarketPlace and Player
	 *
	 * @param tradegood
	 *            that was recently either bought or sold
	 * @param quantity
	 *            added or subtracted from the intial marketplace quantity of
	 *            that resource
	 */
	public final void updateMarketPlace(final TradeGoods tradeGood,
			final int quant) {
		tradeGood.changeQuantity(tradeGood.returnQuantity() + quant);
	}
}