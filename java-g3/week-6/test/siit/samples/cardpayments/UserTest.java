package siit.samples.cardpayments;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;


import org.junit.Test;

public class UserTest {
	
	@Test
	public void userHasName() {
		User user = new User("John");
		assertEquals("John", user.getName());
	}
	
	@Test
	public void userHasCards(){
		User user = new User("John");
		user.addCard(new Card("", new Date()));
		List<Card> cards = user.getCards();
		assertNotNull(cards);
		assertFalse(cards.isEmpty());
	}
	
	@Test
	public void whenAddingCardToAUser_thenCardsListContainsIt(){
		User user = new User("John");
		Card card = new Card("", new Date());
		user.addCard(card);
		List<Card> cards = user.getCards();
		assertTrue(cards.contains(card));
	}

}
