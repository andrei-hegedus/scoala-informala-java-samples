

import java.util.Random;

public class ProducerConsumerWithWait {

	public static void main(String[] args) {
		MailBox mb = new MailBox();
		MailBoxOwner o = new MailBoxOwner(mb);
		Postman p = new Postman(mb);
		p.start();
		o.start();
	}

	private static class MailBox {
		private String mail;

		public boolean hasMail() {
			return mail != null;
		}

		public void addMail(String mail) {
			this.mail = mail;
		}

		public String retrieveMail() {
			String m = mail;
			mail = null;
			return m;
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
					synchronized (mailBox) {
						while (mailBox.hasMail()) {
							mailBox.wait();
						}
						String mail = "mail" + i;
						System.out.println("P - adding: " + mail);
						mailBox.addMail(mail);
						Thread.sleep(r.nextInt(1000)+1000);
						mailBox.notify();
					}
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
			try {
				while (true) {
					synchronized (mailBox) {
						while (!mailBox.hasMail()) {
							mailBox.wait();
						}
						System.out.println(mailBox.retrieveMail());
						mailBox.notify();
					}
				}
			} catch (InterruptedException e) {
				System.err.println(e);
			}
		}

	}

}
