/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.util.Random;

/**
 *
 * @author nikhitasagar needs to be javadoc'ed
 */
public class TradeGoods implements Serializable {
	protected String name;
	protected int MTLP;
	protected int MTLU;
	protected int TTP;
	protected int Base_Price;
	protected int IPL;
	protected int Var;
	protected int MTL;
	protected int MTH;
	public int quantity = 0;

	public TradeGoods(final String name, final int MTLP, final int MTLU,
			final int TTP, final int Base_Price, final int IPL, final int Var,
			final int MTL, final int MTH) {
		this.name = name;
		this.MTLP = MTLP;
		this.MTLU = MTLU;
		this.TTP = TTP;
		this.Base_Price = Base_Price;
		this.IPL = IPL;
		this.Var = Var;
		this.MTL = MTL;
		this.MTH = MTH;
	}

	public final int changeQuantity(final int quantity) {
		this.quantity = quantity;
		return quantity;
	}

	public final int returnQuantity() {
		return quantity;
	}

	public final String getName() {
		return name;
	}

	public final void setQuantity(final int q) {
		quantity = q;
	}

	public final boolean canBuyFromMarket(final int techLevel) {
		return !(techLevel < MTLP);
	}

	public final boolean canSellToMarket(final int techLevel) {
		return !(techLevel < MTLU);
	}

	public final int buy_from_market(final int tech_level) {
		if (tech_level < MTLP) {
			return 0;
		}
		int price = 0;
		Random rand = new Random();
		double variance = (rand.nextInt(Var + 1) / 100.0);
		int coin = rand.nextInt(2);

		if (coin == 0) {
			price = (int) (Base_Price + (IPL * (tech_level - MTLP)) + (Base_Price * variance));
		} else if (coin == 1) {
			price = (int) (Base_Price + (IPL * (tech_level - MTLP)) + (Base_Price * variance));
		}
		return price;

	}

	public final int sell_to_market(final int tech_level) {
		if (tech_level < MTLU) {
			return 0;
		}
		int price = 0;
		Random rand = new Random();
		double variance = (rand.nextInt(Var + 1) / 100.0);
		int coin = rand.nextInt(2);

		if (coin == 0) {
			price = (int) (Base_Price + (IPL * (tech_level - MTLU)) + (Base_Price * variance));
		} else if (coin == 1) {
			price = (int) (Base_Price + (IPL * (tech_level - MTLU)) + (Base_Price * variance));
		}
		return price;
	}

}
