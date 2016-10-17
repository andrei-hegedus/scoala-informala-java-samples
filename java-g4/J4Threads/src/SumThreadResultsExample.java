import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class SumThreadResultsExample {
	
	private static int [] threadResults =new int[5];
	private static Random random = new Random();

	public static void main(String[] args) throws InterruptedException {
		Thread [] threads = new Thread[5];
		for(int i=0;i<5;i++){
			final int threadId = i;
			threads[i] = new Thread(){
				@Override
				public void run() {
					try {
						Thread.sleep(300);
					} catch (InterruptedException e) {
					}
					threadResults[threadId] = random.nextInt(10000);
					System.out.println("generated random number");
				}
			};
			threads[i].start();
		}
		for(Thread t : threads){
			System.out.println("joining thread");
			t.join();
		}
		int sum = 0;
		for(int i : threadResults){
			sum +=i;
		}
		System.out.println(sum);

	}

}
