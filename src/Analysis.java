/**
 * Class performs all analysis required and returns 2d array holding different
 * data to be sent to the graphs/UI
 * @author Kaden Oseen, Mark Nirenshtein, Hazem Sabsabi
 */

public class Analysis {

	public CountryList country = new CountryList();
	Countries[] countries = country.getCountryData();

	/**
	 * Endpoints for data retrieval
	 */
	public String POPULATION = "SP.POP.TOTL", CO2 = "EN.ATM.CO2E.PC", POLLUTION = "EN.ATM.PM25.MC.M3",
			FOREST = "AG.LND.FRST.ZS", ENERGY = "EG.USE.PCAP.KG.OE", GDP = "NY.GDP.PCAP.CD",
			HOSPITAL = "SH.MED.BEDS.ZS", EDUCATION = "SE.XPD.TOTL.GD.ZS", MORTALITY = "SH.STA.MMRT",
			HEALTHPERCAPITA = "SH.XPD.CHEX.PC.CD", HEALTH = "SH.XPD.CHEX.GD.ZS", INFANT = "SP.DYN.IMRT.IN";

	/**
	 * Method returns 2d data item list holding all indicator data for selected country/year range
	 * @param abbrv country abbreviation
	 * @param year1 start year
	 * @param year2 end year
	 * @return 2d data item list with all required data
	 */
	public DataItem[][] analysis1(String abbrv, String year1, String year2) {

		DataItem[][] data = { co2(abbrv, year1, year2), energy(abbrv, year1, year2), pollution(abbrv, year1, year2) };
		return data;
	}

	/**
	 * Method returns 2d data item list holding all indicator data for selected country/year range
	 * @param abbrv country abbreviation
	 * @param year1 start year
	 * @param year2 end year
	 * @return 2d data item list with all required data
	 */
	public DataItem[][] analysis2(String abbrv, String year1, String year2) {

		DataItem[][] data = { forest(abbrv, year1, year2), pollution(abbrv, year1, year2) };
		return data;
	}
	
	/**
	 * Method returns 2d data item list holding all indicator data for selected country/year range
	 * @param abbrv country abbreviation
	 * @param year1 start year
	 * @param year2 end year
	 * @return 2d data item list with all required data
	 */
	public DataItem[][] analysis3(String abbrv, String year1, String year2) {

		DataItem[][] data = { co2(abbrv, year1, year2), gdp(abbrv, year1, year2) };
		return data;
	}
	
	/**
	 * Method returns 2d data item list holding all indicator data for selected country/year range
	 * @param abbrv country abbreviation
	 * @param year1 start year
	 * @param year2 end year
	 * @return 2d data item list with all required data
	 */
	public DataItem[][] analysis4(String abbrv, String year1, String year2) {

		DataItem[][] data = { forest(abbrv, year1, year2) };
		return data;
	}

	/**
	 * Method returns 2d data item list holding all indicator data for selected country/year range
	 * @param abbrv country abbreviation
	 * @param year1 start year
	 * @param year2 end year
	 * @return 2d data item list with all required data
	 */
	public DataItem[][] analysis5(String abbrv, String year1, String year2) {

		DataItem[][] data = { education(abbrv, year1, year2) };
		return data;
	}

	/**
	 * Method returns 2d data item list holding all indicator data for selected country/year range
	 * @param abbrv country abbreviation
	 * @param year1 start year
	 * @param year2 end year
	 * @return 2d data item list with all required data
	 */
	public DataItem[][] analysis6(String abbrv, String year1, String year2) {

		DataItem[] healthData = health(abbrv, year1, year2);
		DataItem[] popData = population(abbrv, year1, year2);
		DataItem[] gdpData = gdp(abbrv, year1, year2);

		DataItem[] healthPer1000 = new DataItem[healthData.length];
		int count = 0;
		for (int i = 0; i < healthData.length; i++) {	// completes required computations for health expenditure per 1000 people
			if (healthData[i] != null && popData[i] != null && gdpData[i] != null) {
				if (healthData[i].getValue() != 0.0 && popData[i].getValue() != 0.0 && gdpData[i].getValue() != 0.0) {
					float newVal = (healthData[i].getValue() * gdpData[i].getValue()) / (popData[i].getValue() / 1000);
					DataItem newData = new DataItem(healthData[i].getYear(), newVal);
					healthPer1000[count] = newData;
					count++;
				}
			}
		}

		DataItem[][] data = { healthPer1000, hospital(abbrv, year1, year2) };
		return data;
	}

	/**
	 * Method returns 2d data item list holding all indicator data for selected country/year range
	 * @param abbrv country abbreviation
	 * @param year1 start year
	 * @param year2 end year
	 * @return 2d data item list with all required data
	 */
	public DataItem[][] analysis7(String abbrv, String year1, String year2) {

		DataItem[][] data = { healthPerCapita(abbrv, year1, year2), infant(abbrv, year1, year2) };
		return data;
	}

	/**
	 * Method returns 2d data item list holding all indicator data for selected country/year range
	 * @param abbrv country abbreviation
	 * @param year1 start year
	 * @param year2 end year
	 * @return 2d data item list with all required data
	 */
	public DataItem[][] analysis8(String abbrv, String year1, String year2) {

		DataItem[][] data = { education(abbrv, year1, year2), health(abbrv, year1, year2) };
		return data;
	}

	/**
	 * Returns dataitem list of population data for specified country
	 * @param countryAbbrv country abbreviation
	 * @param year1 start year
	 * @param year2 end year
	 * @return dataitem list of required data for further computation/analysis
	 */
	public DataItem[] population(String countryAbbrv, String year1, String year2) {
		GetData data = new GetData();
		DataItem[] popData = data.getData(POPULATION, year1, year2, countryAbbrv);
		if (popData.length > 1) {
			return popData;
		} else
			return null;
	}

