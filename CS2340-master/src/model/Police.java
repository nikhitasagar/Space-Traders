/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Random;

/**
 * This class is for the police encountered while traveling
 * 
 * @author nikhitasagar
 */
public class Police {
	public Ship pShip = new Flea(); // change ship constructor
	protected double pstrength;
	public int ptechLevel;

	/**
	 * This method sets the police strength for attacking
	 * 
	 * @param techLevel
	 */
	public final void setStrength(final int techLevel) {
		ptechLevel = techLevel;
		Random rand = new Random();
		double r = (rand.nextInt(techLevel)) / 10;
		pstrength = pShip.getHullStrength() * r;
	}

	/**
	 * This is a query method for the police strength
	 * 
	 * @return pstrength
	 */
	public final double getPoliceStrength() {
		return pstrength;
	}

	/**
	 * This is a query method for the police ship
	 * 
	 * @return pShip
	 */
	public final Ship getPoliceShip() {
		return pShip;
	}
}
