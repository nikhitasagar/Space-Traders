package model;

/**
 * This class helps implement attack feature. The player may attack Police,
 * Pirates and Traders. Similarly, Pirates, Police and Traders may attack the
 * Player.
 * 
 * @author Anugrah Vijay
 */
public abstract class Attackable {
	int[] skillDistribution = new int[5];
	Ship ship;

	public final void attack(final Attackable other) {
		int attackStrength = skillDistribution[1];
		int damageStrength = other.skillDistribution[1];

		while (other.ship.hullStrength > 0 && ship.hullStrength > 0) {
			other.ship.hullStrength -= attackStrength;
			ship.hullStrength -= damageStrength;
		}
	}

	public final boolean isAlive() {
		return ship.hullStrength > 0;
	}
}