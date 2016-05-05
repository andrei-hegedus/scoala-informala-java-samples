package siit.samples.cardpayments;

import java.util.ArrayList;

public class Pos {
	
	private ArrayList<BankAccount> bankAccounts = new ArrayList<>();

	public void knowsAboutBankAccount(BankAccount bankAccount) {
		bankAccounts.add(bankAccount);
	}

	public Receipt pay(float fee, Card card) throws InsufficientFundsException, BankAccountNotFoundException {
		// iterate over all bank accounts and find out whether the Card is attached to an existing account.
		for(BankAccount bankAccount : bankAccounts){
			if(bankAccount.getIban().equals(card.getIban())){
				// once we find the account that the card is attached to, we need to check whether there is enough money for the transaction.
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
