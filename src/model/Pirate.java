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
public class Pirate implements Serializable {
	public int pMoney = 0;
	public Ship pShip = new Flea(); // change ship constructor
	protected int strength;

	// public int ptechLevel;

	public Pirate(final int techLevel) {
		setStrength(techLevel);
		setPirateMoney(techLevel);
	}

	/**
	 * This method is a query method for the money possessed by a pirate
	 * 
	 * @return Pirate Money
	 */
	public final int getPirateMoney() {
		return pMoney;
	}

	/**
	 * This is a query method for the pirate ship
	 * 
	 * @return Pirate Ship
	 */
	public final Ship getPirateShip() {
		return pShip;
	}

	private void setPirateMoney(final int techLevel) {
		int base = 200;
		// System.out.println("Double Strength = " + (double)this.strength);
		// System.out.println("max s = " + (double)pShip.getMaxHullStrength());
		double fraction = strength / (double) pShip.getMaxHullStrength();
		// System.out.println("Fraction = " + fraction);
		int price = (int) ((double) base * (double) techLevel * fraction);
		pMoney = (base + price);
	}

	private void setStrength(final int techLevel) {
		Random gen = new Random();
		if (techLevel > 5) {
			pShip.setHullStrength(gen.nextInt(5 * techLevel));
			strength = pShip.getHullStrength();
		} else {
			strength = pShip.getHullStrength();
		}

	}

	/**
	 * This is a query method that returns the strength of the pirate
	 * 
	 * @return pstrength
	 */
	public final int getPirateStrength() {
		return strength;
	}
}
