package others;

import sun.font.FontRunIterator;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author yuyang
 * @create 2019-08-27 19:46
 */
/*
6
3 + 2 + 1 * -4 / -5 + 1
 */
public class 滴滴1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n1 = sc.nextLine();
        int n = Integer.parseInt(n1);
        String str = sc.nextLine();
        String[] ArrStr = str.split(" ");
        int[] arr = new int[n];
        String[] strings = new String[n - 1];
        int i1 = 0, i2 = 0;
        for (int i = 0; i < ArrStr.length; i++) {
            if((i & 1) == 0){
                arr[i1++] = Integer.parseInt(ArrStr[i]);
            }else{
                strings[i2++] = ArrStr[i];
            }
        }
        fun(arr,strings);
        i1 = 0;i2 = 0;
        for (int i = 0; i < ArrStr.length; i++) {
            if((i & 1) == 0)
                System.out.print(arr[i1++]);
            else
                System.out.print(strings[i2++]);
        }
        System.out.println();
    }

    private static void fun(int[] arr, String[] strings) {
        for (int i = 0; i < arr.length - 1;) {
            int j;
            for (j = i; j < arr.length - 1;) {
                if(strings[i].equals(strings[j]) && strings[i].equals("+")){
                    j++;
                }else{
                    break;
                }

            }
            fun1(arr, i, j);
            i = j + 1;
        }
        for (int i = 0; i < arr.length - 1;) {
            int k;
            for (k = i; k < arr.length - 1;) {
                if(strings[i].equals("*")){
                    k++;
                }else{
                    break;
                }
            }
            fun1(arr, i, k + 1);
            i = k + 1;
        }
    }
    private static void fun1(int[] arr, int i, int j) {
        Arrays.sort(arr,i, j);
    }
}
