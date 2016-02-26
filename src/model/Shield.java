package model;

import java.io.Serializable;

public class Shield implements Serializable {
	private int cost;
	private int strength;
	private String name;

	private final int MAX_COST = 25000;
	private final int MAX_STRENGTH = 50;

	public Shield(final int level) {
		if (level == 1) {
			cost = 15000;
			name = "Titanium Hull";
			strength = 30;
		} else if (level == 2) {
			cost = 20000;
			name = "Pulsar Shield";
			strength = 40;
		} else if (level == 3) {
			cost = 25000;
			name = "Plasma Shield";
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
