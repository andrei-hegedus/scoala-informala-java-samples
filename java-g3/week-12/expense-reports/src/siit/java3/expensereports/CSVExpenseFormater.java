package siit.java3.expensereports;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CSVExpenseFormater {

	private static final SimpleDateFormat DATE_FORMATER = new SimpleDateFormat("yyyy-MMM-dd hh:mm");

	public String toCSV(Expense expense) {
		return DATE_FORMATER.format(expense.getDate()) + "," + expense.getCategory().name() + "," + expense.getAmount()
				+ "," + expense.getDescription();
	}
	
	public Expense fromCSV(String csvLine) throws ParseException{
		String[] tokens = csvLine.split(",");
		Date d = DATE_FORMATER.parse(tokens[0]);
		ExpenseCategory c = ExpenseCategory.valueOf(tokens[1]);
		Float a = Float.parseFloat(tokens[2]);
		return new Expense(d, c, a, tokens[3]);
	}

}
