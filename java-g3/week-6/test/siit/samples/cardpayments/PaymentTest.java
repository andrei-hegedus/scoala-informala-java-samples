package siit.samples.cardpayments;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

/**
 * Integration test - tests the payment flow
 * 
 * @author andrei
 *
 */
public class PaymentTest {

	@Test
	public void whenSufficientMoneyInAccount_paymentIsSuccessful() throws Exception {
		// given
		BankAccount bankAccount = new BankAccount("1234");
		bankAccount.setBalance(500f);
		User user = new User("John");
		Card card = new Card("1234", new Date());
		user.addCard(card);
		Pos pos = new Pos();
		pos.knowsAboutBankAccount(bankAccount);
		// when
		Receipt receipt = pos.pay(10f, user.getCards().get(0));
		// then
		assertEquals(10f, receipt.getValue(), 0f);
	}

	@Test(expected = InsufficientFundsException.class)
	public void whenInsufficientMoneyInAccount_paymentFails() throws Exception {
		// given
		BankAccount bankAccount = new BankAccount("1234");
		bankAccount.setBalance(9f);
		User user = new User("John");
		Card card = new Card("1234", new Date());
		user.addCard(card);
		Pos pos = new Pos();
		pos.knowsAboutBankAccount(bankAccount);
		// when
		pos.pay(10f, user.getCards().get(0));
	}

	@Test(expected = BankAccountNotFoundException.class)
	public void whenBankAccountUnknown_paymentFails() throws Exception {
		// given
		BankAccount bankAccount = new BankAccount("134");
		bankAccount.setBalance(100f);
		User user = new User("John");
		Card card = new Card("1234", new Date());
		user.addCard(card);
		Pos pos = new Pos();
		pos.knowsAboutBankAccount(bankAccount);
		// when
		pos.pay(10f, user.getCards().get(0));
	}

}
