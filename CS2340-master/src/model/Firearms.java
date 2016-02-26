package model;

import java.io.Serializable;

/**
 * This is class for Firearms which is a subclass of the TradeGoods class.
 * Firearms are an illegal trade good that can be traded by the Player.
 *
 * Detailed Description: The GGF strictly forbids the trade in firearms, and the
 * patrolling police will impound them if they find them in your cargo holds.
 * However, once docked you will often be able to sell them for a good price,
 * unless the government is so strict that people don't dare to trade them.
 * Firearms which are of interest as trade goods (even if only for their
 * collector's value) are produced in systems which have at least left the
 * middle ages behind them. Prices vary mostly in the 725 to 1175 credits range.
 * A warlike population will produce more weapons than usual and will sell them
 * therefore cheaper. Of course, where there is a war they will sell for
 * considerably higher prices.
 * 
 * @author Nikhita Sagar
 */
public class Firearms extends TradeGoods implements Serializable {
	public Firearms() {
		super("Firearms", 3, 1, 5, 1250, -75, 100, 600, 1100);
	}
}
