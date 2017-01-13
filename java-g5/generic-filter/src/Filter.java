import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class Filter<T> {
	
	private HashSet<FilterRule<T>> rules = new HashSet<>();
	
	public void addRule(FilterRule<T> rule){
		rules.add(rule);
	}
	
	public List<T> filter(List<T> unFilteredList){
		ArrayList<T> filteredList = new ArrayList<>();
		for(T t : unFilteredList){
			Iterator<FilterRule<T>> iterator = rules.iterator();
			System.out.println("Filtering "+t);
			if(isFiltered(t, iterator)){
				filteredList.add(t);
			}
		}
		return filteredList;
	}

	private boolean isFiltered(T t, Iterator<FilterRule<T>> iterator) {
		if(iterator.hasNext()){
			FilterRule<T> rule = iterator.next();
			if(rule.filter(t)){
				System.out.println("passed "+rule.getFilterName());
				return isFiltered(t, iterator);
			} else {
				System.out.println("did not pass "+rule.getFilterName());
				return false;
			}
		}
		return true;
	}

}
