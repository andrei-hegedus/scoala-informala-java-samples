package siit.java3.maps;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class Main {

	private static HashMap<Integer, String> testMap = new HashMap<>();

	public static void main(String[] args) {
		testMap.put(1, "apple");
		testMap.put(2, "orange");
		testMap.put(3, "mango");
		testMap.put(4, "lemon");
		testMap.put(5, "strawberry");
		testMap.put(6, "peach");
		testMap.put(7, "plum");
		
		// I. entryset
		Set<Entry<Integer, String>> entries= testMap.entrySet();
		for(Entry<Integer, String> entry : entries){
			System.out.println(entry.getKey()+", "+entry.getValue());
		}
		
		// I. keyset
		System.out.println("\nII.");
		Set<Integer> keys = testMap.keySet();
		for(Integer key : keys){
			System.out.println(key+", "+testMap.get(key));
		}
		
		// III entries
		System.out.println("\nIII.");
		Collection<String> values = testMap.values();
		for(String value : values){
			System.out.println(value);
		}
	}

}
