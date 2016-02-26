package model;

import java.io.Serializable;

/**
 * This is class for the Robots resource which is a subclass of the 
 * TradeGoods. The player can buy/sell this resource from the market place or 
 * other traders.
 * 
 * Detailed Description: Robots are the ultimate hi-tech good, and a system 
 * needs at least to have entered the post-industrial era to produce them. 
 * Prices vary mostly in the 3950 to 4400 credits range. Especially systems 
 * which lack workers have a need for robots and will pay the most for them.
 * @author Nikhita Sagar
 */
public class Robots extends TradeGoods implements Serializable {
    public Robots() {
		super("Robots", 6, 4, 7, 5000, -150, 100, 3500, 5000);
	}
}
