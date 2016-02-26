package model;

import java.io.Serializable;

/**
 * This is class for the Food resource which is a subclass of the TradeGoods.  
 * The player can buy/sell this resource from the market place or other traders.
 * 
 * Detailed Description: Except for pre-agricultural systems, food can be bought 
 * in all systems. Prices will vary mostly in the 105 to 135 credits range. The 
 * soil quality will influence the price of food: rich soil makes it cheaper, 
 * poor soil more expensive. When there is a crop failure, the price of food 
 * will rise.
 * @author Nikhita Sagar
 */
public class Food extends TradeGoods implements Serializable {
    public Food() {
		super("Food", 1, 0, 1, 100, 5, 5, 90, 160);
	}
}
