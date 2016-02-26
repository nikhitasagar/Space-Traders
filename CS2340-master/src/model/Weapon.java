package model;

import java.io.Serializable;

public class Weapon implements Serializable {
	private int cost;
	private int strength;
	private String name;

	private final int MAX_COST = 25000;
	private final int MAX_STRENGTH = 50;

	public Weapon(final int level) {
		if (level == 1) {
			cost = 15000;
			name = "Photon Torpedo";
			strength = 30;
		} else if (level == 2) {
			cost = 20000;
			name = "Particle Beam";
			strength = 40;
		} else if (level == 3) {
			cost = 25000;
			name = "Plasma Cannon";
			strength = 50;
		}
	}

	public final int getCost() {
		return cost;
	}

	public final String getName() {
		return name;
	}

	public final int getStrength() {
		return strength;
	}

	public final int getMaxCost() {
		return MAX_COST;
	}

	public final int getMaxStrength() {
		return MAX_STRENGTH;
	}
}