/**
 * This Junit file tests if a drastic event increases the prices of goods affected by 5
 * fold or not.
 * @author Chakshu Agarwal
 */

package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestChak {
	Planet planet;
	MarketPlace marketplace;
	int[] one_good;
	int[] no_goods;
	int[] many_goods;

	@Before
	public void setUp() {
		planet = new Planet(5, 4, 10, 20);
		marketplace = planet.getMarketPlace();
		one_good = new int[] { 4 };
		no_goods = null;
		many_goods = new int[] { 1, 2 };
	}

	@Test
	// (one good)
	public void testsetDrasticPrices1() {
		setUp();
		int initial_price = marketplace.getBuyingPrices()[4];
		marketplace.setDrasticPrices(one_good);
		int initial_pricecheck = initial_price * 5;
		int changed_price = marketplace.getBuyingPrices()[4];
		System.out.println(initial_pricecheck);
		System.out.println(changed_price);
		assertEquals(initial_pricecheck, changed_price);
	}

	@Test
	// (many goods)
	public void testsetDrasticPrices2() {
		setUp();
		int initial_price1 = marketplace.getBuyingPrices()[1];
		int initial_price2 = marketplace.getBuyingPrices()[2];
		marketplace.setDrasticPrices(many_goods);
		int initial_pricecheck1 = initial_price1 * 5;
		int initial_pricecheck2 = initial_price2 * 5;
		int changed_price1 = marketplace.getBuyingPrices()[1];
		int changed_price2 = marketplace.getBuyingPrices()[2];
		System.out.println(initial_pricecheck1);
		System.out.println(changed_price1);
		System.out.println(initial_pricecheck2);
		System.out.println(changed_price2);
		assertEquals(initial_pricecheck1, changed_price1);
		assertEquals(initial_pricecheck2, changed_price2);
	}

	@Test
	// (no goods)
	public void testsetDrasticPrices3() {
		setUp();
		int initial_price = marketplace.getBuyingPrices()[7];
		marketplace.setDrasticPrices(no_goods);
		int changed_price = marketplace.getBuyingPrices()[7];
		System.out.println(initial_price);
		System.out.println(changed_price);
		assertEquals(initial_price, changed_price);
	}

}