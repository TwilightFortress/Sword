package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author yuyang
 * @create 2019-08-25 16:55
 */
public class test9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Boolean> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            String[] arrStr = str.split(" ");
            list.add(fun1(arrStr));
        }
        for (Boolean aBoolean : list) {
            System.out.println(aBoolean);
        }
    }

    public static boolean fun1(String[] arrStr){
        String str1 = arrStr[0];
        String[] str11 = str1.split("\\.");
        int[] arr1 = new int[str11.length];
        for (int i = 0; i < str11.length; i++) {
            arr1[i] = Integer.parseInt(str11[i]);
        }
        String str2 = arrStr[1];
        String[] str22 = str2.split("\\.");
        int[] arr2 = new int[str22.length];
        for (int i = 0; i < str22.length; i++) {
            arr2[i] = Integer.parseInt(str22[i]);
        }
        int i = 0;
        while (i < arr1.length && i < arr2.length){
            if(arr1[i] > arr2[i]) return false;
            if(arr1[i] < arr2[i]) return true;
            i++;
        }
        while(i < arr1.length){
            if(arr1[i] >= 0) return false;
            i++;
        }
        while(i < arr2.length){
            if(arr2[i] != 0) return true;
            i++;
        }
        if(arr1.length < arr2.length)
            return false;
        else
            return true;
    }
}
