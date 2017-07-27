/**
 * Created by andrei on 7/26/17.
 */
public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(fibonacci(8));
    }

    private static int fibonacci(int n) {
        System.out.println(n);
        if(n == 0 || n == 1){
            return n;
        }
        return fibonacci(n-1)+fibonacci(n-2);
    }
}
