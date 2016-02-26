package model;

import java.io.Serializable;

/**
 * This is the Ship super class. All the different types of Ships will extend
 * this class. This class has all the methods and characteristics of any kind of
 * Ship aleady implemented.
 *
 * @author Pratik
 *
 *         This is the Ship super class. All the different types of Ships will
 *         extend this class. This class has all the methods and characteristics
 *         of any kind of Ship already implemented.
 */

public abstract class Ship implements Serializable {
	public TradeGoods[] cargoBay;
	public int cargoBayCount = 0;
	// protected Weapons[] weaponSlot;
	// protected int weaponSlotCount = 0;
	// protected Shield[] shieldSlot;
	// protected int shieldSlotCount = 0;
	// protected Gadget[] gadgetSlot;
	// protected int gadgetSlotCount = 0;
	// protected Crew[] crewSlot;
	// protected int crewSlotCount = 0;

	protected Weapon[] weapons;
	protected Shield[] shields;
	protected Gadget[] gadgets;
	protected int weaponCount;
	protected int shieldCount;
	protected int gadgetCount;

	protected int weaponCapacity;
	protected int shieldCapacity;
	protected int gadgetCapacity;
	protected int crewCapacity;
	protected Mercenaries[] crew;
	protected int crewCount;
	protected int fuelCapacity;
	protected int fuel;
	protected int minTechLevel;
	protected int fuelCost;
	protected int price;
	protected int bounty;
	protected int occurance;
	protected int MAX_HULL_STRENGTH;
	public int hullStrength;
	protected int repairCost;
	protected int size;
	protected String shipType;
	protected int cargoBayCapacity;

	/**
	 * Returns the number of mercenaries on the ship.
	 *
	 * @return the number of mercenaries on the ship
	 */
	public final int getCrewCount() {
		return crewCount;
	}

	/**
	 * Resets the weapon counter on the ship.
	 *
	 * public final void resetWeaponCount() { this.weaponCount = 0; }
	 *
	 * /** Returns all the weapons on the ship.
	 *
	 * @return all the weapons on the ship
	 */
	public final Weapon[] getWeapons() {
		return this.weapons;
	}

	/**
	 * Returns all the shields on the ship.
	 *
	 * @return all the shields on the ship
	 */
	public final Shield[] getShields() {
		return this.shields;
	}

	/**
	 * Returns all the gadgets on the ship
	 *
	 * @return all the gadgets on the ship
	 */
	public final Gadget[] getGadgets() {
		return this.gadgets;
	}

	/**
	 * Adds a weapon to the ship.
	 *
	 * @param g
	 *            the weapon to be added
	 */
	public final void addWeapon(final Weapon w) {
		this.weapons[weaponCount] = w;
		this.weaponCount++;
	}

	/**
	 * Adds a shield to the ship.
	 *
	 * @param g
	 *            the shield to be added
	 */
	public final void addShield(final Shield s) {
		this.shields[shieldCount] = s;
		this.shieldCount++;
	}

	/**
	 * Adds a gadget to the ship.
	 *
	 * @param g
	 *            the gadget to be added
	 */
	public final void addGadget(final Gadget g) {
		this.gadgets[gadgetCount] = g;
		this.gadgetCount++;
	}

	/**
	 * Returns the number of weapons on board.
	 *
	 * @return the number of weapons on board
	 */
	public final int getWeaponCount() {
		return this.weaponCount;
	}

	/**
	 * Returns the number of shields on board.
	 *
	 * @return the number of shields on board
	 */
	public final int getShieldCount() {
		return this.shieldCount;
	}

	/**
	 * Returns the number of gadgets on board.
	 *
	 * @return the number of gadgets on board
	 */
	public final int getGadgetCount() {
		return this.gadgetCount;
	}

	/**
	 * Replaces the cargo bay of the ship.
	 *
	 * @param newGoods
	 *            the new cargo bay of the ship
	 */
	public final void setTradeGoods(final TradeGoods[] newGoods) {
		this.cargoBay = newGoods;
	}

	/**
	 * Adds a mercenary to the ship.
	 *
	 * @param m
	 *            the mercenary to be added
	 */
	public final void addMercenary(final Mercenaries m) {
		crew[crewCount] = m;
		crewCount++;
	}

	/**
	 * Gets the last added mercenary.
	 *
	 * @return the last added mercenary
	 */
	public final Mercenaries getMercenary() {
		return crew[crewCount - 1];
	}

	/**
	 * The capacity of weapons on the ship.
	 *
	 * @return the capacity of weapons on the ship
	 */
	public final int getWeaponCapacity() {
		return weaponCapacity;
	}

	/**
	 * The capacity of shields on the ship.
	 *
	 * @return the capacity of shields on the ship
	 */
	public final int getShieldCapacity() {
		return shieldCapacity;
	}

	/**
	 * The capacity of gadgets on the ship.
	 *
	 * @return the capacity of gadgets on the ship
	 */
	public final int getGadgetCapacity() {
		return gadgetCapacity;
	}

	/**
	 * Returns the type of ship.
	 *
	 * @return the type of ship
	 */
	public final String getShipType() {
		return shipType;
	}

	/**
	 * The capacity of crew that can be held on board.
	 *
	 * @return the capacity of crew that can be held on board
	 */
	public final int getCrewCapacity() {
		return crewCapacity;
	}

	/**
	 * This method returns the number of TradeGoods on the ship.
	 *
	 * @return int Number of TradeGoods on the ship
	 */
	// change method name to getCargoBayCount()
	public int getCargoBaySpace() {
		// for(int i=0;i<cargoBay.length;++i){
		// cargoBayCapacity += cargoBay[i].returnQuantity();
		// }
		// return cargoBayCapacity;
		return cargoBayCapacity - cargoBayCount;
	}

