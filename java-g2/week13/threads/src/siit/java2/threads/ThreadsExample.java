package siit.java2.threads;

public class ThreadsExample {

	public static void main(String[] args) {
		SteppingThread st1 = new SteppingThread("ST1", 2);
		//st1.start();
		SteppingThread st2 = new SteppingThread("ST2", 3);
		//st2.start();
		System.out.println("before object creation: "+Thread.currentThread().getName());
		Thread countingThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=1;i<=100;i++){
					if(i % 10 ==0){
						System.out.println(i);
						System.out.println(Thread.currentThread().getName());
					}
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}, "counting-thread");
		System.out.println("after object creation: "+Thread.currentThread().getName());
		countingThread.start();
		System.out.println("after thread start: "+Thread.currentThread().getName());
	}


	private static class SteppingThread extends Thread {

		private int step;

		public SteppingThread(String name, int step) {
			super(name);
			this.step = step;
		}

		@Override
		public void run() {
			for (int i = 1; i <= 100; i += step) {
				System.out.println(getName()+" - "+i);
			}
		}
	}

}
