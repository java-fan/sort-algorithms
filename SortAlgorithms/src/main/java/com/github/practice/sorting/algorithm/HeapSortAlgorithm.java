package com.github.practice.sorting.algorithm;

public class HeapSortAlgorithm extends SortAlgorithm {

    @Override
    protected void doSort(int[] array) {
    	heapify(array);
    }

    private void heapify(int[] array) {
		// TODO Auto-generated method stub
		
	}

	@Override
    public SortAlgorithmType getType() {
        return SortAlgorithmType.HEAP_SORT;
    }

}
