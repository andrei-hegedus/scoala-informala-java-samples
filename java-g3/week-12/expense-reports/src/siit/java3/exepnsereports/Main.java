package siit.java3.exepnsereports;

import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;

public class Main {

	public static void main(String[] args) throws Exception {
		// CSVExpenseRepository repo = new CSVExpenseRepository();
		try (OptimizedCSVExpenseRepository repo = new OptimizedCSVExpenseRepository()) {
			repo.openCSV();
			ExpenseRecords records = new ExpenseRecords(repo);
			records.addExpense(new Expense(new Date(), ExpenseCategory.BILLS, 10, "gaz"));
			records.addExpense(new Expense(new Date(), ExpenseCategory.HOBBIES, 200, "pesti"));
			// repo.closeCSV();
			Map<ExpenseCategory, Float> report = records.generateReport();
			for (Entry<ExpenseCategory, Float> entry : report.entrySet()) {
				System.out.println(entry.getKey().name() + " - " + entry.getValue() + "%");
			}
		}
	}

}
