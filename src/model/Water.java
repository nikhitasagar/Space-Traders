package model;

import java.io.Serializable;

/**
 * This is class for water which is a subclass of the TradeGoods class. Water is
 * a resource which the player can buy/sell from the market place or from other 
 * traders
 * @author Nikhita Sagar
 */
public class Water extends TradeGoods implements Serializable {
    public Water() {
		super("Water", 0, 0, 2, 30, 3, 4, 30, 50);
	}
}
