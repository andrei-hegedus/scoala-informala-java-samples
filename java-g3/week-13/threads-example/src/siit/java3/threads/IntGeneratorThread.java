package siit.java3.threads;

import java.util.Random;

public class IntGeneratorThread extends Thread{
	
	private int index;
	private int [] array;
	
	public IntGeneratorThread(int index, int[] array) {
		super();
		this.index = index;
		this.array = array;
	}

	@Override
	public void run() {
		try {
			Random r = new Random();
			Thread.sleep(1000+r.nextInt(2000));
			array[index] = r.nextInt(100);
			System.out.println("array["+index+"] = "+array[index]);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
};