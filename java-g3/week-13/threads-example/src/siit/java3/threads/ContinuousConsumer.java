package siit.java3.threads;

import java.util.Collection;
import java.util.Iterator;

public class ContinuousConsumer<T> {

	private Collection<T> data;

	public ContinuousConsumer(Collection<T> data) {
		super();
		this.data = data;
	}

	public void consumeToConsole() {
		new Thread() {
			public void run() {
				synchronized (data) {
					while (true) {
						consume();
					}
				}
			}

			private void consume() {
				if (data.isEmpty()) {
					try {
						System.out.println("waiting to read.");
						data.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				//unsafeConsume();
				safeConsume(); // used when the collection is not synchronized (i.e not CopyOnModificationArrayLiast)
				data.notifyAll();
			}


			private void safeConsume() {
				Iterator<T> iterator = data.iterator();
				while(iterator.hasNext()){
					T t = iterator.next();
					iterator.remove();
					System.out.println("read: " + t);
				}
			}

			private void unsafeConsume() {
				T previous  = null;
				for (T t : data) {
					data.remove(t);
					System.out.println("read: " + t);
				}
			};
		}.start();
	}

}
