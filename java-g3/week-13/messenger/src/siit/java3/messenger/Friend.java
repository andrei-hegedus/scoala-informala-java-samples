package siit.java3.messenger;

import java.util.Random;

public class Friend {

	private String name;
	private String[] phrases;
	private MessageSender sender;
	private MessageReceiver receiver;
	private boolean isConversationStarter = false;

	public Friend(String name, String...phrases) {
		this.name = name;
		this.phrases = phrases;
	}

	public void talkTo(Friend bianca) {
		isConversationStarter = true;
		MessagingChannel channel = new MessagingChannel();
		sender = channel;
		receiver = bianca.contactFriend(channel);
		new ConversationThread().start();
	}


	private MessageReceiver contactFriend(MessageReceiver fromChannel) {
		this.receiver = fromChannel;
		new ConversationThread().start();
		MessagingChannel channel = new MessagingChannel();
		sender = channel;
		return channel;
	}
	
	private class ConversationThread extends Thread {
		private Random random = new Random();
		
		@Override
		public void run() {
			try {
				while (true) {
					simulateThinking();
					readMessage();
					writeMessage();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		private void simulateThinking() throws InterruptedException {
			long sleepTime = (long) (1000 + random.nextInt(2000));
			Thread.sleep(sleepTime);
		}

		private void writeMessage() throws Exception {
			String message = name + ": " + phrases[random.nextInt(phrases.length)];
			sender.sendMessage(message);
		}

		private void readMessage() throws Exception {
			if (!isConversationStarter) {
				String received = receiver.obtainMessage();
				if (received != null) {
					System.out.println(received);
				}
			} else {
				isConversationStarter = false;
			}
		}
		
	}

}
