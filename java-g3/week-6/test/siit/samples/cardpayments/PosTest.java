package siit.samples.cardpayments;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

// Unit Test
public class PosTest {

	@Test
	public void whenPreRequisitsAreMet_paymentsIsSuccessfull()
			throws InsufficientFundsException, BankAccountNotFoundException {
		Pos pos = new Pos();
		final String iban = "111";
		BankAccount mockBankAccount = new BankAccountWithHardcodedBalance(iban,  1001);
		pos.knowsAboutBankAccount(mockBankAccount);
		Card card = new Card(iban, new Date());
		Receipt receipt = pos.pay(1000, card);
		assertEquals(1000f, receipt.getValue(), 0);
	}

	@Test(expected = BankAccountNotFoundException.class)
	public void whenPosDoesNotKnowAboutAnyBankAccount_paymentFails()
			throws InsufficientFundsException, BankAccountNotFoundException {
		Pos pos = new Pos();
		final String iban = "111";
		Card card = new Card(iban, new Date());
		Receipt receipt = pos.pay(1000, card);
	}

	@Test(expected = BankAccountNotFoundException.class)
	public void whenPosDoesNotKnowAboutBankAccount_paymentFails()
			throws InsufficientFundsException, BankAccountNotFoundException {
		Pos pos = new Pos();
		final String iban = "111";
		BankAccount mockBankAccount = new BankAccountWithHardcodedBalance("123",  1001);
		pos.knowsAboutBankAccount(mockBankAccount);
		Card card = new Card(iban, new Date());
		Receipt receipt = pos.pay(1000, card);
	}
	
	@Test(expected=InsufficientFundsException.class)
	public void whenNotEnoughFunds_paymentFails() throws InsufficientFundsException, BankAccountNotFoundException {
		Pos pos = new Pos();
		final String iban = "111";
		BankAccount mockBankAccount = new BankAccountWithHardcodedBalance(iban,  100);
		pos.knowsAboutBankAccount(mockBankAccount);
		Card card = new Card(iban, new Date());
		Receipt receipt = pos.pay(1000, card);
		assertEquals(1000f, receipt.getValue(), 0);
	}
	
	private static class BankAccountWithHardcodedBalance extends BankAccount{
		
		private final float hardcodedBalance;

		public BankAccountWithHardcodedBalance(String iban, float balance) {
			super(iban);
			this.hardcodedBalance = balance;
		}
		
		@Override
		public float getBalance() {
			return hardcodedBalance;
		}
		
	}

}
