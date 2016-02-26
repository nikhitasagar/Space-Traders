/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Random;

/**
 * This class is for the pirates encountered while traveling
 * 
 * @author nikhitasagar
 */
public class Traders implements Serializable {
	public int money = 0;
	public Ship ship = new Flea(); // change ship constructor
	protected int strength;
	private TradeGoods narcotics;
	private TradeGoods firearms;

	// public int ptechLevel;

	public Traders(final int techLevel) {
		setStrength(techLevel);
		setTraderMoney(techLevel);
	}

	/**
	 * This method is a query method for the money possessed by a pirate
	 * 
	 * @return Pirate Money
	 */
	public final int getTraderMoney() {
		return money;
	}

	/**
	 * This is a query method for the pirate ship
	 * 
	 * @return Pirate Ship
	 */
	public final Ship getTraderShip() {
		return ship;
	}

	private void setTraderMoney(final int techLevel) {
		int base = 50;
		double fraction = strength / (double) ship.getMaxHullStrength();
		int price = (int) ((double) base * (double) techLevel * fraction);
		money = (base + price);
	}

	private void setStrength(final int techLevel) {
		Random gen = new Random();
		ship.setHullStrength(gen.nextInt(techLevel * 3));
		strength = ship.getHullStrength();

	}

	/**
	 * This is a query method that returns the strength of the pirate
	 * 
	 * @return pstrength
	 */
	public final int getTraderStrength() {
		return strength;
	}
}