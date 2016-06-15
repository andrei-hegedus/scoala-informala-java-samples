package siit.java3.exepnsereports;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseRecords {
	
	private ExpenseRepository repo;
	
	public ExpenseRecords(ExpenseRepository repo) {
		super();
		this.repo = repo;
	}

	public void addExpense(Expense expense) throws Exception{
		repo.save(expense);
	}
	
	public Map<ExpenseCategory, Float> generateReport() throws Exception{
		List<Expense> expenses = repo.loadAll();
		HashMap<ExpenseCategory, Float> report = new HashMap<>();
		float totalExpenses = computeTotalExpenses(expenses);
		for(ExpenseCategory category : ExpenseCategory.values()){
			float categoryTotal = computeTotalForCategory(category, expenses);
			report.put(category, calculatePercentage(totalExpenses, categoryTotal));
		}
		return report;
	}

	private float calculatePercentage(float max, float actual) {
		return actual*100/max;
	}

	private float computeTotalForCategory(ExpenseCategory category, List<Expense> expenses) {
		float categoryTotal = 0;
		for(Expense e : expenses){
			if(category.equals(e.getCategory())){
				categoryTotal += e.getAmount();
			}
		}
		return categoryTotal;
	}

	private float computeTotalExpenses(List<Expense> expenses) {
		float totalExpenses = 0;
		for(Expense e : expenses){
			totalExpenses += e.getAmount();
		}
		return totalExpenses;
	}

}
