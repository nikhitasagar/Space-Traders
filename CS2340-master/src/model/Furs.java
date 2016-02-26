package model;

import java.io.Serializable;

/**
 * This is class for the Furs resource which is a subclass of the TradeGoods.  
 * The player can buy/sell this resource from the market place or other traders.
 * 
 * Detailed Description: Furs are made from the hides of animals indigenous to a 
 * system. They can be bought on any system. Prices will vary mostly in the 250 
 * to 320 credits range. A lifeless system will pay more for furs, and a system 
 * with rich fauna will have them available cheaply. During a cold spell, the 
 * price of furs will certainly increase.
 * @author Nikhita Sagar
 */
public class Furs extends TradeGoods implements Serializable {
    public Furs() {
		super("Furs", 0, 0, 0, 250, 10, 10, 230, 280);
	}
}
