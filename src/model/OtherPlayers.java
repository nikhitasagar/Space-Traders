package model;

import java.io.Serializable;
import java.util.Random;

public abstract class OtherPlayers implements Serializable {
	private int bounty;
	public Ship ship;
	private int strength;

	private final int TECHLEVEL_THRESHOLD_SHIP = 5;

	private final double STRENGTH_0_TO_1 = 3.0;
	private final double STRENGTH_2_TO_3 = 2.0;
	private final double STRENGTH_4_TO_5 = 1.3;
	private final double STRENGTH_6_TO_7 = 1.1;

	private final int FLEA_BOUNTY = 300;
	private final int GNAT_BOUNTY = 700;
	private final int FIREFLY_BOUNTY = 1400;
	private final int MOSQUITO_BOUNTY = 2300;
	private final int BUMBLEBEE_BOUNTY = 4600;

	public OtherPlayers(final int techLevel) {
		setShip(techLevel);
		setStrength(techLevel);
		setMoney(techLevel);
	}

	private void setShip(final int techLevel) {
		if (techLevel <= TECHLEVEL_THRESHOLD_SHIP) {
			ship = new Flea();
		} else {
			Random gen = new Random();
			int selectShip = gen.nextInt(4);
			if (selectShip == 0) {
				ship = new Gnat();
			} else if (selectShip == 1) {
				ship = new FireFly();
			} else if (selectShip == 2) {
				ship = new Mosquito();
			} else {
				ship = new BumbleBee();
			}
		}
	}

	private void setStrength(final int techLevel) {
		Random gen = new Random();
		if (techLevel < 2) {
			ship.setHullStrength((int) (gen.nextInt(ship.getMaxHullStrength()) / STRENGTH_0_TO_1));
		} else if (techLevel < 4) {
			ship.setHullStrength((int) (gen.nextInt(ship.getMaxHullStrength()) / STRENGTH_2_TO_3));
		} else if (techLevel < 6) {
			ship.setHullStrength((int) (gen.nextInt(ship.getMaxHullStrength()) / STRENGTH_4_TO_5));
		} else {
			ship.setHullStrength((int) (gen.nextInt(ship.getMaxHullStrength()) / STRENGTH_6_TO_7));
		}
		strength = ship.getHullStrength();
		// System.out.println("The strength is : " + this.strength);
	}

	private void setMoney(final int techLevel) {
		bounty = (int) ((double) strength / (double) ship.getMaxHullStrength());
		if (ship instanceof Flea) {
			bounty = bounty * FLEA_BOUNTY;
		} else if (ship instanceof Gnat) {
			bounty = bounty * GNAT_BOUNTY;
		} else if (ship instanceof Gnat) {
			bounty = bounty * FIREFLY_BOUNTY;
		} else if (ship instanceof Gnat) {
			bounty = bounty * MOSQUITO_BOUNTY;
		} else {
			bounty = bounty * BUMBLEBEE_BOUNTY;
		}
	}

	public final int getStrength() {
		return strength;
	}

	public final int getBounty() {
		return bounty;
	}

	public final Ship getShip() {
		return ship;
	}

	public void setPirateStrength(int newStrength) {
		this.strength = newStrength;
	}

}
