import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * This class creates and renders bar charts
 * @author Cole Letsche, Mark Nirenshtein, Hazem Sabsabi
 *
 */
public class BarChart {

	public static ChartPanel chartPanel;

	/**
	 * This method will render a bar chart for CO2 Emissions vs. Energy Use vs. Air Pollution
	 * @param data The data that must be entered into the chart
	 * @param pane Where the graph will be rendered
	 */
	public void barchart1(DataItem[][] data, JPanel pane) {

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		for (int i = 0; i < data[0].length; i++)
			if (data[0][i] != null) {
				dataset.setValue(data[0][i].getValue(), "CO2 Emissions (metric tons per capita)",
						Integer.toString(data[0][i].getYear()));
			}

		for (int i = 0; i < data[1].length; i++)
			if (data[1][i] != null) {
				dataset.setValue(data[1][i].getValue(), "Energy Use (kg oil equivalent/capita)",
						Integer.toString(data[1][i].getYear()));
			}

		for (int i = 0; i < data[2].length; i++) {
			if (data[2][i] != null) {
				dataset.setValue(data[2][i].getValue(), "Air Pollution (micrograms/cubic meter)",
						Integer.toString(data[2][i].getYear()));
			}
		}

		CategoryPlot plot = new CategoryPlot();
		BarRenderer barrenderer1 = new BarRenderer();

		plot.setDataset(0, dataset);
		plot.setRenderer(0, barrenderer1);

		CategoryAxis domainAxis = new CategoryAxis("Year");

		plot.setDomainAxis(domainAxis);
		plot.setRangeAxis(new NumberAxis(""));

		plot.mapDatasetToRangeAxis(0, 0);// 1st dataset to 1st y-axis

		JFreeChart barChart = new JFreeChart("CO2 Emissions vs. Energy Use vs. Air Pollution",
				new Font("Serif", java.awt.Font.BOLD, 18), plot, true);

		chartPanel = new ChartPanel(barChart);
		chartPanel.setPreferredSize(new Dimension(400, 300));
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		chartPanel.setBackground(Color.white);
		pane.add(chartPanel);
	}

	/**
	 * This method will render a bar chart for Air Pollution vs. Forest Area
	 * @param data The data that must be entered into the chart
	 * @param pane Where the graph will be rendered
	 */
	public void barchart2(DataItem[][] data, JPanel pane) {

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		for (int i = 0; i < data[0].length; i++)
			if (data[0][i] != null) {
				dataset.setValue(data[0][i].getValue(), "Air Pollution (micrograms/cubic meter)",
						Integer.toString(data[0][i].getYear()));
			}

		for (int i = 0; i < data[1].length; i++)
			if (data[1][i] != null) {
				dataset.setValue(data[1][i].getValue(), "Forest Area (% of land)",
						Integer.toString(data[1][i].getYear()));
			}

		CategoryPlot plot = new CategoryPlot();
		BarRenderer barrenderer1 = new BarRenderer();

		plot.setDataset(0, dataset);
		plot.setRenderer(0, barrenderer1);

		CategoryAxis domainAxis = new CategoryAxis("Year");

		plot.setDomainAxis(domainAxis);
		plot.setRangeAxis(new NumberAxis(""));

		plot.mapDatasetToRangeAxis(0, 0);// 1st dataset to 1st y-axis

		JFreeChart barChart = new JFreeChart("Air Pollution vs. Forest Area", new Font("Serif", java.awt.Font.BOLD, 18),
				plot, true);

		chartPanel = new ChartPanel(barChart);
		chartPanel.setPreferredSize(new Dimension(400, 300));
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		chartPanel.setBackground(Color.white);
		pane.add(chartPanel);
	}

