package siit.java3.exepnsereports;

import java.util.List;

public interface ExpenseRepository {

	void save(Expense expense) throws Exception;
	List<Expense> loadAll() throws Exception;
	
}
