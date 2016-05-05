package siit.samples.cardpayments;

import java.util.ArrayList;

public class Pos {
	
	private ArrayList<BankAccount> bankAccounts = new ArrayList<>();

	public void knowsAboutBankAccount(BankAccount bankAccount) {
		bankAccounts.add(bankAccount);
	}

	public Receipt pay(float fee, Card card) throws InsufficientFundsException, BankAccountNotFoundException {
		for(BankAccount bankAccount : bankAccounts){
			if(bankAccount.getIban().equals(card.getIban())){
				if(bankAccount.getBalance() >= fee){
					bankAccount.withdraw(fee);
					return new Receipt(fee);
				} else {
					throw new InsufficientFundsException();
				}
			}
		}
		throw new BankAccountNotFoundException();
	}
	

}
