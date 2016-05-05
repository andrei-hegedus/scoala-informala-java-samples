package siit.samples.cardpayments;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

/**
 * Unit tests for the Card class.
 * 
 * @author andrei
 */
public class CardTest {

	@Test
	public void cardHasIBAN() {
		Card card = new Card("1234", new Date());
		assertEquals("1234", card.getIban());
	}

	@Test
	public void cardHasExpirationDate() {
		Date date = new Date();
		Card card = new Card("1234", date);
		assertEquals(date, card.getExpirationDate());
	}

	@Test
	public void cardIsValid() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2019, 1, 1);
		Date date = calendar.getTime();
		Card card = new Card("1234", date);
		assertEquals(date, card.getExpirationDate());
	}

}
