package model;

import java.io.Serializable;

/**
 * This is class for the Games resource which is a subclass of the TradeGoods.  
 * The player can buy/sell this resource from the market place or other traders.
 * 
 * Detailed Description: Games are used for relaxation and entertainment, 
 * whether they are board games, computer games or dolls. After a system has 
 * gone through medieval times and people have become free spirits, games get 
 * produced and sold. Prices will vary mostly in the 180 to 240 credits range. 
 * They will be cheaper if the solar system that sells them has a particularly 
 * artistic populace. You best sell them to systems where people are bored, 
 * since this will fetch you the highest price.
 * @author Nikhita Sagar
 */
public class Games extends TradeGoods implements Serializable {
    public Games() {
		super("Games", 3, 1, 6, 250, -10, 5, 160, 270);
	}
}
