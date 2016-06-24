package siit.java3.messenger;

import java.util.Random;

public class Friend {

	private String name;
	private String[] phrases;
	private MessageSender sender;
	private MessageReceiver receiver;
	private boolean isConversationStarter = false;

	public Friend(String name, String[] phrases) {
		this.name = name;
		this.phrases = phrases;
	}

	public void talkTo(Friend bianca) {
		isConversationStarter = true;
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
						if (!isConversationStarter) {
							String received = receiver.obtainMessage();
							if (received != null) {
								System.out.println(received);
							}
						} else {
							isConversationStarter = false;
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
