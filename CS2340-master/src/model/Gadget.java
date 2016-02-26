package model;

import java.io.Serializable;

public class Gadget implements Serializable {
	private int cost;
	private String description;
	private String name;

	private final int MAX_COST = 25000;

	// private final int MAX_STRENGTH = 50;

	public Gadget(final int level) {
		if (level == 1) {
			cost = 15000;
			name = "Warp Speed";
			description = "This gadget allows you to flea from \n pirates more easily";
		} else if (level == 2) {
			cost = 17500;
			name = "Tractor Beam";
			description = "This gadget allows you to stop a \n trader or pirate from fleeing";
		} else if (level == 3) {
			cost = 20000;
			name = "Teleportation";
			description = "this gadget allows you to bean onto \n another ship and steal goods";
		} else if (level == 4) {
			cost = 25000;
			name = "Deflector";
			description = "This gadget allows you to deflet the \n damage back on the attacker";
		}
	}

	public final int getCost() {
		return cost;
	}

	public final String getDescription() {
		return description;
	}

	public final String getName() {
		return name;
	}

	public final int getMaxCost() {
		return MAX_COST;
	}

}