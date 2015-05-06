package com.github.practice.sorting.chart.view.panel;

import java.awt.GridLayout;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.UnknownKeyException;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import com.github.practice.sorting.utils.producer.ArrayType;

@SuppressWarnings("serial")
public class PerformancePanel extends JPanel {
	
	private XYSeriesCollection ascData = new XYSeriesCollection();
	private XYSeriesCollection descData = new XYSeriesCollection();
	private XYSeriesCollection randomData = new XYSeriesCollection();
	private XYSeriesCollection duplicatedData = new XYSeriesCollection();

	public PerformancePanel() {
		setLayout(new GridLayout(2, 2));
		
		add(geChart("ASC", ascData));
		add(geChart("DESC", descData));
		add(geChart("RANDOM", randomData));
		add(geChart("DUPLICATED", duplicatedData));
	}
	
	private ChartPanel geChart(String name, XYSeriesCollection data) {
		final JFreeChart chart = ChartFactory.createXYLineChart(
			name,
            "X", 
            "Y", 
            data,
            PlotOrientation.VERTICAL,
            true,
            true,
            false
        );

        final XYPlot plot = (XYPlot) chart.getPlot();
        final NumberAxis axis = (NumberAxis) plot.getRangeAxis();
        axis.setAutoRangeIncludesZero(false);
        axis.setAutoRangeMinimumSize(1.0);
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        
        return chartPanel;
	}

	public void addData(ArrayType type, String key, int x, long y) {
		XYSeriesCollection data = getDataByType(type);
		XYSeries series;
		try {
			series = data.getSeries(key);
		} catch (UnknownKeyException e) {
			series = new XYSeries(key);
			data.addSeries(series);
		}
		series.add(x, y);
	}
	
	private XYSeriesCollection getDataByType(ArrayType type) {
		switch(type) {
			case ASC:
				return ascData;
			case DESC:
				return descData;
			case RANDOM:
				return randomData;
			case DUPLICATED:
				return duplicatedData;
			default: return null;
		}
	}

}