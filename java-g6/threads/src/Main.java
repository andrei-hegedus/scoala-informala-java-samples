/**
 * Created by andrei on 2/15/17.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("This code runs on "+Thread.currentThread().getName());
            }
        }, "second-thread");
        t.start();
        Thread t2 = new Thread("third-thread"){
            @Override
            public void run() {
                System.out.println("La la la on "+Thread.currentThread().getName());
            }
        };
        t2.start();
        System.out.println("Bla  bla bla on "+Thread.currentThread().getName());
        MyThread mt = new MyThread();
        mt.start();
    }

    private static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("4th thread");
        }
    }

}
