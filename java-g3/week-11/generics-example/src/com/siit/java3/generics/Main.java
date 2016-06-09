package com.siit.java3.generics;
import java.util.Arrays;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {
		BubbleSort sort = new BubbleSort();
		String[] strings = new String[] { "b", "a", "z", "t" };
		String[] sortedStrings = sort.sort(strings);
		System.out.println(Arrays.toString(sortedStrings));
		Integer[] ints = new Integer[] { 5, 3, 4, 1 };
		Integer[] sortedInts = sort.sort(ints);
		System.out.println(Arrays.toString(sortedInts));
		Room[] rooms = new Room[] { new Room(100),  new Room(50), new Room(60) };
		Room[] sortedRooms = sort.sort(rooms);
		System.out.println(Arrays.toString(sortedRooms));
	}
	
	

	static class Room implements Comparable<Room> {
		private float area;

		public Room(float area) {
			this.area = area;
		}

		public float getArea() {
			return area;
		}

		@Override
		public int compareTo(Room o) {
			if (area == o.area) {
				return 0;
			}
			if (area > o.area) {
				return 1;
			}
			return -1;
		}

		@Override
		public String toString() {
			return "Room [area=" + area + "]";
		}
		
		
	}

}
