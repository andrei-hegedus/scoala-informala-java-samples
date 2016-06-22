package siit.java3.expensereports;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class CSVExpenseRepository implements ExpenseRepository {

	protected static final String CSV_FILE_NAME = "expenses.csv";
	protected CSVExpenseFormater csvFormater = new CSVExpenseFormater();

	@Override
	public synchronized void save(Expense expense) throws IOException {
		File file = new File(CSV_FILE_NAME);
		try (FileWriter writer = new FileWriter(file, true)) {
			writer.append(csvFormater.toCSV(expense) + "\n");
		}
	}

	@Override
	public synchronized List<Expense> loadAll() throws FileNotFoundException, IOException, ParseException {
		File file = new File(CSV_FILE_NAME);
		ArrayList<Expense> expenses = new ArrayList<>();
		if (file.exists()) {
			try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
				String line = reader.readLine();
				while (line != null) {
					Expense e = csvFormater.fromCSV(line);
					expenses.add(e);
					line = reader.readLine();
				}
			}
		}
		return expenses;
	}

}
