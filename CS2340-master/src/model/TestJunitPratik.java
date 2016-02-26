package model;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * This Junit Test will basically see whether adding a good to a ships cargo bay
 * conforms with the set rules
 *
 * @author Pratik
 *
 */
public class TestJunitPratik {

	// @BeforeClass
	Ship ship = new Flea();

	// insure that the ship starts off with a capacity of 0
	// in the cargo bay
	@Test
	public final void testInitialCapacity() {
		int initialSpace = ship.getCargoBayCount();
		assertEquals(0, initialSpace);
	}

	// now we will add an item. We need to see that the counter
	// for number of cargo bay goods increases by one
	// we will add the good to the zeroth index, which is water
	@Test
	public final void testAddOneGood() {
		ship.addTradeGood(0);
		int newSpace = ship.getCargoBayCount();
		assertEquals(1, newSpace);
	}

	// we will continue adding until we reach the limit of the
	// ships cargo bay capacity, which we know when we call the
	// method getCargoBayCapacity()
	@Test
	public final void testAddMaxItems() {
		for (int i = ship.getCargoBayCount(); i < ship.getCargoBayCapacity(); i++) {
			ship.addTradeGood(0);
		}
		int newSpace = ship.getCargoBayCount();
		assertEquals(ship.getCargoBayCapacity(), newSpace);
	}

	// see if it possible to add a good beyond the maximum
	@Test
	public final void testAddBeyondMax() {
		for (int i = ship.getCargoBayCount(); i < ship.getCargoBayCapacity(); i++) {
			ship.addTradeGood(0);
		}
		ship.addTradeGood(0);
		int newSpace = ship.getCargoBayCount();
		assertEquals(ship.getCargoBayCapacity(), newSpace);
	}

	// we have a full cargo bay, now see if removing an item will reduce
	// the number of items in the cargo bay
	@Test
	public final void testRemoveOneFromMax() {
		for (int i = ship.getCargoBayCount(); i < ship.getCargoBayCapacity(); i++) {
			ship.addTradeGood(0);
		}
		ship.removeTradeGood(0);
		int newSpace = ship.getCargoBayCount();
		assertEquals(ship.getCargoBayCapacity() - 1, newSpace);
	}

	// we will now try to remove a good that isnt there, so for example
	// lets try to remove food, which is the 1st index. The number of
	// good onboard should not change, which is the max
	@Test
	public final void testRemoveBoogyGood() {
		for (int i = ship.getCargoBayCount(); i < ship.getCargoBayCapacity(); i++) {
			ship.addTradeGood(0);
		}
		ship.removeTradeGood(1);
		int newSpace = ship.getCargoBayCount();
		assertEquals(ship.getCargoBayCapacity(), newSpace);
	}

	// lets add to the max then remove until there are no goods onboard
	@Test
	public final void testRemoveAllGoods() {
		for (int i = ship.getCargoBayCount(); i < ship.getCargoBayCapacity(); i++) {
			ship.addTradeGood(0);
		}
		while (ship.getCargoBayCount() > 0) {
			ship.removeTradeGood(0);
		}
		int newSpace = ship.getCargoBayCount();
		assertEquals(0, newSpace);
	}

	// lets try to remove from an empty cargo bay. The result SHOULD NOT
	// BE -1
	@Test
	public final void testRemoveBeyondZeroGoods() {
		ship.removeTradeGood(0);
		int newSpace = ship.getCargoBayCount();
		assertEquals(0, newSpace);
	}
}
