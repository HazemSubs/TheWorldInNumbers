
/**
 * 
 * Class makes HTTPS get requests from the world bank and stores data in dictionary year:value for further analysis
 * @author Kaden Oseen
 * 
 */

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

public class GetData {

	/**
	 * Method completes entire process of HTTPS get requests from The World Bank
	 * @param indicator type of data
	 * @param year1 start year
	 * @param year2 end year
	 * @param countryAbbr country abbreviation
	 * @return list of data items holding year:value of data fetched
	 */
	public DataItem[] getData(String indicator, String year1, String year2, String countryAbbr) {
		DataItem[] data = new DataItem[100];
		String endYear;
		if (year2.equals("Now"))
			endYear = "2020";
		else
			endYear = year2;
		String urlString = String.format("http://api.worldbank.org/v2/country/%s/indicator/%s?date=%s:%s&format=json",
				countryAbbr, indicator, year1, endYear);

		float value = 0;
		int count = 0;

		try {
			URL url = new URL(urlString);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			int responsecode = conn.getResponseCode();
			if (responsecode == 200) {
				String inline = "";
				Scanner sc = new Scanner(url.openStream());
				while (sc.hasNext()) {
					inline += sc.nextLine();
				}
				sc.close();
				JsonArray jsonArray = new JsonParser().parse(inline).getAsJsonArray();
				int sizeOfResults = jsonArray.get(1).getAsJsonArray().size();
				int year;
				for (int i = 0; i < sizeOfResults; i++) {	// gets data and value from world bank json format
					year = jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject().get("date").getAsInt();
					if (jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject().get("value").isJsonNull()) {
						value = 0;
					} else {
						value = jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject().get("value").getAsFloat();
					}
						// stores each data item in data[] list
					DataItem entry = new DataItem(year, value);
					data[count] = entry;
					count++;
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return data;
	}
}
