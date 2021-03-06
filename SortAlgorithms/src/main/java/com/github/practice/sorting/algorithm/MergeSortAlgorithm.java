package com.github.practice.sorting.algorithm;

public class MergeSortAlgorithm extends SortAlgorithm {
	
    @Override
    protected void doSort(int[] array) {
    	int [] aux = new int[array.length];
		for (int i = 0; i < array.length; ++i) {
			swapLeft(aux, i, array, i);
		}
        mergeSort(array, aux, 0, array.length);
    }

    private void mergeSort(int[] array, int[] aux, int left, int right) {
    	if (right - left > 1) {
			int middle = (right + left) / 2;
			mergeSort(aux, array, left, middle);
			mergeSort(aux, array, middle, right);
			merge(array, aux, left, middle, right);
		}
	}

	protected void merge(int[] array, int[] aux, int left, int middle, int right) {
		if (middle != left && !less(aux[middle], aux[middle - 1])) {
			// biggest item in first half <= smallest item in second half
			// just copy
			for (int i = left; i < right; ++i) {
				swapLeft(array, i, aux, i);
			}
			return;
		}
		
		int startIndex = left;
		int middleIndex = middle;
		for (int i = left; i < right; ++i) {
			if (startIndex == middle) {
				swapLeft(array, i, aux, middleIndex++);
			} else if (middleIndex == right) {
				swapLeft(array, i, aux, startIndex++);
			} else if (less(aux[startIndex], aux[middleIndex])) {
				swapLeft(array, i, aux, startIndex++);
			} else {
				swapLeft(array, i, aux, middleIndex++);
			}
		}
	}

	@Override
    public SortAlgorithmType getType() {
        return SortAlgorithmType.MERGE_SORT;
    }

}
