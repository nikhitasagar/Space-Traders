package model;

import java.io.Serializable;

/**
 * This is class for the Medicine resource which is a subclass of the TradeGoods.  
 * The player can buy/sell this resource from the market place or other traders.
 * 
 * Detailed Description: Medicine is produced by early industrial systems and 
 * higher tech levels. Prices vary mostly in the 510 to 630 credits range. 
 * Systems which have special herbs as natural resources can produce them 
 * cheaper, while systems which suffer under a plague will pay a lot for them.
 * @author Nikhita Sagar
 */
public class Medicine extends TradeGoods implements Serializable {
    public Medicine() {
		super("Medicine", 4, 1, 6, 650, -20, 10, 400, 700);
	}
    
}
