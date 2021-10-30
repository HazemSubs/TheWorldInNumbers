/**
 * Class creates scatter charts for analysis types that require them
 * @author Kaden Oseen, Mark Nirenshtein
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.Year;

public class ScatterChart {

	public static ChartPanel chartPanel;

	/**
	 * Method creates scatter chart for analysis type 1
	 * @param data 2d list of data required to build graph 
	 * @param west panel that graph is rendered to
	 */
	public void scatter1(DataItem[][] data, JPanel west) {

		// creates required number of series (varies depending on number of series in type of analysis)
		TimeSeries series1 = new TimeSeries("CO2 Emissions (metric tons per capita)");
		for (int i = 0; i < data[0].length; i++) {
			if (data[0][i] != null && data[0][i].getValue() != 0)	// adds valid values/years to series
				series1.add(new Year(data[0][i].getYear()), data[0][i].getValue());
		}
		TimeSeries series2 = new TimeSeries("Energy Use (kg oil equivalent/capita)");
		for (int i = 0; i < data[1].length; i++) {
			if (data[1][i] != null && data[1][i].getValue() != 0)
				series2.add(new Year(data[1][i].getYear()), data[1][i].getValue());
		}

		TimeSeriesCollection dataset2 = new TimeSeriesCollection();
		dataset2.addSeries(series2);

		TimeSeries series3 = new TimeSeries("Air Pollution (micrograms/cubic meter)");
		for (int i = 0; i < data[2].length; i++) {
			if (data[2][i] != null && data[2][i].getValue() != 0)
				series3.add(new Year(data[2][i].getYear()), data[2][i].getValue());
		}

		TimeSeriesCollection dataset = new TimeSeriesCollection();
		dataset.addSeries(series1);
		dataset.addSeries(series3);

		// Creates plot to hold scatter values
		XYPlot plot = new XYPlot();
		XYItemRenderer itemrenderer1 = new XYLineAndShapeRenderer(false, true);
		XYItemRenderer itemrenderer2 = new XYLineAndShapeRenderer(false, true);

		// Formats size and location of scatter plot
		plot.setDataset(0, dataset);
		plot.setRenderer(0, itemrenderer1);
		DateAxis domainAxis = new DateAxis("Year");
		plot.setDomainAxis(domainAxis);
		plot.setRangeAxis(new NumberAxis("CO2 Emissions and Air Pollution"));

		plot.setDataset(1, dataset2);
		plot.setRenderer(1, itemrenderer2);
		plot.setRangeAxis(1, new NumberAxis("Energy Use (kg of oil equivalent)"));

		plot.mapDatasetToRangeAxis(0, 0);
		plot.mapDatasetToRangeAxis(1, 1);

		// Creates scatter chart
		JFreeChart scatterChart = new JFreeChart("CO2 Emissions vs. Energy Use vs Air Pollution",
				new Font("Serif", java.awt.Font.BOLD, 18), plot, true);

		// Formats and creates view of scatter chart
		chartPanel = new ChartPanel(scatterChart);
		chartPanel.setPreferredSize(new Dimension(400, 300));
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		chartPanel.setBackground(Color.white);
		west.add(chartPanel);
	}

	/**
	 * Method creates scatter chart for analysis type 2
	 * @param data 2d list of data required to build graph 
	 * @param west panel that graph is rendered to
	 */
	public void scatter2(DataItem[][] data, JPanel west) {

		TimeSeries series1 = new TimeSeries("Forest Area (% of land)");
		for (int i = 0; i < data[0].length; i++) {
			if (data[0][i] != null && data[0][i].getValue() != 0)
				series1.add(new Year(data[0][i].getYear()), data[0][i].getValue());
		}
		TimeSeries series2 = new TimeSeries("Air Pollution (micrograms/cubic meter)");
		for (int i = 0; i < data[1].length; i++) {
			if (data[1][i] != null && data[1][i].getValue() != 0)
				series2.add(new Year(data[1][i].getYear()), data[1][i].getValue());
		}

		TimeSeriesCollection dataset2 = new TimeSeriesCollection();
		dataset2.addSeries(series2);

		TimeSeriesCollection dataset = new TimeSeriesCollection();
		dataset.addSeries(series1);

		XYPlot plot = new XYPlot();
		XYItemRenderer itemrenderer1 = new XYLineAndShapeRenderer(false, true);
		XYItemRenderer itemrenderer2 = new XYLineAndShapeRenderer(false, true);

		plot.setDataset(0, dataset);
		plot.setRenderer(0, itemrenderer1);
		DateAxis domainAxis = new DateAxis("Year");
		plot.setDomainAxis(domainAxis);
		plot.setRangeAxis(new NumberAxis("Forest Area (% of land area)"));

		plot.setDataset(1, dataset2);
		plot.setRenderer(1, itemrenderer2);
		plot.setRangeAxis(1, new NumberAxis("Air Pollution (micrograms/cubic meter)"));

		plot.mapDatasetToRangeAxis(0, 0);// 1st dataset to 1st y-axis
		plot.mapDatasetToRangeAxis(1, 1); // 2nd dataset to 2nd y-axis

		JFreeChart scatterChart = new JFreeChart("Air Pollution vs. Forest Area",
				new Font("Serif", java.awt.Font.BOLD, 18), plot, true);

		chartPanel = new ChartPanel(scatterChart);
		chartPanel.setPreferredSize(new Dimension(400, 300));
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		chartPanel.setBackground(Color.white);
		west.add(chartPanel);
	}

	/**
	 * Method creates scatter chart for analysis type 3
	 * @param data 2d list of data required to build graph 
	 * @param west panel that graph is rendered to
	 */
	public void scatter3(DataItem[][] data, JPanel west) {

		TimeSeries series1 = new TimeSeries("CO2 Emissions (metric tons per capita)");
		for (int i = 0; i < data[0].length; i++) {
			if (data[0][i] != null && data[0][i].getValue() != 0)
				series1.add(new Year(data[0][i].getYear()), data[0][i].getValue());
		}
		TimeSeries series2 = new TimeSeries("GDP Per Capita (Current US$)");
		for (int i = 0; i < data[1].length; i++) {
			if (data[1][i] != null && data[1][i].getValue() != 0)
				series2.add(new Year(data[1][i].getYear()), data[1][i].getValue());
		}

		TimeSeriesCollection dataset2 = new TimeSeriesCollection();
		dataset2.addSeries(series2);

		TimeSeriesCollection dataset = new TimeSeriesCollection();
		dataset.addSeries(series1);

		XYPlot plot = new XYPlot();
		XYItemRenderer itemrenderer1 = new XYLineAndShapeRenderer(false, true);
		XYItemRenderer itemrenderer2 = new XYLineAndShapeRenderer(false, true);

		plot.setDataset(0, dataset);
		plot.setRenderer(0, itemrenderer1);
		DateAxis domainAxis = new DateAxis("Year");
		plot.setDomainAxis(domainAxis);
		plot.setRangeAxis(new NumberAxis("CO2 Emissions (metric tons per capita)"));

		plot.setDataset(1, dataset2);
		plot.setRenderer(1, itemrenderer2);
		plot.setRangeAxis(1, new NumberAxis("GDP Per Capita ($US)"));

		plot.mapDatasetToRangeAxis(0, 0);// 1st dataset to 1st y-axis
		plot.mapDatasetToRangeAxis(1, 1); // 2nd dataset to 2nd y-axis

		JFreeChart scatterChart = new JFreeChart("CO2 Emissions vs. GDP Per Capita",
				new Font("Serif", java.awt.Font.BOLD, 18), plot, true);

		chartPanel = new ChartPanel(scatterChart);
		chartPanel.setPreferredSize(new Dimension(400, 300));
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		chartPanel.setBackground(Color.white);
		west.add(chartPanel);
	}

	/**
	 * Method creates scatter chart for analysis type 6
	 * @param data 2d list of data required to build graph 
	 * @param west panel that graph is rendered to
	 */
	public void scatter6(DataItem[][] data, JPanel west) {

		TimeSeries series1 = new TimeSeries("Health Expenditure (per 1000 people)");
		for (int i = 0; i < data[0].length; i++) {
			if (data[0][i] != null && data[0][i].getValue() != 0)
				series1.add(new Year(data[0][i].getYear()), data[0][i].getValue());
		}
		TimeSeries series2 = new TimeSeries("Ratio Hospital Beds (per 1000 people)");
		for (int i = 0; i < data[1].length; i++) {
			if (data[1][i] != null && data[1][i].getValue() != 0)
				series2.add(new Year(data[1][i].getYear()), data[1][i].getValue());
		}

		TimeSeriesCollection dataset2 = new TimeSeriesCollection();
		dataset2.addSeries(series2);

		TimeSeriesCollection dataset = new TimeSeriesCollection();
		dataset.addSeries(series1);

		XYPlot plot = new XYPlot();
		XYItemRenderer itemrenderer1 = new XYLineAndShapeRenderer(false, true);
		XYItemRenderer itemrenderer2 = new XYLineAndShapeRenderer(false, true);

		plot.setDataset(0, dataset);
		plot.setRenderer(0, itemrenderer1);
		DateAxis domainAxis = new DateAxis("Year");
		plot.setDomainAxis(domainAxis);
		plot.setRangeAxis(new NumberAxis("Ratio Hospital Beds ($US per 1,000 people) "));

		plot.setDataset(1, dataset2);
		plot.setRenderer(1, itemrenderer2);
		plot.setRangeAxis(1, new NumberAxis("Health Expenditure ($US per 1000 people)"));

		plot.mapDatasetToRangeAxis(0, 0);// 1st dataset to 1st y-axis
		plot.mapDatasetToRangeAxis(1, 1); // 2nd dataset to 2nd y-axis

		JFreeChart scatterChart = new JFreeChart("Ratio Hospital Beds vs. Health Expenditure",
				new Font("Serif", java.awt.Font.BOLD, 18), plot, true);

		chartPanel = new ChartPanel(scatterChart);
		chartPanel.setPreferredSize(new Dimension(400, 300));
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		chartPanel.setBackground(Color.white);
		west.add(chartPanel);
	}

	/**
	 * Method creates scatter chart for analysis type 7
	 * @param data 2d list of data required to build graph 
	 * @param west panel that graph is rendered to
	 */
	public void scatter7(DataItem[][] data, JPanel west) {

		TimeSeries series1 = new TimeSeries("Health Expenditure Per Capita");
		for (int i = 0; i < data[0].length; i++) {
			if (data[0][i] != null && data[0][i].getValue() != 0)
				series1.add(new Year(data[0][i].getYear()), data[0][i].getValue());
		}
		TimeSeries series2 = new TimeSeries("Infant Mortality Rate");
		for (int i = 0; i < data[1].length; i++) {
			if (data[1][i] != null && data[1][i].getValue() != 0)
				series2.add(new Year(data[1][i].getYear()), data[1][i].getValue());
		}

		TimeSeriesCollection dataset2 = new TimeSeriesCollection();
		dataset2.addSeries(series2);

		TimeSeriesCollection dataset = new TimeSeriesCollection();
		dataset.addSeries(series1);

		XYPlot plot = new XYPlot();
		XYItemRenderer itemrenderer1 = new XYLineAndShapeRenderer(false, true);
		XYItemRenderer itemrenderer2 = new XYLineAndShapeRenderer(false, true);

		plot.setDataset(0, dataset);
		plot.setRenderer(0, itemrenderer1);
		DateAxis domainAxis = new DateAxis("Year");
		plot.setDomainAxis(domainAxis);
		plot.setRangeAxis(new NumberAxis("Health Expenditure per Capita (US$)"));

		plot.setDataset(1, dataset2);
		plot.setRenderer(1, itemrenderer2);
		plot.setRangeAxis(1, new NumberAxis("Mortality Rate (per 1000 live births)"));

		plot.mapDatasetToRangeAxis(0, 0);// 1st dataset to 1st y-axis
		plot.mapDatasetToRangeAxis(1, 1); // 2nd dataset to 2nd y-axis

		JFreeChart scatterChart = new JFreeChart("Health Expenditure Per Capita vs. Infant Mortality Rate",
				new Font("Serif", java.awt.Font.BOLD, 18), plot, true);

		chartPanel = new ChartPanel(scatterChart);
		chartPanel.setPreferredSize(new Dimension(400, 300));
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		chartPanel.setBackground(Color.white);
		west.add(chartPanel);
	}

	/**
	 * Method creates scatter chart for analysis type 8
	 * @param data 2d list of data required to build graph 
	 * @param west panel that graph is rendered to
	 */
	public void scatter8(DataItem[][] data, JPanel west) {

		TimeSeries series1 = new TimeSeries("Ratio Government Expenditure on Education (% of GDP)");
		for (int i = 0; i < data[0].length; i++) {
			if (data[0][i] != null && data[0][i].getValue() != 0)
				series1.add(new Year(data[0][i].getYear()), data[0][i].getValue());
		}
		TimeSeries series2 = new TimeSeries("Health Expenditure (% of GDP)");
		for (int i = 0; i < data[1].length; i++) {
			if (data[1][i] != null && data[1][i].getValue() != 0)
				series2.add(new Year(data[1][i].getYear()), data[1][i].getValue());
		}

		TimeSeriesCollection dataset2 = new TimeSeriesCollection();
		dataset2.addSeries(series2);

		TimeSeriesCollection dataset = new TimeSeriesCollection();
		dataset.addSeries(series1);

		XYPlot plot = new XYPlot();
		XYItemRenderer itemrenderer1 = new XYLineAndShapeRenderer(false, true);
		XYItemRenderer itemrenderer2 = new XYLineAndShapeRenderer(false, true);

		plot.setDataset(0, dataset);
		plot.setRenderer(0, itemrenderer1);
		DateAxis domainAxis = new DateAxis("Year");
		plot.setDomainAxis(domainAxis);
		plot.setRangeAxis(new NumberAxis("Gov't. Exp. on Education (% of GDP)"));

		plot.setDataset(1, dataset2);
		plot.setRenderer(1, itemrenderer2);
		plot.setRangeAxis(1, new NumberAxis("Health Expenditure (% of gdp)"));

		plot.mapDatasetToRangeAxis(0, 0);// 1st dataset to 1st y-axis
		plot.mapDatasetToRangeAxis(1, 1); // 2nd dataset to 2nd y-axis

		JFreeChart scatterChart = new JFreeChart("Health Expenditure (% of GDP) vs. Education Expenditure (% of gdp)",
				new Font("Serif", java.awt.Font.BOLD, 18), plot, true);

		chartPanel = new ChartPanel(scatterChart);
		chartPanel.setPreferredSize(new Dimension(400, 300));
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		chartPanel.setBackground(Color.white);
		west.add(chartPanel);
	}
}
