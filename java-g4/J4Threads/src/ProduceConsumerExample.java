import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class ProduceConsumerExample {

	// shared resource among threads.
	private static LinkedList<String> list = new LinkedList<>();

	public static void main(String[] args) {
		ConsumerThread c = new ConsumerThread(list);
		// c.start();
		ProducerThread p = new ProducerThread(list);
		p.start();
		c.start();
	}

	private static class ConsumerThread extends Thread {

		private LinkedList<String> sharedList;

		public ConsumerThread(LinkedList<String> sharedList) {
			this.sharedList = sharedList;
		}

		@Override
		public void run() {
			while (true) {
				try {
					synchronized (sharedList) {
						if (sharedList.isEmpty()) {
							System.out.println("C- nothing to consume");
							// sharedList.wait();
						} else {
							System.out.println("C - consumed: " + sharedList.removeFirst());
						}
						// sharedList.notify();
					}
					Thread.sleep(2000);
				} catch (InterruptedException e) {
				}
			}
		}

	}

	private static class ProducerThread extends Thread {

		private static final String[] DATA = new String[] { "apple", "dog", "car", "whatever", "banana", "snow",
				"pineapple", "rain", "cloud", "drops", "grass", "weed" };

		private LinkedList<String> sharedList;
		private Random random = new Random();

		public ProducerThread(LinkedList<String> sharedList) {
			this.sharedList = sharedList;
		}

		@Override
		public void run() {
			try {
				for (int i = 0; i < 100; i++) {
					System.out.println("P- waiting");
					synchronized (sharedList) {
						String randomData = getRandomData();
						sharedList.add(randomData);
						System.out.println("P - produced: " + randomData);
					}
					Thread.sleep(random.nextInt(1000) + 1000);
				}
			} catch (InterruptedException e) {

			}
		}

		private String getRandomData() {
			int randomIndex = random.nextInt(DATA.length);
			return DATA[randomIndex];
		}

	}

}
