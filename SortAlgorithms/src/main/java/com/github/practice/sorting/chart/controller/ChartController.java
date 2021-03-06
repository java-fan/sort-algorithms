package com.github.practice.sorting.chart.controller;

import com.github.practice.sorting.algorithm.performance.Performance;
import com.github.practice.sorting.chart.view.panel.PerformancePanel;
import com.github.practice.sorting.listener.PerformanceListener;
import com.github.practice.sorting.utils.producer.ArrayType;

public class ChartController implements PerformanceListener {
	
	private PerformancePanel timePanel = null;
	private PerformancePanel swapsPanel = null;
	private PerformancePanel comparisonsPanel = null;

	@Override
	public void performanceCalculated(Performance performance, ArrayType arrayType) {
		timePanel.addData(performance.getSortAlgorithmType(), arrayType, performance.getTime());
		swapsPanel.addData(performance.getSortAlgorithmType(), arrayType, performance.getSwaps());
		comparisonsPanel.addData(performance.getSortAlgorithmType(), arrayType, performance.getComparisons());
	}

	public void setTimePanel(PerformancePanel timePanel) {
		this.timePanel = timePanel;
	}

	public void setSwapsPanel(PerformancePanel swapsPanel) {
		this.swapsPanel = swapsPanel;
	}

	public void setComparisonsPanel(PerformancePanel comparisonsPanel) {
		this.comparisonsPanel = comparisonsPanel;
	}
	
}
