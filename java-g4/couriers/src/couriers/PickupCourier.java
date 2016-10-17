package couriers;

import java.util.Queue;
import java.util.Random;

public class PickupCourier extends Thread {
	
	private Queue<String> packageQueue;
	private Random random = new Random();

	public PickupCourier(Queue<String> packageQueue) {
		this.packageQueue = packageQueue;
	}
	
	@Override
	public void run() {
		try{
		for(int i = 0;i<100;i++){
			synchronized (packageQueue) {
				String p = "package"+i;
				System.out.println("pickup courier - bringing in "+p);
				packageQueue.add(p);
				packageQueue.notify();
			}
			Thread.sleep(random.nextInt(1000)+1000);
		}
		} catch (Exception e){
			
		}
	}

}
