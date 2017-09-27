package ro.siit.java;

import java.io.File;
import java.util.Arrays;

/**
 * Created by andrei on 9/27/17.
 */
public class PlayWithFiles {

    public static void main(String[] args) {
        File file = new File(".");
        listContents(file, "");
        /*for(String s : file.list()){
            System.out.println(s);
            File child = new File(file, s);
            if(child.isDirectory()){
                for(String s2 : child.list()){
                    System.out.println("\t"+s2);
                }
            }
        }*/

    }

    public static void listContents(File f, String indentation){
        System.out.println(indentation+f.getName());
        String[] children = f.list();
        if(f.isDirectory() && children.length>0){
            for(String child : children){
                File childFile = new File(f, child);
                listContents(childFile, indentation+"\t");
            }
        }
    }
}
