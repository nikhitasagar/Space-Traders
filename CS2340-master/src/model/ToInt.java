package model;

/**
 * A static class that will use the name of the good and convert that into an
 * int value that can be used by any method in any class
 *
 * @author Pratik
 *
 */
public class ToInt {

	/**
	 * Static method to convert the TradeGood into an int value
	 * 
	 * @param goodName
	 *            the TradeGood to convert
	 * @return int the int value for that respective TradeGood
	 */
	public static int getInt(final String goodName) {
		if (goodName.equalsIgnoreCase("Water")) {
			return 0;
		} else if (goodName.equalsIgnoreCase("Furs")) {
			return 1;
		} else if (goodName.equalsIgnoreCase("Food")) {
			return 2;
		} else if (goodName.equalsIgnoreCase("Ore")) {
			return 3;
		} else if (goodName.equalsIgnoreCase("Games")) {
			return 4;
		} else if (goodName.equalsIgnoreCase("Firearms")) {
			return 5;
		} else if (goodName.equalsIgnoreCase("Medicine")) {
			return 6;
		} else if (goodName.equalsIgnoreCase("Machines")) {
			return 7;
		} else if (goodName.equalsIgnoreCase("Narcotics")) {
			return 8;
		} else if (goodName.equalsIgnoreCase("Robots")) {
			return 9;
		}
		return 0;
	}
}
