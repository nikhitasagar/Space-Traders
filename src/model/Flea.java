
package model;

import java.io.Serializable;



/**
 * The Flea class extends the Ship superclass. It initializes the
 * characteristics of the Flea Ship in the constructor. This class
 * has no methods, and simply uses methods only of the Ship class.
 * 
 * @author Pratik
 *
 */
public class Flea extends Ship implements Serializable {
	public Flea() {
		super();
		cargoBay = new TradeGoods[10];
		cargoBay[0] = new Water();
		cargoBay[1] = new Furs();
		cargoBay[2] = new Food();
		cargoBay[3] = new Ore();
		cargoBay[4] = new Games();
		cargoBay[5] = new Firearms();
		cargoBay[6] = new Medicine();
		cargoBay[7] = new Machines();
		cargoBay[8] = new Narcotics();
		cargoBay[9] = new Robots();
		
		for(int i=0; i<cargoBay.length; ++i) {
			cargoBay[i].setQuantity(0);
		}
		cargoBayCapacity=10;
//		weaponSlot = new Weapons[0];
//		shieldSlot = new Shield[0];
//		gadgetSlot = new Gadget[0];
//		crewSlot = new Crew[1];
		gadgetCapacity = 0;
		shieldCapacity = 0;
		weaponCapacity = 0;
		weaponCount = 0;
		shieldCount = 0;
		gadgetCount = 0;
		weapons = new Weapon[weaponCapacity];
		shields = new Shield[shieldCapacity];
		gadgets = new Gadget[gadgetCapacity];
		crewCapacity = 1;
		crew = new Mercenaries[crewCapacity];
		fuelCapacity = 20;
		fuel = fuelCapacity;
		minTechLevel = 4;
		fuelCost = 1;
		price = 2000;
		bounty = 5;
		occurance = 2;
		MAX_HULL_STRENGTH = 25;
		hullStrength = MAX_HULL_STRENGTH;
		repairCost = 1;
		size = 1;
		shipType = "Flea";
	}
}
