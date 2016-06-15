package siit.java3.exepnsereports;

import java.util.Date;

public class Expense {
	
	private Date date;
	private ExpenseCategory category;
	private float amount;
	private String description;
	
	public Expense(Date date, ExpenseCategory category, float amount, String description) {
		this.date = date;
		this.category = category;
		this.amount = amount;
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public ExpenseCategory getCategory() {
		return category;
	}

	public float getAmount() {
		return amount;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		return "Expense [date=" + date + ", category=" + category + ", amount=" + amount + ", description="
				+ description + "]";
	}
	
}
