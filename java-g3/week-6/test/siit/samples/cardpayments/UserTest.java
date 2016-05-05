package siit.samples.cardpayments;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;


import org.junit.Test;

/**
 * Unit tests for the User class.
 * 
 * @author andrei
 *
 */
public class UserTest {

	// each method is a unit test.
	
	@Test
	public void userHasName() {
		// in this method we test whether the constructor instantiates the user object correctly.
		
		// given
		User user = new User("John");
		// when
		String name = user.getName();
		// then
		assertEquals("John", name);
	}
	
	@Test
	public void userHasCards(){
		// test that adding a card to a user works
		
		// given
		User user = new User("John");
		user.addCard(new Card("", new Date()));
		// when
		List<Card> cards = user.getCards();
		// then
		assertNotNull(cards);
		assertFalse(cards.isEmpty());
	}
	
	@Test
	public void whenAddingCardToAUser_thenCardsListContainsIt(){
		// given
		User user = new User("John");
		Card card = new Card("", new Date());
		user.addCard(card);
		// when
		List<Card> cards = user.getCards();
		// then
		assertTrue(cards.contains(card));
	}
	
	@Test
	public void userContainsTheProvidedCard(){
		// test that adding a card to a user keeps the same instance
		
		// given
		User user = new User("John");
		Card card = new Card("1234", new Date());
		user.addCard(card);
		// when
		List<Card> cards = user.getCards();
		// then
		assertEquals(card, cards.get(0));
	}

}
