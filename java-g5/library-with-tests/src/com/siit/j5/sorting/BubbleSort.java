package com.siit.j5.sorting;

public class BubbleSort {

	public int[] sortIntArray(int[] array) {
		if (array == null) {
			throw new IllegalArgumentException("Array must not be null.");
		}
		if (array.length == 0) {
			throw new IllegalArgumentException("Array must not be empty.");
		}
		boolean sorted = false;
		while (!sorted) {
			sorted = true;
			for (int i = 0; i < array.length - 1; i++) {
				if (array[i] > array[i + 1]) {
					int temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
					sorted = false;
				}
			}
		}
		return array;
	}

}
