package com.siit.j5.sorting;

import java.util.Collection;
import java.util.Iterator;

public class GenericBubbleSort {
	
	
	public <T extends Comparable<T>> T[] sortArray(T[] array) {
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
				if (array[i].compareTo(array[i + 1])>0) {
					T temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
					sorted = false;
				}
			}
		}
		return array;
	}
	
	public <T extends Runnable> void whatever(T data){
		
	}

}
