import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		SortAlgorithm sortAlg = new TreeSort();
		Integer [] unsorted = new Integer [] {10, 5, 1, 3, 2 , 15, 6, 13};
		Integer [] sorted = sortAlg.sort(unsorted);
		System.out.println(Arrays.toString(sorted));
		
		String [] names = new String [] {"John", "Amber", "Michael", "Carl", "Bill", "Razvan"};
		String [] sortedNames = sortAlg.sort(names);
		System.out.println(Arrays.toString(sortedNames));
	}
	
}
