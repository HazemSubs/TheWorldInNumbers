
/**
 * Class creates ADT to store all country names, abbreviations and possible analysis years
 * @author Kaden Oseen
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CountryList {

	/**
	 * Creates object of type GetData to fetch required country data
	 */
	GetData data = new GetData();

	/**
	 * Method gets data for specific country and returns list storing all the countries in type Countries
	 * @return list of countries
	 */
	public Countries[] getCountryData() {
		Countries[] countryData = new Countries[220];
		int count = 0;
		File file = new File("countries.txt"); // File holds all countries and their abbreviations and possible analysis years
		Scanner scanner;

		try { // adds countries to list if they are valid
			scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] splitLine = line.split(",");
				Countries current = new Countries(splitLine[2], splitLine[3], splitLine[0], splitLine[1]);
				countryData[count] = current;
				count++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return countryData;
	}

}