package exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            method1();
        } catch (MyException e) {
            System.out.println("handling exception " + e.getMessage() + " in main().");
        }
        method2();
        ;
    }

    public static void method1() throws MyException {
        try {
            if (2 == 4 - 2) {
                throw new MyException("Ha ha");
            }
        } finally {
            System.out.println("m1");
        }
    }

    public static void method2() {
        File f = new File("");
        try(FileReader  fr = new FileReader(f)){
            fr.read();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("m2");
    }

    private static class MyException extends Exception {
        public MyException(String message) {
            super(message);
        }
    }

}
