package ro.siit.java.mediastore;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by andreihegedus-sirbu on 04/12/2017.
 */
public class SetExamples {

    public static void main(String[] args) {
        //Set<String> names = new HashSet<String>();
        //Set<String> names = new LinkedHashSet<String>();
        Set<String> names = new TreeSet<String>();
        names.add("Jack");
        names.add("Anna");
        names.add("Zack");
        names.add("Bono");
        names.add("Kim");
        for(String name : names){
            System.out.println(name);
        }
    }
}
