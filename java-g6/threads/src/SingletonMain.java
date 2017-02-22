/**
 * Created by andrei on 2/15/17.
 */
public class SingletonMain {

    public static void main(String[] args) {
        for(int i=0;i<=10;i++){
            new Thread("t"+i){
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+" - "+Singleton.getInstance().hashCode());
                }
            }.start();

        }
    }
}
