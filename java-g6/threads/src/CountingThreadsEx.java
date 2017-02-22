/**
 * Created by andrei on 2/15/17.
 */
public class CountingThreadsEx {

    public static void main(String[] args) throws InterruptedException {
        CountingThread c2 = new CountingThread(2);
        CountingThread c3 = new CountingThread(3);
        CountingThread c5 = new CountingThread(5);
        c2.setDaemon(true);
        c3.setDaemon(true);
        c5.setDaemon(false);
        c2.start();
        c3.start();
        c5.start();


        SleepingThread st = new SleepingThread();
        //st.start();
        //c2.join();
        c3.join();
        c5.join();
        System.out.println("End of main");
    }
}
