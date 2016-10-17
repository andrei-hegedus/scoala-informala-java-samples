

import java.util.Random;

public class ProducerConsumerWithWait_withSynchronizedResource {
	public static void main(String[] args) {
		MailBox mb = new MailBox();
		MailBoxOwner o = new MailBoxOwner(mb);
		Postman p = new Postman(mb);
		p.start();
		o.start();
	}

	private static class MailBox {
		private String mail;

		private boolean hasMail() {
			return mail != null;
		}

		public synchronized void addMail(String mail) {
			try {
				if (hasMail()) {
					wait();
				}
				this.mail = mail;
				notify();
			} catch (InterruptedException e) {
				System.err.println(e);
			}
		}

		public synchronized String retrieveMail() {
			try {
				if (!hasMail()) {
					wait();
				}
				String m = mail;
				mail = null;
				notify();
				return m;
			} catch (InterruptedException e) {
				System.err.println(e);
				return null;
			}
		}
	}

	private static class Postman extends Thread {

		private MailBox mailBox;

		public Postman(MailBox mailBox) {
			this.mailBox = mailBox;
		}

		@Override
		public void run() {
			Random r = new Random();
			try {
				for (int i = 0; i < 10; i++) {
					String mail = "mail" + i;
					System.out.println("P - adding: " + mail);
					mailBox.addMail(mail);
					Thread.sleep(r.nextInt(1000) + 1000);
				}
			} catch (InterruptedException e) {
				System.err.println(e);
			}
		}

	}

	private static class MailBoxOwner extends Thread {
		private MailBox mailBox;

		public MailBoxOwner(MailBox mailBox) {
			this.mailBox = mailBox;
		}

		@Override
		public void run() {
			while (true) {
				System.out.println(mailBox.retrieveMail());
			}
		}

	}
}
