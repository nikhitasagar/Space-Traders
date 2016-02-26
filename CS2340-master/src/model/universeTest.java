package model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class universeTest {

	@Test
	public void universeTest() {
	}

	private Universe universe;
	private int width;
	private int height;
	private int solarSystems;

	@Before
	public final void setUp() {
		width = 100;
		height = 150;
		solarSystems = 50;
		universe = new Universe();
	}

	@Test
	public final void testUniverse() {
		assertNotEquals(universe, null);
	}

	@Test
	public final void testUniverseWidth() {
		assertEquals(width, universe.getUniverseWidth());
	}

	@Test
	public final void testUniverseLength() {
		assertEquals(height, universe.getUniverseLength());
	}

	@Test
	public final void testnumSolarSystems() {
		assertEquals(solarSystems, universe.getNumsolarsystem());
	}

	@Test
	public final void testUniverseSolarSystems() {
		ArrayList<SolarSystem> list = universe.solarSystems;
		// check that SolarSystem names are correctly recognized
		for (int i = 0; i < list.size(); i++) {
			SolarSystem solar = list.get(i);
			assertEquals(true, universe.solarSystemNameExists(solar.getName()));
		}
	}

	@After
	public final void tearDown() {
		universe = null;
	}

}
