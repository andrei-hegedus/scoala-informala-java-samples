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

	private static class Friend {

		private String name;
		private String[] phrases;
		private MessageSender sender;
		private MessageReceiver receiver;
		private boolean conversationStarter = false;

		public Friend(String name, String[] phrases) {
			this.name = name;
			this.phrases = phrases;
		}

		public void talkTo(Friend bianca) {
			conversationStarter = true;
			MessagingChannel channel = new MessagingChannel();
			sender = channel;
			receiver = bianca.contactFriend(channel);
			startThread();
		}

		private void startThread() {
			new Thread() {
				public void run() {
					try {
						Random r = new Random();
						while (true) {
							long sleepTime = (long) (1000 + r.nextInt(2000));
							Thread.sleep(sleepTime);
							if (!conversationStarter) {
								String received = receiver.obtainMessage();
								if (received != null) {
									System.out.println(received);
								}
							} else {
								conversationStarter = false;
							}
							String message = name + ": " + phrases[r.nextInt(phrases.length)];
							sender.sendMessage(message);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				};
			}.start();
		}

		private MessageReceiver contactFriend(MessageReceiver fromChannel) {
			this.receiver = fromChannel;
			startThread();
			MessagingChannel channel = new MessagingChannel();
			sender = channel;
			return channel;
		}

	}
	
	

}
