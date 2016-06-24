package siit.java3.messenger;

public class Main {

	public static void main(String[] args) {
		Friend joe = new Friend("Joe", "How you doin?", "Sorry I have a boyfriend...", "Gotta go, buh-bye",
				"I work out!", "I'm hungry.", "..BMW");
		Friend bianca = new Friend("Bianca", "I'm fine.", "Wanna hang out?", "I'm vegan", "I'm fat",
				"I don't like BMWs");
		joe.talkTo(bianca);
	}

}
