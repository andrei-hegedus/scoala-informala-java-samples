/**
 * Created by andrei on 2/15/17.
 */
public class SleepingThread extends Thread {

    @Override
    public void run() {
        for(int i=1;i<=100;i++){
            try {
                Thread.sleep(100);
                if(i%10==0){
                    System.out.println(i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace(System.err);
            }
        }
    }
}
