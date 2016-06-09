package com.siit.java3.generics;

public class BubbleSort {

	public <T extends Comparable<T>> T[] sort(T[] unsortedArray) {
		boolean isSorted = true;
		do {
			isSorted = true;
			for(int i =0; i<unsortedArray.length-1;i++){
				if(unsortedArray[i].compareTo(unsortedArray[i+1])>0){ // strings[i] is greater than strings [i+1]
					T temp = unsortedArray[i];
					unsortedArray[i] = unsortedArray[i+1];
					unsortedArray[i+1] = temp;
					isSorted = false;
				}
			}
		} while(!isSorted);
		return unsortedArray;
	}
	
	

}
