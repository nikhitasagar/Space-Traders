package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class savedGames {
	GameData data;
	private static Person person;
	private static Universe universe;
	String filePath;

	public savedGames() {
		data = GameData.getData();
		File fileObject = new File("test");
		filePath = fileObject
				.getAbsoluteFile()
				.toString()
				.substring(0,
						fileObject.getAbsoluteFile().toString().length() - 4)
						+ "savedGameData.ser";
	}

	public final boolean writeToFile() {
		try {
			person = data.getPerson();
			universe = data.getUniverse();
			FileOutputStream fileOut = new FileOutputStream(filePath);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(person);
			out.writeObject(universe);
			out.close();
			fileOut.close();
			return true;
		} catch (IOException i) {
			i.printStackTrace();
			return false;
		}
	}

	public final boolean readFromFile() {
		try {
			FileInputStream fileIn = new FileInputStream(filePath);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			person = (Person) in.readObject();
			universe = (Universe) in.readObject();
			// System.out.println("Success!");
			// System.out.println(person.toString());
			in.close();
			fileIn.close();
			return true;
		} catch (IOException i) {
			i.printStackTrace();
			return false;
		} catch (ClassNotFoundException c) {
			// System.out.println("Game not found");
			c.printStackTrace();
			return false;
		}
	}

	public static Person getPerson() {
		return person;
	}

}
