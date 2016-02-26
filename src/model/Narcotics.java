package model;

import java.io.Serializable;

/**
 * This is class for the Narcotics resource which is a subclass of the 
 * TradeGoods. The player can buy/sell this resource from the market place or 
 * other traders.
 * 
 * Detailed Description: Like firearms, the GGF strictly forbids trafficking 
 * drugs. However, they are often in high demand, even in low-tech systems, and 
 * it can be very worth your while to try to sneak them past the police. 
 * Industrial systems and higher tech levels can produce them. Prices vary 
 * mostly in the 2625 to 3500 credits range. Some systems find there are weird 
 * mushrooms among their natural resources, which produce excellent drugs for a 
 * cheap price. You best sell them in systems where people are bored.
 * @author Nikhita Sagar
 */
public class Narcotics extends TradeGoods implements Serializable {
    public Narcotics() {
		super("Narcotics", 5, 0, 5, 3500, -125, 150, 2000, 3000);
	}
}
