/**
 * 
 * Class holds object type of country
 * @author Kaden Oseen
 *
 */
public class Countries {

	public String year1;
	public String year2;
	public String country;
	public String abbrv;

	/**
	 * Constructor creates a country
	 * @param first starting year
	 * @param second ending year
	 * @param name country name
	 * @param abbreviation shortened country name
	 */
	public Countries(String first, String second, String name, String abbreviation) {
		year1 = first;
		year2 = second;
		country = name;
		abbrv = abbreviation;
	}
}
