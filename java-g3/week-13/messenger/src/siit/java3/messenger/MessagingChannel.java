package siit.java3.messenger;

public class MessagingChannel implements MessageSender, MessageReceiver {

	private String message = null;

	@Override
	public synchronized void sendMessage(String message) throws InterruptedException {
		while (this.message != null) {
			wait();
		}
		this.message = message;
		notifyAll();
	}

	@Override
	public synchronized String obtainMessage() throws InterruptedException {
		while (message == null) {
			wait();
		}
		String msg = message;
		message = null;
		notifyAll();
		return msg;
	}

}
