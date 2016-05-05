package siit.java2.threads;

public class SingletonExamples {

	public static void main(String[] args) {
		// synchronizedSingletonTest();
		unsafeSingletonTest();
	}

	// run this method multiple times -> notice how sometimes a different
	// hashcode appears.
	private static void unsafeSingletonTest() {
		for (int i = 0; i < 10; i++) {
			new Thread() {
				public void run() {
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(UnsafeSingleton.getInstance().hashCode());
				};
			}.start();
		}
	}

	// run this method multiple times -> notice how the instance is the same
	// from every thread call (i.e haschcode is the same).
	private static void synchronizedSingletonTest() {
		for (int i = 0; i < 10; i++) {
			new Thread() {
				public void run() {
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(SynchronizedSingleton.getInstance().hashCode());
				};
			}.start();
		}
	}

}
