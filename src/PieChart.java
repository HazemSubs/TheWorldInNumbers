/**
 * Class creates pie charts for analysis types that require them
 * @author Kaden Oseen, Hazeem Sabsabi
 */

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.util.TableOrder;
import org.jfree.data.category.DefaultCategoryDataset;

public class PieChart {

	public static ChartPanel chartPanel;

	/**
	 * Method creates pie chart specific for analysis 4
	 * @param data 2d list of data required to build graph 
	 * @param west panel that graph is rendered to
	 */
	public void pie4(DataItem[][] data, JPanel west) {

		float firstVal = 0;
		int firstYear = 0;
		float lastVal = 0;
		int lastYear = 0;
		boolean firstDone = false; 
		for (int i = 0; i < data[0].length; i++) {	// gets first year and value from data
			if (data[0][i] != null && !firstDone) {
				firstVal = data[0][i].getValue();
				firstYear = data[0][i].getYear();
				if (firstVal != 0) {
					firstDone = true;
					break;
				}
			}
		}

		boolean lastDone = false;
		for (int i = data[0].length - 1; i > 0; i--) {	// gets last year and value from data
			if (data[0][i] != null && !lastDone) {
				lastVal = data[0][i].getValue();
				lastYear = data[0][i].getYear();
				if (lastVal != 0) {
					lastDone = true;
					break;
				}
			}
		}

		// creates dataset to hold values to put in chart
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(firstVal, "Forest Area", String.valueOf(firstYear));
		dataset.addValue(100 - firstVal, "Other Area", String.valueOf(firstYear));
		dataset.addValue(lastVal, "Forest Area", String.valueOf(lastYear));
		dataset.addValue(100 - lastVal, "Other Area", String.valueOf(lastYear));

		// creates pie chart
		JFreeChart pieChart = ChartFactory.createMultiplePieChart("Forest Area: " + firstYear + " vs " + lastYear,
				dataset, TableOrder.BY_COLUMN, true, true, false);

		// formats pie chart and adds to UI frame
		chartPanel = new ChartPanel(pieChart);
		chartPanel.setPreferredSize(new Dimension(400, 300));
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		chartPanel.setBackground(Color.white);
		west.add(chartPanel);
	}

	/**
	 * Method creates pie chart specific for analysis 5
	 * @param data 2d list of data required to build graph 
	 * @param west panel that graph is rendered to
	 */
	public void pie5(DataItem[][] data, JPanel west) {
		float firstVal = 0;
		int firstYear = 0;
		float lastVal = 0;
		int lastYear = 0;
		boolean firstDone = false;
		for (int i = 0; i < data[0].length; i++) {
			if (data[0][i] != null && !firstDone) {
				firstVal = data[0][i].getValue();
				firstYear = data[0][i].getYear();
				if (firstVal != 0) {
					firstDone = true;
					break;
				}
			}
		}
		boolean lastDone = false;
		for (int i = data[0].length - 1; i > 0; i--) {
			if (data[0][i] != null && !lastDone) {
				lastVal = data[0][i].getValue();
				lastYear = data[0][i].getYear();
				if (lastVal != 0) {
					lastDone = true;
					break;
				}
			}
		}

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(firstVal, "Education", String.valueOf(firstYear));
		dataset.addValue(100 - firstVal, "Other", String.valueOf(firstYear));
		dataset.addValue(lastVal, "Education", String.valueOf(lastYear));
		dataset.addValue(100 - lastVal, "Other", String.valueOf(lastYear));

		JFreeChart pieChart = ChartFactory.createMultiplePieChart(
				"Gov't. Exp. on Education (% of GDP): " + firstYear + " vs " + lastYear, dataset, TableOrder.BY_COLUMN,
				true, true, false);

		chartPanel = new ChartPanel(pieChart);
		chartPanel.setPreferredSize(new Dimension(400, 300));
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		chartPanel.setBackground(Color.white);
		west.add(chartPanel);
	}
}
