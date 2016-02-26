package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class createMercenaries implements Serializable {
	protected int num_merc;
	ArrayList<Mercenaries> mercenaryList = new ArrayList<>(5);

	public createMercenaries() {
		Random rd = new Random();
		int toss = rd.nextInt(2);
		if (toss == 0) {
			mercenaryList = null;
		} else {
			double num = rd.nextDouble();
			if (num <= 0.05) {
				for (int i = 0; i < 5; i++) {
					Mercenaries m = new Mercenaries();
					mercenaryList.add(m);
				}
			} else if (num >= 0.05 && num <= 0.15) {
				for (int i = 0; i < 4; i++) {
					Mercenaries m = new Mercenaries();
					mercenaryList.add(m);
				}
			} else if (num >= 0.15 && num <= 0.35) {
				for (int i = 0; i < 3; i++) {
					Mercenaries m = new Mercenaries();
					mercenaryList.add(m);
				}
			} else if (num >= 0.35 && num <= 0.70) {
				for (int i = 0; i < 2; i++) {
					Mercenaries m = new Mercenaries();
					mercenaryList.add(m);
				}
			} else {
				Mercenaries m = new Mercenaries();
				mercenaryList.add(m);
			}
		}
	}

	public final ArrayList<Mercenaries> getMercenaries() {
		return mercenaryList;
	}
}