	/**
	 * This method will render a bar chart for Ratio CO2 Emissions vs. GDP Per Capita
	 * @param data The data that must be entered into the chart
	 * @param pane Where the graph will be rendered
	 */
	public void barchart3(DataItem[][] data, JPanel pane) {

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		for (int i = 0; i < data[0].length; i++)
			if (data[0][i] != null) {
				dataset.setValue(data[0][i].getValue(), "CO2 Emissions (metric tons per capita)",
						Integer.toString(data[0][i].getYear()));
			}

		for (int i = 0; i < data[1].length; i++)
			if (data[1][i] != null) {
				dataset.setValue(data[1][i].getValue(), "GDP Per Capita (Current US$)",
						Integer.toString(data[1][i].getYear()));
			}

		CategoryPlot plot = new CategoryPlot();
		BarRenderer barrenderer1 = new BarRenderer();

		plot.setDataset(0, dataset);
		plot.setRenderer(0, barrenderer1);

		CategoryAxis domainAxis = new CategoryAxis("Year");

		plot.setDomainAxis(domainAxis);
		plot.setRangeAxis(new NumberAxis(""));

		plot.mapDatasetToRangeAxis(0, 0);// 1st dataset to 1st y-axis

		JFreeChart barChart = new JFreeChart("Ratio CO2 Emissions vs. GDP Per Capita",
				new Font("Serif", java.awt.Font.BOLD, 18), plot, true);

		chartPanel = new ChartPanel(barChart);
		chartPanel.setPreferredSize(new Dimension(400, 300));
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		chartPanel.setBackground(Color.white);
		pane.add(chartPanel);
	}

	/**
	 * This method will render a bar chart for Average Forest Area
	 * @param data The data that must be entered into the chart
	 * @param pane Where the graph will be rendered
	 */
	public void barchart4(DataItem[][] data, JPanel pane) {

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		for (int i = 0; i < data[0].length; i++)
			if (data[0][i] != null) {
				dataset.setValue(data[0][i].getValue(), "Average Forest Area (% of land)",
						Integer.toString(data[0][i].getYear()));
			}

		CategoryPlot plot = new CategoryPlot();
		BarRenderer barrenderer1 = new BarRenderer();

		plot.setDataset(0, dataset);
		plot.setRenderer(0, barrenderer1);

		CategoryAxis domainAxis = new CategoryAxis("Year");

		plot.setDomainAxis(domainAxis);
		plot.setRangeAxis(new NumberAxis("% of Land Area"));

		plot.mapDatasetToRangeAxis(0, 0);// 1st dataset to 1st y-axis

		JFreeChart barChart = new JFreeChart("Average Forest Area", new Font("Serif", java.awt.Font.BOLD, 18), plot,
				true);

		chartPanel = new ChartPanel(barChart);
		chartPanel.setPreferredSize(new Dimension(400, 300));
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		chartPanel.setBackground(Color.white);
		pane.add(chartPanel);
	}

	/**
	 * This method will render a bar chart for Government Expenditure on Education
	 * @param data The data that must be entered into the chart
	 * @param pane Where the graph will be rendered
	 */
	public void barchart5(DataItem[][] data, JPanel pane) {

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		for (int i = 0; i < data[0].length; i++)
			if (data[0][i] != null) {
				dataset.setValue(data[0][i].getValue(), "Government Expenditure on Education (% of GDP)",
						Integer.toString(data[0][i].getYear()));
			}

		CategoryPlot plot = new CategoryPlot();
		BarRenderer barrenderer1 = new BarRenderer();

		plot.setDataset(0, dataset);
		plot.setRenderer(0, barrenderer1);

		CategoryAxis domainAxis = new CategoryAxis("Year");

		plot.setDomainAxis(domainAxis);
		plot.setRangeAxis(new NumberAxis("% of GDP"));

		plot.mapDatasetToRangeAxis(0, 0);// 1st dataset to 1st y-axis

		JFreeChart barChart = new JFreeChart("Government Expenditure on Education (% of GDP)",
				new Font("Serif", java.awt.Font.BOLD, 18), plot, true);

		chartPanel = new ChartPanel(barChart);
		chartPanel.setPreferredSize(new Dimension(400, 300));
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		chartPanel.setBackground(Color.white);
		pane.add(chartPanel);
	}

