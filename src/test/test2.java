package test;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author yuyang
 * @create 2019-08-22 16:35
 */
public class test2 {

    public static void main(String[] args) {

        //String[] str = {"wrt", "wrf", "er", "ett", "rftt"};
        //fun(str);

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] arr = str.split(" ");
        fun(arr);
    }

    public static void fun(String[] arrStr) {
        StringBuffer sb = new StringBuffer();
        HashSet<Character> set = new HashSet<>();
        int k = 0;
        int len = 0;
        for (int i = 0; i < arrStr.length; i++) {
            len = Math.max(len,arrStr[i].length());
            for (int j = i+1; j < arrStr.length; j++) {
                if(arrStr[i].equals(arrStr[j])){
                    System.out.println("invalid");
                    return ;
                }

            }
        }
        while (k < len) {
            for (int i = 0; i < arrStr.length; i++) {
                if (k < arrStr[i].length()) {
                    char c = arrStr[i].charAt(k);
                    if (!set.contains(c)) {
                        set.add(c);
                        sb.append(c);
                    }
//                    if(check()){
////                        System.out.println("invalid");
////                    }

                }
            }
            k++;
        }
        System.out.println(sb);
    }
}
