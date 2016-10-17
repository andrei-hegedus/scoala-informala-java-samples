
public class Main {
	
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName());
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
			}
		};
		Thread t = new Thread(r);
		t.start();
		for(int i=0;i<Integer.MAX_VALUE;i++){
			
		}
		MyThread t2 =new MyThread();
		t2.start();
		//t2.run();
		System.out.println(Thread.currentThread().getName());
	}
	
	private static class MyThread extends Thread {
		
		@Override
		public void run() {
			System.out.println("MyThread: "+Thread.currentThread().getName());
		}
		
	}

}
