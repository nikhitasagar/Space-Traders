package model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class myTest {
	Person player;
	Trader trader;
	int money;

	@Before
	public final void setUp() {
		player = new Person();
		trader = new Trader();
		trader.ship.cargoBay[0].setQuantity(1);
		money = player.myMoney;
	}

	@Test(timeout = 200)
	public final void testBuyFromTrader() {
		setUp();
		int cost = trader.sellingPrices[0];
		TradeGoods item = new Water();
		System.out.println(money);
		System.out.println(cost);
		assertEquals(money, player.myMoney);
		assertEquals(0, player.myShip.cargoBayCount);
		player.buyFromTrader(item, trader);
		assertEquals(1, player.myShip.cargoBayCount);

		assertEquals(money - cost, player.myMoney);
	}

}
