package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Equipment implements Serializable {
	// weapons : 3 level
	// Shields : 3 levels
	// Gadgets : Escape: Boost/ HyperSpace like in star trek/ Stealth Mode :
	// Escape Police, Pirate
	// : Tractor Beam - Stop people from fleeing
	// : Teleportation (can beam merenaries onto traders ship and steal items)
	// Small chance of getting caught.
	// : Deflector - If you get attacked, reverses damages back onto attacker,
	// without hurting you.
	// items only available after 4th tech level.
	// each one will have a price and min tech Level.

	// HashMap<String, Integer[]> gadgets = new HashMap<String, Integer[]>();
	// HashMap<String, Integer[]> weapons = new HashMap<String, Integer[]>();
	// HashMap<String, Integer[]> shields = new HashMap<String, Integer[]>();
	public int techLevel;

	ArrayList<Gadget> gadgets;
	ArrayList<Weapon> weapons;
	ArrayList<Shield> shields;

	public Equipment(final int techLevel) {
		this.techLevel = techLevel;
		createGadgets(techLevel);
		createWeapons(techLevel);
		createShields(techLevel);
	}

	private void createGadgets(final int techLevel) {
		if (techLevel >= 5) {
			gadgets = new ArrayList<>();
			gadgets.add(new Gadget(1));
		}
		if (techLevel >= 6) {
			gadgets.add(new Gadget(2));
		}
		if (techLevel == 7) {
			gadgets.add(new Gadget(3));
			gadgets.add(new Gadget(4));
		}
	}

	private void createWeapons(final int techLevel) {
		if (techLevel >= 5) {
			weapons = new ArrayList<>();
			weapons.add(new Weapon(1));
		}
		if (techLevel >= 6) {
			weapons.add(new Weapon(2));
		}
		if (techLevel == 7) {
			weapons.add(new Weapon(3));
		}
	}

	private void createShields(final int techLevel) {
		if (techLevel >= 5) {
			shields = new ArrayList<>();
			shields.add(new Shield(1));
		}
		if (techLevel >= 6) {
			shields.add(new Shield(2));
		}
		if (techLevel == 7) {
			shields.add(new Shield(3));
		}
	}

	public final ArrayList<Weapon> getWeapons() {
		return weapons;
	}

	public final ArrayList<Gadget> getGadgets() {
		return gadgets;
	}

	public final ArrayList<Shield> getShields() {
		return shields;
	}

}
