/**
 * Class creates report text to show analysis data in text box
 * @author Kaden Oseen, Cole Letsche
 */

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Report {

	private static JTextArea report;
	public static JScrollPane scroll;

	/**
	 * Method creates report frame
	 */
	private void create() {
		report = new JTextArea();
		report.setEditable(false); // formats size and makes sure it cannot be edited by user
		report.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		report.setBackground(Color.white);
	}

	/**
	 * Method creates report for analysis 1
	 * @param data 2d list of data required for report
	 * @param pane panel that report is rendered to
	 */
	public void report1(DataItem[][] data, JPanel pane) {

		create();

		String reportMessage = "C02 Emissions vs Energy Use vs Air pollution\n" + "==============================\n";

		for (int i = 0; i < data[0].length; i++) {	// creates report message to be viewed in report when analysis done
			if (data[0][i] != null && data[0][i].getValue() != 0.0) {
				reportMessage += "\nYear " + data[0][i].getYear() + ":\n\tCO2 Emissions (metric tons per capita) => "
						+ data[0][i].getValue();
				if (data.length > 1 && data[1][i].getValue() != 0.0)
					reportMessage += "\n\tEnergy Use (kg of oil equivalent) => " + data[1][i].getValue();
				if (data.length > 2 && data[2][i].getValue() != 0.0)
					reportMessage += "\n\tAir Pollution (micrograms per cubic meter) => " + data[2][i].getValue();
			}
		}

		// sets report text and formats scrolling bar to allow all data to be seen
		report.setText(reportMessage);
		report.setCaretPosition(0);
		scroll = new JScrollPane(report);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		pane.add(scroll, BorderLayout.CENTER);
	}

	/**
	 * Method creates report for analysis 2
	 * @param data 2d list of data required for report
	 * @param pane panel that report is rendered to
	 */
	public void report2(DataItem[][] data, JPanel pane) {

		create();

		String reportMessage = "Air Pollution vs Forest Area\n" + "==============================\n";

		for (int i = 0; i < data[0].length; i++) {
			if (data[0][i] != null && data[0][i].getValue() != 0.0) {
				reportMessage += "\nYear " + data[0][i].getYear() + ":\n\tForest Area (% of land area) => "
						+ data[0][i].getValue();
				if (data.length > 1 && data[1][i].getValue() != 0.0)
					reportMessage += "\n\tAir Pollution (micrograms per cubic meter) => " + data[1][i].getValue();
			}
		}

		report.setText(reportMessage);
		report.setCaretPosition(0);
		scroll = new JScrollPane(report);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		pane.add(scroll, BorderLayout.CENTER);
	}

	/**
	 * Method creates report for analysis 3
	 * @param data 2d list of data required for report
	 * @param pane panel that report is rendered to
	 */
	public void report3(DataItem[][] data, JPanel pane) {

		create();

		String reportMessage = "Ratio CO2 Emissions vs GDP Per Capita\n" + "==============================\n";

		for (int i = 0; i < data[0].length; i++) {
			if (data[0][i] != null && data[0][i].getValue() != 0.0) {
				reportMessage += "\nYear " + data[0][i].getYear()
						+ "\n\tRatio CO2 Emissions (metric tons per capita) => " + data[0][i].getValue();
				if (data.length > 1 && data[1][i].getValue() != 0.0)
					reportMessage += "\n\tGDP Per Capita ($US) => " + data[1][i].getValue();
			}
		}

		report.setText(reportMessage);
		report.setCaretPosition(0);
		scroll = new JScrollPane(report);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		pane.add(scroll, BorderLayout.CENTER);

	}

	/**
	 * Method creates report for analysis 4
	 * @param data 2d list of data required for report
	 * @param pane panel that report is rendered to
	 */
	public void report4(DataItem[][] data, JPanel pane) {

		create();

		String reportMessage = "Average Forest Area\n" + "==============================\n";

		for (int i = 0; i < data[0].length; i++) {
			if (data[0][i] != null && data[0][i].getValue() != 0.0) {
				reportMessage += "\nYear " + data[0][i].getYear() + "\n\tForest Area (% of land area) => "
						+ data[0][i].getValue();
			}
		}

		report.setText(reportMessage);
		report.setCaretPosition(0);
		scroll = new JScrollPane(report);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		pane.add(scroll, BorderLayout.CENTER);

	}

	/**
	 * Method creates report for analysis 5
	 * @param data 2d list of data required for report
	 * @param pane panel that report is rendered to
	 */
	public void report5(DataItem[][] data, JPanel pane) {

		create();

		String reportMessage = "Government Expenditure on Education\n" + "==============================\n";

		for (int i = 0; i < data[0].length; i++) {
			if (data[0][i] != null && data[0][i].getValue() != 0.0) {
				reportMessage += "\nYear " + data[0][i].getYear() + "\n\tGov't. Exp. on Education (% of GDP) => "
						+ data[0][i].getValue();
			}
		}

		report.setText(reportMessage);
		report.setCaretPosition(0);
		scroll = new JScrollPane(report);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		pane.add(scroll, BorderLayout.CENTER);

	}

	/**
	 * Method creates report for analysis 6
	 * @param data 2d list of data required for report
	 * @param pane panel that report is rendered to
	 */
	public void report6(DataItem[][] data, JPanel pane) {

		create();

		String reportMessage = "Ratio Hospital Beds vs Current Health Expenditure\n"
				+ "==============================\n";

		for (int i = 0; i < data[0].length; i++) {
			if (data[0][i] != null && data[0][i].getValue() != 0.0) {
				reportMessage += "\nYear " + data[0][i].getYear() + "\n\tRatio Hospital Beds (per 1,000 people) => "
						+ data[0][i].getValue();
				if (data.length > 1 && data[1][i].getValue() != 0.0)
					reportMessage += "\n\tCurrent Health Expenditure (per 1,000 people) => " + data[1][i].getValue();
			}
		}

		report.setText(reportMessage);
		report.setCaretPosition(0);
		scroll = new JScrollPane(report);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		pane.add(scroll, BorderLayout.CENTER);

	}

	/**
	 * Method creates report for analysis 7
	 * @param data 2d list of data required for report
	 * @param pane panel that report is rendered to
	 */
	public void report7(DataItem[][] data, JPanel pane) {

		create();

		String reportMessage = "Health Expenditure Per Capita vs Infant Mortality Rate\n"
				+ "==============================\n";

		for (int i = 0; i < data[0].length; i++) {
			if (data[0][i] != null && data[0][i].getValue() != 0.0) {
				reportMessage += "\nYear " + data[0][i].getYear() + "\n\tHealth Exp. Per Capita => "
						+ data[0][i].getValue();
				if (data.length > 1 && data[1][i].getValue() != 0.0)
					reportMessage += "\n\tInfant Mortality Rate (per 1,000 live births) => " + data[1][i].getValue();
			}
		}

		report.setText(reportMessage);
		report.setCaretPosition(0);
		scroll = new JScrollPane(report);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		pane.add(scroll, BorderLayout.CENTER);
	}

	public void report8(DataItem[][] data, JPanel pane) {

		create();

		String reportMessage = "Government Expenditure on Education vs Health Expenditure\n"
				+ "==============================\n";

		for (int i = 0; i < data[0].length; i++) {
			if (data[0][i] != null && data[0][i].getValue() != 0.0) {
				reportMessage += "\nYear " + data[0][i].getYear() + "\n\tGov't. Exp. on Education (% of GDP) => "
						+ data[0][i].getValue();
				if (data.length > 1 && data[1][i].getValue() != 0.0)
					reportMessage += "\n\tHealth Expenditure (% of GDP) => " + data[1][i].getValue();
			}
		}

		report.setText(reportMessage);
		report.setCaretPosition(0);
		scroll = new JScrollPane(report);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		pane.add(scroll, BorderLayout.CENTER);
	}
}
