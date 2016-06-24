package siit.java3.messenger;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Friend joe = new Friend("Joe", new String[] { "How you doin?", "Sorry I have a boyfriend...",
				"Gotta go, buh-bye", "I work out!", "I'm hungry.", "..BMW" });
		Friend bianca = new Friend("Bianca",
				new String[] { "I'm fine.", "Wanna hang out?", "I'm vegan", "I'm fat", "I don't like BMWs" });
		joe.talkTo(bianca);
	}

}
