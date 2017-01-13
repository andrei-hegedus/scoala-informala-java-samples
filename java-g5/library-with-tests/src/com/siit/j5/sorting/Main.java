package com.siit.j5.sorting;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		int [] array = new int []{1,2,1,3, 4, 2 , 3, 2, 1};
		BubbleSort bubbleSort = new BubbleSort();
		int [] sortedArray = bubbleSort.sortIntArray(array);
		//System.out.println(Arrays.toString(sortedArray));
		
		GenericBubbleSort gBubbleSort = new GenericBubbleSort();
		Integer [] intArray = new Integer []{1,2,1,3, 4, 2 , 3, 2, 1};
		Integer [] sortedIntArray = gBubbleSort.sortArray(intArray);
		System.out.println(Arrays.toString(sortedIntArray));
		
		String [] strArray = new String [] {"Michael", "Adam", "Jane", "Bob"};
		String [] sortedStrArray = gBubbleSort.sortArray(strArray);
		System.out.println(Arrays.toString(sortedStrArray));
		
	}

}
