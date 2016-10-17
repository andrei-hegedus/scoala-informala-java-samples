
public class CounterThreadExample {

	public static void main(String[] args) throws InterruptedException {
		SteppingThread steppingThread2 = new SteppingThread(2);
		steppingThread2.start();
		SteppingThread steppingThread3 = new SteppingThread(3);
		steppingThread3.start();
		SteppingThread steppingThread5 = new SteppingThread(5);
		steppingThread5.start();
		//steppingThread2.join();
		//steppingThread3.join();
		//steppingThread5.join();
		System.out.println("Main exits");
	}

	private static class SteppingThread extends Thread {

		private int stepCount;

		public SteppingThread(int stepCount) {
			super("SteppingThread_" + stepCount);
			this.stepCount = stepCount;
		}

		@Override
		public void run() {
			int counter = 0;
			while (counter <= 100 - stepCount) {
				counter += stepCount;
				int stepsMade = counter / stepCount;
				//if (stepsMade % 10 == 0) {
					System.out.println(getName() + " - " + counter);
				//}
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
				}
			}

		}

	}

}
