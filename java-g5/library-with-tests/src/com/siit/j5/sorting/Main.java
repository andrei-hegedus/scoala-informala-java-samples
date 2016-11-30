package com.siit.j5.sorting;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		int [] array = new int []{1,2,1,3, 4, 2 , 3, 2, 1};
		BubbleSort bubbleSort = new BubbleSort();
		int [] sortedArray = bubbleSort.sortIntArray(array);
		System.out.println(Arrays.toString(sortedArray));
	}

}
