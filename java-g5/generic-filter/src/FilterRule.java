
public interface FilterRule<T> {
	
	boolean filter(T data);
	String getFilterName();

}
