package siit.samples.cardpayments;

import java.util.ArrayList;
import java.util.List;

public class User {
	
	private String name;
	private ArrayList<Card> cards = new ArrayList<>();

	public User(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void addCard(Card card) {
		cards.add(card);
	}

}
