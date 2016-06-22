package siit.java3.expensereports;

import java.io.File;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

public class Main {
	
	private static int threadId = 0;

	public static void main(String[] args) throws Exception {
		//manageExpenseRecords();
		manageExpenseRecordsAsync();
	}

	private static void manageExpenseRecords() throws Exception {
		deleteExpenseCSVFile();
		CSVExpenseRepository repo = new CSVExpenseRepository();
		ExpenseRecords records = new ExpenseRecords(repo);
		records.addExpense(new Expense(new Date(), ExpenseCategory.BILLS, 10, "gaz"));
		records.addExpense(new Expense(new Date(), ExpenseCategory.HOBBIES, 200, "pesti"));
		Map<ExpenseCategory, Float> report = records.generateReport();
		for (Entry<ExpenseCategory, Float> entry : report.entrySet()) {
			System.out.println(entry.getKey().name() + " - " + entry.getValue() + "%");
		}
	}

	private static void deleteExpenseCSVFile() {
		File f = new File("expenses.csv");
		if (f.exists()) {
			f.delete();
		}
	}

	private static void manageExpenseRecordsAsync() {
		deleteExpenseCSVFile();
		CSVExpenseRepository repo = new CSVExpenseRepository();
		showReportsAsync(repo);
		addExpenseAsync(repo, new Expense(new Date(), ExpenseCategory.BILLS, 10, "gaz"));
		addExpenseAsync(repo, new Expense(new Date(), ExpenseCategory.CAR, 350, "gaz"));
		addExpenseAsync(repo, new Expense(new Date(), ExpenseCategory.CLOTHES, 400, "gaz"));
		addExpenseAsync(repo, new Expense(new Date(), ExpenseCategory.CAR, 20, "gaz"));
		addExpenseAsync(repo, new Expense(new Date(), ExpenseCategory.HOBBIES, 100, "gaz"));
		addExpenseAsync(repo, new Expense(new Date(), ExpenseCategory.MUSIC, 19, "gaz"));
	}

	private static void addExpenseAsync(CSVExpenseRepository repo, Expense expense) {
		new Thread("add-expense-thread-" + threadId++) {
			@Override
			public void run() {
				try {
					Thread.sleep(2000 + new Random().nextInt(2000));
					synchronized (repo) {
						ExpenseRecords records = new ExpenseRecords(repo);
						records.addExpense(expense);
						System.out.println("added: " + expense.toString());
					}
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}.start();
	}

	private static void showReportsAsync(CSVExpenseRepository repo) {
		new Thread("reports-thread") {
			@Override
			public void run() {
				try {
					while (true) {
						Thread.sleep(1000);
						synchronized (repo) {
							System.out.println("\n________Reports________");
							ExpenseRecords records = new ExpenseRecords(repo);
							Map<ExpenseCategory, Float> report = records.generateReport();
							for (Entry<ExpenseCategory, Float> entry : report.entrySet()) {
								System.out.println(entry.getKey().name() + " - " + entry.getValue() + "%");
							}
						}
					}
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}.start();
	}

}
