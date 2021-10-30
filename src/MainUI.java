
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This class handles all of the UI components displayed to the user
 * @author Cole Letsche, Kaden Oseen, Hazem Sabsabi, Mark Nirenshtein
 */

public class MainUI extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Static instance of the MainUI class
	 */
	public static MainUI instance;

	/**
	 * Static JFrame dimensions 
	 */
	private static final Dimension FRAME_SIZE = new Dimension(1440, 900);

	private Countries[] countryList;

	/**
	 * These fields are used to keep track of the users input
	 */
	private String countrySelected = "Canada";
	private String countryAbbrv = "CAN";
	private int startYear;
	private int endYear;
	private int analysisType = 0;
	int prevSelectedIndex = 0;

	/**
	 * Swing components used in the UI
	 */
	private static JComboBox<String> countriesList;
	private static JComboBox<String> fromList;
	private static JComboBox<String> toList;
	private static JComboBox<String> methodsList;
	private static JComboBox<String> viewsList;
	private static JPanel west;
	private static JFrame frame;

	/**
	 * Keeps track of the visible viewers at any given time
	 */
	private ArrayList<String> visibleViewers = new ArrayList<String>(
			Arrays.asList("Line Chart", "Bar Chart", "Scatter Chart", "Report"));

	/**
	 * Instance of the Analysis class
	 */
	private Analysis analysis = new Analysis();

	/**
	 * Instances of the graph creators
	 */
	private Report report = new Report();
	private BarChart barchart = new BarChart();
	private LineChart linechart = new LineChart();
	private ScatterChart scatterchart = new ScatterChart();
	private PieChart piechart = new PieChart();

	/**
	 * Launches the UI and inits frame settings
	 */
	public void launchUI() {

		frame = MainUI.getInstance();
		frame.setSize(FRAME_SIZE);
		frame.setPreferredSize(FRAME_SIZE);
		frame.setMaximumSize(FRAME_SIZE);
		frame.setMinimumSize(FRAME_SIZE);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Returns a static instance of this class for JFrame usage
	 * @return static instance of this class for JFrame usage
	 */
	public static MainUI getInstance() {
		if (instance == null)
			instance = new MainUI();

		return instance;
	}

	/**
	 * Constructor for the main UI
	 */
	MainUI() {
		// Set window title
		super("Country Statistics");

		// Set top bar
		JLabel chooseCountryLabel = new JLabel("Choose a country: ");
		Vector<String> countriesNames = new Vector<String>();
		CountryList temp = new CountryList();
		countryList = temp.getCountryData();
		for (int i = 0; i < countryList.length; i++) {
			if (countryList[i] != null)
				countriesNames.add(countryList[i].country);
		}

		// Add list of countries to drop down menu
		countriesList = new JComboBox<String>(countriesNames);
		
		// Default to Canada
		countriesList.setSelectedIndex(35);

		// Add action listener for when user selects country
		countriesList.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				// Get the country that the user has selected
				String country = (String) countriesList.getSelectedItem();
				if (country != null)
					countrySelected = country;

				// Find the country in the country list
				for (Countries c : countryList) {
					if (c.country.equalsIgnoreCase(countrySelected)) {

						int lastYear;
						if (c.year2.equals("Now"))
							lastYear = 2020;
						else
							lastYear = Integer.parseInt(c.year2);

						// Set years for analysis
						startYear = Integer.parseInt(c.year1);
						endYear = lastYear;

						// from list
						Vector<String> from = new Vector<String>();
						for (int i = startYear; i <= endYear; i++)
							from.add("" + i);

						// to list
						Vector<String> to = new Vector<String>();
						for (int i = endYear; i >= startYear; i--)
							to.add("" + i);

						// Dynamically add the years to the 'from' and 'to' drop downs
						fromList.removeAllItems();
						for (String s : from)
							fromList.addItem(s);

						toList.removeAllItems();
						for (String s : to)
							toList.addItem(s);

						// Change type of analysis back to top of list
						methodsList.setSelectedIndex(0);
						break;
					}
				}

				// Reset the viewer every time the country is changed.
				resetPane();
				visibleViewers = new ArrayList<String>(
						Arrays.asList("Line Chart", "Bar Chart", "Scatter Chart", "Report"));

			}
		});

		// Create labels for the year drop down menu
		JLabel from = new JLabel("From");
		JLabel to = new JLabel("To");

		// From and To years drop down initialization
		Vector<String> years = new Vector<String>();
		for (int i = 1962; i <= 2020; i++) {
			years.add("" + i);
		}
		fromList = new JComboBox<String>(years);
		
		// Set to 2010 for Canada
		fromList.setSelectedIndex(48);
		
		// Listen for when the user changes the year
		fromList.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				// Reset the viewers every time the year is changed
				resetPane();
				visibleViewers = new ArrayList<String>(
						Arrays.asList("Line Chart", "Bar Chart", "Scatter Chart", "Report"));
			}
		});

		years = new Vector<String>();
		for (int i = 2020; i >= 1962; i--) {
			years.add("" + i);
		}

		toList = new JComboBox<String>(years);
		
		// Listen for when the user changes the year
		toList.addActionListener(new ActionListener() {

			// Reset the viewers every time the year is changed
			public void actionPerformed(ActionEvent e) {
				resetPane();
				visibleViewers = new ArrayList<String>(
						Arrays.asList("Line Chart", "Bar Chart", "Scatter Chart", "Report"));
			}
		});

		// Add all the relevant components to the north panel of the JFRame
		JPanel north = new JPanel();
		north.add(chooseCountryLabel);
		north.add(countriesList);
		north.add(from);
		north.add(fromList);
		north.add(to);
		north.add(toList);

		// Set bottom bar
		JButton recalculate = new JButton("Recalculate");

		// Action listener for the recalculate button
		recalculate.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				// Clear the screen
				resetPane();

				// Get the years that the user selects
				startYear = Integer.parseInt((String) fromList.getSelectedItem());
				endYear = Integer.parseInt((String) toList.getSelectedItem());

				// Notify the user that they have selected an invalid year.
				if (startYear >= endYear || endYear <= startYear) {
					NotifyUser.notify("Invalid Year Range! Try again!");
					fromList.setSelectedIndex(0);
					toList.setSelectedIndex(0);
					return;
				}

				// Cement all of the chosen user options and put them into memory
				countrySelected = (String) countriesList.getSelectedItem();

				// Get the abbreviation of the country to pass to GetData
				for (Countries c : countryList)
					if (c.country.equals(countrySelected)) {
						countryAbbrv = c.abbrv;
						break;
					}

				// Get the type of analysis
				analysisType = methodsList.getSelectedIndex();

				if (analysisType == 3 || analysisType == 4) {
					visibleViewers = new ArrayList<String>(
							Arrays.asList("Line Chart", "Bar Chart", "Pie Chart", "Report"));
					addGraph(analysisType, "Line Chart");
					addGraph(analysisType, "Bar Chart");
					addGraph(analysisType, "Pie Chart");
					addGraph(analysisType, "Report");
				} else {
					visibleViewers = new ArrayList<String>(
							Arrays.asList("Line Chart", "Bar Chart", "Scatter Chart", "Report"));
					addGraph(analysisType, "Line Chart");
					addGraph(analysisType, "Bar Chart");
					addGraph(analysisType, "Scatter Chart");
					addGraph(analysisType, "Report");
				}

				west.revalidate();
				west.repaint();
			}
		});

		// Initialize the viewers drop-down
		JLabel viewsLabel = new JLabel("Available Views: ");

		Vector<String> viewsNames = new Vector<String>(
				Arrays.asList("Line Chart", "Bar Chart", "Scatter Chart", "Report"));

		viewsList = new JComboBox<String>(viewsNames);

		// Adding graphs
		JButton addView = new JButton("+");
		
		// Listen for when the user wants to add a new graph
		addView.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				// Get the selected viewer
				String selectedViewer = (String) viewsList.getSelectedItem();
				for (String s : visibleViewers) {
					if (selectedViewer.equalsIgnoreCase(s)) {
						// Notify user that graph is already in
						NotifyUser.notify("Selected Viewer Already Visible!");
						return;
					}
				}

				// Add the selected viewer that the user want to see to the control list
				visibleViewers.add(selectedViewer);

				// Make the graph visible
				addGraph(analysisType, selectedViewer);

				west.revalidate();
				west.repaint();
			}
		});

		// Removing graphs
		JButton removeView = new JButton("-");
		
		// Listen for when the user wants to remove a new graph
		removeView.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				// Get the selected viewer
				String selectedViewer = (String) viewsList.getSelectedItem();

				boolean found = false;
				for (String s : visibleViewers) {
					if (selectedViewer.equalsIgnoreCase(s))
						// Notify user that graph is already in
						found = true;
				}

				// In the case that the viewer is already removed
				if (!found) {
					NotifyUser.notify("Selected Viewer Already Removed!");
					return;
				}

				// Remove the viewer from control list
				visibleViewers.remove(selectedViewer);

				// Make the graph invisible
				if (selectedViewer.equalsIgnoreCase("Report")) {
					west.remove(Report.scroll);
				} else if (selectedViewer.equalsIgnoreCase("Bar Chart")) {
					west.remove(BarChart.chartPanel);
				} else if (selectedViewer.equalsIgnoreCase("Scatter Chart")) {
					west.remove(ScatterChart.chartPanel);
				} else if (selectedViewer.equalsIgnoreCase("Line Chart")) {
					west.remove(LineChart.chartPanel);
				} else {
					west.remove(PieChart.chartPanel);
				}

				west.revalidate();
				west.repaint();
			}
		});

		JLabel methodLabel = new JLabel("        Choose analysis method: ");

		Vector<String> methodsNames = new Vector<String>();

		String[] analyses = { "CO2 Emissions vs. Energy Use vs. Air Pollution", "Air Pollution vs. Forest Area",
				"Ratio CO2 Emissions vs. GDP Per Capita", "Average Forest Area", "Government Expenditure on Education",
				"Ratio of Hospital Beds vs. Current Health Expenditure",
				"Health Expenditure Per Capita vs. Infant Mortality Rate",
				"Government Expenditure on Education vs. Health Expenditure" };

		for (int i = 0; i < analyses.length; i++) {
			methodsNames.add(analyses[i]);
		}

		methodsList = new JComboBox<String>(methodsNames);
		
		// Listen for when a user to change the analysis type
		methodsList.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				int type = methodsList.getSelectedIndex();

				// Remove all of the old viewers when a new analysis method is chosen

				if (prevSelectedIndex != type) {
					resetPane();
				}

				prevSelectedIndex = type;

				Vector<String> viewsNames = new Vector<String>(
						Arrays.asList("Pie Chart", "Line Chart", "Bar Chart", "Scatter Chart", "Report"));

				viewsList.removeAllItems();

				if (type == 3 || type == 4) {

					viewsNames.remove(3);
					for (int i = 0; i < viewsNames.size(); i++)
						viewsList.addItem(viewsNames.get(i));
				} else {
					for (int i = 1; i < viewsNames.size(); i++)
						viewsList.addItem(viewsNames.get(i));
				}
			}
		});

		JPanel south = new JPanel();
		south.add(viewsLabel);
		south.add(viewsList);
		south.add(addView);
		south.add(removeView);

		south.add(methodLabel);
		south.add(methodsList);
		south.add(recalculate);

		// Set charts region
		west = new JPanel();
		west.setLayout(new GridLayout(2, 0));

		getContentPane().add(north, BorderLayout.PAGE_START);
		getContentPane().add(west, BorderLayout.CENTER);
		getContentPane().add(south, BorderLayout.PAGE_END);
	}

	/**
	 * This method resets the center pane
	 */
	private void resetPane() {
		frame.remove(west);
		frame.revalidate();
		frame.repaint();

		west = new JPanel();
		west.setLayout(new GridLayout(2, 0));
		getContentPane().add(west, BorderLayout.CENTER);
	}

	/**
	 * This method will add a graph to the viewer depending on the analysis selected and the type of graph needed
	 * @param analysisType The type of analysis
	 * @param graphType The type of graph
	 */
	private void addGraph(int analysisType, String graphType) {

		DataItem[][] data;
		// Depending on what analysis type is selected
		switch (analysisType) {

		case 0:
			// C02 Emissions vs Energy Use vs Air pollution

			// Fetch the needed data
			data = analysis.analysis1(countryAbbrv, Integer.toString(startYear), Integer.toString(endYear));

			if (graphType.equalsIgnoreCase("Line Chart"))
				linechart.linechart1(data, west);
			else if (graphType.equalsIgnoreCase("Bar Chart"))
				barchart.barchart1(data, west);
			else if (graphType.equalsIgnoreCase("Scatter Chart"))
				scatterchart.scatter1(data, west);
			else if (graphType.equalsIgnoreCase("Report"))
				report.report1(data, west);
			break;

		case 1:

			// Air pollution vs forest area

			// Fetch the needed data
			data = analysis.analysis2(countryAbbrv, Integer.toString(startYear), Integer.toString(endYear));

			if (graphType.equalsIgnoreCase("Line Chart"))
				linechart.linechart2(data, west);
			else if (graphType.equalsIgnoreCase("Bar Chart"))
				barchart.barchart2(data, west);
			else if (graphType.equalsIgnoreCase("Scatter Chart"))
				scatterchart.scatter2(data, west);
			else if (graphType.equalsIgnoreCase("Report"))
				report.report2(data, west);
			break;

		case 2:

			// Ratio C02 Emissions vs GDP Per Capita

			// Fetch the needed data
			data = analysis.analysis3(countryAbbrv, Integer.toString(startYear), Integer.toString(endYear));

			if (graphType.equalsIgnoreCase("Line Chart"))
				linechart.linechart3(data, west);
			else if (graphType.equalsIgnoreCase("Bar Chart"))
				barchart.barchart3(data, west);
			else if (graphType.equalsIgnoreCase("Scatter Chart"))
				scatterchart.scatter3(data, west);
			else if (graphType.equalsIgnoreCase("Report"))
				report.report3(data, west);
			break;

		case 3:

			// Average Forest Area

			// Fetch the needed data
			data = analysis.analysis4(countryAbbrv, Integer.toString(startYear), Integer.toString(endYear));

			if (graphType.equalsIgnoreCase("Line Chart"))
				linechart.linechart4(data, west);
			else if (graphType.equalsIgnoreCase("Bar Chart"))
				barchart.barchart4(data, west);
			else if (graphType.equalsIgnoreCase("Report"))
				report.report4(data, west);
			else if (graphType.equalsIgnoreCase("Pie Chart"))
				piechart.pie4(data, west);
			break;

		case 4:

			// Government Expenditure on Education

			// Fetch the needed data
			data = analysis.analysis5(countryAbbrv, Integer.toString(startYear), Integer.toString(endYear));

			if (graphType.equalsIgnoreCase("Line Chart"))
				linechart.linechart5(data, west);
			else if (graphType.equalsIgnoreCase("Bar Chart"))
				barchart.barchart5(data, west);
			else if (graphType.equalsIgnoreCase("Report"))
				report.report5(data, west);
			else if (graphType.equalsIgnoreCase("Pie Chart"))
				piechart.pie5(data, west);
			break;

		case 5:

			// Ratio of Hospital Beds vs Current Health Expenditure

			// Fetch the needed data
			data = analysis.analysis6(countryAbbrv, Integer.toString(startYear), Integer.toString(endYear));

			if (graphType.equalsIgnoreCase("Line Chart"))
				linechart.linechart6(data, west);
			else if (graphType.equalsIgnoreCase("Bar Chart"))
				barchart.barchart6(data, west);
			else if (graphType.equalsIgnoreCase("Scatter Chart"))
				scatterchart.scatter6(data, west);
			else if (graphType.equalsIgnoreCase("Report"))
				report.report6(data, west);
			break;

		case 6:

			// Health Expenditure Per Capita vs Infant Mortality Rate

			// Fetch the needed data
			data = analysis.analysis7(countryAbbrv, Integer.toString(startYear), Integer.toString(endYear));

			if (graphType.equalsIgnoreCase("Line Chart"))
				linechart.linechart7(data, west);
			else if (graphType.equalsIgnoreCase("Bar Chart"))
				barchart.barchart7(data, west);
			else if (graphType.equalsIgnoreCase("Scatter Chart"))
				scatterchart.scatter7(data, west);
			else if (graphType.equalsIgnoreCase("Report"))
				report.report7(data, west);
			break;

		case 7:

			// Government Expenditure on Education vs Health Expenditure

			// Fetch the needed data
			data = analysis.analysis8(countryAbbrv, Integer.toString(startYear), Integer.toString(endYear));

			if (graphType.equalsIgnoreCase("Line Chart"))
				linechart.linechart8(data, west);
			else if (graphType.equalsIgnoreCase("Bar Chart"))
				barchart.barchart8(data, west);
			else if (graphType.equalsIgnoreCase("Scatter Chart"))
				scatterchart.scatter8(data, west);
			else if (graphType.equalsIgnoreCase("Report"))
				report.report8(data, west);
			break;
		default:
			break;
		}

		west.revalidate();
		west.repaint();
	}
}