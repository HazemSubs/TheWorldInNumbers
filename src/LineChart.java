import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * This class creates and renders line charts
 * @author Cole Letsche, Kaden Oseen
 *
 */
public class LineChart {

	public static ChartPanel chartPanel;

	/**
	 * This method will render a line chart for CO2 Emissions vs. Energy Use vs. Air Pollution
	 * @param data The data that must be entered into the chart
	 * @param pane Where the graph will be rendered
	 */
	public void linechart1(DataItem[][] data, JPanel pane) {
		XYSeries series1 = new XYSeries("CO2 Emissions (metric tons per capita)");
		for (int i = 0; i < data[0].length; i++)
			if (data[0][i] != null) {
				if (data[0][i].getValue() != 0)
					series1.add(data[0][i].getYear(), data[0][i].getValue());
			}

		XYSeries series2 = new XYSeries("Energy Use (kg oil equivalent/capita)");
		for (int i = 0; i < data[1].length; i++)
			if (data[1][i] != null) {
				if (data[1][i].getValue() != 0)
					series2.add(data[1][i].getYear(), data[1][i].getValue());
			}

		XYSeries series3 = new XYSeries("Air Pollution (micrograms/cubic meter)");
		for (int i = 0; i < data[2].length; i++)
			if (data[2][i] != null) {
				if (data[2][i].getValue() != 0)
					series3.add(data[2][i].getYear(), data[2][i].getValue());
			}

		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series1);
		dataset.addSeries(series2);
		dataset.addSeries(series3);

		JFreeChart chart = ChartFactory.createXYLineChart("CO2 Emissions vs. Energy Use vs. Air Pollution", "Year", "",
				dataset, PlotOrientation.VERTICAL, true, true, false);

		XYPlot plot = chart.getXYPlot();

		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
		renderer.setSeriesPaint(0, Color.RED);
		renderer.setSeriesStroke(0, new BasicStroke(2.0f));

		plot.setRenderer(renderer);
		plot.setBackgroundPaint(Color.white);

		plot.setRangeGridlinesVisible(true);
		plot.setRangeGridlinePaint(Color.BLACK);

		plot.setDomainGridlinesVisible(true);
		plot.setDomainGridlinePaint(Color.BLACK);

		chart.getLegend().setFrame(BlockBorder.NONE);

		chart.setTitle(new TextTitle("CO2 Emissions vs. Energy Use vs. Air Pollution",
				new Font("Serif", java.awt.Font.BOLD, 18)));

		chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new Dimension(400, 300));
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		chartPanel.setBackground(Color.white);
		pane.add(chartPanel);
	}

	/**
	 * This method will render a line chart for Air Pollution vs. Forest Area
	 * @param data The data that must be entered into the chart
	 * @param pane Where the graph will be rendered
	 */
	public void linechart2(DataItem[][] data, JPanel pane) {
		XYSeries series1 = new XYSeries("Air Pollution (micrograms/cubic meter)");
		for (int i = 0; i < data[0].length; i++)
			if (data[0][i] != null) {
				if (data[0][i].getValue() != 0)
					series1.add(data[0][i].getYear(), data[0][i].getValue());
			}

		XYSeries series2 = new XYSeries("Forest Area (% of land)");
		for (int i = 0; i < data[1].length; i++)
			if (data[1][i] != null) {
				if (data[1][i].getValue() != 0)
					series2.add(data[1][i].getYear(), data[1][i].getValue());
			}

		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series1);
		dataset.addSeries(series2);

		JFreeChart chart = ChartFactory.createXYLineChart("Air Pollution vs. Forest Area", "Year", "", dataset,
				PlotOrientation.VERTICAL, true, true, false);

		XYPlot plot = chart.getXYPlot();

		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
		renderer.setSeriesPaint(0, Color.RED);
		renderer.setSeriesStroke(0, new BasicStroke(2.0f));

		plot.setRenderer(renderer);
		plot.setBackgroundPaint(Color.white);

		plot.setRangeGridlinesVisible(true);
		plot.setRangeGridlinePaint(Color.BLACK);

		plot.setDomainGridlinesVisible(true);
		plot.setDomainGridlinePaint(Color.BLACK);

		chart.getLegend().setFrame(BlockBorder.NONE);

		chart.setTitle(new TextTitle("Air Pollution vs. Forest Area", new Font("Serif", java.awt.Font.BOLD, 18)));

		chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new Dimension(400, 300));
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		chartPanel.setBackground(Color.white);
		pane.add(chartPanel);
	}

	/**
	 * This method will render a line chart for Ratio CO2 Emissions vs. GDP Per Capita
	 * @param data The data that must be entered into the chart
	 * @param pane Where the graph will be rendered
	 */
	public void linechart3(DataItem[][] data, JPanel pane) {
		XYSeries series1 = new XYSeries("CO2 Emissions (metric tons per capita)");
		for (int i = 0; i < data[0].length; i++)
			if (data[0][i] != null) {
				if (data[0][i].getValue() != 0)
					series1.add(data[0][i].getYear(), data[0][i].getValue());
			}

		XYSeries series2 = new XYSeries("GDP Per Capita (Current US$)");
		for (int i = 0; i < data[1].length; i++)
			if (data[1][i] != null) {
				if (data[1][i].getValue() != 0)
					series2.add(data[1][i].getYear(), data[1][i].getValue());
			}

		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series1);
		dataset.addSeries(series2);

		JFreeChart chart = ChartFactory.createXYLineChart("Ratio CO2 Emissions vs. GDP Per Capita", "Year", "", dataset,
				PlotOrientation.VERTICAL, true, true, false);

		XYPlot plot = chart.getXYPlot();

		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
		renderer.setSeriesPaint(0, Color.RED);
		renderer.setSeriesStroke(0, new BasicStroke(2.0f));

		plot.setRenderer(renderer);
		plot.setBackgroundPaint(Color.white);

		plot.setRangeGridlinesVisible(true);
		plot.setRangeGridlinePaint(Color.BLACK);

		plot.setDomainGridlinesVisible(true);
		plot.setDomainGridlinePaint(Color.BLACK);

		chart.getLegend().setFrame(BlockBorder.NONE);

		chart.setTitle(
				new TextTitle("Ratio CO2 Emissions vs. GDP Per Capita", new Font("Serif", java.awt.Font.BOLD, 18)));

		chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new Dimension(400, 300));
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		chartPanel.setBackground(Color.white);
		pane.add(chartPanel);
	}

	/**
	 * This method will render a line chart for Government Expenditure on Education
	 * @param data The data that must be entered into the chart
	 * @param pane Where the graph will be rendered
	 */
	public void linechart4(DataItem[][] data, JPanel pane) {
		XYSeries series1 = new XYSeries("Average Forest Area (% of land)");
		for (int i = 0; i < data[0].length; i++)
			if (data[0][i] != null) {
				if (data[0][i].getValue() != 0)
					series1.add(data[0][i].getYear(), data[0][i].getValue());
			}

		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series1);

		JFreeChart chart = ChartFactory.createXYLineChart("Average Forest Area", "Year", "", dataset,
				PlotOrientation.VERTICAL, true, true, false);

		XYPlot plot = chart.getXYPlot();

		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
		renderer.setSeriesPaint(0, Color.RED);
		renderer.setSeriesStroke(0, new BasicStroke(2.0f));

		plot.setRenderer(renderer);
		plot.setBackgroundPaint(Color.white);

		plot.setRangeGridlinesVisible(true);
		plot.setRangeGridlinePaint(Color.BLACK);

		plot.setDomainGridlinesVisible(true);
		plot.setDomainGridlinePaint(Color.BLACK);

		chart.getLegend().setFrame(BlockBorder.NONE);

		chart.setTitle(new TextTitle("Average Forest Area", new Font("Serif", java.awt.Font.BOLD, 18)));

		chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new Dimension(400, 300));
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		chartPanel.setBackground(Color.white);
		pane.add(chartPanel);
	}
	
	/**
	 * This method will render a line chart for Government Expenditure on Education
	 * @param data The data that must be entered into the chart
	 * @param pane Where the graph will be rendered
	 */
	public void linechart5(DataItem[][] data, JPanel pane) {
		XYSeries series1 = new XYSeries("Government Expenditure on Education (% of GDP)");
		for (int i = 0; i < data[0].length; i++)
			if (data[0][i] != null) {
				if (data[0][i].getValue() != 0)
					series1.add(data[0][i].getYear(), data[0][i].getValue());
			}

		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series1);

		JFreeChart chart = ChartFactory.createXYLineChart("Government Expenditure on Education (% of GDP)", "Year", "",
				dataset, PlotOrientation.VERTICAL, true, true, false);

		XYPlot plot = chart.getXYPlot();

		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
		renderer.setSeriesPaint(0, Color.RED);
		renderer.setSeriesStroke(0, new BasicStroke(2.0f));

		plot.setRenderer(renderer);
		plot.setBackgroundPaint(Color.white);

		plot.setRangeGridlinesVisible(true);
		plot.setRangeGridlinePaint(Color.BLACK);

		plot.setDomainGridlinesVisible(true);
		plot.setDomainGridlinePaint(Color.BLACK);

		chart.getLegend().setFrame(BlockBorder.NONE);

		chart.setTitle(new TextTitle("Government Expenditure on Education (% of GDP)",
				new Font("Serif", java.awt.Font.BOLD, 18)));

		chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new Dimension(400, 300));
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		chartPanel.setBackground(Color.white);
		pane.add(chartPanel);
	}

	/**
	 * This method will render a line chart for Ratio of Hospital Beds vs. Current Health Expenditure
	 * @param data The data that must be entered into the chart
	 * @param pane Where the graph will be rendered
	 */
	public void linechart6(DataItem[][] data, JPanel pane) {
		XYSeries series1 = new XYSeries("Ratio of Hospital Beds (per 1000 people)");
		for (int i = 0; i < data[0].length; i++)
			if (data[0][i] != null) {
				if (data[0][i].getValue() != 0)
					series1.add(data[0][i].getYear(), data[0][i].getValue());
			}

		XYSeries series2 = new XYSeries("Current Health Expenditure (per 1000 people)");
		for (int i = 0; i < data[1].length; i++)
			if (data[1][i] != null) {
				if (data[1][i].getValue() != 0)
					series2.add(data[1][i].getYear(), data[1][i].getValue());
			}

		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series1);
		dataset.addSeries(series2);

		JFreeChart chart = ChartFactory.createXYLineChart("Ratio of Hospital Beds vs. Current Health Expenditure",
				"Year", "", dataset, PlotOrientation.VERTICAL, true, true, false);

		XYPlot plot = chart.getXYPlot();

		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
		renderer.setSeriesPaint(0, Color.RED);
		renderer.setSeriesStroke(0, new BasicStroke(2.0f));

		plot.setRenderer(renderer);
		plot.setBackgroundPaint(Color.white);

		plot.setRangeGridlinesVisible(true);
		plot.setRangeGridlinePaint(Color.BLACK);

		plot.setDomainGridlinesVisible(true);
		plot.setDomainGridlinePaint(Color.BLACK);

		chart.getLegend().setFrame(BlockBorder.NONE);

		chart.setTitle(new TextTitle("Ratio of Hospital Beds vs. Current Health Expenditure",
				new Font("Serif", java.awt.Font.BOLD, 18)));

		chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new Dimension(400, 300));
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		chartPanel.setBackground(Color.white);
		pane.add(chartPanel);
	}
	
	/**
	 * This method will render a line chart for Health Expenditure Per Capita vs. Infant Mortality Rate
	 * @param data The data that must be entered into the chart
	 * @param pane Where the graph will be rendered
	 */
	public void linechart7(DataItem[][] data, JPanel pane) {
		XYSeries series1 = new XYSeries("Health Expenditure Per Capita");
		for (int i = 0; i < data[0].length; i++)
			if (data[0][i] != null) {
				if (data[0][i].getValue() != 0)
					series1.add(data[0][i].getYear(), data[0][i].getValue());
			}

		XYSeries series2 = new XYSeries("Infant Mortalilty Rate");
		for (int i = 0; i < data[1].length; i++)
			if (data[1][i] != null) {
				if (data[1][i].getValue() != 0)
					series2.add(data[1][i].getYear(), data[1][i].getValue());
			}

		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series1);
		dataset.addSeries(series2);

		JFreeChart chart = ChartFactory.createXYLineChart("Health Expenditure Per Capita vs. Infant Mortality Rate",
				"Year", "", dataset, PlotOrientation.VERTICAL, true, true, false);

		XYPlot plot = chart.getXYPlot();

		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
		renderer.setSeriesPaint(0, Color.RED);
		renderer.setSeriesStroke(0, new BasicStroke(2.0f));

		plot.setRenderer(renderer);
		plot.setBackgroundPaint(Color.white);

		plot.setRangeGridlinesVisible(true);
		plot.setRangeGridlinePaint(Color.BLACK);

		plot.setDomainGridlinesVisible(true);
		plot.setDomainGridlinePaint(Color.BLACK);

		chart.getLegend().setFrame(BlockBorder.NONE);

		chart.setTitle(new TextTitle("Health Expenditure Per Capita vs. Infant Mortality Rate",
				new Font("Serif", java.awt.Font.BOLD, 18)));

		chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new Dimension(400, 300));
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		chartPanel.setBackground(Color.white);
		pane.add(chartPanel);
	}

	/**
	 * This method will render a line chart for Government Expenditure on Education vs. Health Expenditure
	 * @param data The data that must be entered into the chart
	 * @param pane Where the graph will be rendered
	 */
	public void linechart8(DataItem[][] data, JPanel pane) {
		XYSeries series1 = new XYSeries("Government Expenditure on Education (% of GDP)");
		for (int i = 0; i < data[0].length; i++)
			if (data[0][i] != null) {
				if (data[0][i].getValue() != 0)
					series1.add(data[0][i].getYear(), data[0][i].getValue());
			}

		XYSeries series2 = new XYSeries("Health Expenditure (% of GDP)");
		for (int i = 0; i < data[1].length; i++)
			if (data[1][i] != null) {
				if (data[1][i].getValue() != 0)
					series2.add(data[1][i].getYear(), data[1][i].getValue());
			}

		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series1);
		dataset.addSeries(series2);

		JFreeChart chart = ChartFactory.createXYLineChart("Government Expenditure on Education vs. Health Expenditure",
				"Year", "", dataset, PlotOrientation.VERTICAL, true, true, false);

		XYPlot plot = chart.getXYPlot();

		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
		renderer.setSeriesPaint(0, Color.RED);
		renderer.setSeriesStroke(0, new BasicStroke(2.0f));

		plot.setRenderer(renderer);
		plot.setBackgroundPaint(Color.white);

		plot.setRangeGridlinesVisible(true);
		plot.setRangeGridlinePaint(Color.BLACK);

		plot.setDomainGridlinesVisible(true);
		plot.setDomainGridlinePaint(Color.BLACK);

		chart.getLegend().setFrame(BlockBorder.NONE);

		chart.setTitle(new TextTitle("Government Expenditure on Education vs. Health Expenditure",
				new Font("Serif", java.awt.Font.BOLD, 18)));

		chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new Dimension(400, 300));
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		chartPanel.setBackground(Color.white);
		pane.add(chartPanel);
	}
}
