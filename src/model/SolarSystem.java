package model;

import java.io.Serializable;

import model.Planet;

/**
 * This is the model class for the solar system.
 *
 * @author Utkarsh Garg
 */

public class SolarSystem implements Serializable {
	private String name;
	private Planet planet;
	private Planet[] planets; // Can rplace planet and each solar system can
								// have multiple planets.

	public SolarSystem(final Planet planet) {
		this.planet = planet;
		name = planet.getName();
	}

	public final Planet getPlanet() {
		return planet;
	}

	public final String getName() {
		return name;
	}
}
