/**
 * Created by andrei on 2/15/17.
 */
public class Singleton {

    private static Singleton instance;

    private Singleton(){

    }

    public static Singleton getInstance(){
        if(instance==null){
            instance = new Singleton();
        }
        return instance;
    }
}
