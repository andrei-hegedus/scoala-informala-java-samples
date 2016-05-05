package siit.samples.cardpayments;

public class BankAccount {
	
	private String iban;
	private float balance;

	public BankAccount(String iban) {
		this.iban = iban;
	}

	public void setBalance(float balance) {
		this.balance = balance;	
	}

	public String getIban() {
		return iban;
	}

	public float getBalance() {
		return balance;
	}

	public void withdraw(float fee) {
		balance -= fee;
	}
	
	

}
