/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author nikhitasagar
 */
public class TradeGoodsTest {
	private TradeGoods o;

	@Before
	public final void setUp() {
		o = new Ore();
	}

	@Test
	public final void testcanBuyFromMarket() {
		assertEquals(false, o.buy_from_market(3));
		assertEquals(true, o.buy_from_market(1));
		assertEquals(true, o.buy_from_market(2));
	}
}
