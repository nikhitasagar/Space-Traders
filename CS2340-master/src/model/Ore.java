/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;


/**
 *
 * @author nikhitasagar
 */
public class Ore extends TradeGoods implements Serializable {
    public Ore() {
		super("Ore", 2, 2, 3, 350, 20, 10, 350, 420);
	}
}