	/**
	 * Returns the capacity of goods that can be held on board.
	 *
	 * @return the capacity of goods that can be held on board
	 */
	public final int getCargoBayCapacity() {
		return cargoBayCapacity;
	}

	/**
	 * Sets the number of goods on board.
	 *
	 * @param newCount
	 *            the new number of goods on board
	 */
	public final void setCargoBayCount(final int newCount) {
		this.cargoBayCount = newCount;
	}

	/**
	 * Returns the number of goods on board
	 *
	 * @return the number of goods on board
	 */
	public final int getCargoBayCount() {
		return cargoBayCount;
	}

	/**
	 * This method returns a boolean stating whether the Ship has any more space
	 * in its cargoBay to hold more TradeGoods.
	 *
	 * @return true if there is space in the cargoBay, otherwise false
	 */
	public final boolean hasCargoBaySpace() {
		return cargoBayCount < cargoBayCapacity;
	}

	// public boolean hasWeaponSlotSpace(){
	// if (weaponSlot.length == weaponSlotCount) return false;
	// else return true;
	// }
	// public boolean hasShieldSlotSpace(){
	// if (shieldSlot.length == shieldSlotCount) return false;
	// else return true;
	// }
	// public boolean hasGadgetSlotSpace(){
	// if (gadgetSlot.length == gadgetSlotCount) return false;
	// else return true;
	// }
	// public boolean hasCrewSlotSpace(){
	// if (crewSlot.length == crewSlotCount) return false;
	// else return true;
	// }

	/**
	 * This method returns a boolean stating whether the fuel of the Ship is at
	 * its maximum capacity.
	 *
	 * @return true if fuel is maximum capacity, false otherwise
	 */
	public final boolean isFuelFull() {
		return fuelCapacity == fuel;
	}

	/**
	 * Returns the maximum capacity of fuel for the ship.
	 *
	 * @return the maximum fuel capacity
	 */
	public final int getFuelCapacity() {
		return fuelCapacity;
	}

	/**
	 * This method returns how much fuel needs to be filled in order to reach
	 * the Ship's maximum fuel capacity.
	 *
	 * @return int additional fuel required to reach maximum fuel capacity
	 */
	public final int fuelToFill() {
		return fuelCapacity - fuel;
	}

	/**
	 * Returns the minimum tech level required to buy this Ship.
	 *
	 * @return int minimum tech level required to buy this Ship
	 */
	public final int getMinTechLevel() {
		return minTechLevel;
	}

	/**
	 * Returns the cost per unit fuel for this Ship.
	 *
	 * @return int cost per unit fuel for this Ship
	 */
	public final int getFuelCost() {
		return fuelCost;
	}

	/**
	 * Returns the price of the Ship.
	 *
	 * @return int price of the Ship
	 */
	public final int getPrice() {
		return price;
	}

	/**
	 * Returns the fuel level of the ship.
	 *
	 * @return fuel the fuel level of the ship
	 */
	public final int getFuel() {
		return fuel;
	}

	/**
	 * Sets the fuel of the ship.
	 *
	 * @param f
	 *            the new fuel level
	 */
	public final void setFuel(final int f) {
		fuel = f;
	}

	/**
	 * Returns the bounty value if Ship surrenders.
	 *
	 * @return int bounty value if Ship surrenders
	 */
	public final int getBounty() {
		return bounty;
	}

	/**
	 * Returns the likeliness of encountering the Ship while traveling.
	 *
	 * @return int likeliness of encountering the Ship while traveling
	 */
	public final int getOccurance() {
		return occurance;
	}

	/**
	 * Returns the strength of the Ship.
	 *
	 * @return int strength of the Ship
	 */
	public final int getHullStrength() {
		return hullStrength;
	}

	/**
	 * Sets the strength of the ship.
	 *
	 * @param strength
	 *            the new strength
	 */
	public final void setHullStrength(final int strength) {
		this.hullStrength = strength;
	}

	public final int getMaxHullStrength() {
		return MAX_HULL_STRENGTH;
	}

	/**
	 * Returns the cost of repairing the Ship to fuel strength.
	 *
	 * @return int cost of repairing the Ship to fuel strength
	 */
	public final int getRepairCost() {
		return repairCost;
	}

	/**
	 * Returns the size of the Ship.
	 *
	 * @return int size of the Ship
	 */
	public final int getSize() {
		return size;
	}

	/**
	 * Returns the internal cargoBay array for other classes to use.
	 *
	 * @return array internal cargoBay array for other classes to use
	 */
	public final TradeGoods[] getCargoBay() {
		return cargoBay;
	}

	/**
	 * Method to add a new good to the Ship. Checks to see if there is any space
	 *
	 * @param good
	 *            the good to be added
	 * @param index
	 *            the index to add the good in
	 */

	public final void addTradeGood(final int index) {
		if (cargoBayCount < this.cargoBayCapacity) {
			cargoBay[index].setQuantity(cargoBay[index].returnQuantity() + 1);
			cargoBayCount++;
		}
	}

	/**
	 * Method to remove a particular TradeGood.
	 *
	 * @param index
	 *            the index to remove the good from
	 * @return true if good was successfully removed, false otherwise
	 */
	public final void removeTradeGood(final int index) {
		// System.out.println(q);
		if (hasTradeGood(index)) {
			// removing the trade good
			cargoBay[index].setQuantity(cargoBay[index].returnQuantity() - 1);
			cargoBayCount--;
		}
	}

	/**
	 * Checks to see if the good is there on the ship.
	 *
	 * @param good
	 *            the good in interest
	 * @return the index the good is located in
	 */
	private boolean hasTradeGood(final int index) {
		return !(cargoBay[index].returnQuantity() == 0);
	}

}
