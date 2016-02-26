package model;

import java.io.Serializable;
import java.util.Random;
import java.util.Collections;
import java.util.ArrayList;

import javafx.scene.shape.Shape;

public class Universe implements Serializable {
	ArrayList<Integer> nameList = new ArrayList<>(20);
	ArrayList<Integer> techLevelList = new ArrayList<>(8);
	public static final int UNIVERSE_LENGTH = 150;
	public static final int UNIVERSE_WIDTH = 100;
	private static final int numSolarSystem = 50;

	/**
	 * @return the universeLength
	 */
	public static int getUniverseLength() {
		return UNIVERSE_LENGTH;
	}

	/**
	 * @return the universeWidth
	 */
	public static int getUniverseWidth() {
		return UNIVERSE_WIDTH;
	}

	/**
	 * @return the numsolarsystem
	 */
	public static int getNumsolarsystem() {
		return numSolarSystem;
	}

	// this shape object insure that planets do not overlap
	private Shape shape;
	Random rn = new Random();
	int[][] xyCords = new int[numSolarSystem][2];

	public ArrayList<SolarSystem> solarSystems;

	public Universe() {
		solarSystems = new ArrayList<>(numSolarSystem);
		for (int i = 0; i < numSolarSystem; i++) {
			nameList.add(i);
		}
		for (int i = 0; i < 8; i++) {
			techLevelList.add(i);
		}

		// boogy creation of random shape
		// shape = new Circle(1,1,1);
		//
		// for (int i = 0; i < numSolarSystem; i++) {
		// int x = rn.nextInt(UNIVERSE_LENGTH) + 1;
		// int y = rn.nextInt(UNIVERSE_WIDTH) + 1;
		//
		// while (shape.contains(x, y)){
		// x = rn.nextInt(UNIVERSE_LENGTH) + 1;
		// y = rn.nextInt(UNIVERSE_WIDTH) + 1;
		// }
		// shape = Shape.union(shape, new Circle(x, y, 7));
		// }
		// for (int i = 0; i < numSolarSystem; i++){
		// Planet temp = new Planet(nameList.get(i), techLevelList.get(0),
		// xyCords[i][0], xyCords[i][1]);
		// solarSystems.add(new SolarSystem(temp));
		// Collections.shuffle(techLevelList);
		// }
	}

	public final void addPlanet(final int x, final int y, final int i) {
		Collections.shuffle(nameList);
		Collections.shuffle(techLevelList);

		xyCords[i][0] = x;
		xyCords[i][1] = y;

		Planet temp = new Planet(nameList.get(i), techLevelList.get(0),
				xyCords[i][0], xyCords[i][1]);
		solarSystems.add(new SolarSystem(temp));
	}

	public final int getUniverseSize() {
		return numSolarSystem;
	}

	public final Planet findPlanet(final int x, final int y) {
		Planet temp;
		for (int i = 0; i < solarSystems.size(); i++) {
			temp = solarSystems.get(i).getPlanet();
			if (temp.getX() == x) {
				if (temp.getY() == y) {
					return temp;
				}
			}
		}
		return null;
	}

	@Override
	public final String toString() {
		String answer = "";
		for (int i = 0; i < solarSystems.size(); i++) {
			answer = answer + "Solar System Name: "
					+ solarSystems.get(i).getName() + "\n";
			answer = answer + solarSystems.get(i).getPlanet().toString();
			answer = answer + "\n";
		}
		return answer;
	}

	public final Planet getStartingSolarSystem() {
		return solarSystems.get(0).getPlanet();
	}

	public final boolean[] reachablePlanets(final Ship ship, final Planet planet) {
		boolean[] reachablePlanets = new boolean[numSolarSystem];
		// System.out.print("The max fuel is: ");
		int maxDistance = 5 * ship.fuel;
		// System.out.println(maxDistance);
		for (int i = 0; i < solarSystems.size(); i++) {
			Planet temp = solarSystems.get(i).getPlanet();
			int distance = (int) Math.sqrt(Math.pow(planet.xCor - temp.xCor, 2)
					+ Math.pow(planet.yCor - temp.yCor, 2));
			// System.out.println(distance);
			if (distance <= maxDistance) {
				reachablePlanets[i] = true;
				// System.out.println(true);
			}
			// else System.out.println(false);
		}
		return reachablePlanets;
	}

	public final int getSize() {
		return solarSystems.size();
	}

	public final Planet getPlanet(final int planetIndex) {
		if (planetIndex > solarSystems.size()) {
			return null;
		} else if (planetIndex < 0) {
			return null;
		} else {
			return solarSystems.get(planetIndex).getPlanet();

		}
	}

	public final boolean solarSystemNameExists(final String name) {
		for (SolarSystem each : solarSystems)
			if (each.getName().equals(name)) {
				return true;
			}
		return false;
	}
}