	/**
	 * Returns dataitem list of co2 data for specified country
	 * @param countryAbbrv country abbreviation
	 * @param year1 start year
	 * @param year2 end year
	 * @return dataitem list of required data for further computation/analysis
	 */
	public DataItem[] co2(String countryAbbrv, String year1, String year2) {
		GetData data = new GetData();
		DataItem[] popData = data.getData(CO2, year1, year2, countryAbbrv);

		if (popData.length > 1) {
			return popData;
		} else
			return null;
	}

	/**
	 * Returns dataitem list of pollution data for specified country
	 * @param countryAbbrv country abbreviation
	 * @param year1 start year
	 * @param year2 end year
	 * @return dataitem list of required data for further computation/analysis
	 */
	public DataItem[] pollution(String countryAbbrv, String year1, String year2) {
		GetData data = new GetData();
		DataItem[] popData = data.getData(POLLUTION, year1, year2, countryAbbrv);

		if (popData.length > 1) {
			return popData;
		} else
			return null;
	}

	/**
	 * Returns dataitem list of forest data for specified country
	 * @param countryAbbrv country abbreviation
	 * @param year1 start year
	 * @param year2 end year
	 * @return dataitem list of required data for further computation/analysis
	 */
	public DataItem[] forest(String countryAbbrv, String year1, String year2) {
		GetData data = new GetData();
		DataItem[] popData = data.getData(FOREST, year1, year2, countryAbbrv);

		if (popData.length > 1) {
			return popData;
		} else
			return null;
	}

	/**
	 * Returns dataitem list of energy data for specified country
	 * @param countryAbbrv country abbreviation
	 * @param year1 start year
	 * @param year2 end year
	 * @return dataitem list of required data for further computation/analysis
	 */
	public DataItem[] energy(String countryAbbrv, String year1, String year2) {
		GetData data = new GetData();
		DataItem[] popData = data.getData(ENERGY, year1, year2, countryAbbrv);

		if (popData.length > 1) {
			return popData;
		} else
			return null;
	}

	/**
	 * Returns dataitem list of gdp data for specified country
	 * @param countryAbbrv country abbreviation
	 * @param year1 start year
	 * @param year2 end year
	 * @return dataitem list of required data for further computation/analysis
	 */
	public DataItem[] gdp(String countryAbbrv, String year1, String year2) {
		GetData data = new GetData();
		DataItem[] popData = data.getData(GDP, year1, year2, countryAbbrv);

		if (popData.length > 1) {
			return popData;
		} else
			return null;
	}

	/**
	 * Returns dataitem list of hospital data for specified country
	 * @param countryAbbrv country abbreviation
	 * @param year1 start year
	 * @param year2 end year
	 * @return dataitem list of required data for further computation/analysis
	 */
	public DataItem[] hospital(String countryAbbrv, String year1, String year2) {
		GetData data = new GetData();
		DataItem[] popData = data.getData(HOSPITAL, year1, year2, countryAbbrv);

		if (popData.length > 1) {
			return popData;
		} else
			return null;
	}

	/**
	 * Returns dataitem list of education data for specified country
	 * @param countryAbbrv country abbreviation
	 * @param year1 start year
	 * @param year2 end year
	 * @return dataitem list of required data for further computation/analysis
	 */
	public DataItem[] education(String countryAbbrv, String year1, String year2) {
		GetData data = new GetData();
		DataItem[] popData = data.getData(EDUCATION, year1, year2, countryAbbrv);

		if (popData.length > 1) {
			return popData;
		} else
			return null;
	}

	/**
	 * Returns dataitem list of mortality data for specified country
	 * @param countryAbbrv country abbreviation
	 * @param year1 start year
	 * @param year2 end year
	 * @return dataitem list of required data for further computation/analysis
	 */
	public DataItem[] mortality(String countryAbbrv, String year1, String year2) {
		GetData data = new GetData();
		DataItem[] popData = data.getData(MORTALITY, year1, year2, countryAbbrv);

		if (popData.length > 1) {
			return popData;
		} else
			return null;
	}

	/**
	 * Returns dataitem list of health data for specified country
	 * @param countryAbbrv country abbreviation
	 * @param year1 start year
	 * @param year2 end year
	 * @return dataitem list of required data for further computation/analysis
	 */
	public DataItem[] healthPerCapita(String countryAbbrv, String year1, String year2) {
		GetData data = new GetData();
		DataItem[] popData = data.getData(HEALTHPERCAPITA, year1, year2, countryAbbrv);

		if (popData.length > 1) {
			return popData;
		} else
			return null;
	}

	/**
	 * Returns dataitem list of health data for specified country
	 * @param countryAbbrv country abbreviation
	 * @param year1 start year
	 * @param year2 end year
	 * @return dataitem list of required data for further computation/analysis
	 */
	public DataItem[] health(String countryAbbrv, String year1, String year2) {
		GetData data = new GetData();
		DataItem[] popData = data.getData(HEALTH, year1, year2, countryAbbrv);

		if (popData.length > 1) {
			return popData;
		} else
			return null;
	}

	/**
	 * Returns dataitem list of infant mortality data for specified country
	 * @param countryAbbrv country abbreviation
	 * @param year1 start year
	 * @param year2 end year
	 * @return dataitem list of required data for further computation/analysis
	 */
	public DataItem[] infant(String countryAbbrv, String year1, String year2) {
		GetData data = new GetData();
		DataItem[] popData = data.getData(INFANT, year1, year2, countryAbbrv);

		if (popData.length > 1) {
			return popData;
		} else
			return null;
	}
}