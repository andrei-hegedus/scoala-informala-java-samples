import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<String> words = Arrays
				.asList(new String[] { "Jim", "Tomato", "Banana", "Monica", "Dog", "Chair", "Apple" });
		Filter<String> wordFilter = new Filter<>();
		wordFilter.addRule(new FilterRule<String>() {
			
			@Override
			public boolean filter(String data) {
				String [] plants =  new String[] { "Tomato", "Banana", "Apple", "Palm tree" };
				for(String plant :  plants){
					if(plant.equals(data)){
						return true;
					}
				}
				return false;
			}

			@Override
			public String getFilterName() {
				return "plant filter";
			}
		});
		/*wordFilter.addRule(new FilterRule<String>() {
			
			@Override
			public boolean filter(String data) {
				String [] fruits =  new String[] { "Banana", "Apple", "Lemon" };
				for(String fruit :  fruits){
					if(fruit.equals(data)){
						return true;
					}
				}
				return false;
			}

			@Override
			public String getFilterName() {
				return "fruit filter";
			}
		});*/
		
		List<String> filteredWords = wordFilter.filter(words);
		System.out.println(filteredWords);
	}

}
