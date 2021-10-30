/**
 * Class creates DataItem to hold a country's single year and value for later
 * use in various analysis types
 * @author Kaden Oseen
 */

public class DataItem {

	private int year;
	private float value;

	/**
	 * Constructor creates data item holding a year and value
	 * @param dataYear country year
	 * @param val value of year
	 */
	public DataItem(int dataYear, float val) {
		year = dataYear;
		value = val;
	}

	/**
	 * Method returns year
	 * @return year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * Method returns value
	 * @return value
	 */
	public float getValue() {
		return value;
	}
}
