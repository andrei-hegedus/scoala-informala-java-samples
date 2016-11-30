package com.siit.j5.sorting;

import org.junit.Assert;
import org.junit.Test;

public class BubbleSortTest {
	
	@Test
	public void unsortedIntArrayIsSortedInAscendingOrder(){
		// given
		int [] array = new int []{9, 1, 2, 7 , 5, 6 , 3};
		BubbleSort bubbleSort = new BubbleSort();
		// when
		int [] sortedArray = bubbleSort.sortIntArray(array);
		// then
		int [] correctlySortedArray = new int[]{1,2,3,5,6,7,9};
		Assert.assertArrayEquals(correctlySortedArray, sortedArray);
	}
	
	@Test
	public void sortedIntArrayIsUnmodified(){
		// given
		int [] array = new int []{1,2,3,5,6,7,9};
		BubbleSort bubbleSort = new BubbleSort();
		// when
		int [] sortedArray = bubbleSort.sortIntArray(array);
		// then
		int [] correctlySortedArray = new int[]{1,2,3,5,6,7,9};
		Assert.assertArrayEquals(correctlySortedArray, sortedArray);
	}
	
	@Test
	public void unsortedIntArrayWithDuplicatesIsSorted(){
		// given
		int [] array = new int []{1,2,1,3, 4, 2 , 3, 2, 1};
		BubbleSort bubbleSort = new BubbleSort();
		// when
		int [] sortedArray = bubbleSort.sortIntArray(array);
		// then
		int [] correctlySortedArray = new int[]{1,1,1,2,2,2,3,3,4};
		Assert.assertArrayEquals(correctlySortedArray, sortedArray);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void whenEmptyArrayUsed_ExceptionIsThrown(){
		int [] array = new int [] {};
		BubbleSort bubbleSort = new BubbleSort();
		bubbleSort.sortIntArray(array);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void whenNullArrayUsed_ExceptionIsThrown(){
		int [] array = null;
		BubbleSort bubbleSort = new BubbleSort();
		bubbleSort.sortIntArray(array);
	}

}
