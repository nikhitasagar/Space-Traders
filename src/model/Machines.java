package model;

import java.io.Serializable;

/**
 * This is class for the Machines resource which is a subclass of the TradeGoods.  
 * The player can buy/sell this resource from the market place or other traders.
 * 
 * Detailed Description: Machines are produced by early industrial systems and 
 * higher tech levels. Prices vary mostly in the 690 to 810 credits range. Where 
 * there is a lack of workers, you'll find machines sell the best.
 * @author Nikhita Sagar
 */
public class Machines extends TradeGoods implements Serializable {
    public Machines(){
		super("Machines", 4, 3, 5, 900, -30, 5, 600, 800);
	}
}