	/**
	 * This method will render a bar chart for Ratio of Hospital Beds vs. Current Health Expenditure
	 * @param data The data that must be entered into the chart
	 * @param pane Where the graph will be rendered
	 */
	public void barchart6(DataItem[][] data, JPanel pane) {

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		for (int i = 0; i < data[0].length; i++)
			if (data[0][i] != null) {
				dataset.setValue(data[0][i].getValue(), "Ratio of Hospital Beds (per 1000 people)",
						Integer.toString(data[0][i].getYear()));
			}

		for (int i = 0; i < data[1].length; i++)
			if (data[1][i] != null) {
				dataset.setValue(data[1][i].getValue(), "Current Health Expenditure (per 1000 people)",
						Integer.toString(data[1][i].getYear()));
			}

		CategoryPlot plot = new CategoryPlot();
		BarRenderer barrenderer1 = new BarRenderer();

		plot.setDataset(0, dataset);
		plot.setRenderer(0, barrenderer1);

		CategoryAxis domainAxis = new CategoryAxis("Year");

		plot.setDomainAxis(domainAxis);
		plot.setRangeAxis(new NumberAxis(""));

		plot.mapDatasetToRangeAxis(0, 0);// 1st dataset to 1st y-axis

		JFreeChart barChart = new JFreeChart("Ratio of Hospital Beds vs. Current Health Expenditure",
				new Font("Serif", java.awt.Font.BOLD, 18), plot, true);

		chartPanel = new ChartPanel(barChart);
		chartPanel.setPreferredSize(new Dimension(400, 300));
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		chartPanel.setBackground(Color.white);
		pane.add(chartPanel);
	}

	/**
	 * This method will render a bar chart for Health Expenditure Per Capita vs. Infant Mortality Rate
	 * @param data The data that must be entered into the chart
	 * @param pane Where the graph will be rendered
	 */
	public void barchart7(DataItem[][] data, JPanel pane) {

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		for (int i = 0; i < data[0].length; i++)
			if (data[0][i] != null) {
				dataset.setValue(data[0][i].getValue(), "Health Expenditure Per Capita",
						Integer.toString(data[0][i].getYear()));
			}

		for (int i = 0; i < data[1].length; i++)
			if (data[1][i] != null) {
				dataset.setValue(data[1][i].getValue(), "Infant Mortalilty Rate",
						Integer.toString(data[1][i].getYear()));
			}

		CategoryPlot plot = new CategoryPlot();
		BarRenderer barrenderer1 = new BarRenderer();

		plot.setDataset(0, dataset);
		plot.setRenderer(0, barrenderer1);

		CategoryAxis domainAxis = new CategoryAxis("Year");

		plot.setDomainAxis(domainAxis);
		plot.setRangeAxis(new NumberAxis(""));

		plot.mapDatasetToRangeAxis(0, 0);// 1st dataset to 1st y-axis

		JFreeChart barChart = new JFreeChart("Health Expenditure Per Capita vs. Infant Mortality Rate",
				new Font("Serif", java.awt.Font.BOLD, 18), plot, true);

		chartPanel = new ChartPanel(barChart);
		chartPanel.setPreferredSize(new Dimension(400, 300));
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		chartPanel.setBackground(Color.white);
		pane.add(chartPanel);
	}
	
	/**
	 * This method will render a bar chart for Government Expenditure on Education vs. Health Expenditure
	 * @param data The data that must be entered into the chart
	 * @param pane Where the graph will be rendered
	 */
	public void barchart8(DataItem[][] data, JPanel pane) {

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		for (int i = 0; i < data[0].length; i++)
			if (data[0][i] != null) {
				dataset.setValue(data[0][i].getValue(), "Government Expenditure on Education (% of GDP)",
						Integer.toString(data[0][i].getYear()));
			}

		for (int i = 0; i < data[1].length; i++)
			if (data[1][i] != null) {
				dataset.setValue(data[1][i].getValue(), "Health Expenditure (% of GDP)",
						Integer.toString(data[1][i].getYear()));
			}

		CategoryPlot plot = new CategoryPlot();
		BarRenderer barrenderer1 = new BarRenderer();

		plot.setDataset(0, dataset);
		plot.setRenderer(0, barrenderer1);

		CategoryAxis domainAxis = new CategoryAxis("Year");

		plot.setDomainAxis(domainAxis);
		plot.setRangeAxis(new NumberAxis(""));

		plot.mapDatasetToRangeAxis(0, 0);// 1st dataset to 1st y-axis

		JFreeChart barChart = new JFreeChart("Government Expenditure on Education vs. Health Expenditure",
				new Font("Serif", java.awt.Font.BOLD, 18), plot, true);

		chartPanel = new ChartPanel(barChart);
		chartPanel.setPreferredSize(new Dimension(400, 300));
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		chartPanel.setBackground(Color.white);
		pane.add(chartPanel);
	}
}
