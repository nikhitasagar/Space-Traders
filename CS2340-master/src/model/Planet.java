package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Planet implements Serializable {
	private String name;
	private String drasticEventMessage;
	protected int xCor;
	protected int yCor;
	private String techLevelString;
	private String resourceName;
	private int goodAffected;
	private double priceModifier;
	private int techLevel;
	private MarketPlace market;
	private int isThereDrasticEvent;
	private ArrayList<PiratePlayer> pirateList;
	private ArrayList<TraderPlayer> tradersList;
	private PiratePlayer currentPirate;
	private TraderPlayer currentTrader;

	private final String[] resources = new String[] { "None", "Lots of Water",
			"Desert", "Rich Fauna", "Lifeless", "Rich Soil", "Poor Soil",
			"Mineral Rich", "Mineral Poor", "Artistic", "Warlike",
			"Lots of Herbs", "Weird Mushrooms" };
	private final String[] techLevels = { "PRE-AGRICULTURAL", "AGRICULTURAL",
			"MEDIVAL", "RENAISSANCE", "EARLY INDUSTRIAL", "INDUSTRIAL",
			"POST-INDUSTRIAL", "HI-TECH" };
	public final String[] names = { "Acamar", "Adahn", "Aldea", "Andevian",
			"Antedi", "Balosnee", "Baratas", "Brax", "Bretel", "Calondia",
			"Campor", "Capelle", "Carzon", "Castor", "Cestus", "Cheron",
			"Courteney", "Daled", "Damast", "Davlos", "Deneb", "Deneva",
			"Devidia", "Draylon", "Drema", "Endor", "Esmee", "Exo", "Ferris",
			"Festen", "Fourmi", "Frolix", "Gemulon", "Guinifer", "Hades",
			"Hamlet", "Helena", "Hulst", "Iodine", "Iralius", "Janus",
			"Japori", "Jarada", "Jason", "Kaylon", "Khefka", "Kira", "Klaatu",
			"Klaestron", "Korma", "Kravat", "Krios", "Laertes", "Largo",
			"Lave", "Ligon", "Lowry", "Magrat", "Malcoria", "Melina", "Mentar",
			"Merik", "Mintaka", "Montor", "Mordan", "Myrthe", "Nelvana", "Nix",
			"Nyle", "Odet", "Og", "Omega", "Omphalos", "Orias", "Othello",
			"Parade", "Penthara", "Picard", "Pollux", "Quator", "Rakhar",
			"Ran", "Regulas", "Relva", "Rhymus", "Rochani", "Rubicum", "Rutia",
			"Sarpeidon", "Sefalla", "Seltrice", "Sigma", "Sol", "Somari",
			"Stakoron", "Styris", "Talani", "Tamus", "Tantalos", "Tanuga",
			"Tarchannen", "Terosa", "Thera", "Titan", "Torin", "Triacus",
			"Turkana", "Tyrus", "Umberlee", "Utopia", "Vadera", "Vagra",
			"Vandor", "Ventax", "Xenon", "Xerxes", "Yew", "Yojimbo", "Zalkon",
			"Zuul" };
	public final String[] drasticEventMessages = { "A drought!",
			"A cold, cold winter", "The crops have failed",
			"A war has broken out", "People are extremely bored",
			"There is a plague!", "There is a lack of workers!" };

	public Planet(final int name, final int tech, final int xCor, final int yCor) {
		this.name = names[name];
		techLevel = tech;
		techLevelString = techLevels[tech];
		// existingResources[r1] = true;
		int r = resourceGenerator();
		resourceName = resources[r];
		goodAffected = getGoodAffected(r);
		priceModifier = getPriceModifier(r);
		this.xCor = xCor;
		this.yCor = yCor;
		market = new MarketPlace(techLevel);
		market.setResourcePrice(goodAffected, priceModifier);
	}

	private int resourceGenerator() {
		Random gen = new Random();
		if (techLevel < 1) {
			return gen.nextInt(5);
		} else if (techLevel < 2) {
			return gen.nextInt(7);
		} else if (techLevel < 3) {
			return gen.nextInt(9);
		} else if (techLevel < 4) {
			return gen.nextInt(11);
		} else {
			return gen.nextInt(13);
		}
	}

	private int getGoodAffected(final int r) {
		if (r == 1 || r == 2) {
			return 0;
		} else if (r == 3 || r == 4) {
			return 1;
		} else if (r == 5 || r == 6) {
			return 2;
		} else if (r == 7 || r == 8) {
			return 3;
		} else if (r == 9) {
			return 4;
		} else if (r == 10) {
			return 5;
		} else if (r == 11) {
			return 6;
		} else if (r == 12) {
			return 8;
		} else {
			return -1;
		}
	}

	private double getPriceModifier(final int r) {
		if (r == 2 || r == 4 || r == 6 || r == 8) {
			return 2;
		} else if (r == 0) {
			return 1.0;
		} else {
			return 0.5;
		}
	}

	public final PiratePlayer getCurrentPirate() {
		return currentPirate;
	}

	public final void setCurrentPirate(final PiratePlayer current) {
		currentPirate = current;
	}

	public final TraderPlayer getCurrentTrader() {
		return currentTrader;
	}

	public final void setCurrentTrader(final TraderPlayer current) {
		currentTrader = current;
	}

	public final String getResourceName() {
		return resourceName;
	}

	public final int getX() {
		return xCor;
	}

	public final int getY() {
		return yCor;
	}

	public final String getName() {
		return name;
	}

	public final String getTechLevelString() {
		return techLevelString;
	}

	public final int getTechLevel() {
		return techLevel;
	} // return tech level as int.

	public final MarketPlace getMarketPlace() {
		return market;
	}

	@Override
	public final String toString() {
		return "Planet name: " + name + "\n" + "Tech Level: " + techLevel
				+ "\n" + "Resources: " + resourceName + "\n" + "Coordinates: "
				+ xCor + ", " + yCor + "\n";
	}

	public final int[] getDrasticEvent() {
		if (isThereDrasticEvent < 0) {
			return null;
		} else if (isThereDrasticEvent == 0) {
			return new int[] { 0 };
		} else if (isThereDrasticEvent == 1) {
			return new int[] { 1 };
		} else if (isThereDrasticEvent == 2) {
			return new int[] { 2 };
		} else if (isThereDrasticEvent == 3) {
			return new int[] { 3, 5 };
		} else if (isThereDrasticEvent == 4) {
			return new int[] { 4, 8 };
		} else if (isThereDrasticEvent == 5) {
			return new int[] { 6 };
		} else {
			return new int[] { 7, 9 };
		}
	}

	public final void toggleDrasticEvents() {
		// set prices back to normal
		market.resetDrasticPrices(getDrasticEvent());

		// set everything back to normal
		drasticEventMessage = "No unusual events";
		isThereDrasticEvent = -1;

		Random gen = new Random();
		int drasticEventHappened = gen.nextInt(100);
		if (drasticEventHappened > 70) {
			int planetTechLevel = techLevel;
			if (planetTechLevel < 2) {
				isThereDrasticEvent = gen.nextInt(3);
			} else if (planetTechLevel < 5) {
				isThereDrasticEvent = gen.nextInt(4);
			} else if (planetTechLevel < 6) {
				isThereDrasticEvent = gen.nextInt(6);
			} else {
				isThereDrasticEvent = gen.nextInt(7);
			}
		}
		if (isThereDrasticEvent > 0) {
			drasticEventMessage = drasticEventMessages[isThereDrasticEvent];
			market.setDrasticPrices(getDrasticEvent());
		}
	}

	public final String getDrasticEventMessage() {
		return drasticEventMessage;
	}

	public final double getPriceModifier() {
		return priceModifier;
	}

	public final int getSpecialGood() {
		return goodAffected;
	}

	public final String getSpecialGoodName() {
		return market.getTradeGoodsList()[goodAffected].getName();
	}

	public final void createPirates() {
		Random gen = new Random();
		int p = gen.nextInt(15);
		int numberToGenerate;

		if (p * techLevel <= 40) {
			numberToGenerate = 0;
		} else if (p * techLevel > 40) {
			numberToGenerate = gen.nextInt(5);
		} else if (p * techLevel > 50) {
			numberToGenerate = gen.nextInt(7);
		} else if (p * techLevel > 60) {
			numberToGenerate = gen.nextInt(12);
		} else {
			numberToGenerate = gen.nextInt(15);
		}
		pirateList = new ArrayList<>(numberToGenerate);
		for (int i = 0; i < numberToGenerate; i++) {
			pirateList.add(new PiratePlayer(techLevel));
		}
	}

	public final ArrayList<PiratePlayer> getPirateList() {
		return pirateList;
	}

	public final void createTraders() {
		Random gen = new Random();
		int p = gen.nextInt(15);
		int numberToGenerate;

		if (p * techLevel <= 5) {
			numberToGenerate = 0;
		} else if (p * techLevel > 40) {
			numberToGenerate = gen.nextInt(8);
		} else if (p * techLevel > 60) {
			numberToGenerate = gen.nextInt(10);
		} else if (p * techLevel > 80) {
			numberToGenerate = gen.nextInt(15);
		} else {
			numberToGenerate = gen.nextInt(20);
		}
		tradersList = new ArrayList<>(numberToGenerate);
		for (int i = 0; i < numberToGenerate; i++) {
			tradersList.add(new TraderPlayer(techLevel));
		}
	}

	public final ArrayList<TraderPlayer> getTradersList() {
		return tradersList;
	}
}
