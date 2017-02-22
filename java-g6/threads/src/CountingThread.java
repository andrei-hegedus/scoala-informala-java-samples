import sun.jvm.hotspot.runtime.Threads;

import java.util.Random;

/**
 * Created by andrei on 2/15/17.
 */
public class CountingThread extends Thread {

    private int step;
    private volatile boolean canRun = true;
    private Random random = new Random();

    public CountingThread(int step) {
        super("counting-thread-"+step);
        this.step = step;
    }

    public void stopRunning(){
        canRun = false;
    }

    @Override
    public void run() {
        for(int i = 0;i<=100;i+=step){
            if(!canRun){
                return;
            }
            System.out.println(Thread.currentThread().getName()+" - "+i);
            /*try {
                Thread.sleep(random.nextInt(500)+1000);
            } catch (InterruptedException e) {
                e.printStackTrace(System.err);
            }*/
        }
    }
}
