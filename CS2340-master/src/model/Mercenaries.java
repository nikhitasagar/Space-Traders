package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Mercenaries implements Serializable {
	protected String name;
	private ArrayList<Integer> count = new ArrayList<>(5);
	protected int[] skills;
	public final String[] Merc_names = { "Vader", "Yoda", "Boba", "Luke",
			"Leia", "Palpatine", "Padme", "Ahsoka", "Obi-Wan", "Jaba", "R2-D2",
			"Han", "Jar Jar", "Chewbacca", "Darth", "Lando", "Mace", "C-3PO",
			"Greedo", "Chakshu", "Dooku", "Qui-Gon", "Christopher Pike",
			"Spock", "Number One", "Phillip Boyce", "Jose Tyler", "Scotty",
			"James Kirk", "Meonard McCoy", "Hikaru Sulu", "Pavel Chekov",
			"Nyota Uhra" };

	public Mercenaries() {
		Random rand = new Random();
		int nameint = rand.nextInt(Merc_names.length);
		name = Merc_names[nameint];
		for (int i = 0; i < 5; i++) {
			count.add(i);
		}
		skills = new int[] { 0, 0, 0, 0, 0 };
		int total = 15;
		int c = 0;
		for (int i = 0; i < count.size() - 1; i++) {
			Collections.shuffle(count);
			int temp = rand.nextInt(total + 1);
			skills[count.get(0)] = temp;
			total = total - temp;
			if (total == 0) {
				break;
			}
			count.remove(0);
		}
		// just to make sure all the points are allocated
		if (total > 0) {
			skills[count.get(0)] = total;
		}
	}

	public final int[] getSkills() {
		return skills;
	}

	public final String getName() {
		return name;
	}

	public final int getMaxSkill() {
		int answer = 0;
		for (int i = 1; i < skills.length; i++) {
			if (skills[answer] < skills[i]) {
				answer = i;
			}
		}
		return answer;
	}

}