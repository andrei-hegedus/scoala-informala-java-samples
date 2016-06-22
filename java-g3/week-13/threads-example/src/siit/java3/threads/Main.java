package siit.java3.threads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {

	private static int[] sharedResource;

	public static void main(String[] args) throws InterruptedException {
		//singletonTest();
		//joinTest();
		synchronizedReadWrite();
	}

	private static void synchronizedReadWrite() {
		//final Collection<Integer> list = new CopyOnWriteArrayList<>();
		final Collection<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		new ContinuousConsumer<Integer>(list).consumeToConsole();
		new Thread() {
			public void run() {
				int count = 0;
				Random r = new Random();
				while(count<10){
					try {
						Thread.sleep(1000);
						synchronized (list) {
							int i = r.nextInt(100);
							list.add(i);
							System.out.println("wrote: "+i);
							count++;
							list.notifyAll();
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
		}.start();
	}

	private static void joinTest() throws InterruptedException {
		sharedResource = new int[3]; // shared among threads

		Thread t1 = new IntGeneratorThread(0, sharedResource);
		t1.start();

		Thread t2 = new IntGeneratorThread(1, sharedResource);
		t2.start();

		Thread t3 = new IntGeneratorThread(2, sharedResource);
		t3.start();

		t1.join(); // main thread joins to t1's end.
		t2.join(); // main thread joins to t2's end.
		t3.join(); // main thread joins to t3's end.
		System.out.println("total sum: " + sumOfArray(sharedResource));
	}

	private static int sumOfArray(int[] array) {
		int sum = 0;
		for (int i : array) {
			sum += i;
		}
		return sum;
	}

	private static void singletonTest() {
		for (int i = 0; i < 10; i++) {
			new Thread() {
				public void run() {
					Singleton s = Singleton.getInstance();
					System.out.println(s.hashCode());
				};
			}.start();
			;
		}
	}

}
