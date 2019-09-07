package test;

import java.util.HashMap;
import java.util.Hashtable;

public abstract  class test1 {
    public static void main(String[] args) {
        HashMap<String, String> h = new HashMap<>();
        h.put(null, "hello");
        System.out.println(h);

        Hashtable<String, String> h1 = new Hashtable<>();
        h1.put(null, "wor");
        System.out.println(h1);
    }

}
