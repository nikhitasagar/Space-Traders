package model;

import java.io.Serializable;

public class GameData implements Serializable {
	// P;

	private static Person person;
	private static Universe universe;
	private static boolean existingGame = false;

	private static GameData data;

	public GameData() {
	}

	public GameData(final GameData x) {
		data = x;
	}

	public static GameData getData() {
		return data;
	}

	public static void setData(final GameData x) {
		data = x;
	}

	public final Person getPerson() {
		return person;
	}

	public final void setPerson(final Person newPerson) {
		person = newPerson;
		existingGame = true;
	}

	public final boolean isThereExistingGame() {
		return existingGame;
	}

	public final Universe getUniverse() {
		return universe;
	}

	public final void setUniverse(final Universe newUniverse) {
		universe = newUniverse;
	}
}
